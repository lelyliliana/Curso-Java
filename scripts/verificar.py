"""Compila y ejecuta las referencias independientes, prueba y empaqueta el curso."""
from pathlib import Path
import json
import os
import re
import shutil
import subprocess
import sys
import tempfile
import xml.etree.ElementTree as ET

RAIZ = Path(__file__).resolve().parents[1]
COMPROBACIONES = 0


def ejecutar(comando, cwd=RAIZ, entrada="", timeout=120):
    entorno = os.environ.copy()
    opciones = "-Dfile.encoding=UTF-8 -Dstdout.encoding=UTF-8 -Dstderr.encoding=UTF-8"
    entorno["JAVA_TOOL_OPTIONS"] = (entorno.get("JAVA_TOOL_OPTIONS", "") + " " + opciones).strip()
    resultado = subprocess.run(comando, cwd=cwd, input=entrada, text=True,
                               encoding="utf-8", capture_output=True, timeout=timeout, env=entorno)
    if resultado.returncode:
        raise RuntimeError("Falló " + str(comando) + "\n" + resultado.stdout + resultado.stderr)
    return resultado.stdout.replace("\r\n", "\n").strip()


def comprobar(condicion, mensaje):
    global COMPROBACIONES
    if not condicion:
        raise AssertionError(mensaje)
    COMPROBACIONES += 1


def verificar_documentacion():
    unidades = sorted(RAIZ.glob("unidad*"))
    comprobar(len(unidades) == 31, "Se esperan 31 unidades")
    referencias = 0
    for archivo in RAIZ.rglob("*.md"):
        if "target" in archivo.parts:
            continue
        texto = archivo.read_text(encoding="utf-8")
        comprobar(len(re.findall(r"^# ", texto, re.M)) == 1, f"Encabezado principal: {archivo}")
        comprobar(not re.search(r"TODO:|FIXME:|instrucciones internas del generador", texto),
                  f"Contenido ajeno a la lección: {archivo}")
        for enlace in re.findall(r"\[[^\]]*\]\(([^)]+)\)", texto):
            if re.match(r"[a-z]+://", enlace) or enlace.startswith("#"):
                continue
            destino = enlace.split("#", 1)[0]
            comprobar((archivo.parent / destino).exists(), f"Enlace roto: {archivo} -> {destino}")
            referencias += 1
    for i, unidad in enumerate(unidades):
        texto = (unidad / "README.md").read_text(encoding="utf-8")
        for nombre in ("PRACTICA.md", "SOLUCIONES.md"):
            comprobar((unidad / nombre).is_file(), f"Falta {nombre} en {unidad}")
        if i:
            comprobar(f"../{unidades[i-1].name}/README.md" in texto, "Navegación anterior")
        if i < 30:
            comprobar(f"../{unidades[i+1].name}/README.md" in texto, "Navegación siguiente")
    print(f"Documentación: 31 unidades, {referencias} referencias locales", flush=True)


def verificar_laboratorios(java, javac):
    esperados = json.loads((RAIZ / "tests/laboratorios.json").read_text(encoding="utf-8"))
    for carpeta, esperado in esperados.items():
        fuente = RAIZ / carpeta / "laboratorio/Laboratorio.java"
        with tempfile.TemporaryDirectory(prefix="java laboratorio ") as salida:
            ejecutar([javac, "-encoding", "UTF-8", "--release", "21", "-d", salida, str(fuente)])
            obtenido = ejecutar([java, "-cp", salida, "Laboratorio"], entrada="Cuaderno\n2\n12.50\n", timeout=15)
            if carpeta.startswith("unidad01"):
                version = re.search(r"Versión de clase: (\d+)\.0", obtenido)
                comprobar(version is not None and int(version.group(1)) >= 65, "JVM compatible con Java 21")
                obtenido = re.sub(r"Versión de clase: \d+\.0", "Versión de clase: 65.0", obtenido)
            comprobar(obtenido == esperado, f"Salida diferente en {carpeta}:\n{obtenido}")
            if carpeta.startswith("unidad03"):
                obtenido = ejecutar([java, "-cp", salida, "Laboratorio"], entrada="A\nabc\n1\n")
                comprobar("Formato numérico inválido" in obtenido, "Formato de consola")
                obtenido = ejecutar([java, "-cp", salida, "Laboratorio"], entrada="A\n")
                comprobar("Entrada terminada" in obtenido, "EOF de consola")
            if carpeta.startswith("unidad27"):
                obtenido = ejecutar([java, "-Dcurso.limite=0", "-cp", salida, "Laboratorio"])
                comprobar("Configuración rechazada" in obtenido, "Validación de configuración")
    print(f"Laboratorios: {len(esperados)} compilados y ejecutados con salida comprobada", flush=True)


def verificar_ejemplos(java, javac):
    contador = 0
    salidas = {
        "Cancelacion.java": "Tiempo de espera agotado\nCancelación solicitada: true\nResultado cancelado",
        "ComposicionAsync.java": "Resultado: 42\nAlternativa: -1\nCausa: Fallo simulado",
        "ParseoEstricto.java": "29/02/2024 -> 2024-02-29\n29/02/2023 -> Fecha inválida\n31/04/2026 -> Fecha inválida",
        "Variantes.java": "Éxito: Listo\nFallo: 404",
    }
    for carpeta in sorted(RAIZ.glob("unidad*/ejemplos")):
        fuentes = sorted(carpeta.glob("*.java"))
        if not fuentes or any(p.name.endswith("Test.java") for p in fuentes):
            continue
        with tempfile.TemporaryDirectory(prefix="java ejemplo ") as salida:
            ejecutar([javac, "-encoding", "UTF-8", "--release", "21", "-d", salida] + [str(p) for p in fuentes])
            for fuente in fuentes:
                if fuente.name in ("ClienteEco.java", "ServidorEco.java"):
                    continue  # El laboratorio integrado prueba el intercambio sin puerto fijo.
                texto = ejecutar([java, "-cp", salida, fuente.stem], cwd=carpeta,
                                 entrada="Cuaderno\n2\n12.50\n", timeout=15)
                comprobar(bool(texto), f"Ejemplo sin salida: {fuente}")
                if fuente.name in salidas:
                    comprobar(texto == salidas[fuente.name], f"Salida incorrecta: {fuente}")
                contador += 1
    print(f"Ejemplos conservados: {contador} ejecutados; cliente/servidor compilados", flush=True)


def verificar_maven(maven, java):
    comando_base = [maven, "-B", "-ntp"]
    # Un settings local puede pasarse para redes institucionales; no se publica configuración personal.
    settings = os.environ.get("CURSO_MAVEN_SETTINGS")
    if settings:
        comando_base += ["-s", settings]
    proyectos = [RAIZ, RAIZ / "unidad24-maven/ejemplos/proyecto-minimo",
                 RAIZ / "unidad25-junit", RAIZ / "unidad26-mockito"]
    total = 0
    for proyecto in proyectos:
        print(f"Maven: {proyecto.relative_to(RAIZ) if proyecto != RAIZ else 'proyecto final'}", flush=True)
        salida = ejecutar(comando_base + ["verify"], cwd=proyecto, timeout=300)
        informes = sorted((proyecto / "target/surefire-reports").glob("TEST-*.xml"))
        comprobar(bool(informes), "Maven no produjo informes de pruebas")
        for informe in informes:
            suite = ET.parse(informe).getroot()
            comprobar(int(suite.attrib.get("failures", 0)) == 0
                      and int(suite.attrib.get("errors", 0)) == 0
                      and int(suite.attrib.get("skipped", 0)) == 0, f"Pruebas no aprobadas: {informe}")
            total += int(suite.attrib["tests"])
    comprobar(total > 0, "No se ejecutaron pruebas")
    with tempfile.TemporaryDirectory(prefix="java proyecto ") as directorio:
        archivo = Path(directorio) / "carpeta con espacios" / "inventario.txt"
        jar = RAIZ / "target/curso-java-1.1.0.jar"
        salida = ejecutar([java, "-jar", str(jar), str(archivo)],
                          entrada="1\nA\nCuaderno\n12.50\n3\n4\nA\n1\n5\n0\n")
        comprobar("Valor de existencias: 25.00" in salida, "Reporte de consola empaquetada")
        salida = ejecutar([java, "-jar", str(jar), str(archivo)], entrada="2\n0\n")
        comprobar("stock 2" in salida, "Persistencia entre procesos")
    salida = ejecutar([java, "-jar", str(proyectos[1] / "target/java-unidad24-1.1.0.jar")])
    comprobar(salida == "Hola, Java", "JAR del proyecto mínimo")
    print(f"JUnit/Mockito: {total} pruebas aprobadas; dos JAR ejecutables comprobados", flush=True)


def main():
    sys.stdout.reconfigure(encoding="utf-8")
    sys.stderr.reconfigure(encoding="utf-8")
    herramientas = {nombre: shutil.which(nombre) for nombre in ("java", "javac", "mvn")}
    if not all(herramientas.values()):
        raise RuntimeError("Necesitas java, javac y mvn en PATH. Consulta docs/ENTORNO.md")
    verificar_documentacion()
    verificar_laboratorios(herramientas["java"], herramientas["javac"])
    verificar_ejemplos(herramientas["java"], herramientas["javac"])
    verificar_maven(herramientas["mvn"], herramientas["java"])
    print(f"Verificación completa: {COMPROBACIONES} comprobaciones", flush=True)


if __name__ == "__main__":
    try:
        main()
    except (AssertionError, RuntimeError, subprocess.TimeoutExpired) as error:
        print(str(error), file=sys.stderr)
        sys.exit(1)

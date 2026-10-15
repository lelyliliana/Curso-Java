# Verificación reproducible

## Resultados de la versión 1.2

Comprobación del 14 de octubre de 2026 (Colombia), en Linux con Amazon Corretto 21.0.12, objetivo Java 21 y Maven 3.9.16. Se conservaron las dependencias fijadas del curso.

| Área | Resultado observado |
|---|---|
| Documentación | 31 unidades con desarrollos, prácticas y soluciones; 883 referencias locales válidas |
| Laboratorios | 27 compilados y ejecutados con salida contrastada |
| Extensiones | 13 programas completos compilados y ejecutados con casos normales, fronteras y rechazos |
| Fragmentos nuevos | Seis fragmentos extraídos de los desarrollos, compilados en el contexto explicado y ejecutados |
| Ejemplos conservados | 26 ejecutados; cliente y servidor de dos terminales compilados |
| Maven y pruebas | Cuatro proyectos verificados; 66 pruebas JUnit/Mockito aprobadas, sin fallos, errores ni omitidas |
| Artefactos | Dos JAR ejecutables comprobados (inventario y saludo) |
| Inventario ampliado | Añadir existencias y actualizar nombre/precio conservan invariantes, guardan antes de confirmar y se recuperan entre procesos |
| Rechazos | Cantidad extrema, estado máximo, datos inválidos, fallo de escritura y EOF comprobados |
| Verificación completa | 1459 comprobaciones del script aprobadas |

El total de comprobaciones incluye estructura documental, referencias y expectativas de programas; no representa porcentaje de cobertura. Los 66 tests se contabilizan desde informes reales de Surefire, incluidas invocaciones parametrizadas.

En esta revisión se ejecutó Linux con JDK 21. La matriz de integración continua conserva Ubuntu/Windows/macOS y JDK 21/25; esa configuración no equivale a afirmar que se hayan observado aquí sus resultados para este commit. Las limitaciones de una sesión local, durabilidad y concurrencia entre procesos permanecen.

## Paso 1. Requisitos

JDK 21 o25, Maven 3.9.16 y Python 3.10 o posterior. Las herramientas deben estar en PATH; consulta [ENTORNO.md](ENTORNO.md). La primera resolución de dependencias requiere Internet. No desactives comprobaciones de TLS para resolver un problema de red.

## Paso 2. Comprobación completa

Desde la raíz:

```text
python scripts/verificar.py
```

En sistemas donde Python se llama python3 o py -3, sustituye solo ese lanzador. El script utiliza rutas compuestas, carpetas temporales con espacios y comandos sin shell específico.

La verificación configura UTF-8 para la salida de Python y para los procesos Java que inicia, mediante file.encoding, stdout.encoding y stderr.encoding. La salida estándar de una JVM puede usar una codificación distinta de la de archivos, especialmente en Windows; indicar solamente `javac -encoding UTF-8` no la configura. Esta decisión permite comparar tildes y símbolos sin perder información. No modifica la configuración permanente de tu terminal.

## Qué se comprueba

| Área | Comprobación |
|---|---|
| Material | 31 unidades, desarrollos/prácticas/soluciones, navegación y referencias locales existentes; marcas internas y codificación dañada en Markdown |
| Laboratorios | 27 compilaciones aisladas y salidas esperadas, EOF y configuración inválida |
| Extensiones resueltas | 13 programas independientes con salidas de casos normales, fronteras y rechazos |
| Fragmentos nuevos | Seis fragmentos extraídos de los desarrollos, compilados dentro de su contexto y ejecutados |
| Ejemplos conservados | Compilación por carpeta, ejecución de ejemplos y compilación cliente/servidor |
| Dominio | Contratos de Producto e Inventario, fronteras, unicidad y estado posterior |
| Archivo | Ida/vuelta UTF-8, corrupción, tamaño, duplicados y limpieza de temporales |
| Servicio | Cambio confirmado después de guardar, rechazo sin escritura y fallo de I/O |
| Consola | Registro, consulta, retiro, ampliación de existencias, actualización, reporte, filtro, EOF y reinicio |
| Construcción | Cuatro proyectos Maven, informes con pruebas ejecutadas, JAR ejecutables |
| Sistemas | Matriz de Ubuntu, Windows y macOS, con JDK 21 y25 |

La propiedad java.class.version del laboratorio 01 cambia con la JVM activa: se verifica compatibilidad y el resto de la salida, sin fingir que identifica el bytecode del archivo. El mensaje INFO del laboratorio 27 contiene fecha/formato variables y no se compara como una cadena fija.

## Paso 3. Pruebas del proyecto final

```text
mvn test
```

ProductoTest e InventarioTest comprueban reglas puras. ArchivoInventarioTest usa archivos reales temporales. ServicioInventarioTest usa Mockito para provocar fallos de Almacen. ConsolaTest ejecuta comandos completos con entrada y salida controladas. El script comprueba también el JAR en procesos separados para verificar persistencia tras reiniciar, incluidas las opciones 7 y 8 de las ampliaciones.

## Paso 4. Leer resultados

Maven debe indicar Tests run mayor que cero, sin fallos, errores ni pruebas omitidas. Los XML de target/surefire-reports permiten ver qué suite se ejecutó. Si falla un laboratorio, el script muestra la carpeta y la salida obtenida. No borres un caso para convertir la verificación en verde.

[Resultados de integración continua](https://github.com/lelyliliana/Curso-Java/actions). La matriz ejecuta los mismos comandos del curso; no constituye una certificación de todas las instalaciones, permisos o sistemas de archivos posibles.

## Límites de la evidencia

La demostración deliberadamente incorrecta CondicionCarrera se ejecuta sin exigir que falle siempre; su resultado no determinista no se utiliza como prueba de corrección. El laboratorio 23 sí prueba un intercambio TCP real sobre loopback con puerto asignado por el sistema. Los ejemplos en dos terminales se compilan; pueden requerir liberar puerto 5000 para una ejecución manual.

El chequeo de enlaces prueba destinos locales, no la disponibilidad futura de sitios externos. Las pruebas del inventario no prometen durabilidad ante cortes, acceso simultáneo ni protección de un servicio público.

[Índice](../README.md)

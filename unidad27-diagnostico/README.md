# Unidad 27: Diagnóstico, logging, depuración y configuración

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Investigar fallos con hipótesis/evidencia, usar debugger/logs y separar configuración del código.

## 1. No cambies cosas al azar

Proceso:
```text
síntoma
→ reproducir
→ hipótesis
→ evidencia
→ experimento pequeño
→ conclusión
→ corrección
→ prueba de regresión
```

Cambiar cinco cosas simultáneamente destruye información.

## 2. Stack trace

Lee:
- tipo de excepción;
- mensaje;
- causa (`Caused by`);
- primera línea relevante de tu código;
- cadena de llamadas.

No empieces necesariamente por la primera línea del stack si pertenece a framework/biblioteca.

## 3. Logging

Niveles conceptuales:
- ERROR: fallo que requiere atención;
- WARN: situación anómala/recuperable;
- INFO: eventos operativos significativos;
- DEBUG/TRACE: detalle diagnóstico.

La política concreta depende de la aplicación.

## 4. No registres secretos

Nunca logs con:
- contraseñas;
- tokens;
- claves;
- datos sensibles innecesarios.

“Necesito depurar” no justifica exponerlos.

## 5. System.out vs logging

Para ejercicios, println es útil.

En aplicaciones con observabilidad, un framework de logging aporta niveles, destinos, formato y contexto.

No añadiremos uno obligatorio solo para aprender el concepto.

## 6. Debugger

Herramientas:
- breakpoint;
- step over;
- step into;
- step out;
- watches;
- inspección de variables.

Usa breakpoint cerca del punto donde el estado empieza a divergir, no necesariamente donde finalmente explota.

## 7. Configuración

No hardcodees:
```java
String password = "real-secret";
String ruta = "/home/miusuario/...";
```

Valores variables por entorno deben venir de mecanismos de configuración apropiados.

## 8. Variables de entorno

Pueden servir para ciertos secretos/configuración:
```java
System.getenv("APP_PORT")
```

Pero también requieren validación y gestión segura.

## 9. Causa y contexto

Al relanzar:
```java
throw new ProcesamientoException(
    "Error procesando archivo " + nombreSeguro,
    e
);
```

Conserva causa sin incluir datos sensibles.

## 10. Práctica guiada

Toma programa defectuoso:
1. reproduce;
2. escribe hipótesis;
3. breakpoint;
4. inspecciona;
5. añade log solo si aporta;
6. corrige;
7. crea test que falle antes y pase después.

Consulta `GUIA.md`.

## 11. Errores frecuentes
- “arreglar” borrando configuración/caché sin hipótesis.
- logs excesivos.
- secretos en logs.
- catch que pierde stack trace.
- debugger sin entender flujo.
- configuración personal versionada.

## 12. Reto
Diagnostica un fallo y entrega bitácora hipótesis→evidencia→corrección→prueba.

## 13. Autoevaluación
1. ¿Qué lees en stack trace?
2. ¿Qué es causa?
3. ¿INFO/DEBUG son iguales?
4. ¿Qué no debe ir a logs?
5. ¿Por qué cambiar una variable por vez?
6. ¿Cómo una prueba evita regresión?

## 14. Checklist
- [ ] Reproduzco.
- [ ] Formulo hipótesis.
- [ ] Uso debugger/logs.
- [ ] Protejo secretos.
- [ ] Creo regresión.

Continúa con buenas prácticas.


## Laboratorio completo: observar, explicar y modificar

System.getProperty consulta propiedades de la JVM; System.getenv consulta variables del proceso. Son mecanismos diferentes. Un valor predeterminado solo se aplica ante ausencia, no ante formato incorrecto. java.util.logging pertenece al JDK y permite niveles sin añadir un framework. La marca temporal del log no forma parte de la salida estable del ejercicio.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad27-diagnostico/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

### Paso 2. Compila

```text
javac -encoding UTF-8 --release 21 Laboratorio.java
```

`-encoding` define cómo se lee el código fuente y `--release` fija lenguaje, API y formato de clase compatibles con Java 21. Son decisiones diferentes. Si el comando falla, corrige el primer error relevante antes de ejecutar un bytecode antiguo.

### Paso 3. Ejecuta

```text
java Laboratorio
```

Compara la salida con el resultado previsto. Los valores se eligieron para hacer visible el comportamiento de esta unidad.

```text
Límite: 3 (más un registro INFO con fecha y formato dependientes del entorno)
```

### Paso 4. Recorre la lógica

Ejecuta con -Dcurso.limite=5 antes del nombre de la clase. Repite con 0 y abc. Pon un breakpoint tras parseInt y compara hipótesis con valor observado. No imprimas el entorno completo para depurar.

### Paso 5. Lee el código completo

```java
import java.util.logging.Logger;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        Logger log = Logger.getLogger(Laboratorio.class.getName());
        String texto = System.getProperty("curso.limite", "3");
        try {
            int limite = Integer.parseInt(texto);
            if (limite < 1 || limite > 10) throw new IllegalArgumentException("Límite entre 1 y 10");
            log.info("Configuración validada");
            System.out.println("Límite: " + limite);
        } catch (IllegalArgumentException e) {
            System.out.println("Configuración rechazada: " + e.getMessage());
        }
    }

    
}
```

### Paso 6. Comprueba y extiende

Ausente:valor por defecto; 5000:válido; 80:fuera de política; abc:formato; 65536:fuera de rango.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 26: Mockito y pruebas con dependencias](../unidad26-mockito/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 28: Buenas prácticas y refactorización](../unidad28-buenas-practicas/README.md)


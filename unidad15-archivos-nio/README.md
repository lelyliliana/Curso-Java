# Unidad 15: Archivos y NIO

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Trabajar con Path/Files, elegir lectura completa o streaming, manejar codificación y recursos.

## 1. Path

```java
Path ruta = Path.of("datos", "entrada.txt");
```

Path representa una ruta de forma independiente de concatenar separadores manualmente.

Evita:
```java
"C:\\Users\\miNombre\\Desktop\\..."
```
en proyectos compartidos.

## 2. Ruta relativa

```text
datos/entrada.txt
```

se resuelve respecto al directorio de trabajo del proceso, no necesariamente respecto al archivo fuente.

Muchos “archivo no encontrado” son realmente confusión sobre directorio de trabajo.

## 3. Leer archivo pequeño

```java
String contenido = Files.readString(ruta);
```

Carga todo en memoria.

Apropiado si sabes que el archivo es pequeño.

## 4. Líneas

```java
List<String> lineas = Files.readAllLines(ruta);
```

También carga todas.

## 5. Archivo grande

```java
try (Stream<String> lineas = Files.lines(ruta)) {
    lineas.forEach(System.out::println);
}
```

El stream debe cerrarse; try-with-resources es apropiado.

No guardes el Stream para usarlo después del cierre.

## 6. Escritura

```java
Files.writeString(Path.of("salida.txt"), "Hola");
```

Revisa opciones de sobrescritura/append cuando el requisito lo necesite.

## 7. Codificación

Puedes indicar `StandardCharsets.UTF_8` cuando el contrato del archivo lo requiere.

No dependas ciegamente de defaults si intercambias archivos entre sistemas.

## 8. Metadatos/operaciones

Files permite:
- exists;
- createDirectories;
- copy;
- move;
- delete;
- size.

Cada operación tiene errores posibles y condiciones de carrera; `exists` antes de operar no sustituye manejo de excepción.

## 9. Práctica guiada

Archivo:
```text
Ana,10
Luis,abc
Sara,20
```

Procesa línea por línea:
- válida;
- inválida;
- número de línea;
- motivo.

Genera reporte separado.

## 10. Seguridad básica

Una ruta proveniente de usuario no debe usarse sin analizar si puede escapar del directorio permitido (path traversal) en aplicaciones que exponen acceso a archivos.

Este curso introduce el riesgo; el diseño seguro depende del contexto.

## 11. Errores frecuentes
- ruta absoluta personal.
- asumir directorio de trabajo.
- readAllLines para archivos enormes.
- no cerrar Stream.
- ignorar codificación.
- perder línea/motivo al importar.

## 12. Ejercicios
Leer, escribir, copiar, procesar CSV simple y generar reporte.

## 13. Reto
Importador de registros con válidas/inválidas y resumen, sin cargar todo si el archivo puede crecer.

## 14. Autoevaluación
1. ¿Qué es Path?
2. ¿Respecto a qué se resuelve ruta relativa?
3. ¿readString carga todo?
4. ¿Files.lines requiere cierre?
5. ¿Por qué codificación explícita?
6. ¿exists elimina necesidad de manejar errores?

## 15. Checklist
- [ ] Uso Path/Files.
- [ ] Elijo estrategia por tamaño.
- [ ] Cierro recursos.
- [ ] Manejo codificación.
- [ ] Conservo diagnóstico.

Continúa con colecciones.


## Precisiones para aplicar el modelo

### CSV sencillo y persistencia

Dividir por coma sirve únicamente si el contrato excluye comas, comillas y saltos de línea dentro de campos. Un CSV general necesita un parser que entienda su formato. Documentar esa restricción evita enseñar un split como parser universal.

Files.exists es una observación que puede cambiar antes de la siguiente operación. Maneja el error de la operación real. Para no truncar directamente datos previos, escribe un temporal y reemplaza tras completar; el movimiento atómico depende del sistema de archivos. No prometas durabilidad ante cortes ni coordinación entre escritores a partir de ese patrón.

## Laboratorio completo: observar, explicar y modificar

Path describe una ruta; Files realiza operaciones que pueden fallar por permisos, ausencia, espacio o concurrencia. resolve compone rutas sin escribir separadores específicos del sistema. readAllLines carga todo el archivo en memoria y sirve para entradas pequeñas; Files.lines permite procesamiento progresivo y debe cerrarse con try-with-resources.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad15-archivos-nio/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

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
No vacías: 2
Texto UTF-8: Sol
```

### Paso 4. Recorre la lógica

Identifica creación, escritura, lectura y limpieza. Comprueba que el archivo temporal se elimina al terminar. Cambia los caracteres por tildes. Introduce una ruta inexistente en una lectura separada para reconocer IOException.

### Paso 5. Lee el código completo

```java
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        Path carpeta = Files.createTempDirectory("curso-java-");
        Path archivo = carpeta.resolve("lecturas.txt");
        try {
            Files.writeString(archivo, "Sol\n\nLuna\n", StandardCharsets.UTF_8);
            var lineas = Files.readAllLines(archivo, StandardCharsets.UTF_8);
            System.out.println("No vacías: " + lineas.stream().filter(s -> !s.isBlank()).count());
            System.out.println("Texto UTF-8: " + lineas.getFirst());
        } finally { Files.deleteIfExists(archivo); Files.deleteIfExists(carpeta); }
    }

    
}
```

### Paso 6. Comprueba y extiende

Archivo vacío:0; dos líneas útiles:2; ruta inexistente:error; tildes preservadas; recurso cerrado incluso ante fallo.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 14: Fechas y tiempo con java.time](../unidad14-fechas-tiempo/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 16: Colecciones](../unidad16-colecciones/README.md)


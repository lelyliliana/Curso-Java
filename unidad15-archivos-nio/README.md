# Unidad 15 — Archivos y NIO

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Trabajar con Path/Files, elegir lectura completa o streaming, manejar codificación y recursos.

# 1. Path

```java
Path ruta = Path.of("datos", "entrada.txt");
```

Path representa una ruta de forma independiente de concatenar separadores manualmente.

Evita:
```java
"C:\\Users\\miNombre\\Desktop\\..."
```
en proyectos compartidos.

# 2. Ruta relativa

```text
datos/entrada.txt
```

se resuelve respecto al directorio de trabajo del proceso, no necesariamente respecto al archivo fuente.

Muchos “archivo no encontrado” son realmente confusión sobre directorio de trabajo.

# 3. Leer archivo pequeño

```java
String contenido = Files.readString(ruta);
```

Carga todo en memoria.

Apropiado si sabes que el archivo es pequeño.

# 4. Líneas

```java
List<String> lineas = Files.readAllLines(ruta);
```

También carga todas.

# 5. Archivo grande

```java
try (Stream<String> lineas = Files.lines(ruta)) {
    lineas.forEach(System.out::println);
}
```

El stream debe cerrarse; try-with-resources es apropiado.

No guardes el Stream para usarlo después del cierre.

# 6. Escritura

```java
Files.writeString(Path.of("salida.txt"), "Hola");
```

Revisa opciones de sobrescritura/append cuando el requisito lo necesite.

# 7. Codificación

Puedes indicar `StandardCharsets.UTF_8` cuando el contrato del archivo lo requiere.

No dependas ciegamente de defaults si intercambias archivos entre sistemas.

# 8. Metadatos/operaciones

Files permite:
- exists;
- createDirectories;
- copy;
- move;
- delete;
- size.

Cada operación tiene errores posibles y condiciones de carrera; `exists` antes de operar no sustituye manejo de excepción.

# 9. Práctica guiada

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

# 10. Seguridad básica

Una ruta proveniente de usuario no debe usarse sin analizar si puede escapar del directorio permitido (path traversal) en aplicaciones que exponen acceso a archivos.

Este curso introduce el riesgo; el diseño seguro depende del contexto.

# 11. Errores frecuentes
- ruta absoluta personal.
- asumir directorio de trabajo.
- readAllLines para archivos enormes.
- no cerrar Stream.
- ignorar codificación.
- perder línea/motivo al importar.

# 12. Ejercicios
Leer, escribir, copiar, procesar CSV simple y generar reporte.

# 13. Reto
Importador de registros con válidas/inválidas y resumen, sin cargar todo si el archivo puede crecer.

# 14. Autoevaluación
1. ¿Qué es Path?
2. ¿Respecto a qué se resuelve ruta relativa?
3. ¿readString carga todo?
4. ¿Files.lines requiere cierre?
5. ¿Por qué codificación explícita?
6. ¿exists elimina necesidad de manejar errores?

# 15. Checklist
- [ ] Uso Path/Files.
- [ ] Elijo estrategia por tamaño.
- [ ] Cierro recursos.
- [ ] Manejo codificación.
- [ ] Conservo diagnóstico.

Continúa con colecciones.


---

## Continuar el curso

- **Unidad anterior:** [Unidad 14 — Fechas y tiempo con java.time](../unidad14-fechas-tiempo/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 16 — Colecciones](../unidad16-colecciones/README.md)

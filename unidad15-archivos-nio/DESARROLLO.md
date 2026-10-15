# Procesar un archivo por recorrido y cerrar el recurso

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad15-archivos-nio/laboratorio/Laboratorio.java](../unidad15-archivos-nio/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

La referencia crea un directorio temporal, escribe UTF-8 y carga sus líneas. Es suficiente para un archivo pequeño controlado, pero readAllLines conserva la colección completa en memoria. El contrato de la extensión pide contar sin esa carga total.

Files.lines entrega un Stream asociado a un recurso de archivo. Debe cerrarse mediante try-with-resources; que count termine no elimina la responsabilidad de cierre. filter excluye líneas isBlank y count acumula sin necesitar almacenar cada texto en una lista.

Path representa la ruta y resolve compone segmentos. No concatenes separadores de un sistema operativo ni supongas que el directorio de ejecución coincide con el de la fuente. Un argumento de ruta con espacios debe llegar como un solo argumento del proceso.

El conteo no valida cualquier tamaño de línea de una fuente no confiable: una línea individual podría ser muy grande. Tampoco convierte un archivo ausente o ilegible en cero observaciones. La ausencia del archivo se informa como fallo de I/O según el límite de esta herramienta.

## 3. Construye y contrasta

Crea un archivo con Sol, una línea vacía y Luna. Espera dos. Prueba un archivo vacío, uno con solo espacios y una ruta inexistente. Conserva tildes en UTF-8 y cierra el stream también cuando el recorrido falle.

## Implementación de la parte añadida

Método dentro de Laboratorio; main debe exigir un argumento y llamar contar(Path.of(args[0])):

```java
static long contar(Path ruta) throws IOException {
    try (var lineas = Files.lines(ruta, StandardCharsets.UTF_8)) {
        return lineas.filter(s -> !s.isBlank()).count();
    }
}
```

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2015%20%E2%80%94%20Archivos%20y%20NIO%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad15-archivos-nio%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

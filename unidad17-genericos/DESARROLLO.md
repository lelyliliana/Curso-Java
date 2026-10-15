# Expresar quién produce y quién consume un tipo

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad17-genericos/laboratorio/Laboratorio.java](../unidad17-genericos/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

List<Integer> no es subtipo de List<Number>. Si lo fuera, una operación que acepta números podría insertar un Double donde el llamador espera exclusivamente Integer. La invarianza protege esa relación.

copiar lee de List<? extends T> y escribe en List<? super T>. La fuente produce elementos compatibles con T y el destino puede consumirlos. La llamada del ejemplo permite copiar enteros a una lista de Number sin casts que oculten errores.

sumar convierte cada Number a double. Es una decisión de precisión distinta de conservar dinero exacto; los genéricos no eliminan las propiedades de la representación elegida. No generalices este método como acumulador decimal financiero.

La extensión primero preserva el tipo T en Optional<T>. La lista vacía produce ausencia; un elemento nulo no está permitido por el contrato propuesto. Optional no admite un valor null presente, así que esa condición debe explicarse antes de escoger of u ofNullable.

## 3. Construye y contrasta

Obtén primero de una lista de String, de Integer y de una lista vacía. El compilador debe conservar el tipo sin un cast. Intenta una asignación List<Number> = List<Integer> en una copia y explica el error; restáurala antes de verificar.

## Implementación de la parte añadida

Método estático dentro de Laboratorio, con los imports java.util de la referencia:

```java
static <T> Optional<T> primero(List<T> datos) {
    Objects.requireNonNull(datos);
    return datos.isEmpty() ? Optional.empty() : Optional.of(datos.getFirst());
}
```

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2017%20%E2%80%94%20Gen%C3%A9ricos%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad17-genericos%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

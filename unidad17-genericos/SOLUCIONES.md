# Soluciones razonadas

## Solución del laboratorio

El origen produce elementos para el método y el destino los consume. El parámetro T relaciona ambos lados. Los tipos genéricos son invariantes: List<Integer> no se asigna a List<Number>, pero puede pasarse como List<? extends Number>. PECS describe este acceso, no impide toda mutación de la lista; por ejemplo puede eliminar elementos si su implementación lo admite.

La salida prevista es:

```text
[1, 2, 3]
Suma: 6.0
```

Copia a List<Number> y a List<Object>. Intenta asignar directamente origen a List<Number> y observa el error de compilación en un archivo aparte. Prueba un destino List.of para distinguir seguridad de tipos de mutabilidad.

## Solución de la extensión

Devuelve Optional.empty si isEmpty y Optional.of(datos.getFirst()) en otro caso, con contrato de elementos no nulos. Si se permite null, decide si representa ausencia o error. El tipo T evita casts del llamador.

## Casos de aceptación

List<String> devuelve Optional<String>; vacía:empty; [7]:Optional[7]; destino no modificable:UnsupportedOperationException.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

La función completa es static <T> Optional<T> primero(List<T> datos): exige lista no nula, devuelve Optional.empty si está vacía y Optional.of(datos.getFirst()) si tiene un primer elemento no nulo. Con [Java,SQL] devuelve Java y con [2,3] devuelve 2 conservando tipos. No uses raw types ni un retorno Object que obligue al llamador a adivinar el tipo.

## Implementación de la parte añadida

Método estático dentro de Laboratorio, con los imports java.util de la referencia:

```java
static <T> Optional<T> primero(List<T> datos) {
    Objects.requireNonNull(datos);
    return datos.isEmpty() ? Optional.empty() : Optional.of(datos.getFirst());
}
```

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

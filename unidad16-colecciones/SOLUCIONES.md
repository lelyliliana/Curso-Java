# Soluciones razonadas

## Solución del laboratorio

List conserva secuencia y duplicados; Set expresa unicidad por equals/hashCode; Map asocia claves únicas con valores; Deque permite extremos. LinkedHashMap y LinkedHashSet conservan orden de inserción. HashMap no garantiza ese orden. List.of no admite null ni cambios estructurales; no vuelve inmutables los objetos que contiene.

La salida prevista es:

```text
Lista: [java, git, java]
Únicos: [java, git]
Frecuencias: {java=2, git=1}
Atendido: java
Restantes: [git, java]
```

Elige la estructura según la consulta, antes de escribir el bucle. Prueba un duplicado. Compara cola FIFO con removeLast LIFO. Investiga removeFirst cuando no hay elementos y pollFirst para ausencia.

## Solución de la extensión

Comprueba containsKey antes de put o usa putIfAbsent con una política de valores no nulos. Devuelve List.copyOf de los valores para evitar exponer la estructura mutable. Define orden de consulta mediante LinkedHashMap.

## Casos de aceptación

Dos códigos distintos:2; duplicado:error y primer dato intacto; vacío:listado vacío; consulta ausente no crea entrada.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

Usa Map<String,Producto> y un método registrar que exija producto no nulo, compruebe containsKey(producto.codigo()) y lance IllegalArgumentException antes de put. Un duplicado conserva la primera referencia y el tamaño. El [Inventario real](../src/main/java/com/lelyliliana/inventario/Inventario.java) implementa esa secuencia y permite contrastarla con pruebas.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

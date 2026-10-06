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

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

Dos códigos distintos:2; duplicado:error y primer dato intacto; vacío:listado vacío; consulta ausente no crea entrada.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

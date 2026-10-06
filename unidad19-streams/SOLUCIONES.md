# Soluciones razonadas

## Solución del laboratorio

Un stream es un recorrido, no una colección que guarda resultados. Operaciones intermedias son diferidas hasta una terminal. No reutilices un stream consumido: crea otro desde la fuente. groupingBy utiliza claves y acumuladores; TreeMap fija orden por categoría. La suma long sigue teniendo rango finito; las entradas de esta demostración son pequeñas.

La salida prevista es:

```text
{Libros=8000, Tecnología=20000}
Totales iguales: true
Sin ventas: 0
```

Identifica fuente, transformación y terminal. Compara total con el bucle. Prueba una fuente vacía. Añade otra venta de la misma categoría y explica qué cambia en el acumulador.

## Solución de la extensión

Agrupa primero. Ordena las entradas por valor descendente y luego clave ascendente; aplica limit(3) y toList. No ordenes ventas individuales si el requisito exige comparar totales agregados.

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

Categorías repetidas:suman; empate:orden de nombres; menos de tres:devuelve las existentes; vacío:lista vacía.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

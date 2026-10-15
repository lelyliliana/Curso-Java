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

## Casos de aceptación

Categorías repetidas:suman; empate:orden de nombres; menos de tres:devuelve las existentes; vacío:lista vacía.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

La solución agrupa en un mapa con merge y Math.addExact, convierte entradas a Total, ordena por importe descendente y nombre ascendente, y aplica limit(3). Devuelve A=60,B=60,C=5. Vacío produce lista vacía y una suma fuera de long se rechaza. El desempate no depende del orden accidental del mapa.

La [implementación completa](solucion/Solucion.java) se compila de forma independiente; el [desarrollo](DESARROLLO.md) explica su recorrido y comandos.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

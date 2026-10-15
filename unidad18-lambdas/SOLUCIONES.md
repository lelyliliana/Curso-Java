# Soluciones razonadas

## Solución del laboratorio

Una lambda necesita un tipo objetivo que sea una interfaz funcional, con un método abstracto principal. Predicate prueba una condición y Function transforma un valor. El cuerpo no ejecuta al declararse: se invoca mediante test o apply. Las variables locales capturadas deben ser finales o efectivamente finales.

La salida prevista es:

```text
[4, 6]
N=4
```

Identifica parámetros y valor devuelto. Cambia and por or y predice resultados. Reescribe par como clase anónima para comparar el contrato. Evita modificar una lista externa dentro del predicate.

## Solución de la extensión

Combina dos Predicate<Producto>. Normaliza una vez el criterio y usa startsWith dentro de la condición. Mantén los predicates sin efectos laterales y devuelve una nueva lista.

## Casos de aceptación

Cumple ambas:incluido; solo stock:no incluido con and; lista vacía:vacía; original intacto.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

Define Predicate<Producto> disponible = p -> p.stock()>0 y otro de nombre que compare prefijos normalizados con Locale.ROOT; combina mediante disponible.and(prefijo). Con C se acepta Cuaderno, no Cable ni Libro. El dominio Producto del inventario ya garantiza nombre no vacío. Esta selección no cambia stock y no equivale a búsqueda fonética.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

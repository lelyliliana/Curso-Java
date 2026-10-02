# Unidad 19 — Stream API

Streams permiten expresar pipelines de procesamiento.

```java
List<String> nombres = personas.stream()
    .filter(Persona::activa)
    .map(Persona::nombre)
    .sorted()
    .toList();
```

## Operaciones
Intermedias: filter, map, sorted.
Terminales: toList, collect, reduce, count, forEach.

## Streams no son colecciones
Un Stream representa una secuencia de operaciones y normalmente se consume una vez.

## Evita efectos secundarios
Un pipeline es más fácil de razonar cuando sus operaciones no modifican estado externo.

## Reto
Procesa ventas: filtra, agrupa, suma y ordena resultados.

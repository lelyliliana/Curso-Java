# Unidad 16 — Colecciones

## List
Orden y repetidos.

## Set
Unicidad.

## Map
Clave → valor.

## Queue / Deque
Procesamiento por orden o doble extremo.

## Elegir por operaciones
No elijas ArrayList/HashMap por costumbre. Pregunta:
- ¿necesito índice?
- ¿unicidad?
- ¿búsqueda por clave?
- ¿orden?
- ¿cola/pila?

## Ejemplo
```java
Map<String, Integer> frecuencia = new HashMap<>();
frecuencia.merge(palabra, 1, Integer::sum);
```

## Reto
Analiza registros usando List, Set y Map, justificando el papel de cada estructura.

# Unidad 16 — Colecciones

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Elegir interfaces y implementaciones según operaciones, comprender igualdad/hash y utilizar List, Set, Map, Queue y Deque.

# 1. Programa contra la abstracción

```java
List<String> nombres = new ArrayList<>();
```

Tipo de variable: `List`.  
Implementación: `ArrayList`.

Esto permite expresar qué operaciones necesita el consumidor sin acoplarse innecesariamente a la implementación.

# 2. List

```java
List<String> nombres = new ArrayList<>();
nombres.add("Ana");
nombres.add("Ana");
```

Conserva secuencia y permite repetidos.

ArrayList ofrece acceso por índice eficiente en términos generales, pero inserciones/eliminaciones en ciertas posiciones pueden mover elementos.

LinkedList tiene características diferentes; no la elijas solo porque “insertar es O(1)” sin considerar localizar posición, memoria y patrones reales.

# 3. Set

```java
Set<String> etiquetas = new HashSet<>();
```

Modela unicidad.

HashSet no promete un orden de iteración que debas usar como contrato.

Si necesitas orden de inserción o orden natural/comparador, existen otras implementaciones como LinkedHashSet/TreeSet con distintos costos/semántica.

# 4. Map

```java
Map<String,Integer> frecuencia = new HashMap<>();
frecuencia.merge(palabra,1,Integer::sum);
```

Asocia clave→valor.

Las claves deben comportarse correctamente respecto a `equals` y `hashCode` para colecciones hash.

# 5. equals y hashCode

Si dos objetos son iguales según `equals`, deben producir el mismo `hashCode`.

Romper ese contrato produce comportamientos incorrectos en HashSet/HashMap.

Records ya generan ambos coherentemente según componentes.

# 6. Claves mutables

Usar como clave un objeto cuyo estado que participa en equals/hashCode cambia después de insertarlo puede hacer que el mapa/conjunto deje de encontrarlo correctamente.

Prefiere claves estables/inmutables.

# 7. Queue

```java
Queue<Tarea> cola = new ArrayDeque<>();
```

FIFO.

Métodos como `offer/poll/peek` tienen contratos diferentes de `add/remove/element` ante capacidad/vacío.

# 8. Deque

```java
Deque<Integer> pila = new ArrayDeque<>();
pila.push(10);
pila.pop();
```

Puede funcionar como pila o doble extremo.

Para nuevas pilas suele preferirse Deque frente a la clase legacy Stack.

# 9. Ordenamiento

```java
nombres.sort(Comparator.naturalOrder());
```

O:
```java
personas.sort(Comparator.comparing(Persona::nombre));
```

No mezcles “colección ordenada” con “ordenar temporalmente una lista”.

# 10. Elegir

Pregunta:
- ¿posición?
- ¿duplicados?
- ¿unicidad?
- ¿clave?
- ¿orden?
- ¿FIFO/LIFO?
- ¿qué operaciones dominan?

# 11. Práctica guiada

Procesa compras:
- List conserva transacciones;
- Set obtiene categorías únicas;
- Map acumula total por categoría;
- Queue simula pendientes.

Justifica cada estructura.

# 12. Errores frecuentes
- ArrayList/HashMap por costumbre.
- Depender del orden de HashMap/HashSet.
- claves mutables.
- equals sin hashCode.
- LinkedList por una complejidad aislada.
- usar List para búsquedas por clave repetidas sin analizar.

# 13. Ejercicios
Frecuencias, únicos, agenda, cola de tareas, ranking con Comparator.

# 14. Reto
Analiza registros usando al menos tres abstracciones y documenta por qué cada una corresponde al problema.

# 15. Autoevaluación
1. ¿List vs ArrayList?
2. ¿Set permite duplicados?
3. ¿Map usa claves?
4. ¿Contrato equals/hashCode?
5. ¿Por qué clave mutable es riesgosa?
6. ¿Deque puede ser pila?

# 16. Checklist
- [ ] Elijo interfaces.
- [ ] Comprendo implementaciones.
- [ ] Respeto equals/hashCode.
- [ ] No dependo de orden inexistente.
- [ ] Justifico estructura.

Continúa con genéricos.


---

## Continuar el curso

- **Unidad anterior:** [Unidad 15 — Archivos y NIO](../unidad15-archivos-nio/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 17 — Genéricos](../unidad17-genericos/README.md)

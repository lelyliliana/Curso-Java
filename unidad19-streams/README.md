# Unidad 19 — Stream API

## Qué aprenderás
Construir pipelines declarativos, distinguir operaciones intermedias/terminales y reconocer cuándo un ciclo es más claro.

# 1. Colección vs Stream

```java
List<Persona> personas = ...;
```

La List almacena elementos.

```java
personas.stream()
```

crea un flujo de procesamiento sobre una fuente.

Un Stream normalmente se consume una vez.

# 2. Pipeline

```java
List<String> nombres = personas.stream()
    .filter(Persona::activa)
    .map(Persona::nombre)
    .sorted()
    .toList();
```

Lee:
1. fuente;
2. filtrar;
3. transformar;
4. ordenar;
5. materializar resultado.

# 3. Intermedias

`filter`, `map`, `sorted`, `distinct`, `limit`.

Son generalmente lazy: construyen pipeline y el trabajo ocurre al ejecutar terminal.

# 4. Terminales

`toList`, `collect`, `reduce`, `count`, `findFirst`, `anyMatch`, `forEach`.

Después de una terminal, no reutilices el mismo Stream.

# 5. map no es forEach

`map` transforma cada elemento a otro valor.

`forEach` es terminal y suele usarse para un efecto.

No uses map para efectos secundarios.

# 6. reduce

Suma:
```java
int total = numeros.stream()
    .reduce(0, Integer::sum);
```

Para agregaciones complejas/mutables, collectors suelen expresar mejor la intención.

# 7. Collectors

```java
Map<String, Long> porCategoria = ventas.stream()
    .collect(Collectors.groupingBy(
        Venta::categoria,
        Collectors.counting()
    ));
```

# 8. Efectos secundarios

Evita:

```java
List<String> salida = new ArrayList<>();
personas.stream().forEach(p -> salida.add(p.nombre()));
```

Mejor:
```java
List<String> salida = personas.stream()
    .map(Persona::nombre)
    .toList();
```

# 9. Stream o ciclo

Un ciclo puede ser más claro cuando:
- hay estado complejo;
- control de flujo irregular;
- múltiples efectos;
- el pipeline se vuelve críptico.

Streams no son una medida de “Java más profesional”.

# 10. Streams paralelos

`parallelStream()` no hace automáticamente más rápido.

Depende de tamaño, costo por elemento, divisibilidad, pool, efectos, orden y entorno.

No lo uses sin medir y comprender seguridad del trabajo.

# 11. Práctica guiada

Ventas:
1. filtra pagadas;
2. map a importes;
3. suma;
4. agrupa por categoría;
5. ordena reporte.

Después escribe una versión imperativa y compara legibilidad.

# 12. Errores frecuentes
- reutilizar Stream.
- efectos externos.
- pipeline enorme.
- parallel por velocidad supuesta.
- usar forEach para construir colección.
- Optional.get dentro de pipeline sin comprobar.

# 13. Ejercicios
Filter/map, anyMatch, reduce, groupingBy, partitioningBy y comparación con ciclo.

# 14. Reto
Reporte de ventas con filtrado, agrupación, suma y orden. Explica por qué Stream mejora o no la solución.

# 15. Autoevaluación
1. ¿Stream almacena datos?
2. ¿Qué es lazy?
3. ¿map vs forEach?
4. ¿Stream se reutiliza?
5. ¿parallel garantiza velocidad?
6. ¿Cuándo ciclo puede ser mejor?

# 16. Checklist
- [ ] Diseño pipelines legibles.
- [ ] Distingo intermedia/terminal.
- [ ] Evito efectos.
- [ ] No fuerzo Streams.

Continúa con Optional.

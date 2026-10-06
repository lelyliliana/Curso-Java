# Unidad 19: Stream API

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Construir pipelines declarativos, distinguir operaciones intermedias/terminales y reconocer cuándo un ciclo es más claro.

## 1. Colección vs Stream

```java
record Persona(String nombre, boolean activa) {}
List<Persona> personas = List.of(new Persona("Ana", true), new Persona("Luis", false));
```

La List almacena elementos.

```java
personas.stream()
```

crea un flujo de procesamiento sobre una fuente.

Un Stream normalmente se consume una vez.

## 2. Pipeline

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

## 3. Intermedias

`filter`, `map`, `sorted`, `distinct`, `limit`.

Son generalmente lazy: construyen pipeline y el trabajo ocurre al ejecutar terminal.

## 4. Terminales

`toList`, `collect`, `reduce`, `count`, `findFirst`, `anyMatch`, `forEach`.

Después de una terminal, no reutilices el mismo Stream.

## 5. map no es forEach

`map` transforma cada elemento a otro valor.

`forEach` es terminal y suele usarse para un efecto.

No uses map para efectos secundarios.

## 6. reduce

Suma:
```java
int total = numeros.stream()
    .reduce(0, Integer::sum);
```

Para agregaciones complejas/mutables, collectors suelen expresar mejor la intención.

## 7. Collectors

```java
Map<String, Long> porCategoria = ventas.stream()
    .collect(Collectors.groupingBy(
        Venta::categoria,
        Collectors.counting()
    ));
```

## 8. Efectos secundarios

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

## 9. Stream o ciclo

Un ciclo puede ser más claro cuando:
- hay estado complejo;
- control de flujo irregular;
- múltiples efectos;
- el pipeline se vuelve críptico.

Streams no son una medida de “Java más profesional”.

## 10. Streams paralelos

`parallelStream()` no hace automáticamente más rápido.

Depende de tamaño, costo por elemento, divisibilidad, pool, efectos, orden y entorno.

No lo uses sin medir y comprender seguridad del trabajo.

## 11. Práctica guiada

Ventas:
1. filtra pagadas;
2. map a importes;
3. suma;
4. agrupa por categoría;
5. ordena reporte.

Después escribe una versión imperativa y compara legibilidad.

## 12. Errores frecuentes
- reutilizar Stream.
- efectos externos.
- pipeline enorme.
- parallel por velocidad supuesta.
- usar forEach para construir colección.
- Optional.get dentro de pipeline sin comprobar.

## 13. Ejercicios
Filter/map, anyMatch, reduce, groupingBy, partitioningBy y comparación con ciclo.

## 14. Reto
Reporte de ventas con filtrado, agrupación, suma y orden. Explica por qué Stream mejora o no la solución.

## 15. Autoevaluación
1. ¿Stream almacena datos?
2. ¿Qué es lazy?
3. ¿map vs forEach?
4. ¿Stream se reutiliza?
5. ¿parallel garantiza velocidad?
6. ¿Cuándo ciclo puede ser mejor?

## 16. Checklist
- [ ] Diseño pipelines legibles.
- [ ] Distingo intermedia/terminal.
- [ ] Evito efectos.
- [ ] No fuerzo Streams.

Continúa con Optional.


## Laboratorio completo: observar, explicar y modificar

Un stream es un recorrido, no una colección que guarda resultados. Operaciones intermedias son diferidas hasta una terminal. No reutilices un stream consumido: crea otro desde la fuente. groupingBy utiliza claves y acumuladores; TreeMap fija orden por categoría. La suma long sigue teniendo rango finito; las entradas de esta demostración son pequeñas.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad19-streams/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

### Paso 2. Compila

```text
javac -encoding UTF-8 --release 21 Laboratorio.java
```

`-encoding` define cómo se lee el código fuente y `--release` fija lenguaje, API y formato de clase compatibles con Java 21. Son decisiones diferentes. Si el comando falla, corrige el primer error relevante antes de ejecutar un bytecode antiguo.

### Paso 3. Ejecuta

```text
java Laboratorio
```

Compara la salida con el resultado previsto. Los valores se eligieron para hacer visible el comportamiento de esta unidad.

```text
{Libros=8000, Tecnología=20000}
Totales iguales: true
Sin ventas: 0
```

### Paso 4. Recorre la lógica

Identifica fuente, transformación y terminal. Compara total con el bucle. Prueba una fuente vacía. Añade otra venta de la misma categoría y explica qué cambia en el acumulador.

### Paso 5. Lee el código completo

```java
import java.util.*;
import java.util.stream.Collectors;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        var ventas = List.of(new Venta("Libros", 5000), new Venta("Tecnología", 20000), new Venta("Libros", 3000));
        var totales = ventas.stream().collect(Collectors.groupingBy(Venta::categoria,
                TreeMap::new, Collectors.summingLong(Venta::centavos)));
        System.out.println(totales);
        long suma = ventas.stream().mapToLong(Venta::centavos).sum();
        long imperativa = 0;
        for (Venta venta : ventas) imperativa += venta.centavos();
        System.out.println("Totales iguales: " + (suma == imperativa));
        System.out.println("Sin ventas: " + List.<Venta>of().stream().mapToLong(Venta::centavos).sum());
    }

    record Venta(String categoria, long centavos) {}
}
```

### Paso 6. Comprueba y extiende

Categorías repetidas:suman; empate:orden de nombres; menos de tres:devuelve las existentes; vacío:lista vacía.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 18: Lambdas e interfaces funcionales](../unidad18-lambdas/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 20: Optional y ausencia de valores](../unidad20-optional/README.md)


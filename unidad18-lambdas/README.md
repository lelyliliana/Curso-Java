# Unidad 18 — Lambdas e interfaces funcionales

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Tratar comportamiento como valor mediante interfaces funcionales, lambdas y referencias a métodos.

# 1. Problema

Queremos filtrar números según distintas reglas.

Sin parametrizar comportamiento podríamos duplicar:
```text
filtrarPares
filtrarPositivos
filtrarMayoresA10
```

Podemos recibir la regla.

# 2. Interface funcional

Tiene un único método abstracto relevante para lambda.

```java
@FunctionalInterface
interface Regla<T> {
    boolean cumple(T valor);
}
```

# 3. Lambda

```java
Regla<Integer> esPar = n -> n % 2 == 0;
```

No es “una función suelta” fuera del sistema de tipos: es una implementación compatible con un tipo funcional objetivo.

# 4. Predicate

Java ya ofrece:

```java
Predicate<Integer> esPar = n -> n % 2 == 0;
```

`Predicate<T>`: T→boolean.

# 5. Interfaces estándar

`Consumer<T>`: recibe T, no retorna valor.  
`Supplier<T>`: produce T.  
`Function<T,R>`: transforma T→R.  
`UnaryOperator<T>`: T→T.  
`BiFunction<T,U,R>`: dos entradas→R.

Elegir una estándar evita interfaces propias innecesarias.

# 6. Captura

```java
int limite = 10;
Predicate<Integer> mayor = n -> n > limite;
```

Variables locales capturadas deben ser finales o efectivamente finales.

No puedes reasignar `limite` después de usarlo así.

# 7. Referencia a método

```java
System.out::println
```

Puede sustituir una lambda cuando las firmas son compatibles.

No la uses si vuelve menos clara la intención.

# 8. Composición

Predicates:
```java
Predicate<Integer> positivo = n -> n > 0;
Predicate<Integer> par = n -> n % 2 == 0;

Predicate<Integer> positivoYPar = positivo.and(par);
```

# 9. Práctica guiada

Crea método:
```java
filtrar(List<T>, Predicate<T>)
```

Pásale:
- pares;
- positivos;
- Strings no vacíos.

Observa que el algoritmo de recorrido no cambia; cambia el comportamiento recibido.

# 10. Errores frecuentes
- lambda larga con mucha lógica.
- crear interface propia cuando Function/Predicate basta.
- efectos secundarios ocultos.
- referencias a métodos crípticas.
- creer que lambda elimina tipos.

# 11. Ejercicios
Predicates, transformaciones, comparadores y estrategias recibidas como parámetro.

# 12. Reto
Refactoriza reglas hardcodeadas para recibir comportamiento y prueba varias implementaciones.

# 13. Autoevaluación
1. ¿Qué es interface funcional?
2. ¿Lambda tiene tipo objetivo?
3. ¿Predicate?
4. ¿Function?
5. ¿Qué significa efectivamente final?
6. ¿Referencia a método siempre mejora?

# 14. Checklist
- [ ] Uso interfaces estándar.
- [ ] Escribo lambdas pequeñas.
- [ ] Comprendo captura.
- [ ] Parametrizo comportamiento.

Continúa con Streams.


---

## Continuar el curso

- **Unidad anterior:** [Unidad 17 — Genéricos](../unidad17-genericos/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 19 — Stream API](../unidad19-streams/README.md)

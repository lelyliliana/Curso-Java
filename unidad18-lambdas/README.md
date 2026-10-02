# Unidad 18 — Lambdas e interfaces funcionales

## Lambda
```java
x -> x * 2
```

Representa comportamiento compatible con una interfaz funcional.

## Interfaces estándar
- Predicate<T>
- Consumer<T>
- Supplier<T>
- Function<T,R>

## Ejemplo
```java
Predicate<Integer> esPar = n -> n % 2 == 0;
```

## Referencias a métodos
```java
System.out::println
```

## Reto
Reemplaza estrategias hardcodeadas por funciones recibidas como parámetro.

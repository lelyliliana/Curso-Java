# Unidad 04 — Decisiones

## if / else
```java
if (edad >= 18) {
    System.out.println("Mayor de edad");
} else {
    System.out.println("Menor de edad");
}
```

## Condiciones compuestas
```java
if (nota >= 0 && nota <= 5) {
    // rango válido
}
```

## switch
Útil cuando una expresión se compara con casos discretos.

```java
String nombreDia = switch (dia) {
    case 1 -> "Lunes";
    case 2 -> "Martes";
    default -> "Otro";
};
```

## Orden
Las condiciones más generales pueden ocultar condiciones específicas.

## Ejercicios
1. Par/impar.
2. Mayor de tres.
3. Nota por rangos.
4. Año bisiesto.
5. Menú con switch.

## Reto
Construye una tarifa por rangos y crea pruebas para cada frontera.

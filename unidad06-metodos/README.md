# Unidad 06 — Métodos y modularización

## Método
```java
static boolean esPar(int numero) {
    return numero % 2 == 0;
}
```

## Parámetros y retorno
El método recibe información mediante parámetros y puede devolver un resultado.

## Sobrecarga
Java permite métodos con el mismo nombre y diferentes listas de parámetros.

```java
static int sumar(int a, int b) { return a + b; }
static double sumar(double a, double b) { return a + b; }
```

## Paso de argumentos
Java pasa argumentos **por valor**. En referencias, se copia el valor de la referencia; esto no equivale a “paso por referencia”.

## Diseño
Prefiere métodos:
- pequeños;
- con nombres descriptivos;
- una responsabilidad;
- pocos efectos secundarios.

## Ejercicios
Crea métodos para validar rango, calcular área, convertir temperatura y obtener máximo.

## Reto
Construye una calculadora modular donde main coordine y los métodos realicen operaciones y validaciones.

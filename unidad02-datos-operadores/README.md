# Unidad 02 — Variables, tipos y operadores

## Primitivos
Java incluye tipos como:
```java
int edad = 20;
long poblacion = 8_000_000L;
double precio = 19.95;
boolean activo = true;
char inicial = 'L';
```

## Referencias
```java
String nombre = "Laura";
```

String no es un primitivo.

## var
En variables locales, Java puede inferir el tipo:
```java
var total = 25.5;
```
El tipo sigue siendo estático; `var` no convierte Java en lenguaje dinámico.

## Operadores
Aritméticos, relacionales, lógicos y asignación.

## División
```java
System.out.println(5 / 2);   // 2
System.out.println(5.0 / 2); // 2.5
```

## Conversión
Una conversión estrecha puede perder información:
```java
double valor = 9.8;
int entero = (int) valor;
```

## Ejercicios
1. Conversión de tiempo.
2. Área/perímetro.
3. Precio con descuento.
4. DIV/MOD usando / y %.
5. Experimenta con división entera.

## Reto
Programa una calculadora de costo de viaje y documenta tipos elegidos.

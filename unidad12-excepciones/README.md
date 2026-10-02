# Unidad 12 — Excepciones

## Objetivo
Distinguir errores esperables del dominio, errores de programación y condiciones excepcionales.

```java
try {
    int numero = Integer.parseInt(texto);
} catch (NumberFormatException e) {
    System.out.println("Número inválido");
}
```

## checked y unchecked
Java distingue excepciones comprobadas y no comprobadas. No conviertas automáticamente todas en RuntimeException ni captures Exception sin una razón.

## finally / try-with-resources
Para recursos cerrables, prefiere try-with-resources.

## No ocultes errores
```java
catch (Exception e) {
}
```
destruye información de diagnóstico.

## Reto
Diseña manejo de errores para importar datos: línea inválida no debe impedir necesariamente procesar todas las demás.

# Unidad 13 — String y procesamiento de texto

String es inmutable.

```java
String nombre = "Java";
String otro = nombre.toUpperCase();
```

## Comparación
Usa equals() para contenido:
```java
a.equals(b)
```
No uses `==` para comparar contenido de String.

## StringBuilder
Adecuado para construir texto mediante muchas modificaciones.

## Operaciones
isBlank, contains, substring, split, replace, strip.

## Reto
Analizador de texto con normalización, frecuencias y palabra más larga.

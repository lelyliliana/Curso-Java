# Unidad 13 — String y procesamiento de texto

## Qué aprenderás
Comprender inmutabilidad, igualdad, operaciones de texto y cuándo usar StringBuilder.

# 1. String es un objeto inmutable

```java
String nombre = "Java";
String mayus = nombre.toUpperCase();
```

`nombre` sigue siendo "Java". `toUpperCase()` produce/retorna otro resultado cuando corresponde.

# 2. ¿Por qué importa?

```java
nombre.replace("J", "L");
System.out.println(nombre);
```

Si ignoras el valor retornado, `nombre` no cambia.

# 3. Igualdad

```java
a.equals(b)
```

compara contenido según String.

```java
a == b
```

compara referencias.

A veces `==` parece “funcionar” con literales por internado de Strings, lo cual lo hace aún más peligroso como prueba de contenido.

# 4. Null

```java
"si".equals(respuesta)
```

es seguro si respuesta es null.

```java
respuesta.equals("si")
```
lanza NullPointerException si respuesta es null.

Esto no significa que debas aceptar null indiscriminadamente; diseña contratos.

# 5. Operaciones

```java
texto.isBlank();
texto.contains("Java");
texto.substring(0, 4);
texto.replace("a", "A");
texto.strip();
texto.split("\\s+");
```

Revisa índices de substring: el límite final es exclusivo.

# 6. Unicode y caracteres

Java `char` representa una unidad UTF-16, no necesariamente un carácter Unicode completo (code point).

Para textos con ciertos símbolos/emoji, `length()` cuenta unidades UTF-16, no siempre “caracteres visuales”.

No necesitas dominar Unicode completo ahora, pero evita asumir char = carácter humano universal.

# 7. Concatenación

```java
String mensaje = nombre + " tiene " + edad;
```

Es clara para pocas partes.

En un ciclo con muchas concatenaciones, crear Strings intermedios puede ser innecesario.

# 8. StringBuilder

```java
StringBuilder sb = new StringBuilder();

for (String palabra : palabras) {
    sb.append(palabra).append(' ');
}

String resultado = sb.toString();
```

Útil para construcción incremental mutable.

No reemplaces toda concatenación por StringBuilder por reflejo.

# 9. Normalización

Antes de comparar texto define:
- mayúsculas;
- espacios;
- signos;
- tildes;
- Locale si aplica.

```java
texto.toLowerCase(Locale.ROOT)
```

puede ser apropiado para normalización técnica independiente del idioma, pero reglas lingüísticas reales pueden requerir más cuidado.

# 10. Práctica guiada

Analiza:
```text
"  Java java JAVA  "
```

1. strip;
2. minúsculas;
3. split por espacios;
4. frecuencias.

# 11. Errores frecuentes
- == para contenido.
- olvidar asignar resultado de operación.
- concatenar masivamente en ciclo.
- índices incorrectos.
- asumir char = carácter Unicode completo.
- normalizar sin reglas.

# 12. Ejercicios
Palíndromo, palabras, frecuencias, reemplazos y construcción de reporte.

# 13. Reto
Analizador de texto con reglas de normalización documentadas.

# 14. Autoevaluación
1. ¿String es mutable?
2. ¿equals vs ==?
3. ¿Qué devuelve replace?
4. ¿Cuándo StringBuilder?
5. ¿length siempre cuenta caracteres visuales?

# 15. Checklist
- [ ] Comparo contenido correctamente.
- [ ] Comprendo inmutabilidad.
- [ ] Construyo texto eficientemente cuando importa.
- [ ] Documento normalización.

Continúa con fechas.

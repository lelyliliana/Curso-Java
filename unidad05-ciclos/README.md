# Unidad 05 — Ciclos en Java

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Implementar repeticiones con for, while, do-while y for-each y reconocer errores de límites e infinitos.

# 1. for

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

Tres partes:
```text
inicialización; condición; actualización
```

Traza i antes de escribir código complejo.

# 2. Error off-by-one

Para índices de un arreglo de longitud n:
```java
for (int i = 0; i < n; i++)
```

Usar `i <= n` intentaría acceder a una posición fuera del rango si utilizas i como índice.

# 3. while

```java
while (saldo > 0) {
    ...
}
```

Úsalo cuando la cantidad de iteraciones depende de una condición.

Pregunta: ¿qué cambia la condición?

# 4. do-while

```java
do {
    ...
} while (condicion);
```

El cuerpo se ejecuta al menos una vez.

Puede ser útil para ciertos menús/validaciones, aunque el diseño debe seguir siendo claro.

# 5. for-each

```java
for (int valor : valores) {
    System.out.println(valor);
}
```

Recorre valores. Si necesitas índice, otro recorrido puede ser más apropiado.

# 6. Contador/acumulador

```java
int cantidad = 0;
double suma = 0.0;
```

Dentro:
```java
cantidad++;
suma += valor;
```

# 7. Centinela

```java
int valor = scanner.nextInt();

while (valor != -1) {
    ...
    valor = scanner.nextInt();
}
```

No incluyas -1 en estadísticas.

# 8. Máximo/mínimo

No inicialices `maximo=0` si pueden existir negativos.

Para datos almacenados puedes usar el primer elemento. Para streaming, trata especialmente el primer dato válido.

# 9. break y continue

Existen y son útiles, pero no deben ocultar un flujo que podría expresarse más claramente.

`break`: termina el ciclo.  
`continue`: pasa a la siguiente iteración.

# 10. Ciclo infinito

```java
int i=0;
while (i<10) {
    System.out.println(i);
}
```

i no cambia.

# 11. Práctica guiada

Lee valores hasta -1 y calcula:
- cantidad;
- suma;
- promedio;
- mayor;
- menor.

Define el caso donde el primer valor es -1.

# 12. Errores frecuentes
- < vs <=.
- actualización incorrecta.
- centinela incluido.
- división entre cero.
- máximo inicial incorrecto.
- modificar colección mientras for-each sin comprender reglas.

# 13. Ejercicios
Tabla, factorial, suma, promedio, máximo/mínimo, centinela y validación.

# 14. Reto
Estadísticas sin almacenar todos los datos. Documenta estado que necesitas mantener.

# 15. Autoevaluación
1. ¿Cuándo for/while?
2. ¿Qué garantiza do-while?
3. ¿for-each da índice?
4. ¿Qué es off-by-one?
5. ¿Cómo evitar infinito?

# 16. Checklist
- [ ] Elijo ciclo.
- [ ] Manejo límites.
- [ ] Uso contador/acumulador.
- [ ] Manejo caso vacío.
- [ ] Trazo iteraciones.

Continúa con métodos.


---

## Continuar el curso

- **Unidad anterior:** [Unidad 04 — Decisiones en Java](../unidad04-decisiones/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 06 — Métodos y modularización](../unidad06-metodos/README.md)

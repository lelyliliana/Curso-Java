# Unidad 04 — Decisiones en Java

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Traducir decisiones algorítmicas a Java usando if/else y switch, cuidando límites y comparaciones.

# 1. if/else

```java
if (edad >= 18) {
    System.out.println("Mayor de edad");
} else {
    System.out.println("Menor de edad");
}
```

La lógica ya la conoces de Algoritmos; ahora observa sintaxis:
- condición entre paréntesis;
- bloques con llaves;
- expresión boolean.

# 2. Condiciones

```java
if (nota >= 0 && nota <= 5) { ... }
```

`&&` = Y, `||` = O, `!` = NO.

# 3. Límites

```java
edad > 18
```
excluye 18.

Prueba siempre valores inmediatamente antes, en y después de la frontera.

# 4. Cadenas: equals

No uses:
```java
if (opcion == "si")
```
para comparar contenido de String.

Usa:
```java
if ("si".equals(opcion))
```

`==` con referencias pregunta por identidad de referencia; `equals` puede definir igualdad de contenido.

# 5. else-if

```java
if (nota >= 4.5) {
    ...
} else if (nota >= 3.0) {
    ...
} else {
    ...
}
```

El orden sigue importando.

# 6. switch tradicional/con expresión

Java moderno permite:

```java
String nombreDia = switch (dia) {
    case 1 -> "Lunes";
    case 2 -> "Martes";
    case 3 -> "Miércoles";
    default -> "Otro";
};
```

Aquí switch **produce un valor**.

# 7. Cuándo switch

Útil cuando una expresión se compara contra casos discretos.

Rangos como `nota >= 4.5` suelen expresarse naturalmente con if/else.

# 8. Práctica guiada

Construye menú:
1. Crear
2. Consultar
3. Salir

Valida cualquier otro número con default.

Después construye clasificación por rangos con if.

Compara por qué son problemas diferentes.

# 9. Errores frecuentes
- String con ==.
- límites incorrectos.
- condición general antes de específica.
- switch para rangos artificiales.
- olvidar default/caso no contemplado cuando el dominio lo necesita.

# 10. Ejercicios
Par/impar, mayor, notas, bisiesto, menú y comparación de cadenas.

# 11. Reto
Tarifa por rangos con pruebas en cada frontera y tabla entrada→resultado esperado.

# 12. Autoevaluación
1. ¿&&/||?
2. ¿String con ==?
3. ¿Por qué orden de else-if?
4. ¿switch puede devolver valor?
5. ¿Cuándo preferir if?

# 13. Checklist
- [ ] Escribo condiciones.
- [ ] Comparo String correctamente.
- [ ] Pruebo límites.
- [ ] Elijo if/switch.

Continúa con ciclos.


---

## Continuar el curso

- **Unidad anterior:** [Unidad 03 — Entrada, salida y conversiones](../unidad03-entrada-salida/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 05 — Ciclos en Java](../unidad05-ciclos/README.md)

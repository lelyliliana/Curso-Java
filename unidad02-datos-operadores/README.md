# Unidad 02 — Variables, tipos y operadores

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Representar datos en Java, distinguir primitivos/referencias, comprender división, conversiones y expresiones.

# 1. Java necesita tipos

```java
int edad = 20;
double precio = 19.95;
boolean activo = true;
char inicial = 'L';
String nombre = "Laura";
```

Java es de tipado estático: cada variable tiene un tipo conocido en compilación.

# 2. Primitivos

Tipos fundamentales:
```text
byte short int long
float double
char
boolean
```

No elijas el tipo “más grande” por costumbre. El dominio y APIs importan.

# 3. Literales

```java
long poblacion = 8_000_000L;
float tasa = 2.5F;
char letra = 'A';
String texto = "A";
```

`'A'` es char; `"A"` es String.

# 4. String es referencia

```java
String nombre = "Laura";
```

String es una clase, no un tipo primitivo.

Esto será importante al comparar objetos y comprender null.

# 5. var

```java
var total = 25.5;
```

El compilador infiere `double`. No significa que luego pueda guardar un String.

`var` solo se usa en ciertos contextos de variables locales y requiere inicializador que permita inferencia.

# 6. División entera

```java
System.out.println(5 / 2);   // 2
System.out.println(5.0 / 2); // 2.5
```

El tipo de los operandos influye.

Error típico:
```java
int suma = 7;
int cantidad = 2;
double promedio = suma / cantidad; // primero produce 3
```

Una opción:
```java
double promedio = (double) suma / cantidad;
```

# 7. Conversión

Conversión ampliadora:
```java
int n = 10;
double d = n;
```

Conversión estrecha explícita:
```java
double valor = 9.8;
int entero = (int) valor; // 9
```

No redondea: descarta la parte fraccionaria en este caso.

# 8. Overflow

Los enteros tienen rango finito.

Una operación puede desbordarse sin convertirse automáticamente en un tipo más grande.

No uses int para cantidades que puedan exceder su rango.

# 9. Operadores

Aritméticos:
```text
+ - * / %
```

Relacionales:
```text
< <= > >= == !=
```

Lógicos:
```text
&& || !
```

# 10. Cortocircuito

```java
if (divisor != 0 && total / divisor > 5) { ... }
```

Si `divisor != 0` es falso, la segunda parte de `&&` no se evalúa.

Esto puede proteger operaciones, aunque la condición debe seguir siendo legible.

# 11. Precedencia

```java
double promedio = (n1 + n2 + n3) / 3.0;
```

Usa paréntesis cuando aclaren la intención.

# 12. Práctica guiada

Convierte 3670 segundos a horas, minutos y segundos usando `/` y `%`.

Traza los tipos y resultados intermedios.

# 13. Errores frecuentes
- char/String.
- división entera inesperada.
- cast con pérdida.
- creer que var es dinámico.
- overflow.
- comparar objetos con == sin comprender identidad/contenido (lo veremos con String).

# 14. Ejercicios
Conversión de tiempo, área/perímetro, descuento, cociente/residuo y experimentos de tipos.

# 15. Reto
Calculadora de costo de viaje. Documenta por qué cada dato es int, long, double u otro tipo.

# 16. Autoevaluación
1. ¿String es primitivo?
2. ¿5/2?
3. ¿Qué hace cast double→int?
4. ¿var elimina tipos?
5. ¿Qué es cortocircuito?
6. ¿Qué es overflow?

# 17. Checklist
- [ ] Elijo tipos.
- [ ] Comprendo división.
- [ ] Convierto conscientemente.
- [ ] Uso expresiones claras.

Continúa con entrada/salida.


---

## Continuar el curso

- **Unidad anterior:** [Unidad 01 — JDK, JVM y bytecode](../unidad01-plataforma-java/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 03 — Entrada, salida y conversiones](../unidad03-entrada-salida/README.md)

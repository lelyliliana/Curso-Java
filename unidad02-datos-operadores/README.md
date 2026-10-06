# Unidad 02: Variables, tipos y operadores

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Representar datos en Java, distinguir primitivos/referencias, comprender división, conversiones y expresiones.

## 1. Java necesita tipos

```java
int edad = 20;
double precio = 19.95;
boolean activo = true;
char inicial = 'L';
String nombre = "Laura";
```

Java es de tipado estático: cada variable tiene un tipo conocido en compilación.

## 2. Primitivos

Tipos fundamentales:
```text
byte short int long
float double
char
boolean
```

No elijas el tipo “más grande” por costumbre. El dominio y APIs importan.

## 3. Literales

```java
long poblacion = 8_000_000L;
float tasa = 2.5F;
char letra = 'A';
String texto = "A";
```

`'A'` es char; `"A"` es String.

## 4. String es referencia

```java
String nombre = "Laura";
```

String es una clase, no un tipo primitivo.

Esto será importante al comparar objetos y comprender null.

## 5. var

```java
var total = 25.5;
```

El compilador infiere `double`. No significa que luego pueda guardar un String.

`var` solo se usa en ciertos contextos de variables locales y requiere inicializador que permita inferencia.

## 6. División entera

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

## 7. Conversión

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

## 8. Overflow

Los enteros tienen rango finito.

Una operación puede desbordarse sin convertirse automáticamente en un tipo más grande.

No uses int para cantidades que puedan exceder su rango.

## 9. Operadores

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

## 10. Cortocircuito

```java
if (divisor != 0 && total / divisor > 5) {
    System.out.println("Cociente mayor que cinco");
}
```

Si `divisor != 0` es falso, la segunda parte de `&&` no se evalúa.

Esto puede proteger operaciones, aunque la condición debe seguir siendo legible.

## 11. Precedencia

```java
double promedio = (n1 + n2 + n3) / 3.0;
```

Usa paréntesis cuando aclaren la intención.

## 12. Práctica guiada

Convierte 3670 segundos a horas, minutos y segundos usando `/` y `%`.

Traza los tipos y resultados intermedios.

## 13. Errores frecuentes
- char/String.
- división entera inesperada.
- cast con pérdida.
- creer que var es dinámico.
- overflow.
- comparar objetos con == sin comprender identidad/contenido (lo veremos con String).

## 14. Ejercicios
Conversión de tiempo, área/perímetro, descuento, cociente/residuo y experimentos de tipos.

## 15. Reto
Calculadora de costo de viaje. Documenta por qué cada dato es int, long, double u otro tipo.

## 16. Autoevaluación
1. ¿String es primitivo?
2. ¿5/2?
3. ¿Qué hace cast double→int?
4. ¿var elimina tipos?
5. ¿Qué es cortocircuito?
6. ¿Qué es overflow?

## 17. Checklist
- [ ] Elijo tipos.
- [ ] Comprendo división.
- [ ] Convierto conscientemente.
- [ ] Uso expresiones claras.

Continúa con entrada/salida.


## Precisiones para aplicar el modelo

### Rango, precisión y valores especiales

int es un entero con signo de 32 bits y long de 64. double usa aritmética binaria de doble precisión: muchas fracciones decimales no son exactas. `0.1 + 0.2 == 0.3` no es una regla fiable para importes. Double.isFinite permite excluir NaN e infinitos al validar datos de dominio. Ampliar int a double no pierde precisión para todos los int; ampliar long a double puede perderla cuando su magnitud supera la precisión entera representable.

Para dinero utiliza centavos enteros con rango controlado o BigDecimal desde texto. `new BigDecimal("0.1")` representa ese decimal; `new BigDecimal(0.1)` conserva la aproximación binaria recibida. La elección depende de unidad, precisión, redondeo y límite, no del nombre precio.

## Laboratorio completo: observar, explicar y modificar

El tipo de la variable receptora no corrige una operación ya efectuada: double resultado = 5 / 2 guarda 2.0. Ampliar un operando antes de sumar evita ese desbordamiento concreto; convertir después conserva el resultado ya desbordado. Math.addExact permite detectar desbordamiento de enteros cuando el contrato exige rechazarlo.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad02-datos-operadores/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

### Paso 2. Compila

```text
javac -encoding UTF-8 --release 21 Laboratorio.java
```

`-encoding` define cómo se lee el código fuente y `--release` fija lenguaje, API y formato de clase compatibles con Java 21. Son decisiones diferentes. Si el comando falla, corrige el primer error relevante antes de ejecutar un bytecode antiguo.

### Paso 3. Ejecuta

```text
java Laboratorio
```

Compara la salida con el resultado previsto. Los valores se eligieron para hacer visible el comportamiento de esta unidad.

```text
2:03:05
División: 2 / 2.5
Desbordamiento: -2147483648
Ampliado antes: 2147483648
```

### Paso 4. Recorre la lógica

Traza cociente y residuo. Cambia segundos por 59, 60 y 3600. Predice cada división antes de ejecutar. Prueba el cast antes y después de sumar.

### Paso 5. Lee el código completo

```java
public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        int segundos = 7385;
        System.out.printf("%d:%02d:%02d%n", segundos / 3600, segundos % 3600 / 60, segundos % 60);
        System.out.println("División: " + (5 / 2) + " / " + (5.0 / 2));
        System.out.println("Desbordamiento: " + (Integer.MAX_VALUE + 1));
        System.out.println("Ampliado antes: " + ((long) Integer.MAX_VALUE + 1));
    }

    
}
```

### Paso 6. Comprueba y extiende

0: 0:00:00; 59: 0:00:59; 3600: 1:00:00. El intervalo de minutos y segundos debe ser 0..59.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 01: JDK, JVM y bytecode](../unidad01-plataforma-java/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 03: Entrada, salida y conversiones](../unidad03-entrada-salida/README.md)


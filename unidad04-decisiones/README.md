# Unidad 04: Decisiones en Java

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Traducir decisiones algorítmicas a Java usando if/else y switch, cuidando límites y comparaciones.

## 1. if/else

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

## 2. Condiciones

```java
if (Double.isFinite(nota) && nota >= 0 && nota <= 5) {
    System.out.println("Nota válida");
}
```

`&&` = Y, `||` = O, `!` = NO.

## 3. Límites

```java
edad > 18
```
excluye 18.

Prueba siempre valores inmediatamente antes, en y después de la frontera.

## 4. Cadenas: equals

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

## 5. else-if

```java
if (nota >= 4.5) {
    System.out.println("Excelente");
} else if (nota >= 3.0) {
    System.out.println("Aprobada");
} else {
    System.out.println("No aprobada");
}
```

El orden sigue importando. Este fragmento clasifica una nota previamente validada como finita y dentro de 0..5; el laboratorio reúne validación y clasificación.

## 6. switch tradicional/con expresión

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

## 7. Cuándo switch

Útil cuando una expresión se compara contra casos discretos.

Rangos como `nota >= 4.5` suelen expresarse naturalmente con if/else.

## 8. Práctica guiada

Construye menú:
1. Crear
2. Consultar
3. Salir

Valida cualquier otro número con default.

Después construye clasificación por rangos con if.

Compara por qué son problemas diferentes.

## 9. Errores frecuentes
- String con ==.
- límites incorrectos.
- condición general antes de específica.
- switch para rangos artificiales.
- olvidar default/caso no contemplado cuando el dominio lo necesita.

## 10. Ejercicios
Par/impar, mayor, notas, bisiesto, menú y comparación de cadenas.

## 11. Reto
Tarifa por rangos con pruebas en cada frontera y tabla entrada→resultado esperado.

## 12. Autoevaluación
1. ¿&&/||?
2. ¿String con ==?
3. ¿Por qué orden de else-if?
4. ¿switch puede devolver valor?
5. ¿Cuándo preferir if?

## 13. Checklist
- [ ] Escribo condiciones.
- [ ] Comparo String correctamente.
- [ ] Pruebo límites.
- [ ] Elijo if/switch.

Continúa con ciclos.


## Laboratorio completo: observar, explicar y modificar

NaN no es menor ni mayor que los límites, por eso una comprobación nota < 0 || nota > 5 no lo rechaza. Double.isFinite cubre NaN y ambos infinitos. El orden de los rangos conserva el caso más específico; switch expresa opciones discretas y produce un resultado sin fall-through con las flechas.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad04-decisiones/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

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
2.99 -> No aprobada
3.0 -> Aprobada
4.5 -> Excelente
5.0 -> Excelente
NaN -> Inválida
Infinity -> Inválida
Consultar
```

### Paso 4. Recorre la lógica

Construye una tabla con las fronteras 0, 3, 4.5 y 5. Cambia el orden de las condiciones y predice la clasificación. Recupera el orden correcto. Introduce una opción de menú desconocida.

### Paso 5. Lee el código completo

```java
public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        for (double nota : new double[]{2.99, 3, 4.5, 5, Double.NaN, Double.POSITIVE_INFINITY}) {
            System.out.println(nota + " -> " + clasificar(nota));
        }
        int opcion = 2;
        System.out.println(switch (opcion) { case 1 -> "Crear"; case 2 -> "Consultar"; case 0 -> "Salir"; default -> "Inválida"; });
    }

    static String clasificar(double nota) {
        if (!Double.isFinite(nota) || nota < 0 || nota > 5) return "Inválida";
        if (nota >= 4.5) return "Excelente";
        if (nota >= 3) return "Aprobada";
        return "No aprobada";
    }
}
```

### Paso 6. Comprueba y extiende

17.99 frío, 18 templado, 30 templado, 30.01 caliente, NaN inválido.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 03: Entrada, salida y conversiones](../unidad03-entrada-salida/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 05: Ciclos en Java](../unidad05-ciclos/README.md)


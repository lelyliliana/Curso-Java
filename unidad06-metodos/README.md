# Unidad 06: Métodos y modularización

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Crear métodos con contratos claros, comprender parámetros/retornos, sobrecarga y el paso por valor de Java.

## 1. Método

```java
static boolean esPar(int numero) {
    return numero % 2 == 0;
}
```

Firma relevante incluye nombre y tipos de parámetros; el tipo de retorno indica qué devuelve.

## 2. Llamada

```java
boolean resultado = esPar(8);
```

Entrada: 8.  
Salida: true.

## 3. void

```java
static void mostrarTitulo() {
    System.out.println("Calculadora");
}
```

No devuelve un valor al llamador.

No confundas imprimir con retornar.

## 4. Parámetros

```java
static double area(double base, double altura) {
    return base * altura;
}
```

Define precondiciones cuando corresponda: ¿se aceptan negativos?

## 5. Paso por valor

Java **siempre pasa argumentos por valor**.

Con primitivo se copia el valor:
```java
static void cambiar(int x) {
    x = 99;
}
```
No cambia la variable original del llamador.

Con objeto se copia el **valor de la referencia**.

El método puede usar esa referencia copiada para modificar el mismo objeto, pero reasignar el parámetro no reasigna la variable del llamador.

Esto no es “paso por referencia”.

## 6. Sobrecarga

```java
static int sumar(int a,int b) { return a+b; }
static double sumar(double a,double b) { return a+b; }
```

El compilador elige según tipos/argumentos aplicables.

Cambiar solo el tipo de retorno **no basta** para sobrecargar.

## 7. Variables locales

Viven dentro de su alcance.

Evita estado global/static mutable solo para que todos los métodos “lo vean”.

## 8. Método con una responsabilidad

Mal síntoma:
```text
leerValidarCalcularGuardarImprimir()
```

Mejor separar cuando las responsabilidades pueden comprenderse/probarse independientemente.

Pero tampoco crees un método por cada línea sin beneficio.

## 9. Funciones puras

```java
static double celsiusAFahrenheit(double c) {
    return c * 9 / 5 + 32;
}
```

Misma entrada → mismo resultado, sin modificar estado externo. Fácil de probar.

## 10. main como coordinador

```text
main
 ↓ lee entrada
 ↓ llama validación/cálculo
 ↓ muestra salida
```

Evita que main contenga toda la lógica.

## 11. Práctica guiada

Refactoriza una factura monolítica en:
- `esCantidadValida`;
- `calcularSubtotal`;
- `calcularDescuento`;
- `calcularTotal`.

Para cada método escribe contrato antes del código.

## 12. Errores frecuentes
- imprimir en vez de retornar.
- demasiados efectos secundarios.
- creer que Java pasa objetos por referencia.
- sobrecargar solo cambiando retorno.
- static para todo.
- método demasiado grande.

## 13. Ejercicios
Validar rango, área, temperatura, máximo, descuento y conversión.

## 14. Reto
Calculadora modular. main coordina; métodos calculan/validan. Prueba cada método con varios casos.

## 15. Autoevaluación
1. ¿void?
2. ¿return?
3. ¿Java pasa por valor?
4. ¿Qué se copia al pasar objeto?
5. ¿Qué permite sobrecarga?
6. ¿Por qué método puro facilita pruebas?

## 16. Checklist
- [ ] Diseño contratos.
- [ ] Distingo retorno/impresión.
- [ ] Comprendo paso por valor.
- [ ] Uso sobrecarga conscientemente.
- [ ] Mantengo responsabilidades claras.

Continúa con clases y objetos.


## Precisiones para aplicar el modelo

### Alcance, sobrecarga y recursión

Una variable local solo existe dentro del bloque de su declaración. Un campo pertenece a una instancia o clase. La sobrecarga elige entre métodos con distinto conjunto de parámetros según tipos en compilación; no se distingue solo por el retorno. Un método recursivo debe tener caso base y reducir el problema. La pila de llamadas es finita: recursión profunda puede producir StackOverflowError, aun con caso base correcto.

Para sumar de 1 a n, escribe primero una versión iterativa y define n no negativo. Una versión recursiva puede ilustrar llamadas, pero no es automáticamente mejor ni más escalable. Define además rango del resultado para evitar desbordamiento.

## Laboratorio completo: observar, explicar y modificar

Java pasa siempre valores. En una referencia se copia el valor de la referencia: llamador y método apuntan al mismo arreglo inicialmente. Cambiar un elemento afecta ese objeto compartido. Reasignar el parámetro solo cambia la copia local. Esto no es paso por referencia.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad06-metodos/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

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
Número: 10
Arreglo: [99, 20]
Promedio: 3.5
```

### Paso 4. Recorre la lógica

Dibuja dos variables apuntando al mismo arreglo. Identifica qué sentencia modifica el objeto y cuál cambia solo una referencia. Quita una sentencia por vez y compara. Prueba promedio con cantidad cero.

### Paso 5. Lee el código completo

```java
import java.util.Arrays;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        int numero = 10;
        int[] valores = {10, 20};
        cambiar(numero, valores);
        System.out.println("Número: " + numero);
        System.out.println("Arreglo: " + Arrays.toString(valores));
        System.out.println("Promedio: " + promedio(7, 2));
    }

    static void cambiar(int numero, int[] valores) {
        numero = 99;
        valores[0] = 99;
        valores = new int[]{1};
    }
    static double promedio(int suma, int cantidad) {
        if (cantidad <= 0) throw new IllegalArgumentException("Cantidad positiva requerida");
        return (double) suma / cantidad;
    }
}
```

### Paso 6. Comprueba y extiende

[2,3] devuelve [4,6] y original [2,3]; [] devuelve vacío distinto; dos invocaciones no comparten el arreglo resultado.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 05: Ciclos en Java](../unidad05-ciclos/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 07: Clases y objetos](../unidad07-clases-objetos/README.md)


# Unidad 06 — Métodos y modularización

## Qué aprenderás
Crear métodos con contratos claros, comprender parámetros/retornos, sobrecarga y el paso por valor de Java.

# 1. Método

```java
static boolean esPar(int numero) {
    return numero % 2 == 0;
}
```

Firma relevante incluye nombre y tipos de parámetros; el tipo de retorno indica qué devuelve.

# 2. Llamada

```java
boolean resultado = esPar(8);
```

Entrada: 8.  
Salida: true.

# 3. void

```java
static void mostrarTitulo() {
    System.out.println("Calculadora");
}
```

No devuelve un valor al llamador.

No confundas imprimir con retornar.

# 4. Parámetros

```java
static double area(double base, double altura) {
    return base * altura;
}
```

Define precondiciones cuando corresponda: ¿se aceptan negativos?

# 5. Paso por valor

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

# 6. Sobrecarga

```java
static int sumar(int a,int b) { return a+b; }
static double sumar(double a,double b) { return a+b; }
```

El compilador elige según tipos/argumentos aplicables.

Cambiar solo el tipo de retorno **no basta** para sobrecargar.

# 7. Variables locales

Viven dentro de su alcance.

Evita estado global/static mutable solo para que todos los métodos “lo vean”.

# 8. Método con una responsabilidad

Mal síntoma:
```text
leerValidarCalcularGuardarImprimir()
```

Mejor separar cuando las responsabilidades pueden comprenderse/probarse independientemente.

Pero tampoco crees un método por cada línea sin beneficio.

# 9. Funciones puras

```java
static double celsiusAFahrenheit(double c) {
    return c * 9 / 5 + 32;
}
```

Misma entrada → mismo resultado, sin modificar estado externo. Fácil de probar.

# 10. main como coordinador

```text
main
 ↓ lee entrada
 ↓ llama validación/cálculo
 ↓ muestra salida
```

Evita que main contenga toda la lógica.

# 11. Práctica guiada

Refactoriza una factura monolítica en:
- `esCantidadValida`;
- `calcularSubtotal`;
- `calcularDescuento`;
- `calcularTotal`.

Para cada método escribe contrato antes del código.

# 12. Errores frecuentes
- imprimir en vez de retornar.
- demasiados efectos secundarios.
- creer que Java pasa objetos por referencia.
- sobrecargar solo cambiando retorno.
- static para todo.
- método demasiado grande.

# 13. Ejercicios
Validar rango, área, temperatura, máximo, descuento y conversión.

# 14. Reto
Calculadora modular. main coordina; métodos calculan/validan. Prueba cada método con varios casos.

# 15. Autoevaluación
1. ¿void?
2. ¿return?
3. ¿Java pasa por valor?
4. ¿Qué se copia al pasar objeto?
5. ¿Qué permite sobrecarga?
6. ¿Por qué método puro facilita pruebas?

# 16. Checklist
- [ ] Diseño contratos.
- [ ] Distingo retorno/impresión.
- [ ] Comprendo paso por valor.
- [ ] Uso sobrecarga conscientemente.
- [ ] Mantengo responsabilidades claras.

Continúa con clases y objetos.

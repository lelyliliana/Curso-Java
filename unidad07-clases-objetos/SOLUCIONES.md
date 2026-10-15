# Soluciones razonadas

## Solución del laboratorio

Una clase define un tipo; new crea una instancia; una variable de referencia permite alcanzarla. Dos instancias con datos iguales no son idénticas. Esta clase no redefine equals: hereda la comparación de identidad de Object. Precio en centavos long ofrece precisión entera mientras el rango y la unidad estén definidos.

La salida prevista es:

```text
Mismo objeto: true
Instancias diferentes: false
Subtotal: 3750
```

Identifica constructor, campos, método de instancia y llamada. Cambia cantidad sin modificar el producto. Compara identidad con alias y con b. Provoca una cantidad inválida y localiza el origen de la excepción.

## Solución de la extensión

Devuelve String nombre() desde un método de consulta. String es inmutable. Mantén los campos final y sin setters. Documenta que subtotal se expresa en centavos, no en unidades monetarias completas.

## Casos de aceptación

3 × 1250: 3750 centavos; cantidad 0: rechazo; alias observa el mismo objeto; otra instancia no es idéntica.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

Dentro de la clase anidada añade `String nombre() { return nombre; }`. Consulta antes y después de subtotal(3); debe conservar Cuaderno. subtotal(3) produce 3750 centavos y subtotal(1) produce 1250. No agregues un setter para demostrar una consulta. El método del laboratorio se llama subtotal; adaptar el nombre del enunciado no exige duplicar el cálculo.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

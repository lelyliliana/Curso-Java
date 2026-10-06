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

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

3 × 1250: 3750 centavos; cantidad 0: rechazo; alias observa el mismo objeto; otra instancia no es idéntica.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

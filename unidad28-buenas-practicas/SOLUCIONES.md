# Soluciones razonadas

## Solución del laboratorio

Refactorizar mantiene el comportamiento contratado, incluidos errores relevantes. Extraer validación mejora el nombre de una responsabilidad, pero no justifica una jerarquía de clases vacías. La misma tabla de casos puede ejecutar ambas versiones y comparar valor o tipo de error. Pruebas verdes reducen riesgo sin demostrar equivalencia para todas las entradas posibles.

La salida prevista es:

```text
Total original: 600
Total refactorizado: 600
```

Ejecuta ambos métodos con la misma lista. Caracteriza vacío y negativo antes de cambiar código. Extrae un método pequeño y repite las comprobaciones. Describe qué mejora concreta facilita leer o cambiar.

## Solución de la extensión

Escribe primero casos que fijan tasa, precisión, momento de redondeo y entradas rechazadas. Extrae cálculo puro del formato y la entrada. No cambies redondeo mientras presentas el cambio como simple refactorización.

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

Lista vacía:0; [100,200]:300; negativo:rechazo en ambos; suma desbordada:ArithmeticException en ambos.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

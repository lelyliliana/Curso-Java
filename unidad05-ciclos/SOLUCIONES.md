# Soluciones razonadas

## Solución del laboratorio

Un arreglo es un objeto con tamaño fijo, posiciones desde cero y length como campo. Sus elementos de int comienzan en cero cuando se crea con new int[n]. El for-each copia cada valor a la variable local: reasignarla no cambia un elemento primitivo del arreglo. Necesitas índices para modificar posiciones.

La salida prevista es:

```text
Promedio: 30.75
Intentos: 3
Dato: 28
Dato: 31
Dato: 35
Dato: 29
```

Traza i, condición y suma en cada vuelta. Distingue datos.length de un método length(). Cambia < por <= para reproducir el acceso inválido y luego corrígelo. Evalúa qué ocurre con un arreglo vacío antes de calcular un promedio.

## Solución de la extensión

Si length == 0 informa Sin datos y termina antes de acceder a datos[0]. Inicializa mínimo y máximo con el primer elemento y recorre los demás. Para promedio amplía suma a double antes de dividir; para grandes sumas usa long o detecta desbordamiento.

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

[5]: min=max=5; [-3,-8]: min=-8,max=-3; []: sin datos; última posición válida: length-1.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

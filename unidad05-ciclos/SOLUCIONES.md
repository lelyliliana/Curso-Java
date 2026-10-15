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

## Casos de aceptación

[5]: min=max=5; [-3,-8]: min=-8,max=-3; []: sin datos; última posición válida: length-1.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

La solución produce 28/35 para la referencia, -8/-2 para negativos y 7/7 para un elemento. El vacío no tiene extremos y devuelve ausencia. No utiliza 0 como mínimo o máximo artificial. Objects.requireNonNull mantiene distinto el fallo de contrato de una ausencia válida de observaciones.

La [implementación completa](solucion/Solucion.java) se compila de forma independiente; el [desarrollo](DESARROLLO.md) explica su recorrido y comandos.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

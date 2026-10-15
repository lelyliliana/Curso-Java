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

## Casos de aceptación

Lista vacía:0; [100,200]:300; negativo:rechazo en ambos; suma desbordada:ArithmeticException en ambos.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

La solución completa calcula base*(1+tasa) y aplica setScale(2,HALF_UP) al final en ambas versiones. 100 con 0.19 produce 119.00 y 0.05 con 0.10 produce 0.06. Base negativa y tasas fuera de 0..1 se rechazan en ambas. El laboratorio original sigue mostrando equivalencia de suma y detección de desbordamiento long.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

## Comparar las versiones ejecutables

[Solucion.java](solucion/Solucion.java) contiene ambas versiones y casos de redondeo/rechazo. Desde la carpeta solucion, ejecuta por separado:

```text
javac -encoding UTF-8 --release 21 Solucion.java
```

```text
java Solucion
```

# Soluciones razonadas

## Solución del laboratorio

Leer una línea por campo evita mezclar tokens con separadores pendientes. Integer.parseInt rechaza letras y enteros fuera de rango. BigDecimal construido desde texto decimal evita introducir la aproximación binaria de double. Este laboratorio valida positividad; el proyecto final añade límites y política explícita de dos decimales.

La salida prevista es:

```text
Con entradas Cuaderno, 2 y 12.50: Cuaderno: 25.00
```

Escribe los tres campos en líneas distintas. Repite con abc como cantidad y con 12,50 como precio. Distingue formato inválido de una cantidad negativa bien parseada. Termina la entrada antes del tercer campo.

## Solución de la extensión

Valida nombre.strip().length() entre 1 y 40 y solo después convierte los números. Mantén lectura completa por líneas. No reemplaces cualquier coma automáticamente si no has definido si representa decimal o separador de miles.

## Casos de aceptación

2 × 12.50: 25.00; abc: formato inválido; -2: fuera del dominio; fin de entrada: mensaje y salida sin stack trace.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

Después de leer el nombre añade una condición nombre.isEmpty() || nombre.length()>40 que informe rechazo y termine. Muestra Nombre confirmado: seguido del nombre aceptado antes del cálculo. Conserva los hasNextLine y la validación de cantidad/precio. Con Cuaderno,2,12.50 el total es 25.00. Un nombre de 41 unidades no debe calcular una factura válida.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

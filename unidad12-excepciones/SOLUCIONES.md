# Soluciones razonadas

## Solución del laboratorio

Una excepción señala que una operación no logró cumplir su contrato. Capturar únicamente NumberFormatException permite recuperar este fallo concreto por línea. No captura errores de programación arbitrarios. El resultado conserva tanto datos válidos como incidencias; esta es una importación parcial deliberada, distinta del proyecto final que rechaza el archivo completo.

La salida prevista es:

```text
Válidos: [10, 25]
Errores: [Línea 2: entero inválido, Línea 4: entero inválido]
```

Sigue la entrada por índice y la salida por número de línea desde uno. Localiza dónde se continúa tras un error. Prueba una lista sin errores y otra vacía. Explica por qué el mensaje no necesita copiar texto sensible.

## Solución de la extensión

Valida cada línea dentro de una colección temporal. Ante error lanza IllegalArgumentException con número de línea y causa. Solo devuelve la colección cuando todas pasen. No modifiques un repositorio real durante el bucle de validación.

## Casos de aceptación

Parcial [10,abc,25]: válidos[10,25]; estricta: excepción y ningún resultado aplicado; []: vacío sin errores.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

La solución estricta acumula localmente y devuelve List.copyOf solo al terminar. {10,abc,25} lanza IllegalArgumentException con Línea 2 y conserva NumberFormatException como causa. Vacío devuelve una lista vacía válida; no se confunde con una excepción. La referencia parcial se conserva para poder comparar ambas políticas.

La [implementación completa](solucion/Solucion.java) se compila de forma independiente; el [desarrollo](DESARROLLO.md) explica su recorrido y comandos.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

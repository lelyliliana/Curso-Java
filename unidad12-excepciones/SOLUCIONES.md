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

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

Parcial [10,abc,25]: válidos[10,25]; estricta: excepción y ningún resultado aplicado; []: vacío sin errores.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

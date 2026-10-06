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

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

2 × 12.50: 25.00; abc: formato inválido; -2: fuera del dominio; fin de entrada: mensaje y salida sin stack trace.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

# Soluciones razonadas

## Solución del laboratorio

Las tareas se envían antes de esperar resultados, de modo que esperar no serializa su envío. invokeAll devuelve futuros en el orden de la lista, no en orden de finalización. ExecutionException conserva la causa. Cerrar ExecutorService espera que las tareas terminen: try-with-resources no garantiza un límite temporal si una tarea ignora interrupciones.

La salida prevista es:

```text
Cuadrado: 1
Cuadrado: 4
Cuadrado: 9
Causa: Fallo simulado
Virtual: true
```

Distingue Callable de Future. Localiza la causa del fallo. Comprueba isVirtual desde dentro de la tarea. Experimenta con get(timeout) y cancel(true) usando una tarea que responda a interrupción.

## Solución de la extensión

Usa CountDownLatch para bloquear. Espera con futuro.get(100, MILLISECONDS), captura TimeoutException y solicita cancel(true). La tarea debe dejar propagar InterruptedException. Explica que cancelación es una solicitud cooperativa; no mata código arbitrario.

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

Resultado normal:valor; tarea falla:ExecutionException con causa; espera excedida:TimeoutException; cancelada:CancellationException al pedir resultado.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

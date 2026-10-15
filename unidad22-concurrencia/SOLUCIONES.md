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

## Casos de aceptación

Resultado normal:valor; tarea falla:ExecutionException con causa; espera excedida:TimeoutException; cancelada:CancellationException al pedir resultado.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

El timeout de get no detiene la tarea. La solución espera su inicio, solicita cancelación con interrupción y observa el latch terminada. get posterior informa cancelación. El finally libera la espera incluso si una comprobación falla. Este caso demuestra cooperación de la tarea controlada, no capacidad de forzar la detención segura de cualquier código.

La [implementación completa](solucion/Solucion.java) se compila de forma independiente; el [desarrollo](DESARROLLO.md) explica su recorrido y comandos.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

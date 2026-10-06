# Soluciones razonadas

## Solución del laboratorio

contador++ sobre int combina lectura, suma y escritura, por eso puede perder incrementos. volatile aporta visibilidad pero no hace atómica esa secuencia. AtomicInteger.incrementAndGet es una operación atómica. join espera la finalización y establece la relación de visibilidad correspondiente. El resultado correcto de una corrida del ejemplo defectuoso no demuestra ausencia de carrera.

La salida prevista es:

```text
Esperado y obtenido: 20000
```

Ejecuta primero el laboratorio correcto. Estudia CondicionCarrera.java como demostración deliberadamente defectuosa. Repite varias veces sin afirmar que debe fallar siempre. Sustituye el incremento por synchronized o AtomicInteger y razona sobre la protección.

## Solución de la extensión

Encapsula un int y sincroniza tanto incremento como lectura pertinente. Inicia los dos hilos antes de hacer join. Comprueba 20000 y documenta que un microbenchmark improvisado incluye calentamiento y ruido del entorno.

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

Un hilo:10000; dos:20000; 0 iteraciones:0; volatile con ++ sigue sin garantizar conteo.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

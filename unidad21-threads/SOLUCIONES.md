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

## Casos de aceptación

Un hilo:10000; dos:20000; 0 iteraciones:0; volatile con ++ sigue sin garantizar conteo.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

La clase resuelta puede tener `private int valor; synchronized void incrementar(){ valor++; } synchronized int valor(){ return valor; }`. Comparte una sola instancia, ejecuta 10000 incrementos por hilo y llama join en ambos antes de leer. El total es 20000. No concluyas superioridad universal de velocidad ni exijas que el ejemplo sin protección falle en cada ejecución.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

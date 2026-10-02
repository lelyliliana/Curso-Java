# Unidad 21 — Threads y tareas

## Thread
```java
Thread hilo = new Thread(() -> System.out.println("Tarea"));
hilo.start();
```

No llames run() esperando crear un hilo nuevo.

## join
Permite esperar finalización.

## Estado compartido
Dos hilos modificando datos pueden producir condiciones de carrera.

## synchronized
Puede proteger secciones críticas, pero la sincronización incorrecta puede introducir bloqueos y problemas de rendimiento.

## Reto
Demuestra una condición de carrera con un contador y después corrígela.

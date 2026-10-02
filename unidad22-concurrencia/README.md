# Unidad 22 — Executors, futuros y sincronización

## ExecutorService
Separa envío de tareas de creación manual de hilos.

```java
try (var executor = Executors.newFixedThreadPool(4)) {
    Future<Integer> futuro = executor.submit(() -> 40 + 2);
    System.out.println(futuro.get());
}
```

## Herramientas
- ExecutorService;
- Future;
- CompletableFuture;
- locks;
- colecciones concurrentes;
- atomics.

## Diseño
Más hilos no significan automáticamente más velocidad.

## Reto
Procesa varias tareas independientes con un pool y compara con ejecución secuencial.

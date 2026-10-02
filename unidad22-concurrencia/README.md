# Unidad 22 — Executors, Future y concurrencia de tareas

## Qué aprenderás
Separar tareas de hilos, utilizar pools/Future y razonar sobre cancelación, bloqueos y rendimiento.

# 1. ¿Por qué no crear Thread por cada tarea?

Crear/administrar hilos manualmente no escala bien y mezcla:
- qué trabajo hacer;
- cómo asignar recursos.

Executor separa ambas responsabilidades.

# 2. ExecutorService

```java
try (var executor = Executors.newFixedThreadPool(4)) {
    Future<Integer> futuro =
        executor.submit(() -> 40 + 2);

    System.out.println(futuro.get());
}
```

Java 21 permite usar ExecutorService con try-with-resources.

# 3. Future

Representa un resultado que puede estar disponible después.

`get()` puede bloquear hasta que termine.

También existen:
- isDone;
- cancel;
- get con timeout.

No bloquees indefinidamente sin analizar el contexto.

# 4. Tamaño del pool

Más threads ≠ más velocidad.

Trabajo CPU-bound suele relacionarse con núcleos disponibles.

Trabajo que espera I/O puede beneficiarse de más concurrencia, pero depende de recursos externos/límites.

Mide y conoce el cuello de botella.

# 5. Excepciones

Si una tarea falla, `Future.get()` puede lanzar `ExecutionException` que envuelve la causa.

No pierdas la causa real.

# 6. CompletableFuture

Permite composición asíncrona:

```java
CompletableFuture
    .supplyAsync(this::cargar)
    .thenApply(this::procesar)
    .thenAccept(this::guardar);
```

Pero cadenas complejas requieren entender qué executor/hilo ejecuta cada etapa y cómo se propagan errores.

# 7. Colecciones concurrentes

`ConcurrentHashMap`, colas concurrentes, etc. ofrecen operaciones seguras específicas.

No significa que una secuencia de varias operaciones sea automáticamente atómica como conjunto.

# 8. Locks

`ReentrantLock` permite control explícito adicional.

Si haces `lock()`, usa normalmente `try/finally` para garantizar `unlock()`.

No elijas Lock si synchronized resuelve claramente el problema.

# 9. Deadlock

Dos tareas:
```text
A tiene lock1, espera lock2
B tiene lock2, espera lock1
```

ninguna progresa.

Evita orden inconsistente de adquisición y reduce secciones críticas.

# 10. Virtual threads — contexto Java 21

Java 21 incorpora virtual threads como característica final.

Son útiles para gran cantidad de tareas que pasan tiempo bloqueadas en I/O con estilo thread-per-task.

No hacen más rápido el trabajo CPU-bound ni eliminan condiciones de carrera.

# 11. Práctica guiada

Procesa 20 tareas independientes:
- secuencial;
- fixed pool;
- registra resultados;
- compara tiempo varias veces;
- identifica si son CPU/I/O simuladas.

# 12. Errores frecuentes
- pool enorme por velocidad.
- get inmediato que serializa accidentalmente el flujo.
- no cerrar executor.
- perder causa de ExecutionException.
- concurrent collection = transacción multioperación.
- virtual thread = CPU más rápida.

# 13. Reto
Compara ejecución secuencial y concurrente bajo condiciones documentadas y explica cuándo aporta.

# 14. Autoevaluación
1. ¿Qué separa Executor?
2. ¿Future.get bloquea?
3. ¿Más threads siempre?
4. ¿Qué es deadlock?
5. ¿Virtual threads eliminan carreras?
6. ¿ConcurrentHashMap hace cualquier secuencia atómica?

# 15. Checklist
- [ ] Uso Executor.
- [ ] Manejo Future.
- [ ] Cierro recursos.
- [ ] Comprendo pool/deadlock.
- [ ] Distingo platform/virtual threads a nivel conceptual.

Continúa con sockets.

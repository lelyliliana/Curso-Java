# Guía: Elegir concurrencia

Antes de añadir hilos pregunta:
- ¿las tareas son independientes?
- ¿son CPU-bound o I/O-bound?
- ¿existe estado compartido?
- ¿el orden importa?
- ¿cómo se propagan errores?
- ¿cómo termina el executor?

## Herramientas
- ExecutorService para administrar tareas.
- Future para resultados pendientes.
- CompletableFuture para composición asíncrona.
- Atomic* para operaciones atómicas específicas.
- locks/synchronized para exclusión coordinada.
- colecciones concurrentes para casos apropiados.

## Regla
La concurrencia añade estados posibles. Úsala cuando resuelva un problema real, no como decoración.


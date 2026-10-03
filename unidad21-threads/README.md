# Unidad 21 — Threads, estado compartido y condiciones de carrera

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Crear tareas concurrentes, esperar su finalización y observar por qué el estado mutable compartido necesita coordinación.

# 1. Proceso e hilo

Un proceso puede contener varios hilos de ejecución.

Los hilos comparten memoria del proceso, lo que permite comunicación pero también interferencias.

# 2. Crear Thread

```java
Thread hilo = new Thread(() -> {
    System.out.println("Tarea");
});

hilo.start();
```

`start()` solicita iniciar un nuevo hilo.

```java
hilo.run();
```

solo llama al método en el hilo actual; no crea concurrencia por sí mismo.

# 3. join

```java
hilo.start();
hilo.join();
System.out.println("Terminó");
```

El hilo actual espera la finalización.

`join` puede lanzar `InterruptedException`; la interrupción forma parte del protocolo de cancelación/coordinación y no debe ignorarse sin decisión.

# 4. Condición de carrera

Dos hilos ejecutan:
```java
contador++;
```

Esta expresión implica leer, incrementar y escribir. No es necesariamente una operación atómica.

Ambos pueden leer el mismo valor y perder una actualización.

# 5. Demostración

Crea varios hilos que incrementen un contador muchas veces.

Resultado esperado matemático:
```text
hilos × incrementos
```

Sin coordinación, algunas ejecuciones pueden producir menos.

Una prueba que casualmente produce el valor correcto **no demuestra ausencia de carrera**.

# 6. synchronized

```java
synchronized void incrementar() {
    contador++;
}
```

Permite exclusión mutua respecto al mismo monitor.

También establece relaciones de visibilidad de memoria según el modelo de memoria Java.

# 7. volatile

`volatile` ayuda con visibilidad/orden de lecturas-escrituras de una variable, pero **no vuelve atómica** una operación compuesta como `contador++`.

# 8. AtomicInteger

```java
AtomicInteger contador = new AtomicInteger();
contador.incrementAndGet();
```

Ofrece operaciones atómicas específicas.

No reemplaza cualquier necesidad de sincronización de invariantes entre múltiples variables.

# 9. Evitar compartir

Una estrategia poderosa es que cada tarea produzca un resultado independiente y combinar después, reduciendo estado mutable compartido.

# 10. Práctica guiada

1. contador secuencial;
2. contador con dos threads sin protección;
3. repite muchas veces;
4. synchronized;
5. AtomicInteger;
6. compara resultados, no solo tiempo.

# 11. Errores frecuentes
- llamar run en vez de start.
- creer que volatile hace ++ atómico.
- ignorar InterruptedException.
- compartir mutable innecesariamente.
- “funcionó una vez” = thread-safe.

# 12. Reto
Demuestra una carrera y corrígela de dos formas. Explica qué propiedad aporta cada solución.

# 13. Autoevaluación
1. ¿start vs run?
2. ¿join?
3. ¿Qué es carrera?
4. ¿contador++ es atómico?
5. ¿volatile basta?
6. ¿Cómo ayuda evitar estado compartido?

# 14. Checklist
- [ ] Creo/coordino threads.
- [ ] Reproduzco una carrera.
- [ ] Comprendo synchronized/atomic.
- [ ] No ignoro interrupción.

Continúa con Executors.


---

## Continuar el curso

- **Unidad anterior:** [Unidad 20 — Optional y ausencia de valores](../unidad20-optional/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 22 — Executors, Future y concurrencia de tareas](../unidad22-concurrencia/README.md)

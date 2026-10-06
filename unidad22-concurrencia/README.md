# Unidad 22: Executors, Future y concurrencia de tareas

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Separar tareas de hilos, utilizar pools/Future y razonar sobre cancelación, bloqueos y rendimiento.

## 1. ¿Por qué no crear Thread por cada tarea?

Crear/administrar hilos manualmente no escala bien y mezcla:
- qué trabajo hacer;
- cómo asignar recursos.

Executor separa ambas responsabilidades.

## 2. ExecutorService

```java
try (var executor = Executors.newFixedThreadPool(4)) {
    Future<Integer> futuro =
        executor.submit(() -> 40 + 2);

    System.out.println(futuro.get());
}
```

Java 21 permite usar ExecutorService con try-with-resources.

## 3. Future

Representa un resultado que puede estar disponible después.

`get()` puede bloquear hasta que termine.

También existen:
- isDone;
- cancel;
- get con timeout.

No bloquees indefinidamente sin analizar el contexto.

## 4. Tamaño del pool

Más threads ≠ más velocidad.

Trabajo CPU-bound suele relacionarse con núcleos disponibles.

Trabajo que espera I/O puede beneficiarse de más concurrencia, pero depende de recursos externos/límites.

Mide y conoce el cuello de botella.

## 5. Excepciones

Si una tarea falla, `Future.get()` puede lanzar `ExecutionException` que envuelve la causa.

No pierdas la causa real.

## 6. CompletableFuture

Permite composición asíncrona:

```java
CompletableFuture
    .supplyAsync(this::cargar)
    .thenApply(this::procesar)
    .thenAccept(this::guardar);
```

Pero cadenas complejas requieren entender qué executor/hilo ejecuta cada etapa y cómo se propagan errores.

## 7. Colecciones concurrentes

`ConcurrentHashMap`, colas concurrentes, etc. ofrecen operaciones seguras específicas.

No significa que una secuencia de varias operaciones sea automáticamente atómica como conjunto.

## 8. Locks

`ReentrantLock` permite control explícito adicional.

Si haces `lock()`, usa normalmente `try/finally` para garantizar `unlock()`.

No elijas Lock si synchronized resuelve claramente el problema.

## 9. Deadlock

Dos tareas:
```text
A tiene lock1, espera lock2
B tiene lock2, espera lock1
```

ninguna progresa.

Evita orden inconsistente de adquisición y reduce secciones críticas.

## 10. Virtual threads: contexto Java 21

Java 21 incorpora virtual threads como característica final.

Son útiles para gran cantidad de tareas que pasan tiempo bloqueadas en I/O con estilo thread-per-task.

No hacen más rápido el trabajo CPU-bound ni eliminan condiciones de carrera.

## 11. Práctica guiada

Procesa 20 tareas independientes:
- secuencial;
- fixed pool;
- registra resultados;
- compara tiempo varias veces;
- identifica si son CPU/I/O simuladas.

## 12. Errores frecuentes
- pool enorme por velocidad.
- get inmediato que serializa accidentalmente el flujo.
- no cerrar executor.
- perder causa de ExecutionException.
- concurrent collection = transacción multioperación.
- virtual thread = CPU más rápida.

## 13. Reto
Compara ejecución secuencial y concurrente bajo condiciones documentadas y explica cuándo aporta.

## 14. Autoevaluación
1. ¿Qué separa Executor?
2. ¿Future.get bloquea?
3. ¿Más threads siempre?
4. ¿Qué es deadlock?
5. ¿Virtual threads eliminan carreras?
6. ¿ConcurrentHashMap hace cualquier secuencia atómica?

## 15. Checklist
- [ ] Uso Executor.
- [ ] Manejo Future.
- [ ] Cierro recursos.
- [ ] Comprendo pool/deadlock.
- [ ] Distingo platform/virtual threads a nivel conceptual.

Continúa con sockets.


## Precisiones para aplicar el modelo

### Ejemplos de composición y cancelación

Los archivos [Cancelacion.java](ejemplos/Cancelacion.java) y [ComposicionAsync.java](ejemplos/ComposicionAsync.java) contienen aplicaciones completas. Desde la carpeta ejemplos, compila cada archivo con `javac -encoding UTF-8 --release 21 Nombre.java` y ejecuta `java Nombre`, sustituyendo Nombre por su clase.

Cancelacion usa latches para saber que la tarea inició, bloquearla y observar su finalización. El timeout de get termina la espera del llamador; cancel(true) solicita interrupción; await responde lanzando InterruptedException y finally señala la terminación. No se ignora la señal ni se afirma que cancel mate cualquier tarea.

ComposicionAsync transforma 21 en 42 y compone otra tarea que genera el texto. exceptionally ofrece una alternativa explícita para un fallo; no modifica el futuro original. Volver a hacer join sobre ese futuro conserva el fallo y su causa. La salida de ambos ejemplos se comprueba en la verificación del curso.

### CompletableFuture y límites temporales

Puedes componer una transformación con `CompletableFuture.completedFuture(21).thenApply(n -> n * 2).join()`: obtiene 42. thenApply transforma un valor; thenCompose une una operación que devuelve otro CompletableFuture. join propaga fallos mediante CompletionException, mientras get usa ExecutionException y puede ser interrumpido.

Las variantes sin Async pueden ejecutar continuaciones en el hilo que completa o invoca según el estado. Las variantes Async sin executor explícito usan la política documentada de ejecución por defecto, normalmente el common pool. No bloquees un pool pequeño esperando tareas que necesitan ese mismo pool para avanzar. cancel(true) de CompletableFuture no controla por sí mismo la interrupción del trabajo subyacente igual que un Future de ExecutorService.

## Laboratorio completo: observar, explicar y modificar

Las tareas se envían antes de esperar resultados, de modo que esperar no serializa su envío. invokeAll devuelve futuros en el orden de la lista, no en orden de finalización. ExecutionException conserva la causa. Cerrar ExecutorService espera que las tareas terminen: try-with-resources no garantiza un límite temporal si una tarea ignora interrupciones.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad22-concurrencia/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

### Paso 2. Compila

```text
javac -encoding UTF-8 --release 21 Laboratorio.java
```

`-encoding` define cómo se lee el código fuente y `--release` fija lenguaje, API y formato de clase compatibles con Java 21. Son decisiones diferentes. Si el comando falla, corrige el primer error relevante antes de ejecutar un bytecode antiguo.

### Paso 3. Ejecuta

```text
java Laboratorio
```

Compara la salida con el resultado previsto. Los valores se eligieron para hacer visible el comportamiento de esta unidad.

```text
Cuadrado: 1
Cuadrado: 4
Cuadrado: 9
Causa: Fallo simulado
Virtual: true
```

### Paso 4. Recorre la lógica

Distingue Callable de Future. Localiza la causa del fallo. Comprueba isVirtual desde dentro de la tarea. Experimenta con get(timeout) y cancel(true) usando una tarea que responda a interrupción.

### Paso 5. Lee el código completo

```java
import java.util.*;
import java.util.concurrent.*;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        try (var executor = Executors.newFixedThreadPool(3)) {
            var tareas = List.<Callable<Integer>>of(() -> 1, () -> 4, () -> 9);
            for (var futuro : executor.invokeAll(tareas)) System.out.println("Cuadrado: " + futuro.get());
            var fallido = executor.submit(() -> { throw new IllegalStateException("Fallo simulado"); });
            try { fallido.get(); }
            catch (ExecutionException e) { System.out.println("Causa: " + e.getCause().getMessage()); }
        }
        try (var virtuales = Executors.newVirtualThreadPerTaskExecutor()) {
            System.out.println("Virtual: " + virtuales.submit(() -> Thread.currentThread().isVirtual()).get());
        }
    }

    
}
```

### Paso 6. Comprueba y extiende

Resultado normal:valor; tarea falla:ExecutionException con causa; espera excedida:TimeoutException; cancelada:CancellationException al pedir resultado.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 21: Threads, estado compartido y condiciones de carrera](../unidad21-threads/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 23: Redes con sockets TCP](../unidad23-redes/README.md)

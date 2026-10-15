# Distinguir visibilidad, atomicidad y espera de finalización

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad21-threads/laboratorio/Laboratorio.java](../unidad21-threads/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

Cada hilo solicita diez mil incrementos del mismo AtomicInteger. start permite que se ejecuten como hilos; llamar directamente a run ejecutaría el cuerpo en el hilo llamador. join espera a ambos antes de consultar el total.

Un contador int con ++ combina lectura, suma y escritura. Dos hilos pueden leer el mismo valor y perder un incremento. volatile mejora garantías de visibilidad, pero no vuelve atómica esa secuencia compuesta. AtomicInteger.incrementAndGet proporciona la operación atómica que necesita este contrato.

Para comparar con synchronized, ambos hilos deben usar la misma instancia y el mismo monitor que protege el dato. Si cada uno crea un contador independiente o bloquea un objeto distinto, la explicación no corresponde al caso de estado compartido.

Un resultado correcto del programa defectuoso en una corrida no demuestra corrección para todas las intercalaciones. Tampoco diez corridas permiten afirmar que una estrategia siempre es más rápida. Define primero el total esperado y después distingue una prueba funcional de un experimento de rendimiento.

## 3. Construye y contrasta

Construye un contador con incrementar y valor sincronizados; compártelo entre los dos hilos y espera ambos con join. Debe producir 20000, igual que AtomicInteger. No uses un sleep como sustituto de saber que el trabajo terminó.

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2021%20%E2%80%94%20Threads%20y%20tareas%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad21-threads%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

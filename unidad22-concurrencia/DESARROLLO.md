# Separar plazo de espera y solicitud de cancelación

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad22-concurrencia/laboratorio/Laboratorio.java](../unidad22-concurrencia/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

invokeAll envía las tareas y entrega futuros en el orden de la colección. Ese orden de resultados no implica que hayan terminado en ese mismo orden. get espera un resultado y ExecutionException conserva la causa del fallo de una tarea.

La extensión usa un CountDownLatch para saber que la tarea comenzó y otro para mantenerla pendiente de forma controlada. get con plazo solo limita cuánto espera el llamador. Un TimeoutException no cancela automáticamente el trabajo; después se solicita cancel(true).

La tarea coopera porque la espera del latch responde a interrupción y su finally anuncia finalización. El futuro cancelado no ofrece el resultado normal y get lanza CancellationException. Aun así es útil observar la señal de terminación real, porque estado cancelado y trabajo detenido no son conceptos idénticos.

Cerrar ExecutorService espera el final del trabajo según su contrato. No prometas un plazo total solo por usar try-with-resources si una tarea ignora interrupciones. La solución acota las comprobaciones del llamador y libera el recurso en finally para evitar dejar la demostración bloqueada.

## 3. Construye y contrasta

Ejecuta la solución: primero agota la espera corta, después cancela y comprueba finalización cooperativa. No introduzcas sleeps largos para conseguir un orden. Relaciona TimeoutException, CancellationException y ExecutionException con límites distintos.

## Ejecutar la extensión completa

El archivo [Solucion.java](solucion/Solucion.java) contiene imports, métodos y main. Abre una terminal en la carpeta solucion de esta unidad y ejecuta cada comando por separado:

```text
javac -encoding UTF-8 --release 21 Solucion.java
```

```text
java Solucion
```

La referencia Laboratorio.java permanece en su carpeta original. Las clases sin paquete de unidades diferentes se compilan por separado; no juntes todos sus archivos en una sola compilación.

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2022%20%E2%80%94%20Executors%2C%20futuros%20y%20sincronizaci%C3%B3n%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad22-concurrencia%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

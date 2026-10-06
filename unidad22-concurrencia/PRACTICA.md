# Práctica: Executors, Future y concurrencia de tareas

## Objetivo y contrato

Añade una tarea bloqueada cooperativamente y prueba timeout y cancelación sin depender de sleeps largos.

## Antes de programar

Explica con tus palabras este modelo: Las tareas se envían antes de esperar resultados, de modo que esperar no serializa su envío. invokeAll devuelve futuros en el orden de la lista, no en orden de finalización. ExecutionException conserva la causa. Cerrar ExecutorService espera que las tareas terminen: try-with-resources no garantiza un límite temporal si una tarea ignora interrupciones.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Añade una tarea bloqueada cooperativamente y prueba timeout y cancelación sin depender de sleeps largos.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

Resultado normal:valor; tarea falla:ExecutionException con causa; espera excedida:TimeoutException; cancelada:CancellationException al pedir resultado.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

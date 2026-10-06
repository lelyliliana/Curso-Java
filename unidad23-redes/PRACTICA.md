# Práctica: Redes con sockets TCP

## Objetivo y contrato

Define un protocolo ECHO|texto y rechaza comandos desconocidos y mensajes superiores a 200 unidades UTF-16.

## Antes de programar

Explica con tus palabras este modelo: El servidor se enlaza explícitamente a 127.0.0.1 y puerto 0 permite que el sistema elija uno libre. UTF-8 fija codificación; newLine y flush terminan y entregan el mensaje. SO_TIMEOUT limita lecturas y accept, no el tiempo de escritura. readLine no limita longitud: este ejemplo usa un emisor propio, no un cliente no confiable.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Define un protocolo ECHO|texto y rechaza comandos desconocidos y mensajes superiores a 200 unidades UTF-16.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

ECHO|hola:respuesta; comando otro:error; EOF antes del mensaje:error; falta terminador:timeout; Unicode conserva texto.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

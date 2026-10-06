# Soluciones razonadas

## Solución del laboratorio

El servidor se enlaza explícitamente a 127.0.0.1 y puerto 0 permite que el sistema elija uno libre. UTF-8 fija codificación; newLine y flush terminan y entregan el mensaje. SO_TIMEOUT limita lecturas y accept, no el tiempo de escritura. readLine no limita longitud: este ejemplo usa un emisor propio, no un cliente no confiable.

La salida prevista es:

```text
ECO:hola
Recibido: hola
```

Sigue el recorrido envío, lectura, respuesta y cierre. Identifica por qué el hilo servidor debe poder ejecutarse mientras el cliente espera. Quita flush en una copia y observa el timeout. No publiques el puerto en Internet.

## Solución de la extensión

Separa antes del primer |, exige ECHO y valida texto. Para un límite de recepción real implementa lector que cuenta antes de acumular; comprobar length después de readLine limita el dominio, pero no protege memoria frente a una línea enorme. Documenta esa diferencia.

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

ECHO|hola:respuesta; comando otro:error; EOF antes del mensaje:error; falta terminador:timeout; Unicode conserva texto.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

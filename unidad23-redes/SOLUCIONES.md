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

## Casos de aceptación

ECHO|hola:respuesta; comando otro:error; EOF antes del mensaje:error; falta terminador:timeout; Unicode conserva texto.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

La solución devuelve OK|hola para ECHO|hola y ERROR|Comando desconocido para otra operación. La lectura admite 200 unidades contando el prefijo y rechaza la siguiente antes de ampliar el buffer. EOF sin LF lanza EOFException. La referencia TCP sigue probándose realmente; el archivo de solución prueba el lector y procesador con StringReader, sin presentarlos como un segundo servidor de red.

La [implementación completa](solucion/Solucion.java) se compila de forma independiente; el [desarrollo](DESARROLLO.md) explica su recorrido y comandos.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

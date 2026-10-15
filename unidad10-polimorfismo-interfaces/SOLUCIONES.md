# Soluciones razonadas

## Solución del laboratorio

El tipo de referencia es Notificador y el objeto concreto determina la implementación. La interfaz establece una operación, pero los nombres no bastan para describir su contrato: también debes documentar entradas, resultado y errores. Ninguna implementación del ejemplo envía correo real.

La salida prevista es:

```text
Consola: Listo
Simulado: Listo
```

Recorre la lista usando la interfaz. Añade otra implementación y confirma que el bucle no cambia. Identifica por qué el método implementado es public. Prueba un mensaje vacío tras definir una política común.

## Solución de la extensión

Recibe el colaborador en un constructor y en enviar delega enviando "[Curso] " + mensaje. La clase compone la interfaz, por lo que puede decorar cualquiera de sus implementaciones sin repetirlas.

## Casos de aceptación

Consola decorada: Consola: [Curso] Listo; simulado decorado: Simulado: [Curso] Listo; colaborador nulo rechazado.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

La solución implementa NotificadorPrefijo con un destino no nulo y devuelve destino.enviar("[Curso] "+mensaje). Una capa produce Consola: [Curso] Listo y dos capas repiten [Curso]. No se modifica Consola para que reconozca todos los decoradores ni se antepone el prefijo después de enviar.

La [implementación completa](solucion/Solucion.java) se compila de forma independiente; el [desarrollo](DESARROLLO.md) explica su recorrido y comandos.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

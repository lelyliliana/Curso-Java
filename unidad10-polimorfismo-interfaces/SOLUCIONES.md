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

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

Consola decorada: Consola: [Curso] Listo; simulado decorado: Simulado: [Curso] Listo; colaborador nulo rechazado.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

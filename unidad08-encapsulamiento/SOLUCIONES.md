# Soluciones razonadas

## Solución del laboratorio

Una operación rechazada debe conservar el estado. Valida antes de asignar. BigDecimal es inmutable y comparar valores monetarios con compareTo evita confundir 1.0 con 1.00. El laboratorio rechaza escalas superiores a dos incluso si son ceros; el proyecto usa una política distinta que admite ceros redundantes.

La salida prevista es:

```text
Saldo: 5.75
Saldo insuficiente
Saldo conservado: 5.75
```

Registra saldo antes y después de cada operación. Retira exactamente el saldo. Intenta retirar más. Observa dónde se compara y dónde se asigna. Introduce 1.001 y explica la política de escala.

## Solución de la extensión

Valida destinatario distinto, monto y fondos antes de modificar cualquiera de las cuentas. Para el ejercicio de un hilo puedes comprobar todo y después efectuar retiro y depósito; si el depósito puede fallar, necesitas validar también su contrato antes del retiro. No prometas atomicidad entre hilos con esta implementación.

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

Retiro exacto: saldo0; exceso: no cambia; cero/negativo: rechazo; transferencia a sí misma: rechazada.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

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

## Casos de aceptación

Retiro exacto: saldo0; exceso: no cambia; cero/negativo: rechazo; transferencia a sí misma: rechazada.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

La solución completa acepta saldo inicial cero, valida todos los datos antes de asignar y conserva ambos saldos ante rechazo. Tras el primer envío quedan 5.75/4.25; el rechazo de 8.00 no altera nada; el envío exacto de 5.75 deja 0.00/10.00. Transferir a sí misma se rechaza. No se promete coordinación entre hilos.

La [implementación completa](solucion/Solucion.java) se compila de forma independiente; el [desarrollo](DESARROLLO.md) explica su recorrido y comandos.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

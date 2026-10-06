# Soluciones razonadas

## Solución del laboratorio

LocalDate representa fecha sin hora ni zona, Instant un punto de la línea temporal y ZonedDateTime lo interpreta en una zona. Period expresa años, meses y días; getDays no es el total de días del período. ChronoUnit.DAYS.between cuenta días entre fechas. Un Clock inyectado hace reproducible una regla dependiente de hoy.

La salida prevista es:

```text
Días: 2
Fecha Bogotá: 2025-12-31
Instante: 2026-01-01T02:00:00Z
```

Cuenta manualmente el 29 de febrero del año bisiesto. Cambia la zona del Clock a UTC y compara la fecha. Mantén el mismo instante. Distingue una duración exacta de una cantidad calendárica.

## Solución de la extensión

Usa fecha.plusDays(7) y vencimiento.isBefore(LocalDate.now(reloj)). Define si vence al inicio o al final del día; con esta regla sigue vigente durante el día de vencimiento. Prueba con Clock.fixed, sin depender del reloj del computador.

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

Fecha límite igual a hoy: no vencido; día anterior: vencido; cruce de febrero bisiesto correcto; fin anterior al inicio: define rechazo.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

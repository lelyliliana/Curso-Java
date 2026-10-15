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

## Casos de aceptación

Fecha límite igual a hoy: no vencido; día anterior: vencido; cruce de febrero bisiesto correcto; fin anterior al inicio: define rechazo.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

La solución usa inicio.plusDays(7) y LocalDate.now(reloj).isAfter(vencimiento). El día 8 no está vencido; el 9 sí. Para 25/02/2024 el vencimiento es 03/03/2024. Inyectar Clock evita pruebas que cambien al llegar medianoche o al ejecutar en otra zona por defecto.

La [implementación completa](solucion/Solucion.java) se compila de forma independiente; el [desarrollo](DESARROLLO.md) explica su recorrido y comandos.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

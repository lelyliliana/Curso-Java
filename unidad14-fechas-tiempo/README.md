# Unidad 14 — Fechas y tiempo

Utiliza java.time.

## Tipos
- LocalDate: fecha sin zona/hora.
- LocalTime: hora sin fecha/zona.
- LocalDateTime: fecha/hora sin zona.
- Instant: punto temporal UTC.
- ZonedDateTime: fecha/hora con zona.

## Ejemplo
```java
LocalDate hoy = LocalDate.now();
LocalDate fecha = LocalDate.of(2026, 10, 2);
```

## No confundas
Una fecha de cumpleaños no necesita zona horaria; un evento global puede requerir instante/zona.

## Reto
Calcula días entre fechas y diseña agenda que distinga fecha local de instante global.

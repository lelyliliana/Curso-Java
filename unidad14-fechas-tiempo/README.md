# Unidad 14 — Fechas y tiempo con java.time

## Qué aprenderás
Elegir entre LocalDate, LocalDateTime, Instant y ZonedDateTime, formatear y calcular intervalos sin confundir fecha local con instante global.

# 1. No existe un único “tipo fecha”

Cumpleaños:
```text
14 de agosto
```
no necesita representar un instante global.

Una transacción:
```text
ocurrió en un momento concreto
```
sí puede requerir un instante.

# 2. Tipos

**LocalDate:** fecha sin hora/zona.  
**LocalTime:** hora sin fecha/zona.  
**LocalDateTime:** fecha+hora sin zona.  
**Instant:** instante en la línea temporal UTC.  
**ZonedDateTime:** fecha/hora asociada a ZoneId y reglas de zona.  
**OffsetDateTime:** fecha/hora con offset explícito.

# 3. Crear

```java
LocalDate fecha = LocalDate.of(2026, 10, 2);
Instant ahora = Instant.now();
ZoneId zona = ZoneId.of("America/Bogota");
ZonedDateTime local = ahora.atZone(zona);
```

# 4. LocalDateTime no es un instante

```text
2026-10-02 10:00
```

¿10:00 dónde?

Sin zona/offset no identifica por sí solo un punto único global.

# 5. Parseo/formato

ISO:
```java
LocalDate fecha = LocalDate.parse("2026-10-02");
```

Formato:
```java
DateTimeFormatter formato =
    DateTimeFormatter.ofPattern("dd/MM/uuuu");

String salida = fecha.format(formato);
```

Distingue almacenamiento/intercambio de presentación.

# 6. Inmutabilidad

Tipos principales de java.time son inmutables.

```java
fecha.plusDays(1);
```

no modifica `fecha`; debes usar el resultado.

# 7. Diferencias

```java
long dias = ChronoUnit.DAYS.between(inicio, fin);
```

Para periodos humanos:
```java
Period periodo = Period.between(fecha1, fecha2);
```

Duración temporal:
```java
Duration.between(instante1, instante2);
```

Period y Duration responden conceptos distintos.

# 8. Zonas horarias

Las zonas tienen reglas históricas y posibles cambios de offset.

Evita convertir todo a un offset fijo si el requisito realmente habla de una zona geográfica.

# 9. Práctica guiada

Agenda:
- fecha de nacimiento → LocalDate;
- hora habitual local → LocalTime;
- instante de creación → Instant;
- reunión internacional → ZonedDateTime/Instant + zona de presentación.

Justifica cada tipo.

# 10. Errores frecuentes
- LocalDateTime para evento global sin zona.
- sumar sin guardar resultado.
- formato de pantalla como formato de almacenamiento universal.
- Duration para “meses” humanos.
- offset fijo = zona.

# 11. Ejercicios
Edad aproximada/correcta según regla, días entre fechas, vencimiento, conversión de instante a dos zonas.

# 12. Reto
Diseña agenda que distinga eventos locales e instantes globales y documenta decisiones.

# 13. Autoevaluación
1. ¿LocalDate tiene zona?
2. ¿Instant?
3. ¿LocalDateTime identifica instante?
4. ¿Period vs Duration?
5. ¿java.time es mutable?
6. ¿offset = ZoneId?

# 14. Checklist
- [ ] Elijo tipo temporal.
- [ ] Parseo/formateo.
- [ ] Manejo inmutabilidad.
- [ ] Distingo zona/offset.

Continúa con archivos.

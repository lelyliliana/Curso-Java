# Unidad 14: Fechas y tiempo con java.time

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Elegir entre LocalDate, LocalDateTime, Instant y ZonedDateTime, formatear y calcular intervalos sin confundir fecha local con instante global.

## 1. No existe un único “tipo fecha”

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

## 2. Tipos

**LocalDate:** fecha sin hora/zona.  
**LocalTime:** hora sin fecha/zona.  
**LocalDateTime:** fecha+hora sin zona.  
**Instant:** instante en la línea temporal UTC.  
**ZonedDateTime:** fecha/hora asociada a ZoneId y reglas de zona.  
**OffsetDateTime:** fecha/hora con offset explícito.

## 3. Crear

```java
LocalDate fecha = LocalDate.of(2026, 10, 2);
Instant ahora = Instant.now();
ZoneId zona = ZoneId.of("America/Bogota");
ZonedDateTime local = ahora.atZone(zona);
```

## 4. LocalDateTime no es un instante

```text
2026-10-02 10:00
```

¿10:00 dónde?

Sin zona/offset no identifica por sí solo un punto único global.

## 5. Parseo/formato

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

## 6. Inmutabilidad

Tipos principales de java.time son inmutables.

```java
fecha.plusDays(1);
```

no modifica `fecha`; debes usar el resultado.

## 7. Diferencias

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

## 8. Zonas horarias

Las zonas tienen reglas históricas y posibles cambios de offset.

Evita convertir todo a un offset fijo si el requisito realmente habla de una zona geográfica.

## 9. Práctica guiada

Agenda:
- fecha de nacimiento → LocalDate;
- hora habitual local → LocalTime;
- instante de creación → Instant;
- reunión internacional → ZonedDateTime/Instant + zona de presentación.

Justifica cada tipo.

## 10. Errores frecuentes
- LocalDateTime para evento global sin zona.
- sumar sin guardar resultado.
- formato de pantalla como formato de almacenamiento universal.
- Duration para “meses” humanos.
- offset fijo = zona.

## 11. Ejercicios
Edad aproximada/correcta según regla, días entre fechas, vencimiento, conversión de instante a dos zonas.

## 12. Reto
Diseña agenda que distinga eventos locales e instantes globales y documenta decisiones.

## 13. Autoevaluación
1. ¿LocalDate tiene zona?
2. ¿Instant?
3. ¿LocalDateTime identifica instante?
4. ¿Period vs Duration?
5. ¿java.time es mutable?
6. ¿offset = ZoneId?

## 14. Checklist
- [ ] Elijo tipo temporal.
- [ ] Parseo/formateo.
- [ ] Manejo inmutabilidad.
- [ ] Distingo zona/offset.

Continúa con archivos.


## Precisiones para aplicar el modelo

### Probar el parser estricto

[ParseoEstricto.java](ejemplos/ParseoEstricto.java) es una aplicación completa. Compílala y ejecútala dentro de ejemplos con los mismos comandos del laboratorio, usando ParseoEstricto como nombre. Acepta 29/02/2024 y rechaza 29/02/2023 y 31/04/2026. La prueba no depende de la fecha actual del equipo.

### Parseo estricto y ambigüedad de zonas

DateTimeFormatter.ofPattern usa resolución SMART por defecto. Si necesitas rechazar estrictamente fechas inexistentes, utiliza `ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT)` y captura DateTimeParseException. uuuu es año proléptico; yyyy es año de era y tiene reglas distintas.

Al convertir LocalDateTime a una zona puede existir un salto horario o dos offsets posibles en una transición. El método elige según reglas documentadas; una aplicación de reservas debe decidir su política para esa ambigüedad. Duration de 24 horas y un día de calendario no siempre coinciden donde hay cambio de horario.

## Laboratorio completo: observar, explicar y modificar

LocalDate representa fecha sin hora ni zona, Instant un punto de la línea temporal y ZonedDateTime lo interpreta en una zona. Period expresa años, meses y días; getDays no es el total de días del período. ChronoUnit.DAYS.between cuenta días entre fechas. Un Clock inyectado hace reproducible una regla dependiente de hoy.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad14-fechas-tiempo/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

### Paso 2. Compila

```text
javac -encoding UTF-8 --release 21 Laboratorio.java
```

`-encoding` define cómo se lee el código fuente y `--release` fija lenguaje, API y formato de clase compatibles con Java 21. Son decisiones diferentes. Si el comando falla, corrige el primer error relevante antes de ejecutar un bytecode antiguo.

### Paso 3. Ejecuta

```text
java Laboratorio
```

Compara la salida con el resultado previsto. Los valores se eligieron para hacer visible el comportamiento de esta unidad.

```text
Días: 2
Fecha Bogotá: 2025-12-31
Instante: 2026-01-01T02:00:00Z
```

### Paso 4. Recorre la lógica

Cuenta manualmente el 29 de febrero del año bisiesto. Cambia la zona del Clock a UTC y compara la fecha. Mantén el mismo instante. Distingue una duración exacta de una cantidad calendárica.

### Paso 5. Lee el código completo

```java
import java.time.*;
import java.time.temporal.ChronoUnit;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        LocalDate inicio = LocalDate.of(2024, 2, 28);
        LocalDate fin = LocalDate.of(2024, 3, 1);
        System.out.println("Días: " + ChronoUnit.DAYS.between(inicio, fin));
        Clock reloj = Clock.fixed(Instant.parse("2026-01-01T02:00:00Z"), ZoneId.of("America/Bogota"));
        System.out.println("Fecha Bogotá: " + LocalDate.now(reloj));
        System.out.println("Instante: " + reloj.instant());
    }

    
}
```

### Paso 6. Comprueba y extiende

Fecha límite igual a hoy: no vencido; día anterior: vencido; cruce de febrero bisiesto correcto; fin anterior al inicio: define rechazo.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 13: String y procesamiento de texto](../unidad13-cadenas/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 15: Archivos y NIO](../unidad15-archivos-nio/README.md)

# Práctica: Fechas y tiempo con java.time

## Objetivo y contrato

Calcula vencimiento 7 días después de una fecha y determina si está vencido usando Clock.

## Antes de programar

Explica con tus palabras este modelo: LocalDate representa fecha sin hora ni zona, Instant un punto de la línea temporal y ZonedDateTime lo interpreta en una zona. Period expresa años, meses y días; getDays no es el total de días del período. ChronoUnit.DAYS.between cuenta días entre fechas. Un Clock inyectado hace reproducible una regla dependiente de hoy.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Calcula vencimiento 7 días después de una fecha y determina si está vencido usando Clock.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

Fecha límite igual a hoy: no vencido; día anterior: vencido; cruce de febrero bisiesto correcto; fin anterior al inicio: define rechazo.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

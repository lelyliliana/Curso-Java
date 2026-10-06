# Práctica: Constructores, encapsulamiento e invariantes

## Objetivo y contrato

Añade saldo inicial no negativo y una transferencia sin cambios parciales por validación.

## Antes de programar

Explica con tus palabras este modelo: Una operación rechazada debe conservar el estado. Valida antes de asignar. BigDecimal es inmutable y comparar valores monetarios con compareTo evita confundir 1.0 con 1.00. El laboratorio rechaza escalas superiores a dos incluso si son ceros; el proyecto usa una política distinta que admite ceros redundantes.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Añade saldo inicial no negativo y una transferencia sin cambios parciales por validación.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

Retiro exacto: saldo0; exceso: no cambia; cero/negativo: rechazo; transferencia a sí misma: rechazada.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

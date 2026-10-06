# Práctica: Stream API

## Objetivo y contrato

Obtén las tres categorías con mayor venta total, con desempate por nombre.

## Antes de programar

Explica con tus palabras este modelo: Un stream es un recorrido, no una colección que guarda resultados. Operaciones intermedias son diferidas hasta una terminal. No reutilices un stream consumido: crea otro desde la fuente. groupingBy utiliza claves y acumuladores; TreeMap fija orden por categoría. La suma long sigue teniendo rango finito; las entradas de esta demostración son pequeñas.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Obtén las tres categorías con mayor venta total, con desempate por nombre.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

Categorías repetidas:suman; empate:orden de nombres; menos de tres:devuelve las existentes; vacío:lista vacía.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

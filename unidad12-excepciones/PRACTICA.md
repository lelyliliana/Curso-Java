# Práctica: Excepciones y manejo de errores

## Objetivo y contrato

Añade política estricta que rechace todo si una línea es inválida.

## Antes de programar

Explica con tus palabras este modelo: Una excepción señala que una operación no logró cumplir su contrato. Capturar únicamente NumberFormatException permite recuperar este fallo concreto por línea. No captura errores de programación arbitrarios. El resultado conserva tanto datos válidos como incidencias; esta es una importación parcial deliberada, distinta del proyecto final que rechaza el archivo completo.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Añade política estricta que rechace todo si una línea es inválida.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

Parcial [10,abc,25]: válidos[10,25]; estricta: excepción y ningún resultado aplicado; []: vacío sin errores.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

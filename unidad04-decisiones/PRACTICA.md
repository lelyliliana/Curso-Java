# Práctica: Decisiones en Java

## Objetivo y contrato

Clasifica temperatura finita en frío (<18), templado (18..30) y caliente (>30).

## Antes de programar

Explica con tus palabras este modelo: NaN no es menor ni mayor que los límites, por eso una comprobación nota < 0 || nota > 5 no lo rechaza. Double.isFinite cubre NaN y ambos infinitos. El orden de los rangos conserva el caso más específico; switch expresa opciones discretas y produce un resultado sin fall-through con las flechas.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Clasifica temperatura finita en frío (<18), templado (18..30) y caliente (>30).

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

17.99 frío, 18 templado, 30 templado, 30.01 caliente, NaN inválido.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

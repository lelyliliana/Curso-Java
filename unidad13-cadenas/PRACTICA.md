# Práctica: String y procesamiento de texto

## Objetivo y contrato

Cuenta palabras ignorando mayúsculas y espacios; texto vacío debe producir mapa vacío.

## Antes de programar

Explica con tus palabras este modelo: String es inmutable y sus índices cuentan unidades UTF-16, no necesariamente caracteres percibidos. Un punto de código tampoco equivale siempre a un grafema: algunos símbolos visibles combinan varios. Locale.ROOT evita depender del idioma del equipo para una normalización técnica. No elimina tildes ni hace equivalentes todas las representaciones Unicode.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Cuenta palabras ignorando mayúsculas y espacios; texto vacío debe producir mapa vacío.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

" Sol sol ": {sol=2}; "  ": {}; "LUNA luna": {luna=2}; una tilde conserva su identidad.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

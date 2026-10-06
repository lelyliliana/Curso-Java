# Práctica: Optional y ausencia de valores

## Objetivo y contrato

Devuelve correo normalizado solo para un usuario encontrado con correo no vacío.

## Antes de programar

Explica con tus palabras este modelo: Optional expresa una ausencia prevista en el retorno. No convierte un fallo de red o archivo en ausencia. orElse evalúa su argumento antes de invocar el método, aunque haya valor. orElseGet recibe un proveedor que solo se invoca si falta el valor. Evita get sin verificar y no retornes null en lugar de Optional.empty.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Devuelve correo normalizado solo para un usuario encontrado con correo no vacío.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

Usuario ausente:empty; correo vacío:empty; correo válido:presente; fallo de repositorio:propaga error según contrato.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

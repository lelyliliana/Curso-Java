# Práctica: Archivos y NIO

## Objetivo y contrato

Cuenta líneas no vacías de un archivo recibido por argumento sin cargar todas las líneas.

## Antes de programar

Explica con tus palabras este modelo: Path describe una ruta; Files realiza operaciones que pueden fallar por permisos, ausencia, espacio o concurrencia. resolve compone rutas sin escribir separadores específicos del sistema. readAllLines carga todo el archivo en memoria y sirve para entradas pequeñas; Files.lines permite procesamiento progresivo y debe cerrarse con try-with-resources.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Cuenta líneas no vacías de un archivo recibido por argumento sin cargar todas las líneas.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

Archivo vacío:0; dos líneas útiles:2; ruta inexistente:error; tildes preservadas; recurso cerrado incluso ante fallo.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

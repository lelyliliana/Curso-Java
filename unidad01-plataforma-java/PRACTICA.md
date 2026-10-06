# Práctica: JDK, JVM y bytecode

## Objetivo y contrato

Explica con evidencia la diferencia entre cambiar fuente y cambiar bytecode.

## Antes de programar

Explica con tus palabras este modelo: La propiedad java.class.version informa la versión de formato de clase soportada por la JVM que ejecuta, no inspecciona el archivo actual. Para inspeccionar el bytecode compilado usa javap -verbose Laboratorio.class y busca major version. release 21 produce major 65 aun si se compila con un JDK posterior.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Explica con evidencia la diferencia entre cambiar fuente y cambiar bytecode.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

Fuente B y bytecode A: A. Recompilado: B. JVM compatible: ejecuta; JVM 17 con clase release 21: UnsupportedClassVersionError.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

# Práctica: Enumeraciones y records

## Objetivo y contrato

Crea record Lectura(double valor, Estado estado) que rechace valores no finitos y estado nulo.

## Antes de programar

Explica con tus palabras este modelo: Un record genera constructor canónico, accesores, equals, hashCode y toString. Sus campos son finales, pero los componentes pueden apuntar a objetos mutables. List.copyOf toma una instantánea no modificable de la lista; sus elementos String son inmutables. Si fueran objetos mutables, la copia seguiría siendo superficial.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Crea record Lectura(double valor, Estado estado) que rechace valores no finitos y estado nulo.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

25.0 válido; NaN/infinito rechazados; estado nulo rechazado; dos lecturas iguales tienen equals true.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

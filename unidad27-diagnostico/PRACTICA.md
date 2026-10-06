# Práctica: Diagnóstico, logging, depuración y configuración

## Objetivo y contrato

Configura un puerto 1024..65535 mediante propiedad y prueba ausente, válido e inválido.

## Antes de programar

Explica con tus palabras este modelo: System.getProperty consulta propiedades de la JVM; System.getenv consulta variables del proceso. Son mecanismos diferentes. Un valor predeterminado solo se aplica ante ausencia, no ante formato incorrecto. java.util.logging pertenece al JDK y permite niveles sin añadir un framework. La marca temporal del log no forma parte de la salida estable del ejercicio.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Configura un puerto 1024..65535 mediante propiedad y prueba ausente, válido e inválido.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

Ausente:valor por defecto; 5000:válido; 80:fuera de política; abc:formato; 65536:fuera de rango.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

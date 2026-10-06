# Práctica: Maven y estructura de proyectos

## Objetivo y contrato

Añade una clase Saludo con una prueba y un JAR ejecutable.

## Antes de programar

Explica con tus palabras este modelo: Maven organiza un ciclo de vida con fases. package ejecuta fases anteriores, incluida test; verify añade comprobaciones posteriores si están configuradas. Dependencias son bibliotecas del proyecto; plugins realizan tareas de construcción. Fijar maven.compiler.release no fija por sí solo la versión del JDK que ejecuta Maven.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Añade una clase Saludo con una prueba y un JAR ejecutable.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

mvn test:pruebas ejecutadas; package:JAR creado; java -jar:saludo; dependencia test no se necesita en la aplicación final.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

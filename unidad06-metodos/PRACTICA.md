# Práctica: Métodos y modularización

## Objetivo y contrato

Escribe duplicar(int[] datos) que devuelve otro arreglo sin cambiar el original.

## Antes de programar

Explica con tus palabras este modelo: Java pasa siempre valores. En una referencia se copia el valor de la referencia: llamador y método apuntan al mismo arreglo inicialmente. Cambiar un elemento afecta ese objeto compartido. Reasignar el parámetro solo cambia la copia local. Esto no es paso por referencia.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Escribe duplicar(int[] datos) que devuelve otro arreglo sin cambiar el original.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

[2,3] devuelve [4,6] y original [2,3]; [] devuelve vacío distinto; dos invocaciones no comparten el arreglo resultado.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

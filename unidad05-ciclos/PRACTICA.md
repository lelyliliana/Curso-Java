# Práctica: Ciclos en Java

## Objetivo y contrato

Calcula mínimo y máximo; define qué hacer si no existen observaciones.

## Antes de programar

Explica con tus palabras este modelo: Un arreglo es un objeto con tamaño fijo, posiciones desde cero y length como campo. Sus elementos de int comienzan en cero cuando se crea con new int[n]. El for-each copia cada valor a la variable local: reasignarla no cambia un elemento primitivo del arreglo. Necesitas índices para modificar posiciones.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Calcula mínimo y máximo; define qué hacer si no existen observaciones.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

[5]: min=max=5; [-3,-8]: min=-8,max=-3; []: sin datos; última posición válida: length-1.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

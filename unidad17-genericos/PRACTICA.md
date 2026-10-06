# Práctica: Genéricos

## Objetivo y contrato

Implementa primero(List<T>) como Optional<T> para una lista posiblemente vacía.

## Antes de programar

Explica con tus palabras este modelo: El origen produce elementos para el método y el destino los consume. El parámetro T relaciona ambos lados. Los tipos genéricos son invariantes: List<Integer> no se asigna a List<Number>, pero puede pasarse como List<? extends Number>. PECS describe este acceso, no impide toda mutación de la lista; por ejemplo puede eliminar elementos si su implementación lo admite.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Implementa primero(List<T>) como Optional<T> para una lista posiblemente vacía.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

List<String> devuelve Optional<String>; vacía:empty; [7]:Optional[7]; destino no modificable:UnsupportedOperationException.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

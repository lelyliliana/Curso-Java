# Práctica: Buenas prácticas y refactorización

## Objetivo y contrato

Refactoriza un cálculo con impuesto: base decimal no negativa, tasa entre 0 y 1, total base*(1+tasa) y redondeo HALF_UP a dos decimales al final. Conserva resultados y excepciones.

## Antes de programar

Explica con tus palabras este modelo: Refactorizar mantiene el comportamiento contratado, incluidos errores relevantes. Extraer validación mejora el nombre de una responsabilidad, pero no justifica una jerarquía de clases vacías. La misma tabla de casos puede ejecutar ambas versiones y comparar valor o tipo de error. Pruebas verdes reducen riesgo sin demostrar equivalencia para todas las entradas posibles.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Refactoriza un cálculo con impuesto: base decimal no negativa, tasa entre 0 y 1, total base*(1+tasa) y redondeo HALF_UP a dos decimales al final. Conserva resultados y excepciones.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

Para la suma del laboratorio: lista vacía produce 0; [100,200] produce 300; negativo y desbordamiento se rechazan en ambas versiones.

Para la extensión del impuesto: 0 con 0.19 produce 0.00; 100 con 0.19 produce 119.00; 0.05 con 0.10 produce 0.06. Base negativa o tasa fuera de 0..1 se rechazan en ambas versiones.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

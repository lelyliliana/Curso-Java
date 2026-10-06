# Práctica: Threads, estado compartido y condiciones de carrera

## Objetivo y contrato

Compara contador protegido por synchronized con AtomicInteger, sin exigir que uno sea siempre más rápido.

## Antes de programar

Explica con tus palabras este modelo: contador++ sobre int combina lectura, suma y escritura, por eso puede perder incrementos. volatile aporta visibilidad pero no hace atómica esa secuencia. AtomicInteger.incrementAndGet es una operación atómica. join espera la finalización y establece la relación de visibilidad correspondiente. El resultado correcto de una corrida del ejemplo defectuoso no demuestra ausencia de carrera.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Compara contador protegido por synchronized con AtomicInteger, sin exigir que uno sea siempre más rápido.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

Un hilo:10000; dos:20000; 0 iteraciones:0; volatile con ++ sigue sin garantizar conteo.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

# Práctica: Variables, tipos y operadores

## Objetivo y contrato

Convierte segundos no negativos en horas, minutos y segundos; conserva el total original.

## Antes de programar

Explica con tus palabras este modelo: El tipo de la variable receptora no corrige una operación ya efectuada: double resultado = 5 / 2 guarda 2.0. Ampliar un operando antes de sumar evita ese desbordamiento concreto; convertir después conserva el resultado ya desbordado. Math.addExact permite detectar desbordamiento de enteros cuando el contrato exige rechazarlo.

Trabaja sobre una copia del laboratorio y conserva el original para comparar. Escribe entradas válidas, fronteras y errores antes de editar; distingue un problema de sintaxis de una operación que se rechaza en ejecución.

## Paso 1. Predicción

Ejecuta el laboratorio sin cambios y registra únicamente lo necesario para justificar su comportamiento. No basta con una captura: relaciona una sentencia con el resultado que produce.

## Paso 2. Implementación

Convierte segundos no negativos en horas, minutos y segundos; conserva el total original.

Mantén el contrato visible cerca del método o en el README de tu solución. Si eliges una política diferente, explica qué entrada cambia y por qué.

## Paso 3. Comprobación

0: 0:00:00; 59: 0:00:59; 3600: 1:00:00. El intervalo de minutos y segundos debe ser 0..59.

Añade al menos un caso que distinga una solución correcta de un error frecuente de esta unidad. Una salida coincidente para el caso habitual no es suficiente si el ejercicio incluye fronteras o fallos.

## Paso 4. Diagnóstico

Si el resultado diverge, anota entrada, esperado, obtenido y la primera operación que explica la diferencia. Cambia una cosa por vez; repite el caso original después de corregir.

## Evidencia de aprendizaje

Presenta el archivo fuente, el comando utilizado, una tabla de casos y una explicación de la decisión principal. Otra persona debe poder ejecutar el programa sin tus rutas personales.

[Consultar soluciones](SOLUCIONES.md) · [Volver a la unidad](README.md)

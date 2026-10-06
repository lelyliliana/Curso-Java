# Práctica: pruebas que detectan errores

## Paso 1. Ejecuta la suite

Desde esta unidad, `mvn test`. CalculadoraTest contiene una suma y una división rechazada. Identifica Preparar, Actuar y Afirmar.

## Paso 2. Define el contrato restante

La división es entera y trunca hacia cero. Decide si el caso Integer.MIN_VALUE / -1 conserva el comportamiento ordinario de int o debe rechazar desbordamiento. Para esta práctica conserva el comportamiento de Java y documenta el caso; no lo cambies en una prueba sin cambiar el contrato.

## Paso 3. Añade casos

Prueba 7/2=3, -7/2=-3, 0/2=0 y divisor0 rechazado. Escribe pruebas independientes; usa parametrización si facilita comparar las entradas. No pruebes métodos privados.

## Paso 4. Haz visible una regresión

Cambia provisionalmente dividir para devolver siempre 3. La prueba 7/2 no lo detecta, pero -7/2 y 0/2 sí. Restaura la implementación.

## Paso 5. Explica cobertura y límites

Describe qué regla comprueba cada caso. Una cobertura elevada no demuestra que todas las combinaciones aritméticas se comporten correctamente. No hace falta probar getters triviales para incrementar la métrica.

[Soluciones](SOLUCIONES.md) · [Unidad](README.md)

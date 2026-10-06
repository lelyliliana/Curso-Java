# Soluciones razonadas

## Solución del laboratorio

NaN no es menor ni mayor que los límites, por eso una comprobación nota < 0 || nota > 5 no lo rechaza. Double.isFinite cubre NaN y ambos infinitos. El orden de los rangos conserva el caso más específico; switch expresa opciones discretas y produce un resultado sin fall-through con las flechas.

La salida prevista es:

```text
2.99 -> No aprobada
3.0 -> Aprobada
4.5 -> Excelente
5.0 -> Excelente
NaN -> Inválida
Infinity -> Inválida
Consultar
```

Construye una tabla con las fronteras 0, 3, 4.5 y 5. Cambia el orden de las condiciones y predice la clasificación. Recupera el orden correcto. Introduce una opción de menú desconocida.

## Solución de la extensión

Rechaza primero !Double.isFinite(valor). Luego comprueba valor < 18, valor <= 30 y el resto. No uses un switch de enteros truncados: alteraría las fronteras decimales del contrato.

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

17.99 frío, 18 templado, 30 templado, 30.01 caliente, NaN inválido.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

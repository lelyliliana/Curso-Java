# Soluciones razonadas

## Solución del laboratorio

El tipo de la variable receptora no corrige una operación ya efectuada: double resultado = 5 / 2 guarda 2.0. Ampliar un operando antes de sumar evita ese desbordamiento concreto; convertir después conserva el resultado ya desbordado. Math.addExact permite detectar desbordamiento de enteros cuando el contrato exige rechazarlo.

La salida prevista es:

```text
2:03:05
División: 2 / 2.5
Desbordamiento: -2147483648
Ampliado antes: 2147483648
```

Traza cociente y residuo. Cambia segundos por 59, 60 y 3600. Predice cada división antes de ejecutar. Prueba el cast antes y después de sumar.

## Solución de la extensión

Calcula horas = total / 3600, minutos = total % 3600 / 60 y segundos = total % 60. Rechaza negativos antes de operar. Reconstruye horas * 3600 + minutos * 60 + segundos para comprobar el resultado.

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

0: 0:00:00; 59: 0:00:59; 3600: 1:00:00. El intervalo de minutos y segundos debe ser 0..59.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

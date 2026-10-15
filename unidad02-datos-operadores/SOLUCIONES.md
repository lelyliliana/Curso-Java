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

## Casos de aceptación

0: 0:00:00; 59: 0:00:59; 3600: 1:00:00. El intervalo de minutos y segundos debe ser 0..59.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

La solución completa devuelve 0:00:00, 0:00:59, 0:01:00, 0:59:59, 1:00:00 y 2:03:05 respectivamente. -1 se rechaza. Se conserva total y se construye Tiempo; no se resta repetidamente sobre una variable que luego quieras usar como entrada original. El ejemplo también contrasta 5/2 con 5.0/2 y ampliación antes de sumar.

La [implementación completa](solucion/Solucion.java) se compila de forma independiente; el [desarrollo](DESARROLLO.md) explica su recorrido y comandos.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

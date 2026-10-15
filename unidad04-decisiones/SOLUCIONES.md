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

## Casos de aceptación

17.99 frío, 18 templado, 30 templado, 30.01 caliente, NaN inválido.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

La solución clasifica 17.99 como Frío; 18 y 30 como Templado; 30.01 como Caliente. NaN e infinito lanzan IllegalArgumentException antes de clasificar. La primera guarda valida finitud, después se evalúan dos fronteras. Una nota inválida y una temperatura no finita no deben presentarse como una categoría normal.

La [implementación completa](solucion/Solucion.java) se compila de forma independiente; el [desarrollo](DESARROLLO.md) explica su recorrido y comandos.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

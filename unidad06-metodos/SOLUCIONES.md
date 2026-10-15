# Soluciones razonadas

## Solución del laboratorio

Java pasa siempre valores. En una referencia se copia el valor de la referencia: llamador y método apuntan al mismo arreglo inicialmente. Cambiar un elemento afecta ese objeto compartido. Reasignar el parámetro solo cambia la copia local. Esto no es paso por referencia.

La salida prevista es:

```text
Número: 10
Arreglo: [99, 20]
Promedio: 3.5
```

Dibuja dos variables apuntando al mismo arreglo. Identifica qué sentencia modifica el objeto y cuál cambia solo una referencia. Quita una sentencia por vez y compara. Prueba promedio con cantidad cero.

## Solución de la extensión

Crea un nuevo int[datos.length], recorre con índices y guarda datos[i] * 2. Devuelve la referencia nueva. Define límites de los enteros o usa Math.multiplyExact si el resultado debe rechazarse cuando se desborda.

## Casos de aceptación

[2,3] devuelve [4,6] y original [2,3]; [] devuelve vacío distinto; dos invocaciones no comparten el arreglo resultado.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

La solución devuelve un arreglo nuevo, usa Math.multiplyExact por elemento y no cambia datos. Vacío produce otro arreglo de longitud cero; null se rechaza. Integer.MAX_VALUE no puede duplicarse en int y lanza ArithmeticException. Si tu interpretación de duplicar era una copia sin transformar, declara ese contrato diferente antes de comparar resultados.

La [implementación completa](solucion/Solucion.java) se compila de forma independiente; el [desarrollo](DESARROLLO.md) explica su recorrido y comandos.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

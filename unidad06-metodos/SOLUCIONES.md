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

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

[2,3] devuelve [4,6] y original [2,3]; [] devuelve vacío distinto; dos invocaciones no comparten el arreglo resultado.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

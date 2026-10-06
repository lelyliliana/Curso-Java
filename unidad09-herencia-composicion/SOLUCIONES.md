# Soluciones razonadas

## Solución del laboratorio

Composición expresa tiene un motor; herencia permite que Perro sea usado donde se requiere Animal. El método sobrescrito se selecciona según el objeto real. No se debe heredar solamente para ahorrar líneas: el subtipo debe respetar el contrato del supertipo.

La salida prevista es:

```text
Motor encendido; vehículo listo
Guau
```

Separa las dos relaciones. Identifica delegación y sobrescritura. Cambia una implementación sin modificar el llamador. Pregunta si un vehículo es realmente un motor antes de intentar extends.

## Solución de la extensión

Define encender en Propulsion, implementa MotorElectrico y MotorCombustion, recibe Propulsion en el constructor y delega. Valida no nulo. La elección se hace al construir el vehículo, sin condicionales de tipo dentro de arrancar.

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

Ambas propulsiones arrancan; null rechazado; código de Vehiculo sin instanceof ni cast.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

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

## Casos de aceptación

Ambas propulsiones arrancan; null rechazado; código de Vehiculo sin instanceof ni cast.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

La solución recibe Propulsion en el constructor y llama propulsion.encender(). Electrica y Combustion devuelven sus mensajes. Vehiculo no extiende ninguna de ellas. La referencia completa puede construirse con cualquiera sin alterar su método arrancar, y rechaza una dependencia null al construir.

La [implementación completa](solucion/Solucion.java) se compila de forma independiente; el [desarrollo](DESARROLLO.md) explica su recorrido y comandos.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

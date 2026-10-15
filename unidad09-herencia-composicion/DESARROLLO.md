# Sustituir una dependencia mediante composición

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad09-herencia-composicion/laboratorio/Laboratorio.java](../unidad09-herencia-composicion/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

La referencia muestra dos relaciones distintas: Perro extiende Animal y Vehiculo contiene Motor. Arrancar delega encender en ese objeto contenido. La relación de uso no exige que Vehiculo sea un tipo de motor.

La extensión define Propulsion con una operación encender. Electrica y Combustion cumplen el mismo contrato y el constructor de Vehiculo recibe una de ellas. El vehículo no necesita preguntar por el tipo concreto para ejecutar la operación.

La dependencia se valida al construir. Aceptar null y fallar mucho después en arrancar alejaría el error del punto donde se violó el contrato. La implementación puede ser pequeña y seguir demostrando sustitución: no es obligatorio crear un framework de inyección.

Elegir composición no elimina toda herencia de Java: las implementaciones satisfacen una interfaz. El objetivo es que el dominio no exprese una relación incorrecta ni dependa de un árbol artificial para intercambiar una capacidad.

## 3. Construye y contrasta

Construye dos vehículos con implementaciones diferentes y llama al mismo método arrancar. No cambies Vehiculo entre las dos ejecuciones ni uses instanceof para decidir qué encender. Identifica qué parte fija el contrato y qué parte aporta el comportamiento variable.

## Ejecutar la extensión completa

El archivo [Solucion.java](solucion/Solucion.java) contiene imports, métodos y main. Abre una terminal en la carpeta solucion de esta unidad y ejecuta cada comando por separado:

```text
javac -encoding UTF-8 --release 21 Solucion.java
```

```text
java Solucion
```

La referencia Laboratorio.java permanece en su carpeta original. Las clases sin paquete de unidades diferentes se compilan por separado; no juntes todos sus archivos en una sola compilación.

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2009%20%E2%80%94%20Herencia%20y%20composici%C3%B3n%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad09-herencia-composicion%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

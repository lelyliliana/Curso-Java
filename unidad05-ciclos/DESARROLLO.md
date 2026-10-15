# Inicializar acumuladores desde una observación real

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad05-ciclos/laboratorio/Laboratorio.java](../unidad05-ciclos/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

El laboratorio suma cuatro valores y convierte antes de dividir para conservar la parte decimal del promedio. Su arreglo no está vacío; cambiar esa precondición exige decidir qué representa la ausencia de observaciones.

En mínimo/máximo no inicialices ambos a cero sin justificarlo. Con un conjunto exclusivamente negativo, cero no pertenece a los datos y produciría un máximo falso. La solución utiliza el primer elemento cuando existe y devuelve Optional.empty para un arreglo vacío.

El ciclo mantiene una invariante sencilla: después de recorrer cada dato, mínimo y máximo representan los extremos de lo visitado. Inicializar con el primer dato y volver a compararlo no perjudica el resultado. La estructura de salida record conserva ambos valores sin recurrir a un arreglo de posiciones con significado implícito.

Un arreglo nulo es un error de llamada en esta API; no se considera otra colección vacía. El for-each permite consultar valores, pero reasignar su variable local no modifica los elementos primitivos del arreglo.

## 3. Construye y contrasta

Compara datos positivos, exclusivamente negativos, un único elemento y un arreglo vacío. Explica qué observación originó cada extremo. Si utilizas un resultado opcional, muestra Sin observaciones en vez de ejecutar get sin comprobar presencia.

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

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2005%20%E2%80%94%20Ciclos%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad05-ciclos%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

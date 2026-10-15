# Agrupar antes de comparar totales

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad19-streams/laboratorio/Laboratorio.java](../unidad19-streams/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

La fuente contiene dos ventas de Libros y una de Tecnología. groupingBy reúne por categoría y summingLong acumula importes. TreeMap determina el orden por nombre de las claves al mostrar el mapa; no está ordenando de mayor a menor venta.

El reto de las tres primeras requiere dos etapas: agregar por categoría y ordenar los totales. Ordenar ventas individuales y tomar tres podría repetir categoría y perder parte de su suma. La solución devuelve un record Total con un resultado por categoría.

El comparador ordena centavos descendente y después categoría ascendente. Cuando A y B suman 60, A aparece antes. Expresar el desempate hace reproducible una expectativa que un HashMap por sí solo no proporciona.

La extensión acumula con Math.addExact para detectar desbordamiento de long. La demostración original utiliza cantidades pequeñas; ampliar los datos sin revisar rango cambiaría sus garantías. Una operación terminal consume el stream; crea otro desde la fuente si necesitas un segundo recorrido.

## 3. Construye y contrasta

Con A=40+20 y B=50+10, espera A antes de B, ambos 60. Añade C=5 y D=1 para comprobar el límite de tres. Prueba vacío y una suma Long.MAX_VALUE+1. El rechazo del desbordamiento no debe convertirse en un total negativo aceptado.

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

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2019%20%E2%80%94%20Stream%20API%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad19-streams%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

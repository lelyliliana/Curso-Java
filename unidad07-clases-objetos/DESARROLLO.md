# Relacionar identidad, consultas y ausencia de cambios

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad07-clases-objetos/laboratorio/Laboratorio.java](../unidad07-clases-objetos/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

a y alias contienen la misma referencia; b apunta a otro Producto construido con datos iguales. Por eso a==alias es true y a==b es false. Esta clase no redefine equals y no hereda automáticamente una igualdad por contenido por tener los mismos campos.

El precio se expresa en centavos long. subtotal multiplica por cantidad y rechaza una cantidad no positiva. Math.multiplyExact detecta desbordamiento. La unidad monetaria forma parte del contrato; imprimir 3750 no significa que el método devuelva 37.50 como decimal.

Añadir una consulta nombre() permite observar el campo sin ofrecer un setter. Los campos final y la ausencia de operaciones mutadoras protegen esta pequeña instancia. Un método que consulta no necesita guardar el subtotal como otro atributo, porque depende de la cantidad recibida.

El código usa una clase anidada para reunir la demostración en un archivo. En el proyecto final las responsabilidades se separan en archivos y paquetes. No copies automáticamente cada decisión de organización de un ejemplo mínimo a una aplicación mayor.

## 3. Construye y contrasta

Consulta nombre y subtotal varias veces con cantidades distintas. Registra que cada operación devuelve un resultado calculado y el nombre permanece. Prueba una cantidad cero y una combinación cuyo producto no quepa en long.

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2007%20%E2%80%94%20Clases%20y%20objetos%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad07-clases-objetos%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

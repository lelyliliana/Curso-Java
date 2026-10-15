# Seguir un comando desde la regla hasta el archivo confirmado

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [src/main/java/com/lelyliliana/inventario/ServicioInventario.java](../src/main/java/com/lelyliliana/inventario/ServicioInventario.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

El taller conecta Producto, Inventario, Almacen, ArchivoInventario y Main. Para estudiar una acción empieza en su comando de consola, sigue el servicio y termina en la nueva instantánea de Producto. La regla no depende de Scanner ni conoce rutas.

Añadir existencias crea otro Producto con el mismo código, nombre y precio. Valida cantidad positiva y que el stock no supere 1000000. La comprobación de margen se hace antes de sumar, incluso para una cantidad int extrema. El constructor vuelve a proteger invariantes de la instantánea.

Inventario busca por código y sustituye el producto solo si la operación aceptó el cambio. ServicioInventario trabaja sobre una copia candidata, solicita guardar y confirma su memoria después del éxito. Si la escritura lanza IOException, la sesión conserva la colección anterior.

La opción 7 utiliza ese servicio. No modifica el archivo directamente ni incrementa primero el producto visible para intentar deshacerlo después. Esta secuencia local no equivale a una transacción multiusuario ni promete recuperación de un disco ante fallos físicos.

## 3. Construye y contrasta

Registra A con stock 3, añade2 y verifica5. Rechaza cantidad0 y exceso del máximo sin cambios. Provoca un fallo de guardado con Almacen simulado y conserva3. En una ejecución real cierra y abre para recuperar el stock confirmado.

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2029%20%E2%80%94%20Taller%20de%20problemas%20Java%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad29-taller%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

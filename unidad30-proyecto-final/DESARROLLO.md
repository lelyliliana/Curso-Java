# Entregar una extensión completa sin duplicar invariantes

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [src/main/java/com/lelyliliana/inventario/Producto.java](../src/main/java/com/lelyliliana/inventario/Producto.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

El proyecto final admite extender el inventario con reglas equivalentes. La referencia añade actualizar nombre y precio manteniendo código y stock. Producto.actualizar construye otra instantánea y reutiliza su constructor: normalización del nombre y escala exacta del precio siguen teniendo una sola frontera de dominio.

Inventario exige que exista el código antes de sustituir. ServicioInventario usa el mismo patrón candidato, guardar y confirmar. El menú pide todos los campos antes de llamar al caso de uso; EOF a mitad descarta la operación incompleta.

Cambiar nombre no cambia identidad. Tampoco debe alterar stock de forma indirecta. Las pruebas verifican normalización, precio inválido, código ausente, fallo de escritura y recuperación al reiniciar. Una salida que diga guardado no basta si el archivo no contiene el nuevo dato.

La entrega explica alcance local, formato, pruebas y comandos. Código adicional solo aporta valor si conserva contratos y presenta evidencia. Agregar threads o un framework no resuelve por sí mismo conflictos entre procesos que escriben el mismo archivo.

## 3. Construye y contrasta

Desde stock 5 actualiza a Libro y 20.00. El reporte debe ser 100.00 y el código mantenerse. Rechaza nombre vacío y 1.001 sin cambiar el registro. Cierra a mitad de la opción 8 y verifica que no se guardaron datos parciales.

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2030%20%E2%80%94%20Proyecto%20final%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad30-proyecto-final%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

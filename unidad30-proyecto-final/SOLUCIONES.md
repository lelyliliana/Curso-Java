# Referencia de solución y decisiones

El inventario completo vive en [src/main/java/com/lelyliliana/inventario](../src/main/java/com/lelyliliana/inventario/); las pruebas están en [src/test/java](../src/test/java/). [La guía del proyecto](../docs/PROYECTO_INVENTARIO.md) describe ejecución, modelo, contratos y límites.

## Cómo estudiar sin copiar a ciegas

1. Lee Producto y predice qué entradas puede construir.
2. Lee Inventario y justifica Map, Optional y copias del listado.
3. Ejecuta ProductoTest e InventarioTest; identifica un caso que detecte un defecto real.
4. Lee ArchivoInventario y construye manualmente un registro con nombre que contiene |.
5. Lee ServicioInventario y explica por qué guardar precede a confirmar memoria.
6. Ejecuta pruebas de archivos reales y pruebas con Almacen simulado.
7. Ejecuta el menú, registra, retira y reinicia.
8. Implementa tu extensión con sus propios contratos.

## Alternativas aceptables

Precio en centavos long puede ser correcto si defines rango y evitas desbordamiento. BigDecimal permite una política decimal explícita. Un modelo mutable puede ser correcto si valida antes de cambiar y no expone alias peligrosos. Una política parcial de importación puede ser correcta para otro caso de uso, pero debe informar incidencias y no hacerse pasar por carga estricta.

Usar un solo archivo no equivale a persistencia multiusuario. Añadir threads no resuelve coordinación entre procesos ni conflictos de versiones. Una capa extra solo se justifica si separa una responsabilidad que existe.

## Extensión: actualizar nombre y precio

Define Producto.actualizar(nombre,precio) que construye otra instantánea conservando código y stock. Inventario sustituye por código existente; ServicioInventario valida un candidato y lo guarda antes de confirmar. Prueba normalización, precio inválido, código ausente y fallo de guardado. Reutiliza invariantes del constructor en vez de duplicarlas en la consola.

## Lectura crítica de las pruebas

La suite comprueba reglas relevantes, no todas las entradas posibles ni todas las fallas de un disco. Un test de error simulado demuestra reacción del servicio al contrato de Almacen. Las pruebas con NIO demuestran ida y vuelta del formato y rechazo de archivos inválidos en entornos controlados.

[Práctica](PRACTICA.md) · [Unidad](README.md)

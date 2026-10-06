# Taller integrador: catálogo y movimientos

## Problema

Una biblioteca de materiales tecnológicos registra productos ficticios, sus precios y existencias. Los códigos no se repiten. Un retiro reduce stock solo si la cantidad es positiva y hay fondos suficientes. Un reporte suma valor de existencias. El archivo debe permitir recuperar el estado después de cerrar el programa.

## Etapa 1. Contratos antes del código

Escribe una tabla de entradas, resultados y errores. Usa el [contrato del inventario](../docs/PROYECTO_INVENTARIO.md) como referencia. Define identidad por código, igualdad de instantáneas por todos los componentes y la diferencia entre producto ausente y archivo ilegible.

Comprueba códigos A-1 y A-2, precio 0.01, stock 0 y retiro exacto. Incluye duplicados, un precio con tres decimales significativos y retiro superior al stock.

## Etapa 2. Modelo puro

Implementa Producto y las operaciones del catálogo sin Scanner ni Files. Un producto válido no contiene nombre vacío, stock negativo ni precio nulo. Un retiro crea otra instantánea. Justifica si tu modelo mutable conserva las mismas garantías.

Antes de avanzar, demuestra con pruebas que un retiro rechazado conserva el producto anterior. No importa todavía cómo se muestra el menú.

## Etapa 3. Consultas

Elige Map por código y conserva orden de inserción para listados. Busca un valor con Optional; filtra varios con List. Crea un total imperativo y otro con Stream, y comprueba que dan el mismo decimal exacto con datos pequeños.

No conviertas el precio a double para imprimirlo ni para sumar. Un resultado 6.60 debe conservar dos decimales de presentación en el reporte.

## Etapa 4. Archivo

Diseña un formato versionado. Delimitar por | sin escapar el nombre rompe un nombre que contiene |. El ejemplo usa Base64 para representar el texto UTF-8: eso resuelve delimitación, **no cifra ni protege secretos**.

Carga a una colección temporal, valida todas las líneas y solo después confirma. Un archivo existente corrupto no debe aparecer como inventario vacío. La política de la importación parcial de la unidad 12 sirve para otro requisito; aquí se rechaza el archivo entero.

## Etapa 5. Guardado y errores

Guarda un candidato antes de sustituir el estado en memoria. Simula un fallo mediante Almacen en un test y comprueba que el stock no cambió. Después prueba escritura y lectura reales en un directorio temporal.

No pruebes fallos de permisos únicamente con chmod: en Windows o con un usuario privilegiado puede producir otro comportamiento. Un mock expresa el fallo del colaborador de forma controlada; una integración verifica el formato real.

## Etapa 6. Interfaz de consola

Lee una línea por campo. Define qué sucede ante opción desconocida, fin de entrada a mitad de registro y formato numérico inválido. Un comando incompleto no registra un producto a medias.

Muestra Registrado y guardado únicamente después de persistir. Diferencia Dato rechazado de No se guardó: una validación y un fallo de I/O no son el mismo problema.

## Etapa 7. Extensión con criterio

Elige una extensión: actualizar nombre/precio, añadir existencias, exportar reporte o historial de movimientos. Añade contrato y pruebas antes de introducirla. No agregues hilos para responder a un menú que funciona secuencialmente.

## Evidencia

Entrega fuente, README con comandos, tabla de casos, pruebas y explicación de una decisión rechazada. La solución debe ejecutarse desde una carpeta con espacios sin editar rutas en el código.

[Soluciones](SOLUCIONES.md) · [Unidad](README.md) · [Proyecto final](../unidad30-proyecto-final/README.md)

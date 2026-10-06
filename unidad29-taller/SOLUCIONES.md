# Solución razonada del taller

La referencia completa se encuentra en [src/main/java/com/lelyliliana/inventario](../src/main/java/com/lelyliliana/inventario/). Se verifica desde la raíz mediante `mvn test` y se construye con `mvn package`.

## Etapa 1. Reglas

Producto valida código, nombre, precio y stock en su constructor compacto. Una instantánea inválida no se incorpora al catálogo. Precio se normaliza a escala 2 usando UNNECESSARY: 1.000 puede convertirse exactamente a 1.00; 1.001 se rechaza. No se aplica redondeo silencioso.

## Etapa 2. Modelo

retirar calcula un nuevo Producto con menor stock. La instancia original permanece intacta. Inventario sustituye el valor del Map después de que retirar haya validado, de modo que una excepción no deja una actualización parcial.

## Etapa 3. Consultas

LinkedHashMap evita búsqueda lineal por código para la operación habitual y mantiene el orden. buscar devuelve Optional<Producto>; listar devuelve una copia no modificable. filtrar usa Locale.ROOT, compara sin distinguir mayúsculas y conserva las tildes. Esa es una política explícita, no búsqueda lingüística universal.

## Etapa 4. Archivo

ArchivoInventario requiere cabecera INVENTARIO|1, cuatro campos por registro y código único. Nombre se decodifica desde Base64 a UTF-8 estricto; bytes no válidos se rechazan. BigDecimal e int se convierten y Producto vuelve a validar el dominio. Inventario temporal verifica duplicados antes de devolver el listado.

## Etapa 5. Guardado

ArchivoInventario escribe un temporal en el mismo directorio y solicita movimiento atómico. Si el sistema no lo soporta, usa reemplazo ordinario y elimina el temporal en finally. Esto reduce exposición a escrituras parciales; el fallback no tiene la misma garantía atómica ni ofrece durabilidad ante corte de energía.

ServicioInventario copia el estado, aplica el comando y solicita guardar. Confirma memoria después del éxito. Si Almacen falla, conserva el estado anterior. Esto no convierte dos procesos independientes en una transacción: el curso limita el ejemplo a una sesión y un archivo local controlado.

## Etapa 6. Consola

Main consume líneas y captura errores en el límite del comando. EOF a mitad de una operación genera un tipo interno específico, cancela el comando y termina. IOException de arranque se propaga para impedir operar sobre un archivo dañado. NumberFormatException se informa como dato rechazado.

## Etapa 7. Extensión: añadir existencias

Añade Producto.agregar(int cantidad). Valida cantidad positiva, suma con Math.addExact y respeta stock máximo1000000. Crea otra instancia. Añade el caso de uso a Inventario y a ServicioInventario siguiendo el patrón candidato → guardar → confirmar. El menú debe usar ese servicio y no editar el archivo directamente.

Pruebas mínimas: stock 0 +1 =1; stock 999999 +1 =1000000; stock 1000000 +1 rechazado; cantidad 0 rechazada; fallo al guardar conserva stock. No se necesita un framework nuevo para esta extensión.

[Práctica](PRACTICA.md) · [Unidad](README.md)

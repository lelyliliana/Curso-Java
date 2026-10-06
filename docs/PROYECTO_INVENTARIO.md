# Proyecto de referencia: inventario local

## Problema y alcance

Gestiona un catálogo ficticio en una sesión de consola: registrar, listar, buscar, retirar stock, filtrar y calcular valor de existencias. Carga al iniciar y guarda después de cada cambio válido. La aplicación usa JDK, sin servidor externo ni base de datos.

## Ejecutar paso a paso

Desde la raíz:

1. `mvn test` comprueba reglas, archivos, servicio y consola.
2. `mvn package` construye el JAR ejecutable.
3. `java -jar target/curso-java-1.1.0.jar` abre el menú.
4. Elige 1 y escribe A-1, Cuaderno, 12.50 y 3 en líneas diferentes.
5. Elige 5: valor de existencias 37.50.
6. Elige 4, código A-1 y cantidad 1: confirma retiro guardado.
7. Elige 0, vuelve a abrir y elige 2: stock 2.

No pegues preguntas o números del enunciado junto con los valores. La aplicación consume una línea por campo. Los espacios que rodean una entrada se recortan.

## Contratos exactos

| Dato/operación | Regla | Error/resultado |
|---|---|---|
| Código | 1..20 caracteres A..Z, 0..9 o guion; no se normaliza a mayúsculas | Código inválido o duplicado se rechaza |
| Nombre | Recortado, 1..80 unidades UTF-16, sin caracteres ISO de control ni secuencias Unicode inválidas | Se rechaza vacío o demasiado largo |
| Precio | BigDecimal >0, hasta 1000000000; convertible exactamente a escala 2 | No redondea decimales significativos extra |
| Stock | int, 0..1000000 | Se rechaza fuera del rango |
| Catálogo | Hasta1000 productos | No registra el producto 1001 |
| Retiro | Cantidad >0 y <=stock | Estado anterior intacto si se rechaza |
| Búsqueda única | Código exacto | Optional vacío si no existe |
| Filtro | Subcadena en nombre o código, ignorando mayúsculas con ROOT | Lista vacía; tildes se conservan |
| Listado | Orden de inserción, instantánea no modificable | No expone Map mutable |
| Reporte | Suma exacta precio × stock | 0.00 si no hay productos |
| Fin de entrada | Termina la sesión; comando incompleto se descarta | No guarda datos parciales |

## Arquitectura

| Componente | Responsabilidad | Independencia |
|---|---|---|
| Producto | Invariantes y retiro de una instantánea | No conoce consola ni archivos |
| Inventario | Índice, unicidad, consultas y totales | No realiza I/O |
| Almacen | Contrato cargar/guardar | Sustituible en pruebas |
| ArchivoInventario | Formato, validación completa y escritura | Usa NIO, UTF-8 y Base64 |
| ServicioInventario | Candidato y confirmación tras guardado | No formatea el menú |
| Main | Lectura y mensajes del comando | No escribe directamente el archivo |

Los métodos de consulta no devuelven el objeto Inventario mutable. Los records Producto solo contienen String, BigDecimal e int, por lo que sus componentes no permiten mutar el estado compartido.

## Formato del archivo

Primera línea: `INVENTARIO|1`. Cada registro: `codigo|nombreBase64|precio|stock`. El nombre se codifica desde sus bytes UTF-8; no es cifrado. Los demás campos tienen contratos que excluyen el delimitador.

Ejemplo con el nombre Ana codificado como QW5h:

```text
INVENTARIO|1
A-1|QW5h|12.50|3
```

No edites un archivo en uso. La carga acepta hasta 1000000 bytes y1000 registros, con validación completa antes de entregar datos. La comprobación de tamaño supone archivo local sin otro escritor simultáneo; no es un límite de recepción frente a archivos que cambian durante la lectura.

## Política de errores

Archivo ausente significa primer uso, y produce catálogo vacío. Un archivo existente con cabecera incorrecta, registro inválido, duplicado o texto UTF-8 inválido provoca IOException. La consola no inicia una sesión vacía ni sobrescribe datos corruptos.

Un cambio válido se aplica a un candidato, que se guarda antes de confirmar el estado de la sesión. Ante un IOException durante el guardado, la memoria anterior se conserva. El archivo se reemplaza usando temporal y movimiento atómico cuando es posible; el reemplazo ordinario de respaldo no garantiza atomicidad. No se promete rollback del sistema de archivos ante fallos físicos.

## Datos y ruta

Por defecto usa `datos-locales/inventario.txt`, excluido de Git. Una ruta opcional cambia el destino sin recompilar. [datos/inventario-ejemplo.txt](../datos/inventario-ejemplo.txt) contiene tres productos ficticios. Cópialo a una ruta local antes de trabajar si quieres preservar la referencia.

## Límites que afectan decisiones

El ejemplo no admite dos sesiones escribiendo el mismo archivo simultáneamente, no sincroniza procesos, no implementa autenticación, backups ni historial. Tampoco es un CSV general. El formato puede evolucionar con una migración explícita, pero versión desconocida se rechaza en lugar de adivinar.

[Proyecto final](../unidad30-proyecto-final/README.md) · [Índice](../README.md)

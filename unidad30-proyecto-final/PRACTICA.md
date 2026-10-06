# Proyecto final: construye y justifica

## Objetivo

Construye una aplicación Java que otra persona pueda comprender, probar y ejecutar. Puedes extender el inventario de referencia o usar otro dominio con reglas equivalentes, datos ficticios y persistencia local.

## Paso 1. Alcance

Describe usuario y cinco acciones. Define qué queda fuera y qué datos son ficticios. Si eliges inventario, incluye registro, búsqueda, retiro, listado y reporte. La interfaz puede ser consola; no se puntúa agregar una GUI por sí sola.

## Paso 2. Contratos

Consulta [PROYECTO_INVENTARIO.md](../docs/PROYECTO_INVENTARIO.md). Escribe tu tabla equivalente: formatos, límites, unicidad, mutabilidad, ausencia y fallos. No copies límites sin entender qué operación protegen.

## Paso 3. Modelo y pruebas

Implementa primero reglas sin I/O. Prueba una operación normal, una frontera y una rechazada que conserve el estado. Define igualdad y no expongas una colección interna que permita romper invariantes.

## Paso 4. Servicio

Separa confirmación de cambios de la lectura del menú. Una operación de archivo no debe ser un efecto oculto dentro de un getter. Introduce una interfaz solamente cuando haya un límite que convenga sustituir o probar.

## Paso 5. Persistencia

Define formato y versión. Distingue archivo ausente de corrupto. Valida todo antes de confirmar si tu política es estricta. Define cómo escribir sin truncar directamente el archivo anterior y explica límites reales de tu estrategia.

## Paso 6. Consultas y reporte

Implementa búsqueda, filtro y total. Si usas Stream, explica fuente, transformación y terminal, y compara el total con un bucle de referencia. No prometas mayor velocidad por usarlo.

## Paso 7. Consola

Lee líneas, valida, conserva mensajes comprensibles y cancela comandos incompletos. Ejecuta un flujo completo sin editar el código entre acciones. Un fallo recuperable debe informar qué operación no se confirmó.

## Paso 8. Pruebas de integración

Usa directorios temporales, guarda y carga realmente. Añade un fallo simulado del almacenamiento para probar la política del servicio sin depender de permisos del sistema operativo. No confundas ese mock con evidencia de escritura real.

## Paso 9. Extensión propia

Añade una función justificable: ingreso de stock, edición de datos, reporte exportado o historial. Define contrato y casos antes de implementarla. La referencia debe ayudarte a razonar, no sustituir tu decisión.

## Paso 10. Verificación y explicación

Desde una descarga limpia, ejecuta comandos del README. Usa [CHECKLIST.md](CHECKLIST.md) y [RUBRICA.md](RUBRICA.md). Presenta código, pruebas, datos ficticios, decisiones y limitaciones. Si no puedes explicar una dependencia, revisa por qué la añadiste.

[Soluciones](SOLUCIONES.md) · [Unidad](README.md)

# Verificación reproducible

## Paso 1. Requisitos

JDK 21 o25, Maven 3.9.16 y Python 3.10 o posterior. Las herramientas deben estar en PATH; consulta [ENTORNO.md](ENTORNO.md). La primera resolución de dependencias requiere Internet. No desactives comprobaciones de TLS para resolver un problema de red.

## Paso 2. Comprobación completa

Desde la raíz:

```text
python scripts/verificar.py
```

En sistemas donde Python se llama python3 o py -3, sustituye solo ese lanzador. El script utiliza rutas compuestas, carpetas temporales con espacios y comandos sin shell específico.

La verificación configura UTF-8 para la salida de Python y para los procesos Java que inicia, mediante file.encoding, stdout.encoding y stderr.encoding. La salida estándar de una JVM puede usar una codificación distinta de la de archivos, especialmente en Windows; indicar solamente `javac -encoding UTF-8` no la configura. Esta decisión permite comparar tildes y símbolos sin perder información. No modifica la configuración permanente de tu terminal.

## Qué se comprueba

| Área | Comprobación |
|---|---|
| Material | 31 unidades, prácticas/soluciones, navegación y referencias locales existentes |
| Laboratorios | 27 compilaciones aisladas y salidas esperadas, EOF y configuración inválida |
| Ejemplos conservados | Compilación por carpeta, ejecución de ejemplos y compilación cliente/servidor |
| Dominio | Contratos de Producto e Inventario, fronteras, unicidad y estado posterior |
| Archivo | Ida/vuelta UTF-8, corrupción, tamaño, duplicados y limpieza de temporales |
| Servicio | Cambio confirmado después de guardar, rechazo sin escritura y fallo de I/O |
| Consola | Registro, consulta, retiro, reporte, filtro, EOF y reinicio |
| Construcción | Cuatro proyectos Maven, informes con pruebas ejecutadas, JAR ejecutables |
| Sistemas | Matriz de Ubuntu, Windows y macOS, con JDK 21 y25 |

La propiedad java.class.version del laboratorio 01 cambia con la JVM activa: se verifica compatibilidad y el resto de la salida, sin fingir que identifica el bytecode del archivo. El mensaje INFO del laboratorio 27 contiene fecha/formato variables y no se compara como una cadena fija.

## Paso 3. Pruebas del proyecto final

```text
mvn test
```

ProductoTest e InventarioTest comprueban reglas puras. ArchivoInventarioTest usa archivos reales temporales. ServicioInventarioTest usa Mockito para provocar fallos de Almacen. ConsolaTest ejecuta comandos completos con entrada y salida controladas. El script comprueba también el JAR en procesos separados para verificar persistencia tras reiniciar.

## Paso 4. Leer resultados

Maven debe indicar Tests run mayor que cero, sin fallos, errores ni pruebas omitidas. Los XML de target/surefire-reports permiten ver qué suite se ejecutó. Si falla un laboratorio, el script muestra la carpeta y la salida obtenida. No borres un caso para convertir la verificación en verde.

[Resultados de integración continua](https://github.com/lelyliliana/Curso-Java/actions). La matriz ejecuta los mismos comandos del curso; no constituye una certificación de todas las instalaciones, permisos o sistemas de archivos posibles.

## Límites de la evidencia

La demostración deliberadamente incorrecta CondicionCarrera se ejecuta sin exigir que falle siempre; su resultado no determinista no se utiliza como prueba de corrección. El laboratorio 23 sí prueba un intercambio TCP real sobre loopback con puerto asignado por el sistema. Los ejemplos en dos terminales se compilan; pueden requerir liberar puerto 5000 para una ejecución manual.

El chequeo de enlaces prueba destinos locales, no la disponibilidad futura de sitios externos. Las pruebas del inventario no prometen durabilidad ante cortes, acceso simultáneo ni protección de un servicio público.

[Índice](../README.md)

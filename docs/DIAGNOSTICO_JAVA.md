# Diagnóstico por capas

## Paso 1. Reproduce y clasifica

Conserva entrada, comando, directorio de trabajo, versiones y mensaje. Primero pregunta si falló la herramienta, la compilación, la búsqueda de clase, la ejecución, la regla del dominio o el entorno externo.

| Síntoma | Comprobación útil | Corrección que corresponde |
|---|---|---|
| java/javac no reconocido | PATH y terminal nueva | Instalar o seleccionar JDK |
| release version 21 not supported | javac --version | Usar compilador 21 o posterior |
| UnsupportedClassVersionError | JVM ejecutora y release del archivo | JVM compatible o recompilar para versión soportada |
| Clase pública con nombre distinto | Nombre exacto de archivo/clase | Corregir ambos, respetando mayúsculas |
| Could not find main class | Directorio, package y classpath | Ejecutar nombre cualificado desde raíz del classpath |
| No main manifest attribute | Manifiesto del JAR | Configurar mainClass o ejecutar clase mediante classpath |
| package org.junit... does not exist | Comando y pom | Ejecutar pruebas con Maven, no javac aislado |
| Maven usa Java 17 | mvn --version y JAVA_HOME | Seleccionar JDK apropiado para Maven |
| Dependency resolution failure | URL, red y causa concreta | Corregir conectividad o coordenadas; no borrar toda la caché |
| Texto decimal inválido | Política de formato | Indicar punto decimal o usar un parser localizado explícito |
| Promedio truncado | Tipos de operandos antes de / | Ampliar antes de dividir |
| NaN aceptado | Validación de finitud | Double.isFinite antes de rangos |
| Archivo no encontrado | Ruta absoluta resuelta y directorio | Corregir ubicación o distinguir ausencia prevista |
| Puerto ocupado | Dirección/puerto y proceso local | Cerrar el servidor previo o usar otro puerto documentado |
| Lectura TCP espera | Terminador, flush y timeout | Completar protocolo y limitar espera |
| Conteo varía | Estado compartido y operaciones compuestas | AtomicInteger, monitor común o resultados independientes |
| Inventario dañado | Cabecera, línea y causa | Restaurar datos válidos; no guardar vacío sobre el archivo |

## Paso 2. Investiga la primera divergencia

Un stack trace se lee por tipo, mensaje, causas y primeras líneas relevantes de tu código. Un NumberFormatException en parseInt sugiere formato o rango de entrada; no se arregla cambiando la colección. Si un resultado ya era incorrecto antes de guardar, tampoco se arregla modificando rutas.

## Paso 3. Prueba una hipótesis

Usa un caso pequeño y cambia una sola variable. Un breakpoint después de una operación muestra estado; uno antes permite comprobar las entradas. Step over ejecuta la llamada sin recorrerla; step into entra; step out retorna al llamador. No imprimas todas las variables de entorno para encontrar una ruta.

## Paso 4. Conserva una regresión

Añade un caso que falle con el defecto y pase con la corrección, cuando compruebe un comportamiento relevante. Para la carrera no conviertas un resultado incorrecto ocasional en un test obligatorio: verifica la versión protegida y razona sobre el código defectuoso.

## Bitácora breve

| Entrada/comando | Esperado | Obtenido | Hipótesis | Evidencia | Corrección | Caso de regresión |
|---|---|---|---|---|---|---|
| Completa con tu experimento | | | | | | |

[Volver al índice](../README.md)

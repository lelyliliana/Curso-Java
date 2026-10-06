# Práctica: Mockito y límites del sistema

## Paso 1. Ejecuta

`mvn test` desde esta unidad. El mock de RepositorioUsuario devuelve Ana para código 1. El servicio transforma el resultado opcional en un nombre.

## Paso 2. Prueba ausencia

Configura Optional.empty para un código inexistente. La respuesta del servicio debe ser No encontrado. El servicio no necesita una base de datos para demostrar esa política.

## Paso 3. Prueba fallo

Configura IllegalStateException en el repositorio. La política de este ejemplo propaga el fallo: no lo transforma en No encontrado. Comprueba el tipo con assertThrows.

## Paso 4. Observa una interacción relevante

Si el contrato requiere consultar exactamente el código recibido, verify(repo).buscarNombre("2") comprueba esa llamada. No verifiques todos los detalles internos de una clase por costumbre.

## Paso 5. Compara con integración

Estudia ArchivoInventarioTest en el proyecto final: usa un directorio temporal y escribe archivos reales. Después estudia ServicioInventarioTest: sustituye Almacen para simular un fallo al guardar. Cada suite comprueba un riesgo distinto.

[Soluciones](SOLUCIONES.md) · [Unidad](README.md)

# Sustituir una dependencia conservando tres resultados distintos

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad26-mockito/ejemplos/ServicioUsuarioTest.java](../unidad26-mockito/ejemplos/ServicioUsuarioTest.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

ServicioUsuario recibe RepositorioUsuario y delega buscarNombre(id). La prueba configura el límite de acceso a datos, manteniendo real la política del servicio. Un nombre presente produce ese nombre; Optional.empty produce No encontrado.

El repositorio también puede fallar. En esta demostración IllegalStateException se propaga y no se transforma en ausencia. Esa distinción evita presentar una caída del almacenamiento como si el usuario simplemente no existiera.

verify(repo).buscarNombre("2") es relevante si quieres demostrar que se consulta el código recibido. Verificar cada detalle incidental acoplaría el test a una implementación sin añadir evidencia de contrato. Tampoco sustituirías el servicio mismo por un mock para afirmar que funciona su lógica.

Las pruebas con ArchivoInventario usan NIO real temporal y cubren otro límite. Un mock no demuestra que el formato de disco se lea correctamente, del mismo modo que escribir un archivo real no fuerza de forma sencilla todos los errores del servicio.

## 3. Construye y contrasta

Ejecuta los casos presente, ausente y fallo. Identifica qué objeto es real y cuál se sustituye. Compara con ServicioInventarioTest, que provoca IOException al guardar y comprueba estado posterior, y con las pruebas del archivo real.

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2026%20%E2%80%94%20Mockito%20y%20pruebas%20de%20unidades%20con%20dependencias%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad26-mockito%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

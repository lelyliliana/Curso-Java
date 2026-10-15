# Elegir estructura según duplicados y forma de acceso

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad16-colecciones/laboratorio/Laboratorio.java](../unidad16-colecciones/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

La lista mantiene repetidos y posición; el conjunto elimina duplicados; el mapa relaciona una clave con un valor; la deque permite atender una secuencia. No son variantes intercambiables solo por contener los mismos textos iniciales.

LinkedHashSet y LinkedHashMap conservan el orden de inserción utilizado en la salida. No atribuyas a cualquier HashMap esa misma política de presentación. La cola retira java y deja git,java porque el repetido sigue siendo un elemento de la secuencia.

Para un catálogo, código es identidad de búsqueda. put reemplaza un valor existente y por eso no expresa por sí solo la regla de rechazo de duplicados. La extensión comprueba la presencia antes de insertar y conserva el primer registro ante rechazo.

La comprobación y el put son suficientes en una sesión de un hilo. No constituyen una operación atómica entre escritores concurrentes. El inventario del curso conserva ese alcance local y valida también sus límites de tamaño y productos.

## 3. Construye y contrasta

Registra A con Cuaderno e intenta A con Libro. Tras el rechazo, buscar A debe devolver Cuaderno y el tamaño seguir en uno. Registra B y comprueba que listar conserva la política de orden elegida. No evalúes solo el mensaje de duplicado.

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2016%20%E2%80%94%20Colecciones%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad16-colecciones%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

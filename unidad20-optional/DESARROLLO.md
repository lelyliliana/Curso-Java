# Modelar ausencia sin ocultar fallos

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad20-optional/laboratorio/Laboratorio.java](../unidad20-optional/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

buscar devuelve Optional.ofNullable del valor del mapa. Si el código existe, map transforma el nombre. Si falta, orElseGet calcula Invitado. El retorno opcional representa una ausencia prevista, no cualquier problema que ocurra en el repositorio.

La referencia también muestra orElse(crearAlternativa()). Java evalúa ese argumento antes de llamar a orElse, incluso si Ana ya está presente. Por eso aparece Se calculó alternativa. El proveedor de orElseGet se evalúa solo cuando se necesita el valor alternativo.

Para el correo, puedes encadenar búsqueda de usuario, acceso al campo, strip y exclusión de vacío. Optional.map convierte un retorno null del mapeador en ausencia. No utilices get al final sin explicar qué ocurre si no existe el usuario o el campo.

Normalizar no valida por sí mismo que el texto sea una dirección de correo aceptable. Si eliges minúsculas para todo el valor, decláralo como política de este ejercicio y no como una garantía universal del comportamiento de todos los servicios de correo.

## 3. Construye y contrasta

Prueba usuario ausente, correo null, espacios y un valor con espacios exteriores. Cuenta cuándo se ejecuta la alternativa de orElse y de orElseGet. Un repositorio que lanza una excepción debe seguir mostrando un fallo y no convertirse silenciosamente en Optional.empty.

## Implementación de la parte añadida

Declaraciones dentro de Laboratorio; los correos null o vacíos representan ausencia:

```java
record Usuario(String correo) {}
static Optional<String> correo(Map<String,Usuario> usuarios, String codigo) {
    Objects.requireNonNull(usuarios);
    Objects.requireNonNull(codigo);
    return Optional.ofNullable(usuarios.get(codigo))
        .map(Usuario::correo).map(String::strip).filter(s -> !s.isEmpty());
}
```

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2020%20%E2%80%94%20Optional%20y%20dise%C3%B1o%20con%20ausencia%20de%20valores%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad20-optional%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

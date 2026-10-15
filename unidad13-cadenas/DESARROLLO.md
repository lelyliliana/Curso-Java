# Definir qué cuenta como palabra y qué cuenta como longitud

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad13-cadenas/laboratorio/Laboratorio.java](../unidad13-cadenas/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

Dos String construidos con new son objetos distintos, aunque equals compare su contenido como igual. Utilizar == para contar palabras relacionaría referencias en vez de la política textual que necesitas.

La frecuencia comienza con strip, normaliza mayúsculas mediante Locale.ROOT y separa por espacios con la expresión utilizada en la referencia. merge suma uno cuando la palabra ya existe; LinkedHashMap conserva orden de primera aparición. El resultado Sol/LUNA/sol es sol=2 y luna=1.

Para el texto vacío hay una frontera adicional: split sobre una cadena vacía puede producir un elemento vacío. Si no lo compruebas, podrías registrar una palabra inexistente. La extensión retorna mapa vacío antes de dividir. La noción de palabra aquí se limita a separación por espacios; puntuación y segmentación lingüística requieren otro contrato.

El ejemplo del símbolo suplementario muestra que length mide unidades UTF-16 y codePointCount mide puntos de código. Ninguna de esas cuentas equivale siempre a grafemas que una persona percibe como un solo carácter. Usa la medida que el dominio declara.

## 3. Construye y contrasta

Prueba vacío, espacios, Sol LUNA sol y una palabra con puntuación. Comprueba qué cambia por normalización y qué se conserva. Después contrasta igualdad de contenido con identidad y unidades de longitud sin convertir símbolos Unicode válidos en errores de codificación.

## Implementación de la parte añadida

Método estático dentro de Laboratorio (sus imports ya incluyen estas clases):

```java
static LinkedHashMap<String,Integer> contar(String texto) {
    var resultado = new LinkedHashMap<String,Integer>();
    String limpio = java.util.Objects.requireNonNull(texto).strip().toLowerCase(Locale.ROOT);
    if (!limpio.isEmpty())
        for (String palabra : limpio.split("\\s+")) resultado.merge(palabra, 1, Integer::sum);
    return resultado;
}
```

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2013%20%E2%80%94%20String%20y%20procesamiento%20de%20texto%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad13-cadenas%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

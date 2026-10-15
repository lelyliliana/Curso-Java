# Soluciones razonadas

## Solución del laboratorio

String es inmutable y sus índices cuentan unidades UTF-16, no necesariamente caracteres percibidos. Un punto de código tampoco equivale siempre a un grafema: algunos símbolos visibles combinan varios. Locale.ROOT evita depender del idioma del equipo para una normalización técnica. No elimina tildes ni hace equivalentes todas las representaciones Unicode.

La salida prevista es:

```text
Identidad: false
Contenido: true
{sol=2, luna=1}
Unidades UTF-16: 2
Puntos de código: 1
```

Predice == y equals. Cambia el locale del proceso y conserva ROOT. Prueba varias separaciones. Cuenta length de una letra, un emoji y una secuencia combinada. Define qué significa longitud para tu aplicación.

## Solución de la extensión

Aplica strip y comprueba isEmpty antes de split, porque split sobre cadena vacía puede producir un elemento vacío. Usa LinkedHashMap si necesitas orden de primera aparición y merge para contar.

## Casos de aceptación

" Sol sol ": {sol=2}; "  ": {}; "LUNA luna": {luna=2}; una tilde conserva su identidad.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

La función resuelta comprueba limpio.isEmpty antes de split, normaliza con ROOT y usa merge. Vacío o espacios producen un mapa vacío; Sol LUNA sol produce dos claves con frecuencias 2 y 1. No se eliminan tildes ni signos de puntuación. Esta política se documenta en vez de presentar la separación por espacios como un analizador universal de lenguaje.

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

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

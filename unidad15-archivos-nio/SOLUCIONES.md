# Soluciones razonadas

## Solución del laboratorio

Path describe una ruta; Files realiza operaciones que pueden fallar por permisos, ausencia, espacio o concurrencia. resolve compone rutas sin escribir separadores específicos del sistema. readAllLines carga todo el archivo en memoria y sirve para entradas pequeñas; Files.lines permite procesamiento progresivo y debe cerrarse con try-with-resources.

La salida prevista es:

```text
No vacías: 2
Texto UTF-8: Sol
```

Identifica creación, escritura, lectura y limpieza. Comprueba que el archivo temporal se elimina al terminar. Cambia los caracteres por tildes. Introduce una ruta inexistente en una lectura separada para reconocer IOException.

## Solución de la extensión

Comprueba args.length y usa Path.of(args[0]). Abre Files.lines(ruta, UTF_8) en try-with-resources, filtra !isBlank y count. Informa IOException conservando causa si relanzas. No captures excepción para devolver cero: cero líneas y fallo de lectura son resultados distintos.

## Casos de aceptación

Archivo vacío:0; dos líneas útiles:2; ruta inexistente:error; tildes preservadas; recurso cerrado incluso ante fallo.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

Exige exactamente una ruta en args; construye Path.of(args[0]). Dentro de try(var lineas=Files.lines(ruta,StandardCharsets.UTF_8)) devuelve lineas.filter(s -> !s.isBlank()).count(). No llames toList antes de count. El archivo vacío produce cero; el inexistente genera un error, no un conteo exitoso de cero.

## Implementación de la parte añadida

Método dentro de Laboratorio; main debe exigir un argumento y llamar contar(Path.of(args[0])):

```java
static long contar(Path ruta) throws IOException {
    try (var lineas = Files.lines(ruta, StandardCharsets.UTF_8)) {
        return lineas.filter(s -> !s.isBlank()).count();
    }
}
```

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

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

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

Archivo vacío:0; dos líneas útiles:2; ruta inexistente:error; tildes preservadas; recurso cerrado incluso ante fallo.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

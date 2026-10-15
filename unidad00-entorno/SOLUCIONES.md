# Soluciones razonadas

## Solución del laboratorio

El archivo contiene una clase pública y un método de entrada. El compilador no imprime el saludo: genera bytecode. El lanzador inicia una JVM que ejecuta main. Un archivo puede compilar y aun así fallar al ejecutarse por una excepción o una dependencia ausente.

La salida prevista es:

```text
Hola, Java
Argumentos: 0
```

Identifica clase, archivo, llaves y punto y coma. Compila sin ejecutar. Busca Laboratorio.class. Ejecuta usando el nombre de la clase. Añade un argumento y explica por qué cambia args.length.

## Solución de la extensión

Añade tres println dentro de main. Usa args.length para contar, sin intentar leer args[0] cuando la longitud sea cero. La salida debe conservar tres líneas de perfil independientemente de los argumentos.

## Casos de aceptación

Sin argumentos: 0. Con Ana Java: 2. Falta un punto y coma: error de compilación; no esperes que cambie un .class antiguo.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

Dentro de main añade tres println para nombre, interés y objetivo ficticios; conserva args.length. Las ejecuciones sin argumentos y con Ana Java producen conteos 0 y 2. Con "Ana Pérez" entre comillas el conteo es 1. No necesitas Scanner: el contrato de esta actividad lee argumentos, no entrada interactiva.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

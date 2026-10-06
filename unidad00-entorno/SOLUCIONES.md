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

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

Sin argumentos: 0. Con Ana Java: 2. Falta un punto y coma: error de compilación; no esperes que cambie un .class antiguo.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

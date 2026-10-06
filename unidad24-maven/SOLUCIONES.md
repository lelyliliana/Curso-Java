# Soluciones razonadas

## Solución del laboratorio

Maven organiza un ciclo de vida con fases. package ejecuta fases anteriores, incluida test; verify añade comprobaciones posteriores si están configuradas. Dependencias son bibliotecas del proyecto; plugins realizan tareas de construcción. Fijar maven.compiler.release no fija por sí solo la versión del JDK que ejecuta Maven.

La salida prevista es:

```text
Fuente -> compilación -> pruebas -> JAR
El proyecto mínimo se ejecuta con java -jar después de mvn package
```

Abre el pom del proyecto mínimo. Localiza coordenadas, propiedades y plugins. Ejecuta mvn test y después package en esa carpeta. Inspecciona target. Ejecuta el JAR con el nombre indicado en su README.

## Solución de la extensión

Ubica código en src/main/java y pruebas en src/test/java con paquete coherente. Configura release 21, compilador, Surefire y mainClass del plugin JAR. Declara JUnit con scope test. Verifica java -jar, no asumas que cualquier JAR incorpora un manifiesto ejecutable.

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

mvn test:pruebas ejecutadas; package:JAR creado; java -jar:saludo; dependencia test no se necesita en la aplicación final.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

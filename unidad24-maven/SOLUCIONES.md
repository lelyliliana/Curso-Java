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

## Casos de aceptación

mvn test:pruebas ejecutadas; package:JAR creado; java -jar:saludo; dependencia test no se necesita en la aplicación final.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

La solución incorpora Saludo.saludar en el proyecto mínimo con pruebas de normalización y rechazo. Main delega y el manifiesto continúa apuntando a su clase principal. mvn package ejecuta pruebas y construye java-unidad24-1.1.0.jar. El número de versión de ese proyecto de aprendizaje es independiente de la versión 1.2 del inventario de la raíz.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

# Entorno reproducible

## Paso 1. Elige e instala un JDK

La referencia del curso es **JDK 21**, sin características preview. Java 25 puede ejecutar y compilar estos ejemplos usando `--release 21`; las prácticas no requieren sintaxis posterior. No necesitas instalar ambos.

Usa una distribución OpenJDK, como [Eclipse Temurin](https://adoptium.net/temurin/releases/?version=21), y elige tu sistema y arquitectura. JDK incluye el compilador. Un runtime sin javac no basta.

### Ubuntu

En Ubuntu 24.04 puedes instalar el JDK desde los repositorios:

```text
sudo apt update
sudo apt install openjdk-21-jdk
```

Si hay varios JDK, selecciona por separado las herramientas que vas a usar con `sudo update-alternatives --config java` y `sudo update-alternatives --config javac`. Comprueba sus versiones después. No cambies alternativas si ya señalan al JDK requerido.

### Windows

1. Descarga el instalador de Temurin 21 para tu arquitectura.
2. Instálalo habilitando las opciones de PATH y JAVA_HOME si están disponibles.
3. Cierra y vuelve a abrir PowerShell.
4. Ejecuta los comandos de comprobación del paso 2.

No necesitas WSL ni herramientas Linux. Los comandos `java`, `javac` y `mvn` del curso se ejecutan en PowerShell.

### macOS

1. Elige el instalador de Temurin 21 para Apple Silicon (aarch64) o Intel (x64), según tu equipo.
2. Instálalo y abre otra terminal.
3. Comprueba el JDK del paso 2.

Si hay varios JDK, `/usr/libexec/java_home -v 21` permite localizar el instalado. Selecciona JAVA_HOME según tu shell y comprueba también `mvn --version`.

## Paso 2. Comprueba las herramientas

```text
java --version
javac --version
```

Ambos deben corresponder al JDK elegido. `java` no reconocido apunta a instalación o PATH; `javac` no reconocido puede indicar runtime incompleto. Reinicia la terminal antes de cambiar otras cosas.

El compilador 17 no admite `--release 21`. Una JVM antigua tampoco ejecuta bytecode de una versión superior. La portabilidad exige una JVM compatible.

## Paso 3. Descarga el curso

En GitHub usa **Code → Download ZIP** y descomprime, o ejecuta:

```text
git clone https://github.com/lelyliliana/Curso-Java.git
cd Curso-Java
```

La raíz es la carpeta que contiene README.md y pom.xml. No compiles todos los archivos Java con un comodín: hay clases de demostración del mismo nombre en carpetas independientes.

## Paso 4. Ejecuta un laboratorio

Desde la raíz:

```text
cd unidad00-entorno/laboratorio
javac -encoding UTF-8 --release 21 Laboratorio.java
java Laboratorio
```

La salida es `Hola, Java` y el conteo de argumentos. En cada unidad, compila y ejecuta dentro de su propia carpeta. Los archivos .class son resultados generados; no los subas al repositorio.

## Paso 5. Instala Maven

Para las unidades 24..26 y el proyecto final se utiliza [Apache Maven 3.9.16](https://maven.apache.org/download.cgi). Descarga la distribución binaria para tu sistema, descomprime y añade su carpeta `bin` a PATH. Maven requiere Java; no sustituye el JDK.

Comprueba:

```text
mvn --version
```

Debe mostrar la versión de Maven y el JDK elegido. Si muestra Java 17 cuando tu terminal muestra 21, revisa JAVA_HOME antes de editar el pom.

## Paso 6. Ejecuta pruebas y proyecto

Vuelve a la raíz del curso y ejecuta, en orden:

```text
mvn test
mvn package
java -jar target/curso-java-1.1.0.jar
```

La primera construcción requiere Internet para resolver bibliotecas. La aplicación final funciona localmente sin Internet. El JAR contiene las clases del inventario y un manifiesto ejecutable; las dependencias declaradas tienen scope test y no se necesitan para ejecutar la consola.

## Paso 7. Comprueba todo el curso

Con Python 3.10 o posterior disponible, desde la raíz:

```text
python scripts/verificar.py
```

En Ubuntu/macOS el ejecutable puede llamarse `python3`. En Windows puede ser `py -3`. Usa el que corresponda a tu instalación, sin instalar tres veces Python. El script necesita `java`, `javac` y `mvn` en PATH.

## Terminal, codificación y directorio

Usa una terminal que represente UTF-8 y una fuente con los símbolos necesarios. `javac -encoding UTF-8` configura la lectura del fuente; no configura por sí mismo el aspecto de la consola. Windows Terminal con PowerShell actual permite trabajar cómodamente; en consolas antiguas puede ser necesario ajustar su página de códigos.

Si rediriges una salida Java a otra herramienta que espera UTF-8, puedes ejecutar `java -Dstdout.encoding=UTF-8 -Dstderr.encoding=UTF-8 Laboratorio`. Las opciones van antes del nombre de la clase. El script de verificación fija esa codificación para sus procesos; un programa ejecutado a mano debe coincidir con lo que espera su terminal o su consumidor.

Las rutas relativas dependen del directorio de trabajo del proceso. El proyecto acepta una ruta opcional entre comillas:

```text
java -jar target/curso-java-1.1.0.jar "datos-locales/carpeta con espacios/inventario.txt"
```

No uses rutas personales en el código. VS Code o IntelliJ pueden abrir la raíz como proyecto Maven, pero verifica el JDK seleccionado en el IDE. Un botón Run no demuestra qué JVM ni qué directorio está usando.

[Volver al índice](../README.md)

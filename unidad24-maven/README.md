# Unidad 24: Maven y estructura de proyectos

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Convertir código suelto en un proyecto reproducible, comprender pom.xml, dependencias y ciclo de construcción.

## 1. El problema

Con archivos sueltos:
```text
Calculadora.java
junit.jar
otro.jar
```

cada persona puede terminar configurando manualmente classpath/versiones.

Maven describe el proyecto.

## 2. Convención

| Ruta relativa | Función |
|---|---|
| pom.xml | Construcción y dependencias |
| src/main/java | Código de la aplicación |
| src/main/resources | Recursos de la aplicación |
| src/test/java | Pruebas |
| target | Resultados generados |

Seguir convenciones reduce configuración.

## 3. Coordenadas

```xml
<groupId>com.ejemplo</groupId>
<artifactId>mi-app</artifactId>
<version>1.0.0-SNAPSHOT</version>
```

Identifican un artefacto.

## 4. Dependencias

```xml
<dependency>
  <groupId>org.junit.jupiter</groupId>
  <artifactId>junit-jupiter</artifactId>
  <version>6.1.3</version>
  <scope>test</scope>
</dependency>
```

Maven resuelve dependencias transitivas según metadatos, repositorios y reglas.

No copies JAR manualmente salvo que exista una razón especial.

## 5. Fases

Comandos:

```bash
mvn test
mvn package
```

Maven ejecuta fases del lifecycle y las anteriores necesarias.

`package` normalmente compila y ejecuta tests antes de empaquetar, salvo configuraciones/opciones que cambien comportamiento.

## 6. clean

```bash
mvn clean
```

elimina resultados de construcción (normalmente target).

No lo ejecutes como superstición ante cualquier error; entiende qué problema intentas resolver.

## 7. target

Contiene artefactos generados.

Normalmente no se versiona.

## 8. Java 21

Configura versión mediante propiedades/plugin apropiado.

Comprueba:
```bash
mvn --version
```

para saber qué Java utiliza Maven; puede diferir del terminal/IDE si la configuración no coincide.

## 9. Repositorio local

Maven descarga dependencias a caché/repositorio local.

Borrar todo el repositorio local no debería ser el primer diagnóstico de cualquier problema.

## 10. Wrapper

Un proyecto puede incluir Maven Wrapper (`mvnw`) para fijar/facilitar versión de Maven.

No es obligatorio para aprender el concepto, pero mejora reproducibilidad en proyectos reales.

## 11. Práctica guiada

Usa `ejemplos/proyecto-minimo`.

1. inspecciona pom;
2. `mvn test`;
3. `mvn package`;
4. revisa target;
5. provoca dependencia/version inválida;
6. lee error.

## 12. Errores frecuentes
- ejecutar Maven fuera de carpeta con pom.
- Java de Maven distinto.
- versionar target.
- dependencias sin scope apropiado.
- borrar caches sin diagnóstico.

## 13. Reto
Convierte un proyecto previo a Maven, añade JUnit y documenta un único comando para verificarlo.

## 14. Autoevaluación
1. ¿Qué es pom?
2. ¿group/artifact/version?
3. ¿Qué hace test?
4. ¿Qué hace package?
5. ¿Qué es target?
6. ¿Por qué mvn --version?

## 15. Checklist
- [ ] Estructuro Maven.
- [ ] Declaro dependencias.
- [ ] Ejecuto test/package.
- [ ] Compruebo Java usado.
- [ ] Mantengo reproducibilidad.

Continúa con JUnit.


## Laboratorio completo: observar, explicar y modificar

Maven organiza un ciclo de vida con fases. package ejecuta fases anteriores, incluida test; verify añade comprobaciones posteriores si están configuradas. Dependencias son bibliotecas del proyecto; plugins realizan tareas de construcción. Fijar maven.compiler.release no fija por sí solo la versión del JDK que ejecuta Maven.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad24-maven/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

### Paso 2. Compila

```text
javac -encoding UTF-8 --release 21 Laboratorio.java
```

`-encoding` define cómo se lee el código fuente y `--release` fija lenguaje, API y formato de clase compatibles con Java 21. Son decisiones diferentes. Si el comando falla, corrige el primer error relevante antes de ejecutar un bytecode antiguo.

### Paso 3. Ejecuta

```text
java Laboratorio
```

Compara la salida con el resultado previsto. Los valores se eligieron para hacer visible el comportamiento de esta unidad.

```text
Fuente -> compilación -> pruebas -> JAR
El proyecto mínimo se ejecuta con java -jar después de mvn package
```

### Paso 4. Recorre la lógica

Abre el pom del proyecto mínimo. Localiza coordenadas, propiedades y plugins. Ejecuta mvn test y después package en esa carpeta. Inspecciona target. Ejecuta el JAR con el nombre indicado en su README.

### Paso 5. Lee el código completo

```java
public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        System.out.println("Fuente -> compilación -> pruebas -> JAR");
        System.out.println("El proyecto mínimo se ejecuta con java -jar después de mvn package");
    }

    
}
```

### Paso 6. Comprueba y extiende

mvn test:pruebas ejecutadas; package:JAR creado; java -jar:saludo; dependencia test no se necesita en la aplicación final.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 23: Redes con sockets TCP](../unidad23-redes/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 25: Pruebas con JUnit](../unidad25-junit/README.md)


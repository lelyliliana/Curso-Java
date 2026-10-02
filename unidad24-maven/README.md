# Unidad 24 — Maven y estructura de proyectos

## Qué aprenderás
Convertir código suelto en un proyecto reproducible, comprender pom.xml, dependencias y ciclo de construcción.

# 1. El problema

Con archivos sueltos:
```text
Calculadora.java
junit.jar
otro.jar
```

cada persona puede terminar configurando manualmente classpath/versiones.

Maven describe el proyecto.

# 2. Convención

```text
proyecto/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/
    │   └── resources/
    └── test/
        └── java/
```

Seguir convenciones reduce configuración.

# 3. Coordenadas

```xml
<groupId>com.ejemplo</groupId>
<artifactId>mi-app</artifactId>
<version>1.0.0-SNAPSHOT</version>
```

Identifican un artefacto.

# 4. Dependencias

```xml
<dependency>
  <groupId>...</groupId>
  <artifactId>...</artifactId>
  <version>...</version>
  <scope>test</scope>
</dependency>
```

Maven resuelve dependencias transitivas según metadatos, repositorios y reglas.

No copies JAR manualmente salvo que exista una razón especial.

# 5. Fases

Comandos:

```bash
mvn test
mvn package
```

Maven ejecuta fases del lifecycle y las anteriores necesarias.

`package` normalmente compila y ejecuta tests antes de empaquetar, salvo configuraciones/opciones que cambien comportamiento.

# 6. clean

```bash
mvn clean
```

elimina resultados de construcción (normalmente target).

No lo ejecutes como superstición ante cualquier error; entiende qué problema intentas resolver.

# 7. target

Contiene artefactos generados.

Normalmente no se versiona.

# 8. Java 21

Configura versión mediante propiedades/plugin apropiado.

Comprueba:
```bash
mvn --version
```

para saber qué Java utiliza Maven; puede diferir del terminal/IDE si la configuración no coincide.

# 9. Repositorio local

Maven descarga dependencias a caché/repositorio local.

Borrar todo el repositorio local no debería ser el primer diagnóstico de cualquier problema.

# 10. Wrapper

Un proyecto puede incluir Maven Wrapper (`mvnw`) para fijar/facilitar versión de Maven.

No es obligatorio para aprender el concepto, pero mejora reproducibilidad en proyectos reales.

# 11. Práctica guiada

Usa `ejemplos/proyecto-minimo`.

1. inspecciona pom;
2. `mvn test`;
3. `mvn package`;
4. revisa target;
5. provoca dependencia/version inválida;
6. lee error.

# 12. Errores frecuentes
- ejecutar Maven fuera de carpeta con pom.
- Java de Maven distinto.
- versionar target.
- dependencias sin scope apropiado.
- borrar caches sin diagnóstico.

# 13. Reto
Convierte un proyecto previo a Maven, añade JUnit y documenta un único comando para verificarlo.

# 14. Autoevaluación
1. ¿Qué es pom?
2. ¿group/artifact/version?
3. ¿Qué hace test?
4. ¿Qué hace package?
5. ¿Qué es target?
6. ¿Por qué mvn --version?

# 15. Checklist
- [ ] Estructuro Maven.
- [ ] Declaro dependencias.
- [ ] Ejecuto test/package.
- [ ] Compruebo Java usado.
- [ ] Mantengo reproducibilidad.

Continúa con JUnit.

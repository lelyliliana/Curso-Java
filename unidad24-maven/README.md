# Unidad 24 — Maven y estructura de proyectos

## Convención
```text
src/main/java
src/main/resources
src/test/java
pom.xml
```

## Ciclo
```bash
mvn test
mvn package
```

## Dependencias
Decláralas en pom.xml en vez de copiar JAR manualmente.

## Coordenadas
groupId, artifactId, version.

## Reproducibilidad
Otra persona debe poder clonar y ejecutar las pruebas sin configurar rutas personales.

## Reto
Convierte un proyecto Java simple a Maven e incorpora JUnit.

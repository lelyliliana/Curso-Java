# Unidad 15 — Archivos y NIO

## Path y Files
```java
Path ruta = Path.of("datos", "entrada.txt");
String contenido = Files.readString(ruta);
```

## Escritura
```java
Files.writeString(Path.of("salida.txt"), "Hola");
```

## Rutas
Evita rutas absolutas personales en proyectos compartidos.

## Recursos
Para streams/lectores utiliza try-with-resources cuando corresponda.

## Codificación
Sé explícito cuando la codificación sea requisito del intercambio.

## Reto
Procesa un archivo de registros, separa líneas válidas/inválidas y genera un reporte.

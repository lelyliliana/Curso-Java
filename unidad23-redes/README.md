# Unidad 23 — Redes con sockets

## TCP
Cliente y servidor establecen una conexión.

Servidor conceptual:
```java
try (ServerSocket server = new ServerSocket(5000);
     Socket socket = server.accept()) {
    // leer/escribir
}
```

## Protocolo
Sockets transportan bytes; tu aplicación necesita definir mensajes, delimitación y errores.

## No expongas servicios educativos
Prueba inicialmente en localhost/red controlada. Un socket abierto no constituye por sí solo un servicio seguro para Internet.

## Reto
Construye cliente/servidor local con protocolo textual y manejo de desconexión.

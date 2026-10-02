# Unidad 23 — Redes con sockets TCP

## Qué aprenderás
Construir un cliente/servidor local, comprender que TCP es un flujo de bytes y diseñar un protocolo de aplicación mínimo.

# 1. Cliente y servidor

```text
cliente ── conexión TCP ── servidor
```

Servidor escucha un puerto; cliente se conecta a host+puerto.

# 2. ServerSocket

```java
try (ServerSocket server = new ServerSocket(5000);
     Socket socket = server.accept()) {
    ...
}
```

`accept()` bloquea esperando una conexión.

# 3. Cliente

```java
try (Socket socket = new Socket("localhost", 5000)) {
    ...
}
```

Empieza en localhost para la práctica.

# 4. TCP no conserva “mensajes”

TCP entrega un **flujo de bytes** confiable/ordenado, no tus mensajes lógicos.

Si envías:
```text
HOLA
MUNDO
```

tu protocolo debe definir dónde termina cada mensaje:
- líneas;
- longitud prefijada;
- formato estructurado;
- cierre;
etc.

# 5. Protocolo textual

Ejemplo:
```text
ECHO|hola
SALIR
```

Define:
- comandos;
- delimitador;
- codificación;
- respuestas;
- errores;
- tamaño máximo.

Consulta `PROTOCOLO.md`.

# 6. Reader/Writer

Para protocolo de líneas puedes envolver streams con lectores/escritores de texto y UTF-8 explícito.

Recuerda hacer flush cuando corresponda.

# 7. Desconexión

Lectura puede indicar fin de stream.

No asumas que el cliente siempre envía SALIR limpiamente.

Maneja desconexión/error.

# 8. Timeouts

Una lectura puede bloquear indefinidamente.

Sockets ofrecen timeouts; una aplicación real debe definir política.

# 9. Un cliente vs varios

Un servidor que hace:
```text
accept → atender completamente → accept
```
atiende secuencialmente.

Para múltiples clientes puedes delegar conexiones a tareas/executor, aplicando lo aprendido en concurrencia.

# 10. Seguridad

Un socket abierto no es un servicio seguro de Internet.

Esta práctica no implementa por sí sola:
- TLS;
- autenticación;
- autorización;
- límites robustos;
- protección contra abuso.

Trabaja en localhost/red controlada.

# 11. Práctica guiada

Ejecuta ServidorEco y ClienteEco:
1. servidor primero;
2. cliente;
3. envía mensaje;
4. desconecta abruptamente;
5. observa comportamiento.

# 12. Errores frecuentes
- asumir que una read = un mensaje.
- olvidar flush.
- puerto ocupado.
- servidor no iniciado.
- bloquear sin timeout/política.
- exponer práctica a Internet.

# 13. Reto
Cliente/servidor local con protocolo de líneas, mensajes inválidos y desconexión controlada.

# 14. Autoevaluación
1. ¿TCP conserva mensajes?
2. ¿Qué hace accept?
3. ¿Por qué protocolo?
4. ¿Qué ocurre si cliente desaparece?
5. ¿Socket = servicio seguro?
6. ¿Cómo atender varios clientes?

# 15. Checklist
- [ ] Conecto cliente/servidor.
- [ ] Defino framing/protocolo.
- [ ] Manejo desconexión.
- [ ] Mantengo práctica local.

Continúa con Maven.

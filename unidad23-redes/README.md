# Unidad 23: Redes con sockets TCP

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Construir un cliente/servidor local, comprender que TCP es un flujo de bytes y diseñar un protocolo de aplicación mínimo.

## 1. Cliente y servidor

El cliente establece una conexión TCP con el servidor.

Servidor escucha un puerto; cliente se conecta a host+puerto.

## 2. ServerSocket

```java
try (ServerSocket server = new ServerSocket()) {
    server.bind(new java.net.InetSocketAddress("127.0.0.1", 5000));
    server.setSoTimeout(30000);
    try (Socket socket = server.accept()) {
        System.out.println("Cliente local conectado");
    }
}
```

`accept()` bloquea esperando una conexión.

## 3. Cliente

```java
try (Socket socket = new Socket()) {
    socket.connect(new java.net.InetSocketAddress("127.0.0.1", 5000), 3000);
    socket.setSoTimeout(3000);
    System.out.println("Conectado");
}
```

Empieza en localhost para la práctica.

## 4. TCP no conserva “mensajes”

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

## 5. Protocolo textual

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

## 6. Reader/Writer

Para protocolo de líneas puedes envolver streams con lectores/escritores de texto y UTF-8 explícito.

Recuerda hacer flush cuando corresponda.

## 7. Desconexión

Lectura puede indicar fin de stream.

No asumas que el cliente siempre envía SALIR limpiamente.

Maneja desconexión/error.

## 8. Timeouts

Una lectura puede bloquear indefinidamente.

Sockets ofrecen timeouts; una aplicación real debe definir política.

## 9. Un cliente vs varios

Un servidor que hace:
```text
accept → atender completamente → accept
```
atiende secuencialmente.

Para múltiples clientes puedes delegar conexiones a tareas/executor, aplicando lo aprendido en concurrencia.

## 10. Seguridad

Un socket abierto no es un servicio seguro de Internet.

Esta práctica no implementa por sí sola:
- TLS;
- autenticación;
- autorización;
- límites robustos;
- protección contra abuso.

Trabaja en localhost/red controlada.

## 11. Práctica guiada

Ejecuta ServidorEco y ClienteEco:
1. servidor primero;
2. cliente;
3. envía mensaje;
4. desconecta abruptamente;
5. observa comportamiento.

## 12. Errores frecuentes
- asumir que una read = un mensaje.
- olvidar flush.
- puerto ocupado.
- servidor no iniciado.
- bloquear sin timeout/política.
- exponer práctica a Internet.

## 13. Reto
Cliente/servidor local con protocolo de líneas, mensajes inválidos y desconexión controlada.

## 14. Autoevaluación
1. ¿TCP conserva mensajes?
2. ¿Qué hace accept?
3. ¿Por qué protocolo?
4. ¿Qué ocurre si cliente desaparece?
5. ¿Socket = servicio seguro?
6. ¿Cómo atender varios clientes?

## 15. Checklist
- [ ] Conecto cliente/servidor.
- [ ] Defino framing/protocolo.
- [ ] Manejo desconexión.
- [ ] Mantengo práctica local.

Continúa con Maven.


## Laboratorio completo: observar, explicar y modificar

El servidor se enlaza explícitamente a 127.0.0.1 y puerto 0 permite que el sistema elija uno libre. UTF-8 fija codificación; newLine y flush terminan y entregan el mensaje. SO_TIMEOUT limita lecturas y accept, no el tiempo de escritura. readLine no limita longitud: este ejemplo usa un emisor propio, no un cliente no confiable.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad23-redes/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

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
ECO:hola
Recibido: hola
```

### Paso 4. Recorre la lógica

Sigue el recorrido envío, lectura, respuesta y cierre. Identifica por qué el hilo servidor debe poder ejecutarse mientras el cliente espera. Quita flush en una copia y observa el timeout. No publiques el puerto en Internet.

### Paso 5. Lee el código completo

```java
import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        try (var servidor = new ServerSocket()) {
            servidor.bind(new InetSocketAddress("127.0.0.1", 0));
            servidor.setSoTimeout(2000);
            try (var executor = Executors.newSingleThreadExecutor()) {
                var respuesta = executor.submit(() -> {
                    try (var cliente = servidor.accept()) {
                        cliente.setSoTimeout(2000);
                        var entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream(), StandardCharsets.UTF_8));
                        var salida = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream(), StandardCharsets.UTF_8));
                        String mensaje = entrada.readLine();
                        if (mensaje == null) throw new EOFException("Sin mensaje");
                        salida.write("ECO:" + mensaje); salida.newLine(); salida.flush();
                        return mensaje;
                    }
                });
                try (var cliente = new Socket()) {
                    cliente.connect(new InetSocketAddress("127.0.0.1", servidor.getLocalPort()), 2000);
                    cliente.setSoTimeout(2000);
                    var salida = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream(), StandardCharsets.UTF_8));
                    salida.write("hola"); salida.newLine(); salida.flush();
                    var entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream(), StandardCharsets.UTF_8));
                    System.out.println(entrada.readLine());
                }
                System.out.println("Recibido: " + respuesta.get(3, TimeUnit.SECONDS));
            }
        }
    }

    
}
```

### Paso 6. Comprueba y extiende

ECHO|hola:respuesta; comando otro:error; EOF antes del mensaje:error; falta terminador:timeout; Unicode conserva texto.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 22: Executors, Future y concurrencia de tareas](../unidad22-concurrencia/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 24: Maven y estructura de proyectos](../unidad24-maven/README.md)


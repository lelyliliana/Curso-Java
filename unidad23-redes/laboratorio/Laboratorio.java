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

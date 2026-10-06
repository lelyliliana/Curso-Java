import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
public class ServidorEco {
    public static void main(String[] args) throws IOException {
        try (var servidor = new ServerSocket()) {
            servidor.bind(new InetSocketAddress("127.0.0.1", 5000));
            servidor.setSoTimeout(30000);
            System.out.println("Servidor local en 127.0.0.1:5000 (espera hasta 30 s)");
            try (Socket cliente = servidor.accept()) {
                cliente.setSoTimeout(3000);
                var entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream(), StandardCharsets.UTF_8));
                var salida = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream(), StandardCharsets.UTF_8));
                String mensaje = entrada.readLine();
                if (mensaje == null) throw new EOFException("Cliente sin mensaje");
                salida.write("ECO:" + mensaje); salida.newLine(); salida.flush();
            }
        }
    }
}

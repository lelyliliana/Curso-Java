import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
public class ClienteEco {
    public static void main(String[] args) throws IOException {
        try (var socket = new Socket()) {
            socket.connect(new InetSocketAddress("127.0.0.1", 5000), 3000);
            socket.setSoTimeout(3000);
            var entrada = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            var salida = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
            salida.write("hola"); salida.newLine(); salida.flush();
            String respuesta = entrada.readLine();
            if (respuesta == null) throw new EOFException("Servidor sin respuesta");
            System.out.println(respuesta);
        }
    }
}

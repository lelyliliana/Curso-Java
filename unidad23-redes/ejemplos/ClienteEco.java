import java.io.*;
import java.net.*;

public class ClienteEco {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 5000);
             var entrada = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             var salida = new PrintWriter(socket.getOutputStream(), true)) {

            salida.println("hola");
            System.out.println(entrada.readLine());
        }
    }
}

import java.io.*;
import java.net.*;

public class ServidorEco {
    public static void main(String[] args) throws IOException {
        try (ServerSocket servidor = new ServerSocket(5000)) {
            System.out.println("Servidor local en puerto 5000");

            try (Socket cliente = servidor.accept();
                 var entrada = new BufferedReader(
                         new InputStreamReader(cliente.getInputStream()));
                 var salida = new PrintWriter(
                         cliente.getOutputStream(), true)) {

                String mensaje = entrada.readLine();
                salida.println("ECO:" + mensaje);
            }
        }
    }
}

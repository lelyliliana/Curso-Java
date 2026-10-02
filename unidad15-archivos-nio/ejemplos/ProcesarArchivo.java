import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ProcesarArchivo {
    public static void main(String[] args) throws IOException {
        Path entrada = Path.of("datos", "entrada.txt");

        if (!Files.exists(entrada)) {
            System.err.println("No existe: " + entrada.toAbsolutePath());
            return;
        }

        List<String> lineas = Files.readAllLines(entrada);
        long noVacias = lineas.stream().filter(s -> !s.isBlank()).count();

        System.out.println("Líneas no vacías: " + noVacias);
    }
}

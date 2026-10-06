import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        Path carpeta = Files.createTempDirectory("curso-java-");
        Path archivo = carpeta.resolve("lecturas.txt");
        try {
            Files.writeString(archivo, "Sol\n\nLuna\n", StandardCharsets.UTF_8);
            var lineas = Files.readAllLines(archivo, StandardCharsets.UTF_8);
            System.out.println("No vacías: " + lineas.stream().filter(s -> !s.isBlank()).count());
            System.out.println("Texto UTF-8: " + lineas.getFirst());
        } finally { Files.deleteIfExists(archivo); Files.deleteIfExists(carpeta); }
    }

    
}

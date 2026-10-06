import java.util.ArrayList;
import java.util.List;

public class Importador {
    static List<Integer> importar(List<String> lineas) {
        List<Integer> validos = new ArrayList<>();

        for (String linea : lineas) {
            try {
                validos.add(Integer.parseInt(linea.strip()));
            } catch (NumberFormatException e) {
                System.err.println("Línea ignorada: " + linea);
            }
        }
        return validos;
    }

    public static void main(String[] args) {
        System.out.println(importar(List.of("10", "abc", "25")));
    }
}


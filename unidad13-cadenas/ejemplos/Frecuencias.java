import java.util.HashMap;
import java.util.Map;

public class Frecuencias {
    public static void main(String[] args) {
        String texto = "sol luna sol mar luna sol";
        Map<String, Integer> frecuencias = new HashMap<>();

        for (String palabra : texto.toLowerCase().split("\\s+")) {
            frecuencias.merge(palabra, 1, Integer::sum);
        }

        System.out.println(frecuencias);
    }
}

import java.util.*;

public class Colecciones {
    public static void main(String[] args) {
        List<String> secuencia = List.of("java", "git", "java", "maven");

        Set<String> unicos = new HashSet<>(secuencia);

        Map<String, Integer> frecuencia = new HashMap<>();
        for (String item : secuencia) {
            frecuencia.merge(item, 1, Integer::sum);
        }

        Deque<String> cola = new ArrayDeque<>(secuencia);

        System.out.println(unicos);
        System.out.println(frecuencia);
        System.out.println(cola.removeFirst());
    }
}

import java.util.*;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        var lista = List.of("java", "git", "java");
        var unicos = new LinkedHashSet<>(lista);
        var frecuencias = new LinkedHashMap<String, Integer>();
        lista.forEach(s -> frecuencias.merge(s, 1, Integer::sum));
        var cola = new ArrayDeque<>(lista);
        System.out.println("Lista: " + lista);
        System.out.println("Únicos: " + unicos);
        System.out.println("Frecuencias: " + frecuencias);
        System.out.println("Atendido: " + cola.removeFirst());
        System.out.println("Restantes: " + cola);
    }

    
}

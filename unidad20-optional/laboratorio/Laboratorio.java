import java.util.*;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        var nombres = Map.of("A", "Ana");
        System.out.println(buscar(nombres, "A").map(String::toUpperCase).orElse("No encontrado"));
        System.out.println(buscar(nombres, "B").orElseGet(() -> "Invitado"));
        var presente = Optional.of("Ana");
        System.out.println(presente.orElse(crearAlternativa()));
    }

    static Optional<String> buscar(Map<String, String> nombres, String codigo) {
        return Optional.ofNullable(nombres.get(codigo));
    }
    static String crearAlternativa() { System.out.println("Se calculó alternativa"); return "Invitado"; }
}

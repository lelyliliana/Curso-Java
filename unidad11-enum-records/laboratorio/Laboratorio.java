import java.util.ArrayList;
import java.util.List;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        var origen = new ArrayList<>(List.of("Java"));
        var grupo = new Grupo("A", origen, Estado.ACTIVO);
        origen.add("SQL");
        System.out.println(grupo);
        System.out.println("Copia protegida: " + grupo.temas().size());
        System.out.println("Igualdad: " + grupo.equals(new Grupo("A", List.of("Java"), Estado.ACTIVO)));
    }

    enum Estado { ACTIVO, CERRADO }
    record Grupo(String nombre, List<String> temas, Estado estado) {
        Grupo {
            if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre requerido");
            temas = List.copyOf(temas);
            java.util.Objects.requireNonNull(estado);
        }
    }
}

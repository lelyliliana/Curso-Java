import java.util.List;
import java.util.Optional;

record Usuario(String id, String nombre) {}

public class RepositorioUsuarios {
    static Optional<Usuario> buscar(List<Usuario> usuarios, String id) {
        return usuarios.stream()
                .filter(u -> u.id().equals(id))
                .findFirst();
    }

    public static void main(String[] args) {
        var usuarios = List.of(new Usuario("1", "Ana"));

        String nombre = buscar(usuarios, "2")
                .map(Usuario::nombre)
                .orElse("No encontrado");

        System.out.println(nombre);
    }
}


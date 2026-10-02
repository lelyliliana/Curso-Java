import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Optional;
import org.junit.jupiter.api.Test;

interface RepositorioUsuario {
    Optional<String> buscarNombre(String id);
}

final class ServicioUsuario {
    private final RepositorioUsuario repositorio;

    ServicioUsuario(RepositorioUsuario repositorio) {
        this.repositorio = repositorio;
    }

    String obtenerNombre(String id) {
        return repositorio.buscarNombre(id).orElse("No encontrado");
    }
}

class ServicioUsuarioTest {
    @Test
    void retornaNombreDelRepositorio() {
        var repo = mock(RepositorioUsuario.class);
        when(repo.buscarNombre("1")).thenReturn(Optional.of("Ana"));

        var servicio = new ServicioUsuario(repo);

        assertEquals("Ana", servicio.obtenerNombre("1"));
    }
}

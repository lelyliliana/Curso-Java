import java.util.List;
import java.util.function.Predicate;

public class Filtros {
    static List<Integer> filtrar(List<Integer> datos, Predicate<Integer> criterio) {
        return datos.stream().filter(criterio).toList();
    }

    public static void main(String[] args) {
        var datos = List.of(1, 2, 3, 4, 5, 6);

        System.out.println(filtrar(datos, n -> n % 2 == 0));
        System.out.println(filtrar(datos, n -> n > 3));
    }
}


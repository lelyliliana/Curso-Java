import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Venta(String categoria, double valor) {}

public class Ventas {
    public static void main(String[] args) {
        var ventas = List.of(
                new Venta("Libros", 50),
                new Venta("Tecnología", 200),
                new Venta("Libros", 30)
        );

        Map<String, Double> totales = ventas.stream()
                .collect(Collectors.groupingBy(
                        Venta::categoria,
                        Collectors.summingDouble(Venta::valor)
                ));

        System.out.println(totales);
    }
}


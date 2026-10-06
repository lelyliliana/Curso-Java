import java.util.*;
import java.util.stream.Collectors;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        var ventas = List.of(new Venta("Libros", 5000), new Venta("Tecnología", 20000), new Venta("Libros", 3000));
        var totales = ventas.stream().collect(Collectors.groupingBy(Venta::categoria,
                TreeMap::new, Collectors.summingLong(Venta::centavos)));
        System.out.println(totales);
        long suma = ventas.stream().mapToLong(Venta::centavos).sum();
        long imperativa = 0;
        for (Venta venta : ventas) imperativa += venta.centavos();
        System.out.println("Totales iguales: " + (suma == imperativa));
        System.out.println("Sin ventas: " + List.<Venta>of().stream().mapToLong(Venta::centavos).sum());
    }

    record Venta(String categoria, long centavos) {}
}

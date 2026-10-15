import java.util.Objects;
import java.util.Optional;
public final class Solucion {
    record Extremos(int minimo, int maximo) {}
    static Optional<Extremos> extremos(int[] datos) {
        Objects.requireNonNull(datos);
        if (datos.length == 0) return Optional.empty();
        int minimo = datos[0], maximo = datos[0];
        for (int dato : datos) { minimo = Math.min(minimo,dato); maximo = Math.max(maximo,dato); }
        return Optional.of(new Extremos(minimo,maximo));
    }
    public static void main(String[] args) {
        for (int[] datos : new int[][]{{28,31,35,29},{-8,-2,-5},{7},{}})
            System.out.println(extremos(datos).map(e -> e.minimo()+" / "+e.maximo()).orElse("Sin observaciones"));
    }
}

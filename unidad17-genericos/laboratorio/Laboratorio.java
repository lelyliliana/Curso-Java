import java.util.*;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        List<Integer> origen = List.of(1, 2, 3);
        List<Number> destino = new ArrayList<>();
        copiar(origen, destino);
        System.out.println(destino);
        System.out.println("Suma: " + sumar(origen));
    }

    static <T> void copiar(List<? extends T> origen, List<? super T> destino) {
        for (T elemento : origen) destino.add(elemento);
    }
    static double sumar(List<? extends Number> datos) {
        double total = 0;
        for (Number dato : datos) total += dato.doubleValue();
        return total;
    }
}

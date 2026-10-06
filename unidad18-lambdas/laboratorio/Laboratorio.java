import java.util.*;
import java.util.function.*;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        var datos = List.of(1, 2, 3, 4, 5, 6);
        Predicate<Integer> par = n -> n % 2 == 0;
        Predicate<Integer> grande = n -> n > 3;
        System.out.println(filtrar(datos, par.and(grande)));
        Function<Integer, String> etiqueta = n -> "N=" + n;
        System.out.println(etiqueta.apply(4));
    }

    static List<Integer> filtrar(List<Integer> datos, Predicate<Integer> criterio) {
        var salida = new ArrayList<Integer>();
        for (int dato : datos) if (criterio.test(dato)) salida.add(dato);
        return List.copyOf(salida);
    }
}

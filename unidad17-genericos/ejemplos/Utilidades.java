import java.util.List;

public class Utilidades {
    static double sumarNumeros(List<? extends Number> datos) {
        double total = 0;
        for (Number dato : datos) {
            total += dato.doubleValue();
        }
        return total;
    }

    static void agregarEnteros(List<? super Integer> destino) {
        destino.add(10);
        destino.add(20);
    }
    public static void main(String[] args) {
        System.out.println(sumarNumeros(List.of(1, 2, 3)));
        var destino = new java.util.ArrayList<Number>();
        agregarEnteros(destino);
        System.out.println(destino);
    }
}

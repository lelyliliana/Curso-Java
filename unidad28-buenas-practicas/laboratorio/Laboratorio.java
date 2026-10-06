import java.util.List;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        var precios = List.of(100L, 200L, 300L);
        System.out.println("Total original: " + totalOriginal(precios));
        System.out.println("Total refactorizado: " + total(precios));
    }

    static long totalOriginal(List<Long> precios) {
        long resultado = 0;
        for (long precio : precios) {
            if (precio < 0) throw new IllegalArgumentException("Precio negativo");
            resultado = Math.addExact(resultado, precio);
        }
        return resultado;
    }
    static long total(List<Long> precios) {
        long resultado = 0;
        for (long precio : precios) resultado = Math.addExact(resultado, validar(precio));
        return resultado;
    }
    static long validar(long precio) {
        if (precio < 0) throw new IllegalArgumentException("Precio negativo");
        return precio;
    }
}

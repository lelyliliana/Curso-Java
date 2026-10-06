import java.util.Arrays;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        int numero = 10;
        int[] valores = {10, 20};
        cambiar(numero, valores);
        System.out.println("Número: " + numero);
        System.out.println("Arreglo: " + Arrays.toString(valores));
        System.out.println("Promedio: " + promedio(7, 2));
    }

    static void cambiar(int numero, int[] valores) {
        numero = 99;
        valores[0] = 99;
        valores = new int[]{1};
    }
    static double promedio(int suma, int cantidad) {
        if (cantidad <= 0) throw new IllegalArgumentException("Cantidad positiva requerida");
        return (double) suma / cantidad;
    }
}

import java.util.Arrays;
import java.util.Objects;
public final class Solucion {
    static int[] duplicar(int[] datos) {
        Objects.requireNonNull(datos);
        int[] copia = new int[datos.length];
        for (int i=0;i<datos.length;i++) copia[i] = Math.multiplyExact(datos[i],2);
        return copia;
    }
    public static void main(String[] args) {
        int[] original = {3,-2,0};
        int[] copia = duplicar(original); copia[0]=100;
        System.out.println("Original: "+Arrays.toString(original));
        System.out.println("Copia modificada: "+Arrays.toString(copia));
        System.out.println("Vacío: "+duplicar(new int[0]).length);
        try { duplicar(new int[]{Integer.MAX_VALUE}); }
        catch (ArithmeticException e) { System.out.println("Desbordamiento rechazado"); }
    }
}

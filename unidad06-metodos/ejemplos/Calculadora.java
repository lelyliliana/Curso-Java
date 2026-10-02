public class Calculadora {
    static double sumar(double a, double b) {
        return a + b;
    }

    static double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir entre cero");
        }
        return a / b;
    }

    public static void main(String[] args) {
        System.out.println(sumar(4, 6));
        System.out.println(dividir(10, 2));
    }
}

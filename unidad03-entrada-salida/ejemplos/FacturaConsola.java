import java.util.Scanner;

public class FacturaConsola {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Producto: ");
            String producto = scanner.nextLine();

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();

            System.out.print("Precio: ");
            double precio = scanner.nextDouble();

            double total = cantidad * precio;

            System.out.printf("%s x %d = %.2f%n", producto, cantidad, total);
        }
    }
}

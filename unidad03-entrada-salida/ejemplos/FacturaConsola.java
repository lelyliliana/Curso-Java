import java.util.Scanner;

public class FacturaConsola {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in).useLocale(java.util.Locale.ROOT)) {
            System.out.print("Producto: ");
            String producto = scanner.nextLine();

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();

            System.out.print("Precio: ");
            double precio = scanner.nextDouble();

            if (producto.isBlank() || cantidad <= 0 || !Double.isFinite(precio) || precio <= 0
                    || !Double.isFinite(cantidad * precio)) {
                throw new IllegalArgumentException("Datos de factura inválidos");
            }
            double total = cantidad * precio;

            System.out.printf("%s x %d = %.2f%n", producto, cantidad, total);
        }
    }
}


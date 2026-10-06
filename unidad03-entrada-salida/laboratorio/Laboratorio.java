import java.util.Scanner;
import java.math.BigDecimal;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        try (var entrada = new Scanner(System.in)) {
            System.out.println("Nombre:");
            if (!entrada.hasNextLine()) { System.out.println("Entrada terminada"); return; }
            String nombre = entrada.nextLine().strip();
            System.out.println("Cantidad (entero positivo):");
            if (!entrada.hasNextLine()) { System.out.println("Entrada terminada"); return; }
            String cantidadTexto = entrada.nextLine().strip();
            System.out.println("Precio (punto decimal):");
            if (!entrada.hasNextLine()) { System.out.println("Entrada terminada"); return; }
            String precioTexto = entrada.nextLine().strip();
            try {
                int cantidad = Integer.parseInt(cantidadTexto);
                BigDecimal precio = new BigDecimal(precioTexto);
                if (nombre.isEmpty() || cantidad <= 0 || precio.signum() <= 0) {
                    System.out.println("Datos fuera del dominio"); return;
                }
                System.out.println(nombre + ": " + precio.multiply(BigDecimal.valueOf(cantidad)).toPlainString());
            } catch (NumberFormatException e) { System.out.println("Formato numérico inválido"); }
        }
    }

    
}

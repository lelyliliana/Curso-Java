public class Producto {
    private final String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        if (nombre == null || nombre.isBlank() || !Double.isFinite(precio) || precio <= 0) {
            throw new IllegalArgumentException("Nombre y precio finito positivo requeridos");
        }
        this.nombre = nombre.strip();
        this.precio = precio;
    }

    public double calcularSubtotal(int cantidad) {
        if (cantidad <= 0 || !Double.isFinite(precio * cantidad)) {
            throw new IllegalArgumentException("Cantidad o subtotal inválido");
        }
        return precio * cantidad;
    }

    public String getNombre() {
        return nombre;
    }
    public static void main(String[] args) {
        System.out.println(new Producto("Cuaderno", 12.50).calcularSubtotal(2));
    }
}

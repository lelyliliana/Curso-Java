public class Producto {
    private final String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double calcularSubtotal(int cantidad) {
        return precio * cantidad;
    }

    public String getNombre() {
        return nombre;
    }
}

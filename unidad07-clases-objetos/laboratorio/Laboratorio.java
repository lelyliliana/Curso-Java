public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        Producto a = new Producto("Cuaderno", 1250);
        Producto b = new Producto("Cuaderno", 1250);
        Producto alias = a;
        System.out.println("Mismo objeto: " + (a == alias));
        System.out.println("Instancias diferentes: " + (a == b));
        System.out.println("Subtotal: " + a.subtotal(3));
    }

    static final class Producto {
        private final String nombre;
        private final long precioCentavos;
        Producto(String nombre, long precioCentavos) {
            if (nombre == null || nombre.isBlank() || precioCentavos <= 0) throw new IllegalArgumentException("Producto inválido");
            this.nombre = nombre;
            this.precioCentavos = precioCentavos;
        }
        long subtotal(int cantidad) {
            if (cantidad <= 0) throw new IllegalArgumentException("Cantidad positiva requerida");
            return Math.multiplyExact(precioCentavos, cantidad);
        }
    }
}

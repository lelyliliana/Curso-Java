public final class Solucion {
    static String clasificar(double temperatura) {
        if (!Double.isFinite(temperatura)) throw new IllegalArgumentException("Temperatura finita requerida");
        if (temperatura < 18) return "Frío";
        if (temperatura <= 30) return "Templado";
        return "Caliente";
    }
    public static void main(String[] args) {
        for (double t : new double[]{17.99,18,30,30.01,Double.NaN,Double.POSITIVE_INFINITY}) {
            try { System.out.println(t + " -> " + clasificar(t)); }
            catch (IllegalArgumentException e) { System.out.println(t + " -> " + e.getMessage()); }
        }
    }
}

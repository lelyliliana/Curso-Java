public final class Solucion {
    record Tiempo(int horas, int minutos, int segundos) {}
    static Tiempo convertir(int total) {
        if (total < 0) throw new IllegalArgumentException("Segundos no negativos");
        return new Tiempo(total / 3600, total % 3600 / 60, total % 60);
    }
    public static void main(String[] args) {
        for (int total : new int[]{0, 59, 60, 3599, 3600, 7385}) {
            var t = convertir(total);
            System.out.printf("%d -> %d:%02d:%02d%n", total, t.horas(), t.minutos(), t.segundos());
        }
        try { convertir(-1); } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
    }
}

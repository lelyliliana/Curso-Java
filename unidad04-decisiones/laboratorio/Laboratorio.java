public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        for (double nota : new double[]{2.99, 3, 4.5, 5, Double.NaN, Double.POSITIVE_INFINITY}) {
            System.out.println(nota + " -> " + clasificar(nota));
        }
        int opcion = 2;
        System.out.println(switch (opcion) { case 1 -> "Crear"; case 2 -> "Consultar"; case 0 -> "Salir"; default -> "Inválida"; });
    }

    static String clasificar(double nota) {
        if (!Double.isFinite(nota) || nota < 0 || nota > 5) return "Inválida";
        if (nota >= 4.5) return "Excelente";
        if (nota >= 3) return "Aprobada";
        return "No aprobada";
    }
}

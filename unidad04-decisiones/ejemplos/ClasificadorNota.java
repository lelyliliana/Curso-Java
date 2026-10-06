public class ClasificadorNota {
    static String clasificar(double nota) {
        if (!Double.isFinite(nota) || nota < 0 || nota > 5) {
            return "Inválida";
        }
        if (nota >= 4.5) {
            return "Excelente";
        }
        if (nota >= 3.0) {
            return "Aprobada";
        }
        return "No aprobada";
    }

    public static void main(String[] args) {
        System.out.println(clasificar(4.5));
        System.out.println(clasificar(3.0));
        System.out.println(clasificar(2.9));
    }
}


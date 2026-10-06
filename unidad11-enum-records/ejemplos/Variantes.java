public class Variantes {
    sealed interface Resultado permits Exito, Fallo {}
    record Exito(String mensaje) implements Resultado {}
    record Fallo(int codigo) implements Resultado {}

    static String describir(Resultado resultado) {
        return switch (resultado) {
            case Exito(String mensaje) -> "Éxito: " + mensaje;
            case Fallo(int codigo) -> "Fallo: " + codigo;
        };
    }

    public static void main(String[] args) {
        System.out.println(describir(new Exito("Listo")));
        System.out.println(describir(new Fallo(404)));
    }
}

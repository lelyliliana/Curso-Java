public class ConversionTiempo {
    public static void main(String[] args) {
        int totalSegundos = 7_385;
        int horas = totalSegundos / 3600;
        int resto = totalSegundos % 3600;
        int minutos = resto / 60;
        int segundos = resto % 60;

        System.out.printf("%d:%02d:%02d%n", horas, minutos, segundos);
    }
}


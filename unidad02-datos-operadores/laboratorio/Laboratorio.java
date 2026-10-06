public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        int segundos = 7385;
        System.out.printf("%d:%02d:%02d%n", segundos / 3600, segundos % 3600 / 60, segundos % 60);
        System.out.println("División: " + (5 / 2) + " / " + (5.0 / 2));
        System.out.println("Desbordamiento: " + (Integer.MAX_VALUE + 1));
        System.out.println("Ampliado antes: " + ((long) Integer.MAX_VALUE + 1));
    }

    
}

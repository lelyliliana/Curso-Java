public class CondicionCarrera {
    private static int contador = 0;

    static void incrementar() {
        contador++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) incrementar();
        });
        Thread b = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) incrementar();
        });

        a.start();
        b.start();
        a.join();
        b.join();

        System.out.println("Esperado: 200000");
        System.out.println("Obtenido: " + contador);
    }
}


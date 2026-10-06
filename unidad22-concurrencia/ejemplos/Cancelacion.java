import java.util.concurrent.*;

public class Cancelacion {
    public static void main(String[] args) throws Exception {
        var iniciado = new CountDownLatch(1);
        var bloqueo = new CountDownLatch(1);
        var terminado = new CountDownLatch(1);
        try (var executor = Executors.newSingleThreadExecutor()) {
            Future<Integer> futuro = executor.submit(() -> {
                iniciado.countDown();
                try {
                    bloqueo.await();
                    return 42;
                } finally {
                    terminado.countDown();
                }
            });
            if (!iniciado.await(2, TimeUnit.SECONDS)) throw new IllegalStateException("Tarea no inició");
            try {
                futuro.get(50, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                System.out.println("Tiempo de espera agotado");
                System.out.println("Cancelación solicitada: " + futuro.cancel(true));
            }
            if (!terminado.await(2, TimeUnit.SECONDS)) throw new IllegalStateException("Tarea no terminó");
            try {
                futuro.get();
            } catch (CancellationException e) {
                System.out.println("Resultado cancelado");
            }
        }
    }
}

import java.util.concurrent.*;
public final class Solucion {
    public static void main(String[] args) throws Exception {
        var iniciada=new CountDownLatch(1); var liberar=new CountDownLatch(1); var terminada=new CountDownLatch(1);
        try (var executor=Executors.newSingleThreadExecutor()) {
            Future<String> futuro=executor.submit(() -> {
                iniciada.countDown();
                try { liberar.await(); return "Terminó espera"; }
                finally { terminada.countDown(); }
            });
            try {
                if (!iniciada.await(2,TimeUnit.SECONDS)) throw new IllegalStateException("No inició la tarea");
                try { futuro.get(20,TimeUnit.MILLISECONDS); }
                catch (TimeoutException e) { System.out.println("Tiempo agotado; la tarea sigue pendiente"); }
                System.out.println("Cancelación aceptada: "+futuro.cancel(true));
                try { futuro.get(); }
                catch (CancellationException e) { System.out.println("Resultado cancelado"); }
                System.out.println("Tarea terminó: "+terminada.await(2,TimeUnit.SECONDS));
            } finally { futuro.cancel(true); liberar.countDown(); }
        }
    }
}

import java.util.concurrent.*;

public class ComposicionAsync {
    public static void main(String[] args) {
        try (var executor = Executors.newFixedThreadPool(2)) {
            var resultado = CompletableFuture.supplyAsync(() -> 21, executor)
                    .thenApply(n -> n * 2)
                    .thenCompose(n -> CompletableFuture.supplyAsync(() -> "Resultado: " + n, executor));
            System.out.println(resultado.join());
            var fallo = CompletableFuture.<Integer>failedFuture(new IllegalStateException("Fallo simulado"));
            System.out.println("Alternativa: " + fallo.exceptionally(error -> -1).join());
            try {
                fallo.join();
            } catch (CompletionException e) {
                System.out.println("Causa: " + e.getCause().getMessage());
            }
        }
    }
}

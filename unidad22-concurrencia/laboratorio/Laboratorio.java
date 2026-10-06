import java.util.*;
import java.util.concurrent.*;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        try (var executor = Executors.newFixedThreadPool(3)) {
            var tareas = List.<Callable<Integer>>of(() -> 1, () -> 4, () -> 9);
            for (var futuro : executor.invokeAll(tareas)) System.out.println("Cuadrado: " + futuro.get());
            var fallido = executor.submit(() -> { throw new IllegalStateException("Fallo simulado"); });
            try { fallido.get(); }
            catch (ExecutionException e) { System.out.println("Causa: " + e.getCause().getMessage()); }
        }
        try (var virtuales = Executors.newVirtualThreadPerTaskExecutor()) {
            System.out.println("Virtual: " + virtuales.submit(() -> Thread.currentThread().isVirtual()).get());
        }
    }

    
}

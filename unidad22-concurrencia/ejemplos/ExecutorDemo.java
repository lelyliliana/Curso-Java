import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorDemo {
    public static void main(String[] args) throws Exception {
        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {
            List<Callable<Integer>> tareas = new ArrayList<>();

            for (int i = 1; i <= 5; i++) {
                int valor = i;
                tareas.add(() -> valor * valor);
            }

            for (Future<Integer> resultado : executor.invokeAll(tareas)) {
                System.out.println(resultado.get());
            }
        }
    }
}


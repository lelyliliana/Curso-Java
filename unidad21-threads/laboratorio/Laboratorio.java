import java.util.concurrent.atomic.AtomicInteger;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        var contador = new AtomicInteger();
        Thread a = new Thread(() -> repetir(contador));
        Thread b = new Thread(() -> repetir(contador));
        a.start(); b.start();
        a.join(); b.join();
        System.out.println("Esperado y obtenido: " + contador.get());
    }

    static void repetir(AtomicInteger contador) {
        for (int i = 0; i < 10000; i++) contador.incrementAndGet();
    }
}

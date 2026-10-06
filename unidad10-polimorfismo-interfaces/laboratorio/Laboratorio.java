import java.util.List;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        for (Notificador notificador : List.<Notificador>of(new Consola(), new Simulado())) {
            System.out.println(notificador.enviar("Listo"));
        }
    }

    interface Notificador { String enviar(String mensaje); }
    static final class Consola implements Notificador {
        @Override public String enviar(String mensaje) { return "Consola: " + mensaje; }
    }
    static final class Simulado implements Notificador {
        @Override public String enviar(String mensaje) { return "Simulado: " + mensaje; }
    }
}

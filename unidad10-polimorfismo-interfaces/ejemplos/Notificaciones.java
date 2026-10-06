interface Notificador {
    void enviar(String mensaje);
}

final class NotificadorConsola implements Notificador {
    @Override
    public void enviar(String mensaje) {
        System.out.println("[Consola] " + mensaje);
    }
}

final class NotificadorSimulado implements Notificador {
    @Override
    public void enviar(String mensaje) {
        System.out.println("[Simulado] " + mensaje);
    }
}

public class Notificaciones {
    static void avisar(Notificador notificador, String mensaje) {
        notificador.enviar(mensaje);
    }

    public static void main(String[] args) {
        avisar(new NotificadorConsola(), "Proceso terminado");
        avisar(new NotificadorSimulado(), "Prueba");
    }
}


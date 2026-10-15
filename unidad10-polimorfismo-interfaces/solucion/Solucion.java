import java.util.Objects;
public final class Solucion {
    interface Notificador { String enviar(String mensaje); }
    record Consola() implements Notificador { public String enviar(String mensaje) { return "Consola: "+mensaje; } }
    record NotificadorPrefijo(Notificador destino) implements Notificador {
        NotificadorPrefijo { Objects.requireNonNull(destino); }
        public String enviar(String mensaje) { return destino.enviar("[Curso] "+mensaje); }
    }
    public static void main(String[] args) {
        Notificador notificador=new NotificadorPrefijo(new Consola());
        System.out.println(notificador.enviar("Listo"));
        System.out.println(new NotificadorPrefijo(notificador).enviar("Listo"));
    }
}

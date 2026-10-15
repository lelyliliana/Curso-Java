import java.time.*;
public final class Solucion {
    static LocalDate vencimiento(LocalDate inicio) { return inicio.plusDays(7); }
    static boolean vencido(LocalDate inicio, Clock reloj) { return LocalDate.now(reloj).isAfter(vencimiento(inicio)); }
    public static void main(String[] args) {
        LocalDate inicio=LocalDate.of(2026,1,1);
        System.out.println("Vence: "+vencimiento(inicio));
        for (String instante : new String[]{"2026-01-08T17:00:00Z","2026-01-09T17:00:00Z"}) {
            Clock reloj=Clock.fixed(Instant.parse(instante),ZoneId.of("America/Bogota"));
            System.out.println(LocalDate.now(reloj)+": "+vencido(inicio,reloj));
        }
        System.out.println("Bisiesto: "+vencimiento(LocalDate.of(2024,2,25)));
    }
}

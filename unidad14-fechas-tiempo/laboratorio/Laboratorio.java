import java.time.*;
import java.time.temporal.ChronoUnit;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        LocalDate inicio = LocalDate.of(2024, 2, 28);
        LocalDate fin = LocalDate.of(2024, 3, 1);
        System.out.println("Días: " + ChronoUnit.DAYS.between(inicio, fin));
        Clock reloj = Clock.fixed(Instant.parse("2026-01-01T02:00:00Z"), ZoneId.of("America/Bogota"));
        System.out.println("Fecha Bogotá: " + LocalDate.now(reloj));
        System.out.println("Instante: " + reloj.instant());
    }

    
}

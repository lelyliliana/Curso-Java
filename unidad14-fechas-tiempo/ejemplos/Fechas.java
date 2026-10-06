import java.time.LocalDate;
import java.time.Period;

public class Fechas {
    public static void main(String[] args) {
        LocalDate inicio = LocalDate.of(2026, 1, 15);
        LocalDate fin = LocalDate.of(2026, 10, 2);

        Period periodo = Period.between(inicio, fin);
        System.out.printf("%d meses y %d días%n",
                periodo.getMonths(), periodo.getDays());
    }
}


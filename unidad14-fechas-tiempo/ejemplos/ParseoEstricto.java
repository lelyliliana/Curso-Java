import java.time.LocalDate;
import java.time.format.*;

public class ParseoEstricto {
    public static void main(String[] args) {
        var formato = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
        for (String texto : new String[]{"29/02/2024", "29/02/2023", "31/04/2026"}) {
            try {
                System.out.println(texto + " -> " + LocalDate.parse(texto, formato));
            } catch (DateTimeParseException e) {
                System.out.println(texto + " -> Fecha inválida");
            }
        }
    }
}

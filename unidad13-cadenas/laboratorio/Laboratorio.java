import java.util.LinkedHashMap;
import java.util.Locale;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        String a = new String("Java");
        String b = new String("Java");
        System.out.println("Identidad: " + (a == b));
        System.out.println("Contenido: " + a.equals(b));
        String texto = " Sol  LUNA sol ";
        var frecuencias = new LinkedHashMap<String, Integer>();
        for (String palabra : texto.strip().toLowerCase(Locale.ROOT).split("\\s+")) {
            frecuencias.merge(palabra, 1, Integer::sum);
        }
        System.out.println(frecuencias);
        String emoji = "😀";
        System.out.println("Unidades UTF-16: " + emoji.length());
        System.out.println("Puntos de código: " + emoji.codePointCount(0, emoji.length()));
    }

    
}

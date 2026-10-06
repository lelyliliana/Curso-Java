import java.util.ArrayList;
import java.util.List;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        var resultado = importar(List.of("10", "abc", " 25 ", "2147483648"));
        System.out.println("Válidos: " + resultado.validos());
        System.out.println("Errores: " + resultado.errores());
    }

    record Resultado(List<Integer> validos, List<String> errores) {
        Resultado { validos = List.copyOf(validos); errores = List.copyOf(errores); }
    }
    static Resultado importar(List<String> lineas) {
        var validos = new ArrayList<Integer>();
        var errores = new ArrayList<String>();
        for (int i = 0; i < lineas.size(); i++) {
            try { validos.add(Integer.parseInt(lineas.get(i).strip())); }
            catch (NumberFormatException e) { errores.add("Línea " + (i + 1) + ": entero inválido"); }
        }
        return new Resultado(validos, errores);
    }
}

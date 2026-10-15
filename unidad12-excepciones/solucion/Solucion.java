import java.util.ArrayList;
import java.util.List;
public final class Solucion {
    static List<Integer> importarEstricto(List<String> lineas) {
        var candidato=new ArrayList<Integer>();
        for (int i=0;i<lineas.size();i++) {
            try { candidato.add(Integer.parseInt(lineas.get(i).strip())); }
            catch (NumberFormatException e) { throw new IllegalArgumentException("Línea "+(i+1)+": entero inválido",e); }
        }
        return List.copyOf(candidato);
    }
    public static void main(String[] args) {
        System.out.println(importarEstricto(List.of("10"," 25 ")));
        try { System.out.println(importarEstricto(List.of("10","abc","25"))); }
        catch (IllegalArgumentException e) { System.out.println("Sin resultado parcial: "+e.getMessage()); }
        System.out.println("Vacío: "+importarEstricto(List.of()));
    }
}

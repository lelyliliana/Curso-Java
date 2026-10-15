import java.util.*;
public final class Solucion {
    record Venta(String categoria,long centavos) {}
    record Total(String categoria,long centavos) {}
    static List<Total> primerasTres(List<Venta> ventas) {
        var totales=new HashMap<String,Long>();
        for (Venta v : ventas) {
            if (v.categoria()==null || v.categoria().isBlank() || v.centavos()<0) throw new IllegalArgumentException("Venta inválida");
            totales.merge(v.categoria(),v.centavos(),Math::addExact);
        }
        return totales.entrySet().stream().map(e -> new Total(e.getKey(),e.getValue()))
                .sorted(Comparator.comparingLong(Total::centavos).reversed().thenComparing(Total::categoria))
                .limit(3).toList();
    }
    public static void main(String[] args) {
        var ventas=List.of(new Venta("B",50),new Venta("A",40),new Venta("B",10),new Venta("A",20),new Venta("C",5),new Venta("D",1));
        primerasTres(ventas).forEach(t -> System.out.println(t.categoria()+"="+t.centavos()));
        System.out.println("Vacío: "+primerasTres(List.of()).size());
        try { primerasTres(List.of(new Venta("A",Long.MAX_VALUE),new Venta("A",1))); }
        catch (ArithmeticException e) { System.out.println("Suma desbordada rechazada"); }
    }
}

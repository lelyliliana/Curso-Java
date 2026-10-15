import java.util.Objects;
public final class Solucion {
    interface Propulsion { String encender(); }
    record Electrica() implements Propulsion { public String encender() { return "Eléctrica lista"; } }
    record Combustion() implements Propulsion { public String encender() { return "Combustión lista"; } }
    record Vehiculo(Propulsion propulsion) {
        Vehiculo { Objects.requireNonNull(propulsion); }
        String arrancar() { return propulsion.encender()+"; vehículo listo"; }
    }
    public static void main(String[] args) {
        System.out.println(new Vehiculo(new Electrica()).arrancar());
        System.out.println(new Vehiculo(new Combustion()).arrancar());
    }
}

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        var vehiculo = new Vehiculo(new Motor());
        System.out.println(vehiculo.arrancar());
        Animal animal = new Perro();
        System.out.println(animal.sonido());
    }

    static final class Motor { String encender() { return "Motor encendido"; } }
    static final class Vehiculo {
        private final Motor motor;
        Vehiculo(Motor motor) { this.motor = java.util.Objects.requireNonNull(motor); }
        String arrancar() { return motor.encender() + "; vehículo listo"; }
    }
    static abstract class Animal { abstract String sonido(); }
    static final class Perro extends Animal { @Override String sonido() { return "Guau"; } }
}

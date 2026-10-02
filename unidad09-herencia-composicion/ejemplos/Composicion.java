final class Motor {
    void encender() {
        System.out.println("Motor encendido");
    }
}

final class Automovil {
    private final Motor motor;

    Automovil(Motor motor) {
        this.motor = motor;
    }

    void arrancar() {
        motor.encender();
        System.out.println("Automóvil listo");
    }
}

public class Composicion {
    public static void main(String[] args) {
        Automovil auto = new Automovil(new Motor());
        auto.arrancar();
    }
}

enum EstadoSensor {
    OK, ADVERTENCIA, ERROR
}

record ResultadoMedicion(double valor, String unidad, EstadoSensor estado) {
    ResultadoMedicion {
        if (!Double.isFinite(valor) || estado == null) {
            throw new IllegalArgumentException("Valor finito y estado requeridos");
        }
        if (unidad == null || unidad.isBlank()) {
            throw new IllegalArgumentException("Unidad requerida");
        }
    }
}

public class Medicion {
    public static void main(String[] args) {
        var resultado = new ResultadoMedicion(25.4, "C", EstadoSensor.OK);
        System.out.println(resultado);
    }
}


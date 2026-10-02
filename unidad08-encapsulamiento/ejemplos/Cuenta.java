public class Cuenta {
    private final String titular;
    private double saldo;

    public Cuenta(String titular) {
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("Titular requerido");
        }
        this.titular = titular;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Depósito inválido");
        }
        saldo += valor;
    }

    public void retirar(double valor) {
        if (valor <= 0 || valor > saldo) {
            throw new IllegalArgumentException("Retiro inválido");
        }
        saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }
}

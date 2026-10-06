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
        if (!Double.isFinite(valor) || valor <= 0 || !Double.isFinite(saldo + valor)) {
            throw new IllegalArgumentException("Depósito inválido");
        }
        saldo += valor;
    }

    public void retirar(double valor) {
        if (!Double.isFinite(valor) || valor <= 0 || valor > saldo) {
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
    public static void main(String[] args) {
        var cuenta = new Cuenta("Ana");
        cuenta.depositar(10);
        cuenta.retirar(4);
        System.out.println(cuenta.getSaldo());
    }
}

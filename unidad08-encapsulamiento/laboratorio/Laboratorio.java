import java.math.BigDecimal;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        var cuenta = new Cuenta("Ana");
        cuenta.depositar(new BigDecimal("10.00"));
        cuenta.retirar(new BigDecimal("4.25"));
        System.out.println("Saldo: " + cuenta.saldo());
        try { cuenta.retirar(new BigDecimal("8.00")); }
        catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        System.out.println("Saldo conservado: " + cuenta.saldo());
    }

    static final class Cuenta {
        private final String titular;
        private BigDecimal saldo = new BigDecimal("0.00");
        Cuenta(String titular) {
            if (titular == null || titular.isBlank()) throw new IllegalArgumentException("Titular requerido");
            this.titular = titular.strip();
        }
        void depositar(BigDecimal valor) { validar(valor); saldo = saldo.add(valor); }
        void retirar(BigDecimal valor) {
            validar(valor);
            if (valor.compareTo(saldo) > 0) throw new IllegalArgumentException("Saldo insuficiente");
            saldo = saldo.subtract(valor);
        }
        private void validar(BigDecimal valor) {
            if (valor == null || valor.signum() <= 0 || valor.scale() > 2) throw new IllegalArgumentException("Importe positivo con hasta dos decimales");
        }
        BigDecimal saldo() { return saldo; }
    }
}

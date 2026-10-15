import java.math.BigDecimal;
import java.util.Objects;
public final class Solucion {
    static final class Cuenta {
        private BigDecimal saldo;
        Cuenta(BigDecimal inicial) {
            Objects.requireNonNull(inicial);
            if (inicial.signum()<0 || inicial.scale()>2) throw new IllegalArgumentException("Saldo inicial inválido");
            saldo=inicial;
        }
        BigDecimal saldo() { return saldo; }
        void transferir(Cuenta destino, BigDecimal importe) {
            if (destino==null || destino==this) throw new IllegalArgumentException("Destino inválido");
            if (importe==null || importe.signum()<=0 || importe.scale()>2 || importe.compareTo(saldo)>0)
                throw new IllegalArgumentException("Importe inválido o fondos insuficientes");
            BigDecimal nuevoOrigen=saldo.subtract(importe);
            BigDecimal nuevoDestino=destino.saldo.add(importe);
            saldo=nuevoOrigen;
            destino.saldo=nuevoDestino;
        }
    }
    public static void main(String[] args) {
        var a=new Cuenta(new BigDecimal("10.00")); var b=new Cuenta(new BigDecimal("0.00"));
        a.transferir(b,new BigDecimal("4.25"));
        System.out.println(a.saldo()+" / "+b.saldo());
        try { a.transferir(b,new BigDecimal("8.00")); }
        catch (IllegalArgumentException e) { System.out.println("Rechazada: "+a.saldo()+" / "+b.saldo()); }
        try { a.transferir(a,BigDecimal.ONE); }
        catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        a.transferir(b,new BigDecimal("5.75"));
        System.out.println("Retiro exacto: "+a.saldo()+" / "+b.saldo());
    }
}

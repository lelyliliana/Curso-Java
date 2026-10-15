import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
public final class Solucion {
    static BigDecimal original(BigDecimal base, BigDecimal tasa) {
        Objects.requireNonNull(base); Objects.requireNonNull(tasa);
        if (base.signum()<0 || tasa.signum()<0 || tasa.compareTo(BigDecimal.ONE)>0)
            throw new IllegalArgumentException("Base o tasa fuera de dominio");
        return base.multiply(BigDecimal.ONE.add(tasa)).setScale(2,RoundingMode.HALF_UP);
    }
    static BigDecimal refactorizado(BigDecimal base, BigDecimal tasa) {
        validar(base,tasa);
        return base.multiply(BigDecimal.ONE.add(tasa)).setScale(2,RoundingMode.HALF_UP);
    }
    static void validar(BigDecimal base, BigDecimal tasa) {
        Objects.requireNonNull(base); Objects.requireNonNull(tasa);
        if (base.signum()<0 || tasa.signum()<0 || tasa.compareTo(BigDecimal.ONE)>0)
            throw new IllegalArgumentException("Base o tasa fuera de dominio");
    }
    public static void main(String[] args) {
        for (String[] caso : new String[][]{{"0","0.19"},{"100","0.19"},{"0.05","0.10"}}) {
            var base=new BigDecimal(caso[0]); var tasa=new BigDecimal(caso[1]);
            var a=original(base,tasa); var b=refactorizado(base,tasa);
            System.out.println(a.toPlainString()+" / "+b.toPlainString()+" iguales="+a.equals(b));
        }
        for (String[] caso : new String[][]{{"-1","0.19"},{"100","1.01"}}) {
            var base=new BigDecimal(caso[0]); var tasa=new BigDecimal(caso[1]);
            for (int version=0;version<2;version++) {
                try { if (version==0) original(base,tasa); else refactorizado(base,tasa); }
                catch (IllegalArgumentException e) { System.out.println("Versión "+version+": rechazo"); }
            }
        }
    }
}

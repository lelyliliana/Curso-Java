import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Calculadora {
    static int sumar(int a, int b) {
        return a + b;
    }

    static int dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor no puede ser cero");
        }
        return a / b;
    }
}

class CalculadoraTest {
    @Test
    void sumaDosValores() {
        assertEquals(5, Calculadora.sumar(2, 3));
    }

    @Test
    void divisionEntreCeroProduceExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> Calculadora.dividir(10, 0));
    }
}

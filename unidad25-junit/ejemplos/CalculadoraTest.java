import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculadoraTest {
    @Test
    void sumaDosValores() {
        assertEquals(5, 2 + 3);
    }

    @Test
    void divisionEntreCeroProduceExcepcion() {
        assertThrows(ArithmeticException.class, () -> {
            int resultado = 10 / 0;
        });
    }
}

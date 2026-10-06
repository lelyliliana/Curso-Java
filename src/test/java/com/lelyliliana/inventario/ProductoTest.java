package com.lelyliliana.inventario;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class ProductoTest {
    @Test void normalizaNombreYEscala() {
        var p = new Producto("A-1", " Cuaderno ", new BigDecimal("12.5"), 2);
        assertEquals("Cuaderno", p.nombre());
        assertEquals(new BigDecimal("12.50"), p.precio());
        assertEquals(new BigDecimal("25.00"), p.valorExistencias());
    }
    @ParameterizedTest @ValueSource(strings={"", "a", "A|B", "A B", "ABCDEFGHIJKLMNOPQRSTU"})
    void rechazaCodigo(String codigo) {
        assertThrows(IllegalArgumentException.class, () -> new Producto(codigo, "A", BigDecimal.ONE, 0));
    }
    @ParameterizedTest @ValueSource(strings={"", " ", "A\nB", "A\tB"})
    void rechazaNombre(String nombre) {
        assertThrows(IllegalArgumentException.class, () -> new Producto("A", nombre, BigDecimal.ONE, 0));
    }
    @Test void limitaNombre() {
        assertDoesNotThrow(() -> new Producto("A", "x".repeat(80), BigDecimal.ONE, 0));
        assertThrows(IllegalArgumentException.class, () -> new Producto("A", "x".repeat(81), BigDecimal.ONE, 0));
    }
    @Test void rechazaSurrogadosAisladosSinDañarEmoji() {
        assertThrows(IllegalArgumentException.class, () -> new Producto("A", "\uD800", BigDecimal.ONE, 0));
        assertThrows(IllegalArgumentException.class, () -> new Producto("A", "\uDC00", BigDecimal.ONE, 0));
        assertDoesNotThrow(() -> new Producto("A", "😀", BigDecimal.ONE, 0));
    }
    @ParameterizedTest @ValueSource(strings={"0", "-1", "1.001", "1000000000.01"})
    void rechazaPrecio(String precio) {
        assertThrows(IllegalArgumentException.class, () -> new Producto("A", "A", new BigDecimal(precio), 0));
    }
    @Test void admiteCerosRedundantesYFronteras() {
        assertEquals(new BigDecimal("1.00"), new Producto("A", "A", new BigDecimal("1.000"), 0).precio());
        assertDoesNotThrow(() -> new Producto("A", "A", new BigDecimal("0.01"), 1000000));
        assertDoesNotThrow(() -> new Producto("A", "A", new BigDecimal("1000000000"), 0));
    }
    @Test void rechazaStockFueraDeRango() {
        assertThrows(IllegalArgumentException.class, () -> new Producto("A", "A", BigDecimal.ONE, -1));
        assertThrows(IllegalArgumentException.class, () -> new Producto("A", "A", BigDecimal.ONE, 1000001));
    }
    @Test void retiroEsInmutable() {
        var p = new Producto("A", "A", BigDecimal.ONE, 2);
        assertEquals(0, p.retirar(2).stock());
        assertEquals(2, p.stock());
        assertThrows(IllegalArgumentException.class, () -> p.retirar(3));
        assertThrows(IllegalArgumentException.class, () -> p.retirar(0));
        assertThrows(IllegalArgumentException.class, () -> p.retirar(-1));
    }
    @Test void nulosNoConstruyenEstadoValido() {
        assertThrows(IllegalArgumentException.class, () -> new Producto(null, "A", BigDecimal.ONE, 0));
        assertThrows(IllegalArgumentException.class, () -> new Producto("A", null, BigDecimal.ONE, 0));
        assertThrows(NullPointerException.class, () -> new Producto("A", "A", null, 0));
    }
}

package com.lelyliliana.inventario;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class InventarioTest {
    Producto p(String codigo) { return new Producto(codigo, "Cuaderno Ágil", new BigDecimal("1.10"), 3); }
    @Test void duplicadoNoReemplaza() {
        var inventario = new Inventario(); inventario.registrar(p("A"));
        assertThrows(IllegalArgumentException.class, () -> inventario.registrar(new Producto("A", "Otro", BigDecimal.TEN, 0)));
        assertEquals("Cuaderno Ágil", inventario.buscar("A").orElseThrow().nombre());
    }
    @Test void ausenciaYFiltroSonContratosDiferentes() {
        var inventario = new Inventario(); inventario.registrar(p("A"));
        assertTrue(inventario.buscar("B").isEmpty());
        assertTrue(inventario.filtrar("no existe").isEmpty());
        assertEquals(1, inventario.filtrar(" CUADERNO ").size());
        assertEquals(1, inventario.filtrar("ágil").size());
        assertEquals(0, inventario.filtrar("agil").size());
    }
    @Test void listadoEsInstantaneaNoModificable() {
        var inventario = new Inventario(); inventario.registrar(p("A"));
        var antes = inventario.listar(); inventario.retirar("A", 1);
        assertEquals(3, antes.getFirst().stock()); assertEquals(2, inventario.listar().getFirst().stock());
        assertThrows(UnsupportedOperationException.class, () -> antes.clear());
    }
    @Test void retiroInvalidoNoCambiaDatos() {
        var inventario = new Inventario(); inventario.registrar(p("A"));
        assertThrows(IllegalArgumentException.class, () -> inventario.retirar("A", 4));
        assertThrows(IllegalArgumentException.class, () -> inventario.retirar("B", 1));
        assertEquals(3, inventario.buscar("A").orElseThrow().stock());
    }
    @Test void valorExactoYOrdenDeInsercion() {
        var inventario = new Inventario(); inventario.registrar(p("B")); inventario.registrar(p("A"));
        assertEquals(new BigDecimal("6.60"), inventario.valorTotal());
        assertEquals("B", inventario.listar().getFirst().codigo());
        assertEquals(new BigDecimal("0.00"), new Inventario().valorTotal());
    }
    @Test void limiteNoAdmiteRegistroMilUno() {
        var inventario = new Inventario();
        for (int i=0;i<1000;i++) inventario.registrar(p("P"+i));
        assertThrows(IllegalArgumentException.class, () -> inventario.registrar(p("EXTRA")));
        assertEquals(1000, inventario.listar().size());
    }
}

package com.lelyliliana.saludo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class SaludoTest {
    @Test void normalizaSinPerderElNombre() { assertEquals("Hola, Ana", Saludo.saludar(" Ana ")); }
    @Test void rechazaNombreAusenteOVacio() {
        assertThrows(IllegalArgumentException.class, () -> Saludo.saludar(null));
        assertThrows(IllegalArgumentException.class, () -> Saludo.saludar(" "));
    }
}

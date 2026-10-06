package com.lelyliliana.saludo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MainTest {
    @Test void normalizaNombre() { assertEquals("Hola, Ana", Main.saludar(" Ana ")); }
    @Test void rechazaVacio() { assertThrows(IllegalArgumentException.class, () -> Main.saludar(" ")); }
}

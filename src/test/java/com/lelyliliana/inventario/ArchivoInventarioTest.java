package com.lelyliliana.inventario;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
class ArchivoInventarioTest {
    @TempDir Path temporal;
    Producto p() { return new Producto("A", "Cuaderno | español 😀", new BigDecimal("12.50"), 2); }
    @Test void archivoAusenteRepresentaInventarioVacio() throws Exception {
        assertTrue(new ArchivoInventario(temporal.resolve("no.txt")).cargar().isEmpty());
    }
    @Test void vueltaCompletaUTF8YDelimitador() throws Exception {
        Path ruta = temporal.resolve("carpeta con espacios").resolve("inventario.txt");
        var archivo = new ArchivoInventario(ruta); archivo.guardar(List.of(p()));
        assertEquals(List.of(p()), archivo.cargar());
        archivo.guardar(List.of()); assertTrue(archivo.cargar().isEmpty());
    }
    @ParameterizedTest @ValueSource(strings={"", "INVENTARIO|2", "OTRO", "INVENTARIO|1\nmal", "INVENTARIO|1\nA|%%%|1.00|0", "INVENTARIO|1\nA|QQ==|1.001|0", "INVENTARIO|1\nA|QQ==|1.00|-1", "INVENTARIO|1\nA|QQ==|1.00|0\nA|Qg==|2.00|0", "INVENTARIO|1\nA|/w==|1.00|0"})
    void archivoInvalidoNoEsAusencia(String texto) throws Exception {
        Path ruta = temporal.resolve("inventario.txt"); Files.writeString(ruta, texto, StandardCharsets.UTF_8);
        assertThrows(IOException.class, () -> new ArchivoInventario(ruta).cargar());
        assertEquals(texto, Files.readString(ruta, StandardCharsets.UTF_8));
    }
    @Test void excesoDeTamanoYRegistros() throws Exception {
        Path ruta=temporal.resolve("inventario.txt");
        Files.writeString(ruta,"x".repeat(1000001));
        assertThrows(IOException.class, () -> new ArchivoInventario(ruta).cargar());
        Files.writeString(ruta,"INVENTARIO|1\n"+"A|QQ==|1.00|0\n".repeat(1001));
        assertThrows(IOException.class, () -> new ArchivoInventario(ruta).cargar());
    }
    @Test void validacionPrevieneSobrescritura() throws Exception {
        Path ruta=temporal.resolve("inventario.txt"); var archivo=new ArchivoInventario(ruta);
        archivo.guardar(List.of(p())); byte[] anterior=Files.readAllBytes(ruta);
        assertThrows(IllegalArgumentException.class, () -> archivo.guardar(List.of(p(),p())));
        assertArrayEquals(anterior,Files.readAllBytes(ruta));
    }
    @Test void falloDeDestinoLimpiaTemporal() throws Exception {
        Path ruta=Files.createDirectory(temporal.resolve("destino"));
        Files.writeString(ruta.resolve("ocupado"),"x");
        assertThrows(IOException.class, () -> new ArchivoInventario(ruta).guardar(List.of(p())));
        try(var archivos=Files.list(temporal)) { assertEquals(1,archivos.count()); }
    }
}

package com.lelyliliana.inventario;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class AmpliacionesInventarioTest {
    @TempDir Path temporal;
    Producto producto(int stock) { return new Producto("A", "Cuaderno", new BigDecimal("12.50"), stock); }
    @Test void agregarRespetaFronterasYConservaInstantaneaOriginal() {
        var original = producto(0);
        assertEquals(1, original.agregar(1).stock());
        assertEquals(0, original.stock());
        assertEquals(1000000, producto(999999).agregar(1).stock());
        for (int cantidad : new int[]{0, -1, Integer.MAX_VALUE})
            assertThrows(IllegalArgumentException.class, () -> original.agregar(cantidad));
        assertThrows(IllegalArgumentException.class, () -> producto(1000000).agregar(1));
    }
    @Test void actualizarConservaCodigoStockYNormalizaConConstructor() {
        var original = producto(3);
        var nuevo = original.actualizar(" Libro ", new BigDecimal("2.000"));
        assertEquals("A", nuevo.codigo()); assertEquals(3, nuevo.stock());
        assertEquals("Libro", nuevo.nombre()); assertEquals(new BigDecimal("2.00"), nuevo.precio());
        assertEquals("Cuaderno", original.nombre());
        assertThrows(IllegalArgumentException.class, () -> original.actualizar(" ", BigDecimal.ONE));
        assertThrows(IllegalArgumentException.class, () -> original.actualizar("Libro", new BigDecimal("1.001")));
    }
    @Test void inventarioRechazaCodigoAusenteYSigueConEstadoAnterior() {
        var inventario = new Inventario(); inventario.registrar(producto(3));
        assertThrows(IllegalArgumentException.class, () -> inventario.agregar("B", 1));
        assertThrows(IllegalArgumentException.class, () -> inventario.actualizar("B", "Libro", BigDecimal.ONE));
        assertEquals(List.of(producto(3)), inventario.listar());
    }
    @Test void servicioNoConfirmaNingunaAmpliacionSiElGuardadoFalla() throws Exception {
        var almacen = mock(Almacen.class); when(almacen.cargar()).thenReturn(List.of(producto(3)));
        doThrow(new IOException("Disco no disponible")).when(almacen).guardar(anyList());
        var servicio = new ServicioInventario(almacen);
        assertThrows(IOException.class, () -> servicio.agregar("A", 1));
        assertThrows(IOException.class, () -> servicio.actualizar("A", "Libro", BigDecimal.ONE));
        assertEquals(producto(3), servicio.buscar("A").orElseThrow());
    }
    @Test void ampliacionesInvalidasNoSolicitanEscritura() throws Exception {
        var almacen = mock(Almacen.class); when(almacen.cargar()).thenReturn(List.of(producto(3)));
        var servicio = new ServicioInventario(almacen);
        assertThrows(IllegalArgumentException.class, () -> servicio.agregar("A", 0));
        assertThrows(IllegalArgumentException.class, () -> servicio.actualizar("A", " ", BigDecimal.ONE));
        verify(almacen, never()).guardar(anyList());
    }
    @Test void consolaAmpliaActualizaYRecuperaDespuesDeCerrar() throws Exception {
        Path ruta = temporal.resolve("datos con espacios.txt");
        String salida = consola("1\nA\nCuaderno\n12.50\n3\n7\nA\n2\n8\nA\nLibro\n20.00\n5\n0\n", ruta);
        assertTrue(salida.contains("Existencias añadidas y guardadas"));
        assertTrue(salida.contains("Datos actualizados y guardados"));
        assertTrue(salida.contains("Valor de existencias: 100.00"));
        assertTrue(consola("2\n0\n", ruta).contains("A | Libro | 20.00 | stock 5"));
    }
    @Test void actualizacionIncompletaNoModificaElArchivo() throws Exception {
        Path ruta = temporal.resolve("inventario.txt");
        consola("1\nA\nCuaderno\n12.50\n3\n0\n", ruta);
        String anterior = Files.readString(ruta);
        assertTrue(consola("8\nA\nNuevo nombre\n", ruta).contains("operación incompleta descartada"));
        assertEquals(anterior, Files.readString(ruta));
    }
    String consola(String texto, Path ruta) throws IOException {
        var salida = new StringWriter();
        try (var entrada = new Scanner(texto); var escritor = new PrintWriter(salida, true)) {
            Main.ejecutar(entrada, escritor, new ArchivoInventario(ruta));
        }
        return salida.toString();
    }
}

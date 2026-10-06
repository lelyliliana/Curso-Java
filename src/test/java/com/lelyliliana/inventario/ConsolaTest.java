package com.lelyliliana.inventario;
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;
class ConsolaTest {
    @TempDir Path temporal;
    String ejecutar(String texto,Path ruta) throws IOException {
        var salida=new StringWriter();
        try(var entrada=new Scanner(texto); var escritor=new PrintWriter(salida,true)) {
            Main.ejecutar(entrada,escritor,new ArchivoInventario(ruta));
        }
        return salida.toString();
    }
    @Test void flujoCompletoYPersistenciaEntreSesiones() throws Exception {
        Path ruta=temporal.resolve("inventario.txt");
        String salida=ejecutar("1\nA\nCuaderno\n12.50\n3\n2\n3\nA\n4\nA\n1\n5\n6\ncuaderno\n0\n",ruta);
        assertTrue(salida.contains("Registrado y guardado"));
        assertTrue(salida.contains("Retiro guardado"));
        assertTrue(salida.contains("Valor de existencias: 25.00"));
        assertTrue(ejecutar("2\n0\n",ruta).contains("stock 2"));
    }
    @Test void entradaIncompletaNoGuarda() throws Exception {
        Path ruta=temporal.resolve("inventario.txt");
        assertTrue(ejecutar("1\nA\n",ruta).contains("operación incompleta descartada"));
        assertFalse(Files.exists(ruta));
    }
    @Test void formatoInvalidoPermiteContinuarYErroresNoCreanRegistros() throws Exception {
        Path ruta=temporal.resolve("inventario.txt");
        String salida=ejecutar("9\n1\nA\nCuaderno\nabc\n2\n0\n",ruta);
        assertTrue(salida.contains("Opción no válida")); assertTrue(salida.contains("Dato rechazado"));
        assertTrue(salida.contains("Sin resultados")); assertFalse(Files.exists(ruta));
    }
    @Test void archivoDañadoNoSeReemplazaPorVacio() throws Exception {
        Path ruta=temporal.resolve("inventario.txt"); Files.writeString(ruta,"mal");
        assertThrows(IOException.class, () -> ejecutar("0\n",ruta));
        assertEquals("mal",Files.readString(ruta));
    }
}

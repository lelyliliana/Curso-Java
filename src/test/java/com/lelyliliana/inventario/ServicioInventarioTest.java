package com.lelyliliana.inventario;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class ServicioInventarioTest {
    Producto p() { return new Producto("A","Cuaderno",BigDecimal.ONE,3); }
    @Test void cargaYGuardaCandidato() throws Exception {
        Almacen almacen=mock(Almacen.class); when(almacen.cargar()).thenReturn(List.of(p()));
        var servicio=new ServicioInventario(almacen); servicio.retirar("A",1);
        verify(almacen).guardar(List.of(p().retirar(1)));
        assertEquals(2,servicio.buscar("A").orElseThrow().stock());
    }
    @Test void falloAlGuardarNoConfirmaCambioEnMemoria() throws Exception {
        Almacen almacen=mock(Almacen.class); when(almacen.cargar()).thenReturn(List.of(p()));
        doThrow(new IOException("Fallo simulado")).when(almacen).guardar(anyList());
        var servicio=new ServicioInventario(almacen);
        assertThrows(IOException.class, () -> servicio.retirar("A",1));
        assertEquals(3,servicio.buscar("A").orElseThrow().stock());
        assertThrows(IOException.class, () -> servicio.registrar(new Producto("B","Otro",BigDecimal.TEN,1)));
        assertTrue(servicio.buscar("B").isEmpty());
    }
    @Test void reglaRechazadaNoEscribeArchivo() throws Exception {
        Almacen almacen=mock(Almacen.class); when(almacen.cargar()).thenReturn(List.of(p()));
        var servicio=new ServicioInventario(almacen);
        assertThrows(IllegalArgumentException.class, () -> servicio.registrar(p()));
        assertThrows(IllegalArgumentException.class, () -> servicio.retirar("A",4));
        verify(almacen,never()).guardar(anyList());
    }
    @Test void falloAlCargarImpideArranque() throws Exception {
        Almacen almacen=mock(Almacen.class); when(almacen.cargar()).thenThrow(new IOException("Archivo dañado"));
        assertThrows(IOException.class, () -> new ServicioInventario(almacen));
        verify(almacen,never()).guardar(anyList());
    }
}

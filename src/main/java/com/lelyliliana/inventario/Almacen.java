package com.lelyliliana.inventario;

import java.io.IOException;
import java.util.List;

public interface Almacen {
    List<Producto> cargar() throws IOException;
    void guardar(List<Producto> productos) throws IOException;
}

package com.lelyliliana.inventario;

import java.io.IOException;
import java.util.Objects;

/** Guarda el candidato antes de sustituir el estado observado por el usuario. */
public final class ServicioInventario {
    private final Almacen almacen;
    private Inventario inventario;

    public ServicioInventario(Almacen almacen) throws IOException {
        this.almacen = Objects.requireNonNull(almacen);
        inventario = new Inventario();
        for (Producto producto : almacen.cargar()) {
            inventario.registrar(producto);
        }
    }

    public java.util.List<Producto> listar() { return inventario.listar(); }
    public java.util.List<Producto> filtrar(String texto) { return inventario.filtrar(texto); }
    public java.util.Optional<Producto> buscar(String codigo) { return inventario.buscar(codigo); }
    public java.math.BigDecimal valorTotal() { return inventario.valorTotal(); }

    private Inventario copiar() {
        var candidato = new Inventario();
        inventario.listar().forEach(candidato::registrar);
        return candidato;
    }

    public void registrar(Producto producto) throws IOException {
        Inventario candidato = copiar();
        candidato.registrar(producto);
        almacen.guardar(candidato.listar());
        inventario = candidato;
    }

    public void retirar(String codigo, int cantidad) throws IOException {
        Inventario candidato = copiar();
        candidato.retirar(codigo, cantidad);
        almacen.guardar(candidato.listar());
        inventario = candidato;
    }
}

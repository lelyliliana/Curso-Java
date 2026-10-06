package com.lelyliliana.inventario;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public final class Inventario {
    public static final int MAX_PRODUCTOS = 1000;
    private final Map<String, Producto> productos = new LinkedHashMap<>();

    public void registrar(Producto producto) {
        Objects.requireNonNull(producto, "Producto requerido");
        if (productos.containsKey(producto.codigo())) {
            throw new IllegalArgumentException("Código duplicado: " + producto.codigo());
        }
        if (productos.size() >= MAX_PRODUCTOS) {
            throw new IllegalArgumentException("Máximo 1000 productos");
        }
        productos.put(producto.codigo(), producto);
    }

    public Optional<Producto> buscar(String codigo) {
        return Optional.ofNullable(productos.get(Objects.requireNonNull(codigo)));
    }

    public List<Producto> listar() {
        return List.copyOf(productos.values());
    }

    public List<Producto> filtrar(String texto) {
        String criterio = Objects.requireNonNull(texto).strip().toLowerCase(Locale.ROOT);
        return productos.values().stream()
                .filter(p -> p.nombre().toLowerCase(Locale.ROOT).contains(criterio)
                        || p.codigo().toLowerCase(Locale.ROOT).contains(criterio)).toList();
    }

    public void retirar(String codigo, int cantidad) {
        Producto actual = buscar(codigo).orElseThrow(
                () -> new IllegalArgumentException("No existe: " + codigo));
        Producto nuevo = actual.retirar(cantidad);
        productos.put(codigo, nuevo);
    }

    public BigDecimal valorTotal() {
        return productos.values().stream().map(Producto::valorExistencias)
                .reduce(new BigDecimal("0.00"), BigDecimal::add);
    }
}

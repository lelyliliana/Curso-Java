package com.lelyliliana.inventario;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public final class ArchivoInventario implements Almacen {
    private static final String CABECERA = "INVENTARIO|1";
    private static final long MAX_BYTES = 1000000;
    private final Path ruta;

    public ArchivoInventario(Path ruta) {
        this.ruta = ruta.toAbsolutePath().normalize();
    }

    @Override
    public List<Producto> cargar() throws IOException {
        final List<String> lineas;
        try {
            if (Files.size(ruta) > MAX_BYTES) {
                throw new IOException("Archivo mayor que 1000000 bytes");
            }
            lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
        } catch (NoSuchFileException e) {
            return List.of();
        }
        if (lineas.isEmpty() || !CABECERA.equals(lineas.getFirst())) {
            throw new IOException("Cabecera o versión de inventario no válida");
        }
        if (lineas.size() > Inventario.MAX_PRODUCTOS + 1) {
            throw new IOException("Demasiados productos");
        }
        var validacion = new Inventario();
        for (int i = 1; i < lineas.size(); i++) {
            try {
                String[] partes = lineas.get(i).split("\\|", -1);
                if (partes.length != 4) {
                    throw new IllegalArgumentException("Se esperan cuatro campos");
                }
                byte[] bytes = Base64.getDecoder().decode(partes[1]);
                String nombre = StandardCharsets.UTF_8.newDecoder()
                        .decode(java.nio.ByteBuffer.wrap(bytes)).toString();
                Producto producto = new Producto(partes[0], nombre,
                        new BigDecimal(partes[2]), Integer.parseInt(partes[3]));
                validacion.registrar(producto);
            } catch (IllegalArgumentException | java.nio.charset.CharacterCodingException e) {
                throw new IOException("Registro inválido en línea " + (i + 1), e);
            }
        }
        return validacion.listar();
    }

    @Override
    public void guardar(List<Producto> productos) throws IOException {
        var validacion = new Inventario();
        productos.forEach(validacion::registrar);
        var lineas = new ArrayList<String>();
        lineas.add(CABECERA);
        for (Producto p : validacion.listar()) {
            String nombre = Base64.getEncoder().encodeToString(p.nombre().getBytes(StandardCharsets.UTF_8));
            lineas.add(p.codigo() + "|" + nombre + "|" + p.precio().toPlainString() + "|" + p.stock());
        }
        Path directorio = ruta.getParent();
        Files.createDirectories(directorio);
        Path temporal = Files.createTempFile(directorio, ".inventario-", ".tmp");
        try {
            Files.write(temporal, lineas, StandardCharsets.UTF_8);
            try {
                Files.move(temporal, ruta, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
            } catch (AtomicMoveNotSupportedException e) {
                Files.move(temporal, ruta, StandardCopyOption.REPLACE_EXISTING);
            }
        } finally {
            Files.deleteIfExists(temporal);
        }
    }
}

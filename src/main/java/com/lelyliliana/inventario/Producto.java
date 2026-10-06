package com.lelyliliana.inventario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/** Una instantánea válida del producto; los cambios crean otra instancia. */
public record Producto(String codigo, String nombre, BigDecimal precio, int stock) {
    public Producto {
        if (codigo == null || !codigo.matches("[A-Z0-9-]{1,20}")) {
            throw new IllegalArgumentException("Código: 1 a 20 letras mayúsculas, números o guiones");
        }
        if (nombre == null || nombre.strip().isEmpty() || nombre.strip().length() > 80
                || nombre.codePoints().anyMatch(Character::isISOControl)) {
            throw new IllegalArgumentException("Nombre: 1 a 80 unidades UTF-16, sin caracteres de control");
        }
        nombre = nombre.strip();
        for (int i = 0; i < nombre.length(); i++) {
            char actual = nombre.charAt(i);
            if (Character.isHighSurrogate(actual)) {
                if (i + 1 >= nombre.length() || !Character.isLowSurrogate(nombre.charAt(i + 1))) {
                    throw new IllegalArgumentException("Nombre con secuencia Unicode no válida");
                }
                i++;
            } else if (Character.isLowSurrogate(actual)) {
                throw new IllegalArgumentException("Nombre con secuencia Unicode no válida");
            }
        }
        Objects.requireNonNull(precio, "Precio requerido");
        if (precio.signum() <= 0 || precio.compareTo(new BigDecimal("1000000000")) > 0) {
            throw new IllegalArgumentException("Precio mayor que cero y hasta 1000000000");
        }
        try {
            precio = precio.setScale(2, RoundingMode.UNNECESSARY);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Precio con hasta dos decimales significativos", e);
        }
        if (stock < 0 || stock > 1000000) {
            throw new IllegalArgumentException("Stock entre 0 y 1000000");
        }
    }

    public Producto retirar(int cantidad) {
        if (cantidad <= 0 || cantidad > stock) {
            throw new IllegalArgumentException("Retiro positivo y hasta el stock disponible");
        }
        return new Producto(codigo, nombre, precio, stock - cantidad);
    }

    public BigDecimal valorExistencias() {
        return precio.multiply(BigDecimal.valueOf(stock));
    }
}

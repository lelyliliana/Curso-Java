package com.lelyliliana.saludo;
public final class Saludo {
    private Saludo() {}
    public static String saludar(String nombre) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre requerido");
        return "Hola, " + nombre.strip();
    }
}

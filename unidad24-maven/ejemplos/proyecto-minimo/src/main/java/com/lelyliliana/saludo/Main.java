package com.lelyliliana.saludo;
public final class Main {
    public static String saludar(String nombre) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre requerido");
        return "Hola, " + nombre.strip();
    }
    public static void main(String[] args) { System.out.println(saludar("Java")); }
}

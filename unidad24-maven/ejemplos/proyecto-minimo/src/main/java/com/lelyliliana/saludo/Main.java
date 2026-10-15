package com.lelyliliana.saludo;
public final class Main {
    public static String saludar(String nombre) {
        return Saludo.saludar(nombre);
    }
    public static void main(String[] args) { System.out.println(saludar("Java")); }
}

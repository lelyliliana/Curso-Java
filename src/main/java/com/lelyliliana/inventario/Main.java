package com.lelyliliana.inventario;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        var salida = new PrintWriter(System.out, true, StandardCharsets.UTF_8);
        try (var entrada = new Scanner(System.in, StandardCharsets.UTF_8)) {
            Path ruta = args.length == 0 ? Path.of("datos-locales", "inventario.txt") : Path.of(args[0]);
            ejecutar(entrada, salida, new ArchivoInventario(ruta));
        } catch (IOException | IllegalArgumentException e) {
            salida.println("No se pudo iniciar: " + e.getMessage());
            System.exit(1);
        }
    }

    public static void ejecutar(Scanner entrada, PrintWriter salida, Almacen almacen) throws IOException {
        var servicio = new ServicioInventario(almacen);
        salida.println("Inventario local (datos ficticios)");
        boolean continuar = true;
        while (continuar && entrada.hasNextLine()) {
            salida.println("1 Registrar | 2 Listar | 3 Buscar | 4 Retirar | 5 Reporte | 6 Filtrar | 0 Salir");
            String opcion = entrada.nextLine().strip();
            try {
                switch (opcion) {
                    case "1" -> {
                        String codigo = leer(entrada, salida, "Código:");
                        String nombre = leer(entrada, salida, "Nombre:");
                        BigDecimal precio = new BigDecimal(leer(entrada, salida, "Precio (punto decimal):"));
                        int stock = Integer.parseInt(leer(entrada, salida, "Stock:"));
                        servicio.registrar(new Producto(codigo, nombre, precio, stock));
                        salida.println("Registrado y guardado");
                    }
                    case "2" -> mostrar(salida, servicio.listar());
                    case "3" -> {
                        var producto = servicio.buscar(leer(entrada, salida, "Código:"));
                        salida.println(producto.map(Main::formato).orElse("No encontrado"));
                    }
                    case "4" -> {
                        String codigo = leer(entrada, salida, "Código:");
                        int cantidad = Integer.parseInt(leer(entrada, salida, "Cantidad:"));
                        servicio.retirar(codigo, cantidad);
                        salida.println("Retiro guardado");
                    }
                    case "5" -> salida.println("Valor de existencias: " + servicio.valorTotal().toPlainString());
                    case "6" -> mostrar(salida, servicio.filtrar(leer(entrada, salida, "Texto:")));
                    case "0" -> continuar = false;
                    default -> salida.println("Opción no válida");
                }
            } catch (EntradaTerminada e) {
                continuar = false;
                salida.println("Entrada terminada; operación incompleta descartada");
            } catch (IllegalArgumentException e) {
                salida.println("Dato rechazado: " + e.getMessage());
            } catch (IOException e) {
                salida.println("No se guardó; operación descartada: " + e.getMessage());
            }
        }
        salida.println("Hasta pronto");
    }

    private static String leer(Scanner entrada, PrintWriter salida, String pregunta) {
        salida.println(pregunta);
        if (!entrada.hasNextLine()) { throw new EntradaTerminada(); }
        return entrada.nextLine().strip();
    }
    private static String formato(Producto p) {
        return p.codigo() + " | " + p.nombre() + " | " + p.precio().toPlainString() + " | stock " + p.stock();
    }
    private static void mostrar(PrintWriter salida, java.util.List<Producto> productos) {
        if (productos.isEmpty()) { salida.println("Sin resultados"); }
        else { productos.forEach(p -> salida.println(formato(p))); }
    }
    private static final class EntradaTerminada extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }
}

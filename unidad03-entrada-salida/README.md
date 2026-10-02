# Unidad 03 — Entrada, salida y conversiones

## Scanner
```java
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            System.out.println("Edad = " + edad);
        }
    }
}
```

## Problema nextInt() + nextLine()
Después de leer un número puede quedar un salto de línea pendiente.

Una estrategia es consumirlo antes de leer texto:
```java
int edad = scanner.nextInt();
scanner.nextLine();
String nombre = scanner.nextLine();
```

## Parseo
```java
int cantidad = Integer.parseInt("25");
double precio = Double.parseDouble("12.5");
```

El texto inválido puede producir una excepción.

## Salida formateada
```java
System.out.printf("Total: %.2f%n", 123.456);
```

## Reto
Solicita nombre, cantidad y precio; valida conceptualmente qué entradas podrían fallar y muestra factura formateada.

# Unidad 03 — Entrada, salida y conversiones

## Qué aprenderás
Leer consola con Scanner, convertir texto, formatear salida y diagnosticar entradas inválidas.

# 1. Scanner

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

`System.in` es la entrada estándar.

try-with-resources cerrará Scanner al finalizar el bloque. En programas pequeños de consola esto nos permite introducir manejo correcto de recursos.

# 2. nextInt + nextLine

Entrada:
```text
25↵
Laura↵
```

`nextInt()` consume el número, pero puede quedar el separador de línea pendiente.

```java
int edad = scanner.nextInt();
scanner.nextLine();
String nombre = scanner.nextLine();
```

Comprender el buffer es mejor que memorizar “pon un nextLine extra”.

# 3. Alternativa: leer líneas y parsear

```java
String texto = scanner.nextLine();
int edad = Integer.parseInt(texto);
```

Esta estrategia puede simplificar algunos flujos de entrada, pero el parseo puede fallar.

# 4. Parseo

```java
int cantidad = Integer.parseInt("25");
double precio = Double.parseDouble("12.5");
```

```java
Integer.parseInt("hola")
```

produce `NumberFormatException`.

Más adelante aprenderás excepciones; por ahora identifica el origen.

# 5. Localización decimal

La entrada de Scanner puede verse afectada por Locale para ciertos métodos numéricos.

No asumas que coma/punto se interpretan igual en todos los entornos. Define el formato esperado en aplicaciones reales.

# 6. Salida

Concatenación:
```java
System.out.println("Edad: " + edad);
```

Formato:
```java
System.out.printf("Total: %.2f%n", 123.456);
```

`%n` produce separador de línea apropiado al entorno.

# 7. Práctica guiada — factura

Solicita:
- nombre;
- cantidad;
- precio.

Calcula:
```text
subtotal = cantidad * precio
```

Muestra dos decimales.

Antes de ejecutar, predice qué pasa si:
- cantidad = abc;
- precio negativo;
- nombre vacío.

Algunas son fallas de formato; otras son reglas de negocio.

# 8. Validar formato vs dominio

“12” puede parsearse como entero, pero ser inválido si edad permitida es 18..100.

Son capas distintas:
1. ¿puedo convertir?
2. ¿el valor pertenece al dominio?

# 9. Errores frecuentes
- nextInt/nextLine sin entender separador.
- confiar en entrada del usuario.
- mezclar validación de formato y negocio.
- imprimir doubles sin formato cuando la presentación requiere precisión específica.
- capturar errores sin informar qué dato falló.

# 10. Ejercicios
Perfil, conversor, factura, lectura de varios campos y experimentos de entrada inválida.

# 11. Reto
Construye factura de consola y documenta entradas que pueden fallar y cómo deberían manejarse cuando estudies excepciones.

# 12. Autoevaluación
1. ¿Qué es System.in?
2. ¿Por qué nextLine puede leer vacío tras nextInt?
3. ¿Qué hace parseInt?
4. ¿Formato válido implica dato válido?
5. ¿Qué hace %.2f?

# 13. Checklist
- [ ] Leo texto/números.
- [ ] Comprendo buffer básico.
- [ ] Parseo.
- [ ] Distingo formato/dominio.
- [ ] Formateo salida.

Continúa con decisiones.

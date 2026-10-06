# Unidad 03: Entrada, salida y conversiones

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Leer consola con Scanner, convertir texto, formatear salida y diagnosticar entradas inválidas.

## 1. Scanner

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

try-with-resources cerrará Scanner al finalizar el bloque. En programas pequeños de consola esto nos permite introducir manejo correcto de recursos. Cerrar Scanner también cierra System.in: hazlo al terminar la sesión, no en cada método que necesita leer del mismo flujo.

## 2. nextInt + nextLine

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

## 3. Alternativa: leer líneas y parsear

```java
String texto = scanner.nextLine();
int edad = Integer.parseInt(texto);
```

Esta estrategia puede simplificar algunos flujos de entrada, pero el parseo puede fallar.

## 4. Parseo

```java
int cantidad = Integer.parseInt("25");
double precio = Double.parseDouble("12.5");
```

```java
Integer.parseInt("hola")
```

produce `NumberFormatException`.

Más adelante aprenderás excepciones; por ahora identifica el origen.

## 5. Localización decimal

La entrada de Scanner puede verse afectada por Locale para ciertos métodos numéricos.

No asumas que coma/punto se interpretan igual en todos los entornos. Define el formato esperado en aplicaciones reales.

## 6. Salida

Concatenación:
```java
System.out.println("Edad: " + edad);
```

Formato:
```java
System.out.printf("Total: %.2f%n", 123.456);
```

`%n` produce separador de línea apropiado al entorno.

## 7. Práctica guiada: factura

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

## 8. Validar formato vs dominio

“12” puede parsearse como entero, pero ser inválido si edad permitida es 18..100.

Son capas distintas:
1. ¿puedo convertir?
2. ¿el valor pertenece al dominio?

## 9. Errores frecuentes
- nextInt/nextLine sin entender separador.
- confiar en entrada del usuario.
- mezclar validación de formato y negocio.
- imprimir doubles sin formato cuando la presentación requiere precisión específica.
- capturar errores sin informar qué dato falló.

## 10. Ejercicios
Perfil, conversor, factura, lectura de varios campos y experimentos de entrada inválida.

## 11. Reto
Construye factura de consola y documenta entradas que pueden fallar y cómo deberían manejarse cuando estudies excepciones.

## 12. Autoevaluación
1. ¿Qué es System.in?
2. ¿Por qué nextLine puede leer vacío tras nextInt?
3. ¿Qué hace parseInt?
4. ¿Formato válido implica dato válido?
5. ¿Qué hace %.2f?

## 13. Checklist
- [ ] Leo texto/números.
- [ ] Comprendo buffer básico.
- [ ] Parseo.
- [ ] Distingo formato/dominio.
- [ ] Formateo salida.

Continúa con decisiones.


## Laboratorio completo: observar, explicar y modificar

Leer una línea por campo evita mezclar tokens con separadores pendientes. Integer.parseInt rechaza letras y enteros fuera de rango. BigDecimal construido desde texto decimal evita introducir la aproximación binaria de double. Este laboratorio valida positividad; el proyecto final añade límites y política explícita de dos decimales.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad03-entrada-salida/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

### Paso 2. Compila

```text
javac -encoding UTF-8 --release 21 Laboratorio.java
```

`-encoding` define cómo se lee el código fuente y `--release` fija lenguaje, API y formato de clase compatibles con Java 21. Son decisiones diferentes. Si el comando falla, corrige el primer error relevante antes de ejecutar un bytecode antiguo.

### Paso 3. Ejecuta

```text
java Laboratorio
```

Escribe Cuaderno, 2 y 12.50 en tres líneas sucesivas. El programa espera estas entradas; no se encuentra bloqueado por un error.

```text
Con entradas Cuaderno, 2 y 12.50: Cuaderno: 25.00
```

### Paso 4. Recorre la lógica

Escribe los tres campos en líneas distintas. Repite con abc como cantidad y con 12,50 como precio. Distingue formato inválido de una cantidad negativa bien parseada. Termina la entrada antes del tercer campo.

### Paso 5. Lee el código completo

```java
import java.util.Scanner;
import java.math.BigDecimal;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        try (var entrada = new Scanner(System.in)) {
            System.out.println("Nombre:");
            if (!entrada.hasNextLine()) { System.out.println("Entrada terminada"); return; }
            String nombre = entrada.nextLine().strip();
            System.out.println("Cantidad (entero positivo):");
            if (!entrada.hasNextLine()) { System.out.println("Entrada terminada"); return; }
            String cantidadTexto = entrada.nextLine().strip();
            System.out.println("Precio (punto decimal):");
            if (!entrada.hasNextLine()) { System.out.println("Entrada terminada"); return; }
            String precioTexto = entrada.nextLine().strip();
            try {
                int cantidad = Integer.parseInt(cantidadTexto);
                BigDecimal precio = new BigDecimal(precioTexto);
                if (nombre.isEmpty() || cantidad <= 0 || precio.signum() <= 0) {
                    System.out.println("Datos fuera del dominio"); return;
                }
                System.out.println(nombre + ": " + precio.multiply(BigDecimal.valueOf(cantidad)).toPlainString());
            } catch (NumberFormatException e) { System.out.println("Formato numérico inválido"); }
        }
    }

    
}
```

### Paso 6. Comprueba y extiende

2 × 12.50: 25.00; abc: formato inválido; -2: fuera del dominio; fin de entrada: mensaje y salida sin stack trace.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 02: Variables, tipos y operadores](../unidad02-datos-operadores/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 04: Decisiones en Java](../unidad04-decisiones/README.md)


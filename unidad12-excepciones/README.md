# Unidad 12: Excepciones y manejo de errores

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Distinguir errores de dominio/programación/entorno, propagar o manejar excepciones y cerrar recursos correctamente.

## 1. Parseo que puede fallar

```java
int numero = Integer.parseInt(texto);
```

Si texto="abc":
```text
NumberFormatException
```

Una excepción interrumpe el flujo normal hasta que se maneja o propaga.

## 2. try/catch

```java
try {
    int numero = Integer.parseInt(texto);
    System.out.println(numero);
} catch (NumberFormatException e) {
    System.out.println("Número inválido");
}
```

Captura **lo que sabes manejar**.

## 3. No captures Exception por reflejo

```java
catch (Exception e) {
}
```

oculta errores y destruye diagnóstico.

Un catch amplio puede tener sentido en límites concretos de una aplicación, pero debe existir una estrategia explícita de registro/respuesta.

## 4. Checked vs unchecked

Java obliga a declarar/manejar ciertas excepciones checked.

Unchecked (subclases de RuntimeException) no requieren declaración obligatoria.

No significa:
```text
checked = recuperable
unchecked = fatal
```

La elección depende del contrato/API y naturaleza del fallo.

## 5. throw

```java
if (valor <= 0) {
    throw new IllegalArgumentException("Valor debe ser positivo");
}
```

El método rechaza una precondición inválida.

## 6. throws

```java
String cargar(Path ruta) throws IOException {
    return Files.readString(ruta, java.nio.charset.StandardCharsets.UTF_8);
}
```

Declara que el método puede propagar esa excepción checked.

No significa que el método la haya manejado.

## 7. Excepción de dominio

Puedes crear una excepción específica cuando mejora el contrato:

```java
class SaldoInsuficienteException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    SaldoInsuficienteException(String mensaje) { super(mensaje); }
}
```

No crees una clase de excepción distinta para cada mensaje sin necesidad.

## 8. finally

Se ejecuta al salir de try/catch en condiciones normales de control, con excepciones extremas del proceso/JVM.

Para recursos `AutoCloseable`, prefiere try-with-resources.

## 9. try-with-resources

```java
try (var reader = Files.newBufferedReader(ruta)) {
    System.out.println(reader.readLine());
}
```

Java cierra el recurso incluso si ocurre una excepción durante el bloque.

## 10. Importación tolerante a errores

Archivo con 1000 líneas; una es inválida.

Decisión de negocio:
- ¿fallar todo?
- ¿registrar línea y continuar?
- ¿aceptar parcialmente?

La excepción no decide la política. El requisito sí.

## 11. Preservar causa

Si traduces una excepción a otra capa, puede ser importante conservar la causa:

```java
throw new ImportacionException("No se pudo importar", e);
```

Así no pierdes diagnóstico original.

## 12. No uses excepciones para flujo normal

Si “usuario no encontrado” es un resultado normal de una consulta, quizá `Optional` sea más apropiado que lanzar excepción. Lo estudiaremos después.

## 13. Práctica guiada

Importa líneas numéricas:
```text
10
20
hola
30
```

Decide política y produce:
- válidas;
- rechazadas con número de línea/motivo.

## 14. Errores frecuentes
- catch vacío.
- capturar demasiado pronto.
- convertir todo en RuntimeException.
- perder causa.
- no cerrar recursos.
- excepciones como if/else cotidiano.

## 15. Ejercicios
Parseo, validación, lectura de archivo, excepción de dominio y propagación.

## 16. Reto
Importador que continúa ante líneas inválidas y entrega resumen reproducible de errores.

## 17. Autoevaluación
1. ¿throw vs throws?
2. ¿checked vs unchecked?
3. ¿Por qué evitar catch(Exception) vacío?
4. ¿Qué hace try-with-resources?
5. ¿Quién decide si continuar una importación?
6. ¿Por qué preservar causa?

## 18. Checklist
- [ ] Capturo específicamente.
- [ ] Propago cuando corresponde.
- [ ] Cierro recursos.
- [ ] Mantengo diagnóstico.
- [ ] Distingo excepción de flujo normal.

Continúa con cadenas y biblioteca estándar.


## Laboratorio completo: observar, explicar y modificar

Una excepción señala que una operación no logró cumplir su contrato. Capturar únicamente NumberFormatException permite recuperar este fallo concreto por línea. No captura errores de programación arbitrarios. El resultado conserva tanto datos válidos como incidencias; esta es una importación parcial deliberada, distinta del proyecto final que rechaza el archivo completo.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad12-excepciones/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

### Paso 2. Compila

```text
javac -encoding UTF-8 --release 21 Laboratorio.java
```

`-encoding` define cómo se lee el código fuente y `--release` fija lenguaje, API y formato de clase compatibles con Java 21. Son decisiones diferentes. Si el comando falla, corrige el primer error relevante antes de ejecutar un bytecode antiguo.

### Paso 3. Ejecuta

```text
java Laboratorio
```

Compara la salida con el resultado previsto. Los valores se eligieron para hacer visible el comportamiento de esta unidad.

```text
Válidos: [10, 25]
Errores: [Línea 2: entero inválido, Línea 4: entero inválido]
```

### Paso 4. Recorre la lógica

Sigue la entrada por índice y la salida por número de línea desde uno. Localiza dónde se continúa tras un error. Prueba una lista sin errores y otra vacía. Explica por qué el mensaje no necesita copiar texto sensible.

### Paso 5. Lee el código completo

```java
import java.util.ArrayList;
import java.util.List;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        var resultado = importar(List.of("10", "abc", " 25 ", "2147483648"));
        System.out.println("Válidos: " + resultado.validos());
        System.out.println("Errores: " + resultado.errores());
    }

    record Resultado(List<Integer> validos, List<String> errores) {
        Resultado { validos = List.copyOf(validos); errores = List.copyOf(errores); }
    }
    static Resultado importar(List<String> lineas) {
        var validos = new ArrayList<Integer>();
        var errores = new ArrayList<String>();
        for (int i = 0; i < lineas.size(); i++) {
            try { validos.add(Integer.parseInt(lineas.get(i).strip())); }
            catch (NumberFormatException e) { errores.add("Línea " + (i + 1) + ": entero inválido"); }
        }
        return new Resultado(validos, errores);
    }
}
```

### Paso 6. Comprueba y extiende

Parcial [10,abc,25]: válidos[10,25]; estricta: excepción y ningún resultado aplicado; []: vacío sin errores.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 11: Enumeraciones y records](../unidad11-enum-records/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 13: String y procesamiento de texto](../unidad13-cadenas/README.md)


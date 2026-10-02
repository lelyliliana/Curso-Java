# Unidad 12 — Excepciones y manejo de errores

## Qué aprenderás
Distinguir errores de dominio/programación/entorno, propagar o manejar excepciones y cerrar recursos correctamente.

# 1. Parseo que puede fallar

```java
int numero = Integer.parseInt(texto);
```

Si texto="abc":
```text
NumberFormatException
```

Una excepción interrumpe el flujo normal hasta que se maneja o propaga.

# 2. try/catch

```java
try {
    int numero = Integer.parseInt(texto);
    System.out.println(numero);
} catch (NumberFormatException e) {
    System.out.println("Número inválido");
}
```

Captura **lo que sabes manejar**.

# 3. No captures Exception por reflejo

```java
catch (Exception e) {
}
```

oculta errores y destruye diagnóstico.

Un catch amplio puede tener sentido en límites concretos de una aplicación, pero debe existir una estrategia explícita de registro/respuesta.

# 4. Checked vs unchecked

Java obliga a declarar/manejar ciertas excepciones checked.

Unchecked (subclases de RuntimeException) no requieren declaración obligatoria.

No significa:
```text
checked = recuperable
unchecked = fatal
```

La elección depende del contrato/API y naturaleza del fallo.

# 5. throw

```java
if (valor <= 0) {
    throw new IllegalArgumentException("Valor debe ser positivo");
}
```

El método rechaza una precondición inválida.

# 6. throws

```java
void cargar(Path ruta) throws IOException {
    ...
}
```

Declara que el método puede propagar esa excepción checked.

No significa que el método la haya manejado.

# 7. Excepción de dominio

Puedes crear una excepción específica cuando mejora el contrato:

```java
class SaldoInsuficienteException extends RuntimeException { ... }
```

No crees una clase de excepción distinta para cada mensaje sin necesidad.

# 8. finally

Se ejecuta al salir de try/catch en condiciones normales de control, con excepciones extremas del proceso/JVM.

Para recursos `AutoCloseable`, prefiere try-with-resources.

# 9. try-with-resources

```java
try (var reader = Files.newBufferedReader(ruta)) {
    ...
}
```

Java cierra el recurso incluso si ocurre una excepción durante el bloque.

# 10. Importación tolerante a errores

Archivo con 1000 líneas; una es inválida.

Decisión de negocio:
- ¿fallar todo?
- ¿registrar línea y continuar?
- ¿aceptar parcialmente?

La excepción no decide la política. El requisito sí.

# 11. Preservar causa

Si traduces una excepción a otra capa, puede ser importante conservar la causa:

```java
throw new ImportacionException("No se pudo importar", e);
```

Así no pierdes diagnóstico original.

# 12. No uses excepciones para flujo normal

Si “usuario no encontrado” es un resultado normal de una consulta, quizá `Optional` sea más apropiado que lanzar excepción. Lo estudiaremos después.

# 13. Práctica guiada

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

# 14. Errores frecuentes
- catch vacío.
- capturar demasiado pronto.
- convertir todo en RuntimeException.
- perder causa.
- no cerrar recursos.
- excepciones como if/else cotidiano.

# 15. Ejercicios
Parseo, validación, lectura de archivo, excepción de dominio y propagación.

# 16. Reto
Importador que continúa ante líneas inválidas y entrega resumen reproducible de errores.

# 17. Autoevaluación
1. ¿throw vs throws?
2. ¿checked vs unchecked?
3. ¿Por qué evitar catch(Exception) vacío?
4. ¿Qué hace try-with-resources?
5. ¿Quién decide si continuar una importación?
6. ¿Por qué preservar causa?

# 18. Checklist
- [ ] Capturo específicamente.
- [ ] Propago cuando corresponde.
- [ ] Cierro recursos.
- [ ] Mantengo diagnóstico.
- [ ] Distingo excepción de flujo normal.

Continúa con cadenas y biblioteca estándar.

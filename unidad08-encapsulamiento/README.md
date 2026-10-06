# Unidad 08: Constructores, encapsulamiento e invariantes

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Construir objetos válidos desde el inicio y controlar cambios de estado mediante operaciones del dominio.

## 1. Objeto válido desde construcción

```java
public Cuenta(String titular) {
    if (titular == null || titular.isBlank()) {
        throw new IllegalArgumentException("Titular requerido");
    }
    this.titular = titular;
}
```

Un constructor establece el estado inicial.

## 2. Constructor

No es un método normal:
- tiene el nombre de la clase;
- no declara tipo de retorno;
- se invoca con `new`.

```java
Cuenta cuenta = new Cuenta("Ana");
```

## 3. Encapsular no es “private + getters/setters”

Mala API:

```java
cuenta.setSaldo(-500);
```

Si saldo negativo es inválido, no deberíamos exponer una operación que permita romper la regla.

Mejor:

```java
public void retirar(double valor) {
    if (!Double.isFinite(valor) || valor <= 0 || valor > saldo) {
        throw new IllegalArgumentException("Retiro inválido");
    }
    saldo -= valor;
}
```

## 4. Invariante

Una invariante es una regla que debe mantenerse durante la vida válida del objeto.

Cuenta:
```text
saldo >= 0
titular no vacío
```

Las operaciones públicas deben preservar esas reglas.

## 5. Getters

Un getter puede ser apropiado cuando otro código necesita observar un valor.

```java
public double getSaldo() {
    return saldo;
}
```

Pero exponer una colección mutable directamente puede permitir modificar estado desde fuera.

## 6. Copias y vistas inmutables

Si una clase guarda una colección, considera devolver una copia o vista no modificable según el contrato.

La encapsulación incluye controlar **aliasing/mutabilidad**, no solo visibilidad private.

## 7. final

```java
private final String titular;
```

Impide reasignar ese campo después de construcción.

No hace automáticamente inmutable al objeto referenciado.

## 8. Sobrecarga de constructores

Puedes ofrecer formas válidas diferentes de construir, evitando duplicar validación mediante delegación cuando sea apropiado.

## 9. Práctica guiada

Cuenta:
- titular obligatorio;
- saldo inicial >=0;
- depositar >0;
- retirar >0 y <=saldo.

Escribe pruebas manuales:
- construcción válida;
- titular vacío;
- depósito 0;
- retiro mayor al saldo.

## 10. Errores frecuentes
- setter para toda propiedad.
- validar solo en UI/main.
- constructor que permite estado inválido.
- final = objeto profundamente inmutable.
- devolver colección interna mutable.

## 11. Ejercicios
Cuenta, Producto con precio positivo, Reserva con fechas coherentes, Sensor con rango permitido.

## 12. Reto
Diseña Cuenta cuyo estado inválido no pueda alcanzarse mediante su API pública.

## 13. Autoevaluación
1. ¿Qué hace constructor?
2. ¿Qué es invariante?
3. ¿Encapsulación = private?
4. ¿final vuelve inmutable una List?
5. ¿Por qué evitar setter de saldo?

## 14. Checklist
- [ ] Construyo objetos válidos.
- [ ] Protejo invariantes.
- [ ] Expongo operaciones de dominio.
- [ ] Controlo mutabilidad.

Continúa con herencia/composición.


## Laboratorio completo: observar, explicar y modificar

Una operación rechazada debe conservar el estado. Valida antes de asignar. BigDecimal es inmutable y comparar valores monetarios con compareTo evita confundir 1.0 con 1.00. El laboratorio rechaza escalas superiores a dos incluso si son ceros; el proyecto usa una política distinta que admite ceros redundantes.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad08-encapsulamiento/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

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
Saldo: 5.75
Saldo insuficiente
Saldo conservado: 5.75
```

### Paso 4. Recorre la lógica

Registra saldo antes y después de cada operación. Retira exactamente el saldo. Intenta retirar más. Observa dónde se compara y dónde se asigna. Introduce 1.001 y explica la política de escala.

### Paso 5. Lee el código completo

```java
import java.math.BigDecimal;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        var cuenta = new Cuenta("Ana");
        cuenta.depositar(new BigDecimal("10.00"));
        cuenta.retirar(new BigDecimal("4.25"));
        System.out.println("Saldo: " + cuenta.saldo());
        try { cuenta.retirar(new BigDecimal("8.00")); }
        catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        System.out.println("Saldo conservado: " + cuenta.saldo());
    }

    static final class Cuenta {
        private final String titular;
        private BigDecimal saldo = new BigDecimal("0.00");
        Cuenta(String titular) {
            if (titular == null || titular.isBlank()) throw new IllegalArgumentException("Titular requerido");
            this.titular = titular.strip();
        }
        void depositar(BigDecimal valor) { validar(valor); saldo = saldo.add(valor); }
        void retirar(BigDecimal valor) {
            validar(valor);
            if (valor.compareTo(saldo) > 0) throw new IllegalArgumentException("Saldo insuficiente");
            saldo = saldo.subtract(valor);
        }
        private void validar(BigDecimal valor) {
            if (valor == null || valor.signum() <= 0 || valor.scale() > 2) throw new IllegalArgumentException("Importe positivo con hasta dos decimales");
        }
        BigDecimal saldo() { return saldo; }
    }
}
```

### Paso 6. Comprueba y extiende

Retiro exacto: saldo0; exceso: no cambia; cero/negativo: rechazo; transferencia a sí misma: rechazada.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 07: Clases y objetos](../unidad07-clases-objetos/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 09: Herencia y composición](../unidad09-herencia-composicion/README.md)


# Unidad 08 — Constructores, encapsulamiento e invariantes

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Construir objetos válidos desde el inicio y controlar cambios de estado mediante operaciones del dominio.

# 1. Objeto válido desde construcción

```java
public Cuenta(String titular) {
    if (titular == null || titular.isBlank()) {
        throw new IllegalArgumentException("Titular requerido");
    }
    this.titular = titular;
}
```

Un constructor establece el estado inicial.

# 2. Constructor

No es un método normal:
- tiene el nombre de la clase;
- no declara tipo de retorno;
- se invoca con `new`.

```java
Cuenta cuenta = new Cuenta("Ana");
```

# 3. Encapsular no es “private + getters/setters”

Mala API:

```java
cuenta.setSaldo(-500);
```

Si saldo negativo es inválido, no deberíamos exponer una operación que permita romper la regla.

Mejor:

```java
public void retirar(double valor) {
    if (valor <= 0 || valor > saldo) {
        throw new IllegalArgumentException("Retiro inválido");
    }
    saldo -= valor;
}
```

# 4. Invariante

Una invariante es una regla que debe mantenerse durante la vida válida del objeto.

Cuenta:
```text
saldo >= 0
titular no vacío
```

Las operaciones públicas deben preservar esas reglas.

# 5. Getters

Un getter puede ser apropiado cuando otro código necesita observar un valor.

```java
public double getSaldo() {
    return saldo;
}
```

Pero exponer una colección mutable directamente puede permitir modificar estado desde fuera.

# 6. Copias y vistas inmutables

Si una clase guarda una colección, considera devolver una copia o vista no modificable según el contrato.

La encapsulación incluye controlar **aliasing/mutabilidad**, no solo visibilidad private.

# 7. final

```java
private final String titular;
```

Impide reasignar ese campo después de construcción.

No hace automáticamente inmutable al objeto referenciado.

# 8. Sobrecarga de constructores

Puedes ofrecer formas válidas diferentes de construir, evitando duplicar validación mediante delegación cuando sea apropiado.

# 9. Práctica guiada

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

# 10. Errores frecuentes
- setter para toda propiedad.
- validar solo en UI/main.
- constructor que permite estado inválido.
- final = objeto profundamente inmutable.
- devolver colección interna mutable.

# 11. Ejercicios
Cuenta, Producto con precio positivo, Reserva con fechas coherentes, Sensor con rango permitido.

# 12. Reto
Diseña Cuenta cuyo estado inválido no pueda alcanzarse mediante su API pública.

# 13. Autoevaluación
1. ¿Qué hace constructor?
2. ¿Qué es invariante?
3. ¿Encapsulación = private?
4. ¿final vuelve inmutable una List?
5. ¿Por qué evitar setter de saldo?

# 14. Checklist
- [ ] Construyo objetos válidos.
- [ ] Protejo invariantes.
- [ ] Expongo operaciones de dominio.
- [ ] Controlo mutabilidad.

Continúa con herencia/composición.


---

## Continuar el curso

- **Unidad anterior:** [Unidad 07 — Clases y objetos](../unidad07-clases-objetos/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 09 — Herencia y composición](../unidad09-herencia-composicion/README.md)

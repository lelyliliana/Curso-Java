# Unidad 11 — Enumeraciones y records

## Qué aprenderás
Representar dominios cerrados con enum y portadores de datos concisos con record, comprendiendo sus límites de mutabilidad.

# 1. Problema con Strings libres

```java
String estado = "pagadoo";
```

Compila, aunque el valor sea inválido para nuestro dominio.

Si los estados son cerrados:

```java
enum EstadoPedido {
    CREADO, PAGADO, ENVIADO, ENTREGADO
}
```

# 2. enum es un tipo

```java
EstadoPedido estado = EstadoPedido.PAGADO;
```

No puede recibir arbitrariamente `"OTRO"`.

# 3. enum puede tener comportamiento

```java
enum Prioridad {
    BAJA(1), MEDIA(2), ALTA(3);

    private final int nivel;

    Prioridad(int nivel) {
        this.nivel = nivel;
    }

    public int nivel() {
        return nivel;
    }
}
```

No es solo una lista de constantes enteras.

# 4. switch con enum

```java
String mensaje = switch (estado) {
    case CREADO -> "Pendiente";
    case PAGADO -> "Confirmado";
    case ENVIADO -> "En ruta";
    case ENTREGADO -> "Finalizado";
};
```

El compilador puede ayudar con exhaustividad en expresiones switch sobre dominios apropiados.

# 5. record

```java
public record Punto(double x, double y) {}
```

Genera componentes/accesores, constructor canónico, equals/hashCode/toString según semántica de records.

Acceso:
```java
punto.x()
```
no `getX()` generado automáticamente.

# 6. Validación en record

```java
public record Medicion(double valor, String unidad) {
    public Medicion {
        if (unidad == null || unidad.isBlank()) {
            throw new IllegalArgumentException("Unidad requerida");
        }
    }
}
```

Es un constructor compacto.

# 7. Inmutabilidad superficial

```java
record Grupo(List<String> nombres) {}
```

El componente `nombres` no puede reasignarse dentro del record como campo normal mutable, pero la List referenciada puede seguir siendo mutable si no la proteges.

Record no garantiza inmutabilidad profunda.

# 8. ¿Cuándo record?

Bueno para valores/datos cuyo significado se expresa principalmente por sus componentes.

No reemplaza automáticamente cualquier clase de dominio con comportamiento e identidad mutable.

# 9. Igualdad

Records implementan igualdad basada en componentes, lo que los hace útiles como valores.

Esto contrasta con una clase normal que no sobrescribe equals.

# 10. Práctica guiada

Modela:
```java
enum EstadoSensor
record ResultadoMedicion(...)
```

Define estados permitidos y validación.

# 11. Errores frecuentes
- enum como int disfrazado sin necesidad.
- String para dominio cerrado.
- creer que record es profundamente inmutable.
- usar record para entidad mutable con ciclo de vida complejo sin analizar.
- esperar getters getX.

# 12. Ejercicios
Estados de pedido, prioridad, coordenada, rango de fechas simple y resultado de cálculo.

# 13. Reto
ResultadoMedicion record + EstadoSensor enum. Protege una colección mutable si la incluyes y explica cómo.

# 14. Autoevaluación
1. ¿enum es un tipo?
2. ¿Puede tener campos/métodos?
3. ¿Qué genera record?
4. ¿Cómo accedes a x?
5. ¿Record = inmutabilidad profunda?
6. ¿Cuándo preferir clase normal?

# 15. Checklist
- [ ] Uso enum para dominio cerrado.
- [ ] Uso records como valores.
- [ ] Valido construcción.
- [ ] Comprendo mutabilidad superficial.

Continúa con excepciones.

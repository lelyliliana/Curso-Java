# Unidad 11 — Enumeraciones y records

## enum
Representa un conjunto cerrado de valores.

```java
enum EstadoPedido {
    CREADO, PAGADO, ENVIADO, ENTREGADO
}
```

Es preferible a strings arbitrarios para estados conocidos.

## record
Útil para portadores de datos inmutables superficiales.

```java
public record Punto(double x, double y) {}
```

Java genera constructor canónico, accesores, equals, hashCode y toString.

## Importante
Un record no vuelve profundamente inmutables los objetos mutables que contiene.

## Reto
Modela un ResultadoMedicion como record y EstadoSensor como enum. Define qué validación debe ocurrir en construcción.

# Unidad 07 — Clases y objetos

## Clase
Define estructura y comportamiento.

```java
public class Cuenta {
    private String titular;
    private double saldo;

    public void depositar(double valor) {
        saldo += valor;
    }
}
```

## Objeto
```java
Cuenta cuenta = new Cuenta();
```

Cada objeto posee su propio estado de instancia.

## static
Un miembro static pertenece a la clase, no a una instancia concreta. No conviertas todo en static para evitar crear objetos.

## Estado y comportamiento
Una clase útil protege invariantes y reúne operaciones relacionadas con sus datos.

## Ejercicios
Modela Producto, Estudiante, Sensor y Cuenta.

## Reto
Diseña una clase sin getters/setters automáticos para todo: define primero qué operaciones tiene sentido permitir.

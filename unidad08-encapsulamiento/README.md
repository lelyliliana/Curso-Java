# Unidad 08 — Constructores, encapsulamiento y validación

## Constructor
```java
public Cuenta(String titular) {
    if (titular == null || titular.isBlank()) {
        throw new IllegalArgumentException("Titular requerido");
    }
    this.titular = titular;
}
```

## Encapsulación
No significa únicamente usar private + getters/setters. Significa controlar cómo puede cambiar el estado.

Mejor:
```java
public void retirar(double valor) {
    if (valor <= 0 || valor > saldo) {
        throw new IllegalArgumentException("Retiro inválido");
    }
    saldo -= valor;
}
```

que permitir modificar saldo arbitrariamente.

## Invariantes
Reglas que deben mantenerse válidas durante la vida del objeto.

## Reto
Diseña una Cuenta cuyo saldo nunca pueda volverse negativo mediante operaciones públicas.

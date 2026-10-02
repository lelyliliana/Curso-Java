# Unidad 09 — Herencia y composición

## Herencia
Modela una relación conceptual **es-un**.

```java
class Empleado {}
class Desarrollador extends Empleado {}
```

## Composición
Modela **tiene-un**.

```java
class Automovil {
    private final Motor motor;
}
```

## No uses herencia solo para reutilizar código
La relación debe tener sentido en el modelo.

## Composición
Suele permitir cambiar colaboradores con menor acoplamiento que una jerarquía rígida.

## super
Permite acceder a construcción/comportamiento de la superclase según las reglas de acceso.

## Reto
Para varios pares (Automóvil/Motor, Animal/Perro, Pedido/Cliente, Cuenta/CuentaAhorros), decide herencia o composición y justifica.

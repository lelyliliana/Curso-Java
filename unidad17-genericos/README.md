# Unidad 17 — Genéricos

## Problema
Queremos reutilizar estructuras manteniendo seguridad de tipos.

```java
class Caja<T> {
    private T valor;
    public void guardar(T valor) { this.valor = valor; }
    public T obtener() { return valor; }
}
```

## Métodos genéricos
```java
static <T> T primero(List<T> datos) { ... }
```

## Wildcards
`? extends T` y `? super T` expresan relaciones de lectura/escritura. Introduce PECS:
**Producer Extends, Consumer Super**.

## Reto
Diseña utilidades genéricas para colecciones sin perder seguridad de tipos.

# Unidad 25 — Pruebas con JUnit

## Test
```java
@Test
void sumaDosValores() {
    assertEquals(5, Calculadora.sumar(2, 3));
}
```

## Arrange / Act / Assert
Organiza preparación, acción y verificación.

## Casos
Prueba:
- normal;
- límite;
- inválido;
- excepción.

## Test independiente
No debe depender del orden de ejecución de otros tests.

## Reto
Crea suite para una clase de dominio con invariantes.

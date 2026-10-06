# Soluciones: JUnit

Una suite pequeña pero sensible puede añadir:

```java
@Test
void divisionEnteraTruncaHaciaCero() {
    assertEquals(3, Calculadora.dividir(7, 2));
    assertEquals(-3, Calculadora.dividir(-7, 2));
    assertEquals(0, Calculadora.dividir(0, 2));
}
```

Estas aserciones cubren una misma regla de truncamiento en tres clases de entrada; también pueden separarse o parametrizarse para mejorar el diagnóstico. La prueba de cero debe mantener la llamada dentro de assertThrows:

```java
@Test
void rechazaDivisorCero() {
    var error = assertThrows(IllegalArgumentException.class,
            () -> Calculadora.dividir(10, 0));
    assertTrue(error.getMessage().contains("cero"));
}
```

Comprobar mensaje solo corresponde si aporta al contrato. No acoples la prueba a cada palabra del texto cuando esa presentación puede cambiar.

Integer.MIN_VALUE / -1 desborda bajo la aritmética ordinaria int y retorna MIN_VALUE; no lanza ArithmeticException por ese caso. Si necesitas detectarlo, valida expresamente y añade una prueba de esa nueva regla.

Las suites del proyecto final comprueban errores que importan más que una suma simple: duplicados, precio exacto, retiro sin fondos, archivo corrupto y fallo de guardado que no confirma cambios en memoria.

Ejecuta `mvn test`. Un fallo muestra esperado, obtenido y ubicación; corrige la regla o la expectativa según el contrato, sin borrar la prueba para obtener BUILD SUCCESS.

[Práctica](PRACTICA.md) · [Unidad](README.md)

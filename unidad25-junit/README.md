# Unidad 25 — Pruebas con JUnit

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Diseñar pruebas unitarias legibles, cubrir fronteras/excepciones y distinguir calidad de pruebas de cantidad.

# 1. Primera prueba

```java
@Test
void sumaDosValores() {
    assertEquals(5, Calculadora.sumar(2, 3));
}
```

Una prueba expresa comportamiento esperado.

# 2. Arrange / Act / Assert

```java
// Arrange
var cuenta = new Cuenta("Ana", 100);

// Act
cuenta.retirar(30);

// Assert
assertEquals(70, cuenta.getSaldo());
```

No es obligación comentar cada sección; es una estructura mental.

# 3. Nombres

```text
retirarReduceSaldoCuandoHayFondos
retirarRechazaValorMayorAlSaldo
```

El nombre debe ayudar a entender escenario/expectativa.

# 4. Fronteras

Para rango 0..5 prueba:
- 0;
- 5;
- justo fuera;
- valores normales.

No necesitas probar todos los números para demostrar la regla.

# 5. Excepciones

```java
assertThrows(
    IllegalArgumentException.class,
    () -> cuenta.retirar(-10)
);
```

Prueba el contrato, no solo que “algo falló”.

# 6. Parametrizadas

Cuando la misma regla debe comprobar varios datos, JUnit permite pruebas parametrizadas.

Evitan duplicación sin esconder escenarios.

# 7. Independencia

Una prueba no debería depender de que otra se ejecute antes.

Cada test prepara su estado.

# 8. Determinismo

Evita depender directamente de:
- hora actual;
- red;
- orden aleatorio;
- archivos compartidos;
si la unidad no necesita realmente esos recursos.

Diseña dependencias inyectables cuando corresponda.

# 9. Qué probar

Prioriza:
- reglas de dominio;
- fronteras;
- transformaciones;
- errores;
- regresiones.

No pruebes getters triviales solo para subir cobertura.

# 10. Cobertura

Cobertura indica código ejecutado por tests, **no calidad ni corrección**.

100% puede coexistir con pruebas pobres.

# 11. Práctica guiada

Cuenta:
- depositar válido;
- depósito inválido;
- retiro válido;
- saldo insuficiente;
- frontera saldo exacto.

Consulta `PLAN_PRUEBAS.md`.

# 12. Errores frecuentes
- una prueba gigante.
- depender de orden.
- assert genérico sin intención.
- perseguir 100%.
- probar implementación privada en lugar de comportamiento.

# 13. Reto
Suite de una clase de dominio con invariantes. Explica por qué cada caso existe.

# 14. Autoevaluación
1. ¿AAA?
2. ¿Qué es caso límite?
3. ¿assertThrows?
4. ¿Tests dependen del orden?
5. ¿Cobertura = calidad?
6. ¿Qué comportamiento merece pruebas?

# 15. Checklist
- [ ] Pruebo reglas.
- [ ] Pruebo fronteras.
- [ ] Pruebo excepciones.
- [ ] Mantengo independencia.
- [ ] No persigo métricas vacías.

Continúa con Mockito.


---

## Continuar el curso

- **Unidad anterior:** [Unidad 24 — Maven y estructura de proyectos](../unidad24-maven/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 26 — Mockito y pruebas con dependencias](../unidad26-mockito/README.md)

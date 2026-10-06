# Unidad 25: Pruebas con JUnit

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Diseñar pruebas unitarias legibles, cubrir fronteras/excepciones y distinguir calidad de pruebas de cantidad.

## 1. Primera prueba

```java
@Test
void sumaDosValores() {
    assertEquals(5, Calculadora.sumar(2, 3));
}
```

Una prueba expresa comportamiento esperado.

## 2. Arrange / Act / Assert

```java
// Arrange
var cuenta = new Cuenta("Ana", 100);

// Act
cuenta.retirar(30);

// Assert
assertEquals(70, cuenta.getSaldo());
```

No es obligación comentar cada sección; es una estructura mental.

## 3. Nombres

```text
retirarReduceSaldoCuandoHayFondos
retirarRechazaValorMayorAlSaldo
```

El nombre debe ayudar a entender escenario/expectativa.

## 4. Fronteras

Para rango 0..5 prueba:
- 0;
- 5;
- justo fuera;
- valores normales.

No necesitas probar todos los números para demostrar la regla.

## 5. Excepciones

```java
assertThrows(
    IllegalArgumentException.class,
    () -> cuenta.retirar(-10)
);
```

Prueba el contrato, no solo que “algo falló”.

## 6. Parametrizadas

Cuando la misma regla debe comprobar varios datos, JUnit permite pruebas parametrizadas.

Evitan duplicación sin esconder escenarios.

## 7. Independencia

Una prueba no debería depender de que otra se ejecute antes.

Cada test prepara su estado.

## 8. Determinismo

Evita depender directamente de:
- hora actual;
- red;
- orden aleatorio;
- archivos compartidos;
si la unidad no necesita realmente esos recursos.

Diseña dependencias inyectables cuando corresponda.

## 9. Qué probar

Prioriza:
- reglas de dominio;
- fronteras;
- transformaciones;
- errores;
- regresiones.

No pruebes getters triviales solo para subir cobertura.

## 10. Cobertura

Cobertura indica código ejecutado por tests, **no calidad ni corrección**.

100% puede coexistir con pruebas pobres.

## 11. Práctica guiada

Cuenta:
- depositar válido;
- depósito inválido;
- retiro válido;
- saldo insuficiente;
- frontera saldo exacto.

Consulta `PLAN_PRUEBAS.md`.

## 12. Errores frecuentes
- una prueba gigante.
- depender de orden.
- assert genérico sin intención.
- perseguir 100%.
- probar implementación privada en lugar de comportamiento.

## 13. Reto
Suite de una clase de dominio con invariantes. Explica por qué cada caso existe.

## 14. Autoevaluación
1. ¿AAA?
2. ¿Qué es caso límite?
3. ¿assertThrows?
4. ¿Tests dependen del orden?
5. ¿Cobertura = calidad?
6. ¿Qué comportamiento merece pruebas?

## 15. Checklist
- [ ] Pruebo reglas.
- [ ] Pruebo fronteras.
- [ ] Pruebo excepciones.
- [ ] Mantengo independencia.
- [ ] No persigo métricas vacías.

Continúa con Mockito.


## Práctica reproducible

Abre una terminal en esta unidad y ejecuta `mvn test`. El pom.xml configura Java 21, JUnit Jupiter 6.1.3 y Mockito 5.24.0. Las pruebas completas están en [ejemplos](ejemplos/). No compiles estos tests con javac sin sus dependencias.

Consulta [PRACTICA.md](PRACTICA.md) y contrasta tu resultado con [SOLUCIONES.md](SOLUCIONES.md).

## Laboratorio ejecutable con Maven

El ejemplo completo prueba reglas aritméticas y excepciones. Abre una terminal en esta unidad y ejecuta:

```text
mvn test
```

El pom fija Java 21 y JUnit Jupiter 6.1.3. En Mockito se configura también el agente del proceso de pruebas. El nombre del archivo termina en Test.java para que Surefire lo encuentre. `Tests run` debe ser mayor que cero; BUILD SUCCESS con ninguna prueba no demuestra que el escenario esté cubierto.

```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Calculadora {
    static int sumar(int a, int b) {
        return a + b;
    }

    static int dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor no puede ser cero");
        }
        return a / b;
    }
}

class CalculadoraTest {
    @Test
    void sumaDosValores() {
        assertEquals(5, Calculadora.sumar(2, 3));
    }

    @Test
    void divisionEntreCeroProduceExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> Calculadora.dividir(10, 0));
    }
    @Test
    void divisionEnteraTruncaHaciaCero() {
        assertEquals(3, Calculadora.dividir(7, 2));
        assertEquals(-3, Calculadora.dividir(-7, 2));
        assertEquals(0, Calculadora.dividir(0, 2));
    }
}
```

### Paso 1. Preparar

Lee los datos iniciales y la regla esperada. Cada prueba crea sus propios objetos para no depender de un test anterior ni del orden de ejecución.

### Paso 2. Actuar

Localiza una operación del sistema que se está probando. En Mockito, when/thenReturn prepara la dependencia; esa configuración no es la acción del servicio.

### Paso 3. Afirmar

La aserción expresa el resultado público o el tipo de excepción. `assertThrows` ejecuta la lambda y devuelve la excepción capturada; no evalúes la llamada fuera de la lambda.

### Paso 4. Demostrar sensibilidad

Modifica temporalmente una regla, ejecuta el caso y comprueba que falla por el motivo previsto. Restaura el código y repite. Un test que permanece verde tras romper su contrato necesita una aserción más precisa.

### Paso 5. Extender

Consulta [PRACTICA.md](PRACTICA.md) y [SOLUCIONES.md](SOLUCIONES.md). Para pruebas de persistencia real y fallos al guardar, estudia también las suites del [inventario](../src/test/java/com/lelyliliana/inventario/).

---

## Continuar el curso

- **Unidad anterior:** [Unidad 24: Maven y estructura de proyectos](../unidad24-maven/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 26: Mockito y pruebas con dependencias](../unidad26-mockito/README.md)


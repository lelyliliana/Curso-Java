# Unidad 26: Mockito y pruebas con dependencias

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Aislar colaboradores cuando aporta valor, configurar respuestas y evitar pruebas acopladas a detalles internos.

## 1. Unidad con dependencia

```java
class ServicioUsuario {
    private final RepositorioUsuario repo;
    ServicioUsuario(RepositorioUsuario repo) {
        this.repo = java.util.Objects.requireNonNull(repo);
    }
    String obtenerNombre(String id) { return repo.buscarNombre(id).orElse("No encontrado"); }
}
```

Para probar reglas del servicio no siempre queremos base real ni enviar mensajes.

## 2. Mock

```java
RepositorioUsuario repo = mock(RepositorioUsuario.class);
```

Es un doble configurable.

## 3. Stub de respuesta

```java
when(repo.buscarNombre("1"))
    .thenReturn(Optional.of("Ana"));
```

Ahora controlamos el escenario.

## 4. Verificación

```java
verify(repo).buscarNombre("1");
```

En el ejemplo de búsqueda se verifica el código consultado. En un servicio con notificación podría verificarse enviar cuando esa acción sea parte de su contrato. Úsala cuando la interacción sea parte observable/importante del contrato.

No verifiques cada llamada interna; refactorizar rompería tests aunque comportamiento no cambie.

## 5. Mock vs objeto real

No mockees:
- records simples;
- entidades fáciles;
- colecciones;
- lógica pura;
solo por “aislar todo”.

Un objeto real simple suele producir una prueba más clara.

## 6. Dependencias difíciles

Mocks aportan cuando colaborador:
- red;
- repositorio;
- reloj abstraído;
- servicio externo;
- operación lenta/no determinista.

## 7. Diseño y testabilidad

Si una clase crea internamente:
```java
new RepositorioReal()
```
puede ser difícil sustituir.

Inyectar interface facilita pruebas y desacoplamiento incluso sin framework.

## 8. No confundas mock con integración

Una prueba con repo mock **no demuestra** que SQL/red/archivo real funcione.

Necesitas pruebas de integración separadas cuando ese riesgo importa.

## 9. Argumentos

Mockito permite matchers/captors, pero no los uses para inspeccionar cada detalle si una aserción sobre resultado final es suficiente.

## 10. Práctica guiada

Servicio:
- repo encuentra usuario;
- servicio actualiza;
- notificador envía.

Casos:
- encontrado;
- no encontrado;
- notificador falla según política.

## 11. Errores frecuentes
- mockear todo.
- verificar implementación.
- test que replica código.
- creer que mock prueba integración.
- mocks profundos de objetos mal diseñados.

## 12. Reto
Prueba servicio con repositorio y notificador. Justifica qué es mock y qué objeto real.

## 13. Autoevaluación
1. ¿Qué es mock?
2. ¿when/thenReturn?
3. ¿verify cuándo?
4. ¿Mock prueba DB real?
5. ¿Por qué no mockear entidad simple?
6. ¿Cómo ayuda inyección?

## 14. Checklist
- [ ] Aíslo límites útiles.
- [ ] Mantengo objetos simples reales.
- [ ] Verifico contratos.
- [ ] Distingo unit/integración.

Continúa con diagnóstico.


## Práctica reproducible

Abre una terminal en esta unidad y ejecuta `mvn test`. El pom.xml configura Java 21, JUnit Jupiter 6.1.3 y Mockito 5.24.0. Las pruebas completas están en [ejemplos](ejemplos/). No compiles estos tests con javac sin sus dependencias.

Consulta [PRACTICA.md](PRACTICA.md) y contrasta tu resultado con [SOLUCIONES.md](SOLUCIONES.md).

## Laboratorio ejecutable con Maven

El ejemplo completo prueba colaborador de búsqueda y política de ausencia. Abre una terminal en esta unidad y ejecuta:

```text
mvn test
```

El pom fija Java 21 y JUnit Jupiter 6.1.3. En Mockito se configura también el agente del proceso de pruebas. El nombre del archivo termina en Test.java para que Surefire lo encuentre. `Tests run` debe ser mayor que cero; BUILD SUCCESS con ninguna prueba no demuestra que el escenario esté cubierto.

```java
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Optional;
import org.junit.jupiter.api.Test;

interface RepositorioUsuario {
    Optional<String> buscarNombre(String id);
}

final class ServicioUsuario {
    private final RepositorioUsuario repositorio;

    ServicioUsuario(RepositorioUsuario repositorio) {
        this.repositorio = repositorio;
    }

    String obtenerNombre(String id) {
        return repositorio.buscarNombre(id).orElse("No encontrado");
    }
}

class ServicioUsuarioTest {
    @Test
    void retornaNombreDelRepositorio() {
        var repo = mock(RepositorioUsuario.class);
        when(repo.buscarNombre("1")).thenReturn(Optional.of("Ana"));

        var servicio = new ServicioUsuario(repo);

        assertEquals("Ana", servicio.obtenerNombre("1"));
    }
    @Test
    void ausenciaEsUnResultadoPrevisto() {
        var repo = mock(RepositorioUsuario.class);
        when(repo.buscarNombre("2")).thenReturn(Optional.empty());
        assertEquals("No encontrado", new ServicioUsuario(repo).obtenerNombre("2"));
        verify(repo).buscarNombre("2");
    }

    @Test
    void falloNoSeConfundeConAusencia() {
        var repo = mock(RepositorioUsuario.class);
        when(repo.buscarNombre("2")).thenThrow(new IllegalStateException("Fallo simulado"));
        assertThrows(IllegalStateException.class, () -> new ServicioUsuario(repo).obtenerNombre("2"));
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

- **Unidad anterior:** [Unidad 25: Pruebas con JUnit](../unidad25-junit/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 27: Diagnóstico, logging, depuración y configuración](../unidad27-diagnostico/README.md)


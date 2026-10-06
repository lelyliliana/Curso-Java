# Unidad 20: Optional y ausencia de valores

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Expresar resultados opcionales, transformar valores presentes y evitar usos mecánicos de Optional.

## 1. Problema

Método:
```java
Usuario buscar(String id)
```

¿Qué retorna si no existe?

`null` es posible, pero el tipo no comunica explícitamente la ausencia.

```java
Optional<Usuario> buscar(String id)
```

hace visible que puede no haber resultado.

## 2. Crear

```java
Optional.of(valor)
Optional.ofNullable(valor)
Optional.empty()
```

`of(null)` lanza NullPointerException.

## 3. Consumir

```java
usuario.ifPresent(System.out::println);
```

Transformar:
```java
String nombre = usuario
    .map(Usuario::nombre)
    .orElse("Desconocido");
```

## 4. orElse vs orElseGet

```java
opt.orElse(crearValorCostoso())
```

evalúa el argumento antes de llamar a orElse.

```java
opt.orElseGet(() -> crearValorCostoso())
```

crea solo si hace falta.

## 5. orElseThrow

```java
Usuario u = buscar(id)
    .orElseThrow(() -> new UsuarioNoEncontradoException(id));
```

Útil cuando en esa capa la ausencia debe convertirse en error.

## 6. No uses get sin comprobar

```java
opt.get()
```

puede lanzar NoSuchElementException.

Si terminas escribiendo `isPresent()+get()` constantemente, revisa si map/orElse/etc. expresan mejor el flujo.

## 7. Optional no es universal

Generalmente es especialmente útil como **tipo de retorno**.

Usarlo como:
- campo de entidad;
- parámetro;
- elemento dentro de colección;
puede añadir complejidad y no siempre es idiomático.

Una colección vacía ya puede expresar “cero resultados” sin `Optional<List<T>>` en muchos contratos.

## 8. Optional no elimina null del universo

El código interno/APIs externas todavía pueden producir null. Optional es una herramienta de contrato, no un sistema completo de null-safety.

## 9. flatMap

Si una transformación ya devuelve Optional:

```java
usuario.flatMap(Usuario::direccionPrincipal)
```

evita `Optional<Optional<Direccion>>`.

## 10. Práctica guiada

Repositorio en memoria:
```java
Optional<Usuario> buscarPorId(String id)
```

Implementa:
- mostrar nombre si existe;
- valor alternativo;
- excepción en una capa que exige existencia.

## 11. Errores frecuentes
- Optional en todo.
- get sin comprobar.
- retornar null desde método que declara Optional.
- Optional<List<T>> sin necesidad.
- orElse con cálculo costoso creyendo que es lazy.

## 12. Ejercicios
Búsquedas, map, filter, flatMap, orElseGet y orElseThrow.

## 13. Reto
Diseña API de repositorio que distinga correctamente “no encontrado” de “lista sin resultados” y justifica tipos.

## 14. Autoevaluación
1. ¿Qué comunica Optional?
2. ¿of vs ofNullable?
3. ¿orElse vs orElseGet?
4. ¿Por qué evitar get?
5. ¿Optional<List> siempre?
6. ¿Qué hace flatMap?

## 15. Checklist
- [ ] Uso Optional como contrato.
- [ ] Transformo sin get.
- [ ] Distingo ausencia/colección vacía.
- [ ] No lo uso mecánicamente.

Continúa con concurrencia.


## Laboratorio completo: observar, explicar y modificar

Optional expresa una ausencia prevista en el retorno. No convierte un fallo de red o archivo en ausencia. orElse evalúa su argumento antes de invocar el método, aunque haya valor. orElseGet recibe un proveedor que solo se invoca si falta el valor. Evita get sin verificar y no retornes null en lugar de Optional.empty.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad20-optional/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

### Paso 2. Compila

```text
javac -encoding UTF-8 --release 21 Laboratorio.java
```

`-encoding` define cómo se lee el código fuente y `--release` fija lenguaje, API y formato de clase compatibles con Java 21. Son decisiones diferentes. Si el comando falla, corrige el primer error relevante antes de ejecutar un bytecode antiguo.

### Paso 3. Ejecuta

```text
java Laboratorio
```

Compara la salida con el resultado previsto. Los valores se eligieron para hacer visible el comportamiento de esta unidad.

```text
ANA
Invitado
Se calculó alternativa
Ana
```

### Paso 4. Recorre la lógica

Consulta código existente y ausente. Predice si se imprime Se calculó alternativa. Sustituye orElse por orElseGet y comprueba. Distingue colección vacía de un valor único ausente.

### Paso 5. Lee el código completo

```java
import java.util.*;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        var nombres = Map.of("A", "Ana");
        System.out.println(buscar(nombres, "A").map(String::toUpperCase).orElse("No encontrado"));
        System.out.println(buscar(nombres, "B").orElseGet(() -> "Invitado"));
        var presente = Optional.of("Ana");
        System.out.println(presente.orElse(crearAlternativa()));
    }

    static Optional<String> buscar(Map<String, String> nombres, String codigo) {
        return Optional.ofNullable(nombres.get(codigo));
    }
    static String crearAlternativa() { System.out.println("Se calculó alternativa"); return "Invitado"; }
}
```

### Paso 6. Comprueba y extiende

Usuario ausente:empty; correo vacío:empty; correo válido:presente; fallo de repositorio:propaga error según contrato.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 19: Stream API](../unidad19-streams/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 21: Threads, estado compartido y condiciones de carrera](../unidad21-threads/README.md)


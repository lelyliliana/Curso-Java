# Unidad 20 — Optional y ausencia de valores

## Qué aprenderás
Expresar resultados opcionales, transformar valores presentes y evitar usos mecánicos de Optional.

# 1. Problema

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

# 2. Crear

```java
Optional.of(valor)
Optional.ofNullable(valor)
Optional.empty()
```

`of(null)` lanza NullPointerException.

# 3. Consumir

```java
usuario.ifPresent(System.out::println);
```

Transformar:
```java
String nombre = usuario
    .map(Usuario::nombre)
    .orElse("Desconocido");
```

# 4. orElse vs orElseGet

```java
opt.orElse(crearValorCostoso())
```

evalúa el argumento antes de llamar a orElse.

```java
opt.orElseGet(() -> crearValorCostoso())
```

crea solo si hace falta.

# 5. orElseThrow

```java
Usuario u = buscar(id)
    .orElseThrow(() -> new UsuarioNoEncontradoException(id));
```

Útil cuando en esa capa la ausencia debe convertirse en error.

# 6. No uses get sin comprobar

```java
opt.get()
```

puede lanzar NoSuchElementException.

Si terminas escribiendo `isPresent()+get()` constantemente, revisa si map/orElse/etc. expresan mejor el flujo.

# 7. Optional no es universal

Generalmente es especialmente útil como **tipo de retorno**.

Usarlo como:
- campo de entidad;
- parámetro;
- elemento dentro de colección;
puede añadir complejidad y no siempre es idiomático.

Una colección vacía ya puede expresar “cero resultados” sin `Optional<List<T>>` en muchos contratos.

# 8. Optional no elimina null del universo

El código interno/APIs externas todavía pueden producir null. Optional es una herramienta de contrato, no un sistema completo de null-safety.

# 9. flatMap

Si una transformación ya devuelve Optional:

```java
usuario.flatMap(Usuario::direccionPrincipal)
```

evita `Optional<Optional<Direccion>>`.

# 10. Práctica guiada

Repositorio en memoria:
```java
Optional<Usuario> buscarPorId(String id)
```

Implementa:
- mostrar nombre si existe;
- valor alternativo;
- excepción en una capa que exige existencia.

# 11. Errores frecuentes
- Optional en todo.
- get sin comprobar.
- retornar null desde método que declara Optional.
- Optional<List<T>> sin necesidad.
- orElse con cálculo costoso creyendo que es lazy.

# 12. Ejercicios
Búsquedas, map, filter, flatMap, orElseGet y orElseThrow.

# 13. Reto
Diseña API de repositorio que distinga correctamente “no encontrado” de “lista sin resultados” y justifica tipos.

# 14. Autoevaluación
1. ¿Qué comunica Optional?
2. ¿of vs ofNullable?
3. ¿orElse vs orElseGet?
4. ¿Por qué evitar get?
5. ¿Optional<List> siempre?
6. ¿Qué hace flatMap?

# 15. Checklist
- [ ] Uso Optional como contrato.
- [ ] Transformo sin get.
- [ ] Distingo ausencia/colección vacía.
- [ ] No lo uso mecánicamente.

Continúa con concurrencia.

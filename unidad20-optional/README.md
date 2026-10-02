# Unidad 20 — Optional y ausencia de valores

Optional puede expresar que un resultado puede no existir.

```java
Optional<Usuario> buscar(String id)
```

## Uso
```java
usuario.ifPresent(System.out::println);
```

```java
String nombre = usuario.map(Usuario::nombre).orElse("Desconocido");
```

## No es reemplazo universal de null
Evita usar Optional mecánicamente en todos los campos, parámetros o colecciones.

## orElse vs orElseGet
orElse evalúa su argumento aunque exista valor; orElseGet difiere la creación.

## Reto
Diseña búsquedas que expresen ausencia sin retornar valores mágicos.

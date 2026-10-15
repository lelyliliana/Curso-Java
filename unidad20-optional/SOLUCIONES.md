# Soluciones razonadas

## Solución del laboratorio

Optional expresa una ausencia prevista en el retorno. No convierte un fallo de red o archivo en ausencia. orElse evalúa su argumento antes de invocar el método, aunque haya valor. orElseGet recibe un proveedor que solo se invoca si falta el valor. Evita get sin verificar y no retornes null en lugar de Optional.empty.

La salida prevista es:

```text
ANA
Invitado
Se calculó alternativa
Ana
```

Consulta código existente y ausente. Predice si se imprime Se calculó alternativa. Sustituye orElse por orElseGet y comprueba. Distingue colección vacía de un valor único ausente.

## Solución de la extensión

Encadena buscar, map al correo, filter para no vacío y map para normalizar. Si buscar devuelve otro Optional, usa flatMap para evitar Optional<Optional<String>>. Define correo inválido por separado si requiere validación real.

## Casos de aceptación

Usuario ausente:empty; correo vacío:empty; correo válido:presente; fallo de repositorio:propaga error según contrato.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

Encadena Optional.ofNullable(usuarios.get(codigo)).map(Usuario::correo).map(String::strip).filter(s -> !s.isEmpty()). El resultado solo contiene correo de un usuario encontrado con texto no vacío. Si el contrato pide minúsculas, añade map con Locale.ROOT y documenta esa política. No se realiza validación sintáctica completa de correo ni se capturan indiscriminadamente excepciones como ausencia.

## Implementación de la parte añadida

Declaraciones dentro de Laboratorio; los correos null o vacíos representan ausencia:

```java
record Usuario(String correo) {}
static Optional<String> correo(Map<String,Usuario> usuarios, String codigo) {
    Objects.requireNonNull(usuarios);
    Objects.requireNonNull(codigo);
    return Optional.ofNullable(usuarios.get(codigo))
        .map(Usuario::correo).map(String::strip).filter(s -> !s.isEmpty());
}
```

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

# Unidad 26 — Mockito y dependencias

## Objetivo
Probar una unidad aislando colaboradores cuando aporta valor.

```java
Repositorio repo = mock(Repositorio.class);
when(repo.buscar("1")).thenReturn(Optional.of(usuario));
```

## No mockees todo
Objetos simples de dominio suelen ser más claros reales. Mockea límites/dependencias cuando necesitas controlar comportamiento.

## Verificación
Puedes verificar interacciones cuando forman parte del contrato, pero evita tests excesivamente acoplados a implementación.

## Reto
Prueba un servicio que depende de un repositorio y un notificador.

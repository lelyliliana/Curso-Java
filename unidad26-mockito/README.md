# Unidad 26 — Mockito y pruebas con dependencias

## Qué aprenderás
Aislar colaboradores cuando aporta valor, configurar respuestas y evitar pruebas acopladas a detalles internos.

# 1. Unidad con dependencia

```java
class ServicioUsuario {
    private final RepositorioUsuarios repo;
    private final Notificador notificador;
}
```

Para probar reglas del servicio no siempre queremos base real ni enviar mensajes.

# 2. Mock

```java
RepositorioUsuarios repo = mock(RepositorioUsuarios.class);
```

Es un doble configurable.

# 3. Stub de respuesta

```java
when(repo.buscar("1"))
    .thenReturn(Optional.of(usuario));
```

Ahora controlamos el escenario.

# 4. Verificación

```java
verify(notificador).enviar(...);
```

Úsala cuando la interacción sea parte observable/importante del contrato.

No verifiques cada llamada interna; refactorizar rompería tests aunque comportamiento no cambie.

# 5. Mock vs objeto real

No mockees:
- records simples;
- entidades fáciles;
- colecciones;
- lógica pura;
solo por “aislar todo”.

Un objeto real simple suele producir una prueba más clara.

# 6. Dependencias difíciles

Mocks aportan cuando colaborador:
- red;
- repositorio;
- reloj abstraído;
- servicio externo;
- operación lenta/no determinista.

# 7. Diseño y testabilidad

Si una clase crea internamente:
```java
new RepositorioReal()
```
puede ser difícil sustituir.

Inyectar interface facilita pruebas y desacoplamiento incluso sin framework.

# 8. No confundas mock con integración

Una prueba con repo mock **no demuestra** que SQL/red/archivo real funcione.

Necesitas pruebas de integración separadas cuando ese riesgo importa.

# 9. Argumentos

Mockito permite matchers/captors, pero no los uses para inspeccionar cada detalle si una aserción sobre resultado final es suficiente.

# 10. Práctica guiada

Servicio:
- repo encuentra usuario;
- servicio actualiza;
- notificador envía.

Casos:
- encontrado;
- no encontrado;
- notificador falla según política.

# 11. Errores frecuentes
- mockear todo.
- verificar implementación.
- test que replica código.
- creer que mock prueba integración.
- mocks profundos de objetos mal diseñados.

# 12. Reto
Prueba servicio con repositorio y notificador. Justifica qué es mock y qué objeto real.

# 13. Autoevaluación
1. ¿Qué es mock?
2. ¿when/thenReturn?
3. ¿verify cuándo?
4. ¿Mock prueba DB real?
5. ¿Por qué no mockear entidad simple?
6. ¿Cómo ayuda inyección?

# 14. Checklist
- [ ] Aíslo límites útiles.
- [ ] Mantengo objetos simples reales.
- [ ] Verifico contratos.
- [ ] Distingo unit/integración.

Continúa con diagnóstico.

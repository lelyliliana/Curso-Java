# Unidad 10 — Polimorfismo, interfaces y clases abstractas

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Programar contra contratos, sustituir implementaciones y elegir entre interface, clase abstracta y clase concreta.

# 1. Problema de acoplamiento

```java
EmailNotificador notificador = new EmailNotificador();
notificador.enviar("Hola");
```

El consumidor depende de Email.

Si mañana queremos consola/SMS, debemos cambiar el código consumidor.

# 2. Interface

```java
public interface Notificador {
    void enviar(String mensaje);
}
```

Implementaciones:

```java
class EmailNotificador implements Notificador { ... }
class ConsolaNotificador implements Notificador { ... }
```

# 3. Polimorfismo

```java
Notificador n = new EmailNotificador();
n.enviar("Hola");
```

La variable conoce el contrato; el objeto concreto decide la implementación.

Colección:

```java
for (Notificador n : notificadores) {
    n.enviar("Hola");
}
```

No necesitamos `if tipo == email`.

# 4. Sustitución

Si cualquier Notificador promete `enviar`, el consumidor debería poder usar implementaciones válidas sin conocer detalles.

El contrato debe ser suficientemente claro para que las implementaciones no sorprendan al consumidor.

# 5. Inyección de dependencia manual

```java
class ServicioAlertas {
    private final Notificador notificador;

    ServicioAlertas(Notificador notificador) {
        this.notificador = notificador;
    }
}
```

No necesitas un framework para comprender inversión de dependencias.

# 6. Clase abstracta

```java
abstract class Figura {
    abstract double area();

    void imprimirArea() {
        System.out.println(area());
    }
}
```

Puede compartir estado/comportamiento base y exigir operaciones abstractas.

# 7. Interface vs abstracta

Pregunta:
- ¿quiero expresar capacidad/contrato?
- ¿necesito múltiples contratos?
- ¿hay estado/comportamiento base coherente?
- ¿existe realmente una familia conceptual?

No existe regla “interfaces siempre”.

# 8. Métodos default

Interfaces modernas pueden tener métodos `default`, pero úsalos cuando pertenecen al contrato y tienen implementación común razonable; no conviertas interfaces en clases base improvisadas.

# 9. instanceof

Puede ser legítimo en ciertos límites, pero una cadena extensa de `instanceof` para decidir comportamiento que cada objeto podría implementar suele indicar polimorfismo desaprovechado.

# 10. Práctica guiada

Crea:
- Notificador;
- EmailNotificador;
- ConsolaNotificador;
- ServicioAlertas.

Inyecta una implementación y después cámbiala sin modificar la lógica de ServicioAlertas.

# 11. Errores frecuentes
- Interface sin propósito.
- Clase abstracta solo para reutilizar dos líneas.
- instanceof en lugar de despacho polimórfico.
- Contratos vagos.
- Consumidor creando internamente siempre la implementación concreta.

# 12. Ejercicios
Pagos, exportadores, figuras y almacenamiento ficticio mediante contratos.

# 13. Reto
Dos notificadores detrás de una interface y una clase consumidora que no conozca sus tipos concretos.

# 14. Autoevaluación
1. ¿Qué es polimorfismo?
2. ¿Qué aporta interface?
3. ¿Cuándo abstracta?
4. ¿Qué significa programar contra contrato?
5. ¿Por qué inyectar colaborador?
6. ¿instanceof siempre está mal?

# 15. Checklist
- [ ] Diseño contratos.
- [ ] Sustituyo implementaciones.
- [ ] Distingo interface/abstracta.
- [ ] Reduzco acoplamiento.

Continúa con enum y records.


---

## Continuar el curso

- **Unidad anterior:** [Unidad 09 — Herencia y composición](../unidad09-herencia-composicion/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 11 — Enumeraciones y records](../unidad11-enum-records/README.md)

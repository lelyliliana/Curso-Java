# Unidad 09 — Herencia y composición

## Qué aprenderás
Modelar relaciones es-un/tiene-un y elegir composición o herencia por significado, no por ahorro de código.

# 1. Herencia

```java
class Empleado { }
class Desarrollador extends Empleado { }
```

Afirma conceptualmente:
> un Desarrollador es un Empleado.

Esto permite sustitución bajo el contrato de la superclase cuando el diseño es correcto.

# 2. Composición

```java
class Automovil {
    private final Motor motor;
}
```

Afirma:
> un Automóvil tiene un Motor.

# 3. Reutilización no basta

Supón que `Pila` quiere reutilizar métodos de `ArrayList`.

Decir:
```text
Pila ES ArrayList
```
puede exponer operaciones que rompen la abstracción de pila.

Composición puede preservar mejor el contrato.

# 4. super

Constructor:

```java
class Desarrollador extends Empleado {
    Desarrollador(String nombre) {
        super(nombre);
    }
}
```

La construcción de la parte base ocurre según reglas de Java.

# 5. protected

`protected` amplía acceso, pero no debería usarse automáticamente para que subclases “toquen todo”.

Una jerarquía muy dependiente de campos internos puede ser frágil.

# 6. Override

Una subclase puede redefinir comportamiento:

```java
@Override
public double calcularPago() { ... }
```

`@Override` ayuda al compilador a verificar intención.

# 7. Sustitución

Si código espera un Empleado, una subclase debería poder participar sin romper expectativas esenciales del contrato.

Una herencia que obliga a lanzar “operación no soportada” en métodos fundamentales puede señalar una jerarquía incorrecta.

# 8. Composición y flexibilidad

```java
class Pedido {
    private final CalculadorEnvio calculador;
}
```

Cambiar colaborador puede ser más sencillo que crear una jerarquía rígida.

# 9. Práctica guiada

Decide:
- Automóvil/Motor;
- Animal/Perro;
- Pedido/Cliente;
- Cuenta/CuentaAhorros.

Para cada uno completa:
```text
X es-un Y
X tiene-un Y
```

Si la frase no tiene sentido, revisa.

# 10. Errores frecuentes
- Herencia para reutilizar código.
- Jerarquías profundas.
- protected para todo.
- Sobrescribir rompiendo expectativas.
- Crear subclases donde una estrategia/componente sería más flexible.

# 11. Ejercicios
Modela empleados, medios de pago y dispositivos. Propón herencia/composición y justifica.

# 12. Reto
Refactoriza un diseño basado en herencia innecesaria hacia composición y explica qué acoplamiento disminuye.

# 13. Autoevaluación
1. ¿Qué expresa extends?
2. ¿Qué expresa composición?
3. ¿Qué hace super?
4. ¿Por qué @Override?
5. ¿Reutilizar código basta para heredar?
6. ¿Qué significa sustitución?

# 14. Checklist
- [ ] Distingo es-un/tiene-un.
- [ ] Justifico herencia.
- [ ] Uso composición conscientemente.
- [ ] Preservo contratos.

Continúa con polimorfismo.

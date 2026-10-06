# Unidad 09: Herencia y composición

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Modelar relaciones es-un/tiene-un y elegir composición o herencia por significado, no por ahorro de código.

## 1. Herencia

```java
class Empleado { }
class Desarrollador extends Empleado { }
```

Afirma conceptualmente:
> un Desarrollador es un Empleado.

Esto permite sustitución bajo el contrato de la superclase cuando el diseño es correcto.

## 2. Composición

```java
class Automovil {
    private final Motor motor;
    Automovil(Motor motor) { this.motor = java.util.Objects.requireNonNull(motor); }
}
```

Afirma:
> un Automóvil tiene un Motor.

## 3. Reutilización no basta

Supón que `Pila` quiere reutilizar métodos de `ArrayList`.

Decir:
```text
Pila ES ArrayList
```
puede exponer operaciones que rompen la abstracción de pila.

Composición puede preservar mejor el contrato.

## 4. super

Constructor:

```java
class Desarrollador extends Empleado {
    Desarrollador(String nombre) {
        super(nombre);
    }
}
```

La construcción de la parte base ocurre según reglas de Java.

## 5. protected

`protected` amplía acceso, pero no debería usarse automáticamente para que subclases “toquen todo”.

Una jerarquía muy dependiente de campos internos puede ser frágil.

## 6. Override

Una subclase puede redefinir comportamiento:

```java
@Override
public double calcularPago() { return salarioBase; }
```

`@Override` ayuda al compilador a verificar intención. En este fragmento salarioBase es un campo del modelo de empleado y calcularPago debe existir en el supertipo con firma compatible.

## 7. Sustitución

Si código espera un Empleado, una subclase debería poder participar sin romper expectativas esenciales del contrato.

Una herencia que obliga a lanzar “operación no soportada” en métodos fundamentales puede señalar una jerarquía incorrecta.

## 8. Composición y flexibilidad

```java
class Pedido {
    private final CalculadorEnvio calculador;
    Pedido(CalculadorEnvio calculador) {
        this.calculador = java.util.Objects.requireNonNull(calculador);
    }
}
```

Cambiar colaborador puede ser más sencillo que crear una jerarquía rígida.

## 9. Práctica guiada

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

## 10. Errores frecuentes
- Herencia para reutilizar código.
- Jerarquías profundas.
- protected para todo.
- Sobrescribir rompiendo expectativas.
- Crear subclases donde una estrategia/componente sería más flexible.

## 11. Ejercicios
Modela empleados, medios de pago y dispositivos. Propón herencia/composición y justifica.

## 12. Reto
Refactoriza un diseño basado en herencia innecesaria hacia composición y explica qué acoplamiento disminuye.

## 13. Autoevaluación
1. ¿Qué expresa extends?
2. ¿Qué expresa composición?
3. ¿Qué hace super?
4. ¿Por qué @Override?
5. ¿Reutilizar código basta para heredar?
6. ¿Qué significa sustitución?

## 14. Checklist
- [ ] Distingo es-un/tiene-un.
- [ ] Justifico herencia.
- [ ] Uso composición conscientemente.
- [ ] Preservo contratos.

Continúa con polimorfismo.


## Laboratorio completo: observar, explicar y modificar

Composición expresa tiene un motor; herencia permite que Perro sea usado donde se requiere Animal. El método sobrescrito se selecciona según el objeto real. No se debe heredar solamente para ahorrar líneas: el subtipo debe respetar el contrato del supertipo.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad09-herencia-composicion/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

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
Motor encendido; vehículo listo
Guau
```

### Paso 4. Recorre la lógica

Separa las dos relaciones. Identifica delegación y sobrescritura. Cambia una implementación sin modificar el llamador. Pregunta si un vehículo es realmente un motor antes de intentar extends.

### Paso 5. Lee el código completo

```java
public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        var vehiculo = new Vehiculo(new Motor());
        System.out.println(vehiculo.arrancar());
        Animal animal = new Perro();
        System.out.println(animal.sonido());
    }

    static final class Motor { String encender() { return "Motor encendido"; } }
    static final class Vehiculo {
        private final Motor motor;
        Vehiculo(Motor motor) { this.motor = java.util.Objects.requireNonNull(motor); }
        String arrancar() { return motor.encender() + "; vehículo listo"; }
    }
    static abstract class Animal { abstract String sonido(); }
    static final class Perro extends Animal { @Override String sonido() { return "Guau"; } }
}
```

### Paso 6. Comprueba y extiende

Ambas propulsiones arrancan; null rechazado; código de Vehiculo sin instanceof ni cast.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 08: Constructores, encapsulamiento e invariantes](../unidad08-encapsulamiento/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 10: Polimorfismo, interfaces y clases abstractas](../unidad10-polimorfismo-interfaces/README.md)


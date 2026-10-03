# Unidad 07 — Clases y objetos

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Pasar de métodos sueltos a objetos con estado y comportamiento, distinguir instancia/clase y comenzar a modelar responsabilidades.

# 1. ¿Por qué objetos?

Hasta ahora podemos tener:

```java
String nombreProducto;
double precioProducto;
int stockProducto;
```

Si manejamos muchos productos, esos datos pertenecen conceptualmente a una misma entidad.

Una clase permite reunir **estado y comportamiento relacionados**.

# 2. Clase

```java
public class Producto {
    private String nombre;
    private double precio;
    private int stock;
}
```

La clase define una estructura/tipo. Todavía no representa un producto concreto.

# 3. Objeto

```java
Producto a = new Producto();
Producto b = new Producto();
```

`a` y `b` son referencias a objetos distintos.

Cada instancia puede tener su propio estado.

# 4. Referencia vs objeto

```java
Producto a = new Producto();
Producto b = a;
```

No creamos un segundo Producto. Ambas variables referencian el mismo objeto.

Este concepto explica muchos comportamientos posteriores.

# 5. Comportamiento

En vez de permitir que cualquier código manipule stock arbitrariamente:

```java
public void agregarStock(int cantidad) {
    if (cantidad <= 0) {
        throw new IllegalArgumentException("Cantidad inválida");
    }
    stock += cantidad;
}
```

La clase puede proteger sus reglas.

# 6. Estado

Estado de un Producto:
```text
nombre
precio
stock
```

Comportamiento:
```text
agregarStock
retirarStock
cambiarPrecio (si el dominio lo permite)
```

No todo atributo necesita automáticamente getter y setter.

# 7. this

```java
public void cambiarNombre(String nombre) {
    this.nombre = nombre;
}
```

`this` representa la instancia actual y permite distinguir el campo del parámetro.

# 8. static

```java
static int contador;
```

Pertenece a la clase, no a cada instancia.

No conviertas campos/métodos en static simplemente para evitar crear objetos.

Pregunta:
> ¿esto pertenece conceptualmente a una instancia o al tipo/clase?

# 9. Identidad e igualdad

Dos objetos distintos pueden representar datos equivalentes.

```java
new Producto(...)
new Producto(...)
```

`==` compara referencias para objetos. La igualdad lógica puede definirse mediante `equals`, que estudiaremos también al usar records/colecciones.

# 10. Modelar responsabilidades

Una clase `Producto` no debería enviar correos, conectarse a una base y dibujar una interfaz solo porque “puede tener métodos”.

Pregunta:
> ¿qué responsabilidad representa este objeto en el dominio?

# 11. Práctica guiada

Modela `Sensor`:
- identificador;
- unidad;
- última medición.

Operaciones:
- registrarMedicion;
- mostrar/obtener información necesaria.

Decide qué reglas debe proteger.

# 12. Errores frecuentes
- Clase = tabla de datos sin comportamiento.
- Getter/setter para todo.
- static para todo.
- Confundir variable de referencia con objeto.
- Clase con demasiadas responsabilidades.

# 13. Ejercicios
Modela Producto, Estudiante, Sensor y Cuenta. Para cada uno escribe primero responsabilidades e invariantes.

# 14. Reto
Diseña una clase Producto sin setters automáticos. Expón únicamente operaciones válidas del dominio.

# 15. Autoevaluación
1. ¿Clase vs objeto?
2. ¿Qué contiene una referencia?
3. ¿b=a crea otro objeto?
4. ¿Qué significa static?
5. ¿Por qué no todo necesita setter?
6. ¿Qué es responsabilidad?

# 16. Checklist
- [ ] Distingo clase/instancia.
- [ ] Comprendo referencias.
- [ ] Agrupo estado/comportamiento.
- [ ] Evito static indiscriminado.
- [ ] Diseño responsabilidades.

Continúa con constructores y encapsulamiento.


---

## Continuar el curso

- **Unidad anterior:** [Unidad 06 — Métodos y modularización](../unidad06-metodos/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 08 — Constructores, encapsulamiento e invariantes](../unidad08-encapsulamiento/README.md)

# Unidad 07: Clases y objetos

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Pasar de métodos sueltos a objetos con estado y comportamiento, distinguir instancia/clase y comenzar a modelar responsabilidades.

## 1. ¿Por qué objetos?

Hasta ahora podemos tener:

```java
String nombreProducto;
double precioProducto;
int stockProducto;
```

Si manejamos muchos productos, esos datos pertenecen conceptualmente a una misma entidad.

Una clase permite reunir **estado y comportamiento relacionados**.

## 2. Clase

```java
public class Producto {
    private String nombre;
    private double precio;
    private int stock;
}
```

La clase define una estructura/tipo. Todavía no representa un producto concreto.

## 3. Objeto

```java
Producto a = new Producto();
Producto b = new Producto();
```

`a` y `b` son referencias a objetos distintos.

Cada instancia puede tener su propio estado.

## 4. Referencia vs objeto

```java
Producto a = new Producto();
Producto b = a;
```

No creamos un segundo Producto. Ambas variables referencian el mismo objeto.

Este concepto explica muchos comportamientos posteriores.

## 5. Comportamiento

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

## 6. Estado

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

## 7. this

```java
public void cambiarNombre(String nombre) {
    this.nombre = nombre;
}
```

`this` representa la instancia actual y permite distinguir el campo del parámetro.

## 8. static

```java
static int contador;
```

Pertenece a la clase, no a cada instancia.

No conviertas campos/métodos en static simplemente para evitar crear objetos.

Pregunta:
> ¿esto pertenece conceptualmente a una instancia o al tipo/clase?

## 9. Identidad e igualdad

Dos objetos distintos pueden representar datos equivalentes.

```java
new Producto("Cuaderno", 12.50)
new Producto("Cuaderno", 12.50)
```

`==` compara referencias para objetos. La igualdad lógica puede definirse mediante `equals`, que estudiaremos también al usar records/colecciones.

## 10. Modelar responsabilidades

Una clase `Producto` no debería enviar correos, conectarse a una base y dibujar una interfaz solo porque “puede tener métodos”.

Pregunta:
> ¿qué responsabilidad representa este objeto en el dominio?

## 11. Práctica guiada

Modela `Sensor`:
- identificador;
- unidad;
- última medición.

Operaciones:
- registrarMedicion;
- mostrar/obtener información necesaria.

Decide qué reglas debe proteger.

## 12. Errores frecuentes
- Clase = tabla de datos sin comportamiento.
- Getter/setter para todo.
- static para todo.
- Confundir variable de referencia con objeto.
- Clase con demasiadas responsabilidades.

## 13. Ejercicios
Modela Producto, Estudiante, Sensor y Cuenta. Para cada uno escribe primero responsabilidades e invariantes.

## 14. Reto
Diseña una clase Producto sin setters automáticos. Expón únicamente operaciones válidas del dominio.

## 15. Autoevaluación
1. ¿Clase vs objeto?
2. ¿Qué contiene una referencia?
3. ¿b=a crea otro objeto?
4. ¿Qué significa static?
5. ¿Por qué no todo necesita setter?
6. ¿Qué es responsabilidad?

## 16. Checklist
- [ ] Distingo clase/instancia.
- [ ] Comprendo referencias.
- [ ] Agrupo estado/comportamiento.
- [ ] Evito static indiscriminado.
- [ ] Diseño responsabilidades.

Continúa con constructores y encapsulamiento.


## Precisiones para aplicar el modelo

### Paquetes, acceso y classpath

`package com.ejemplo;` declara el nombre cualificado de una clase. En un proyecto Maven sitúa el archivo en src/main/java/com/ejemplo. public permite acceso desde otros paquetes; sin modificador se aplica acceso de paquete. private restringe miembros a la clase y el contexto permitido por las reglas del lenguaje. protected incluye acceso de paquete y acceso de subclase con condiciones adicionales fuera del paquete: no significa acceso público para cualquier objeto de una subclase.

Para ejecutar una clase empaquetada usa su nombre cualificado y la raíz del classpath, por ejemplo `java -cp target/classes com.lelyliliana.inventario.Main`. El punto de entrada static no convierte todos los datos del programa en datos compartidos. El main puede construir objetos que conservan su propio estado.

## Laboratorio completo: observar, explicar y modificar

Una clase define un tipo; new crea una instancia; una variable de referencia permite alcanzarla. Dos instancias con datos iguales no son idénticas. Esta clase no redefine equals: hereda la comparación de identidad de Object. Precio en centavos long ofrece precisión entera mientras el rango y la unidad estén definidos.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad07-clases-objetos/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

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
Mismo objeto: true
Instancias diferentes: false
Subtotal: 3750
```

### Paso 4. Recorre la lógica

Identifica constructor, campos, método de instancia y llamada. Cambia cantidad sin modificar el producto. Compara identidad con alias y con b. Provoca una cantidad inválida y localiza el origen de la excepción.

### Paso 5. Lee el código completo

```java
public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        Producto a = new Producto("Cuaderno", 1250);
        Producto b = new Producto("Cuaderno", 1250);
        Producto alias = a;
        System.out.println("Mismo objeto: " + (a == alias));
        System.out.println("Instancias diferentes: " + (a == b));
        System.out.println("Subtotal: " + a.subtotal(3));
    }

    static final class Producto {
        private final String nombre;
        private final long precioCentavos;
        Producto(String nombre, long precioCentavos) {
            if (nombre == null || nombre.isBlank() || precioCentavos <= 0) throw new IllegalArgumentException("Producto inválido");
            this.nombre = nombre;
            this.precioCentavos = precioCentavos;
        }
        long subtotal(int cantidad) {
            if (cantidad <= 0) throw new IllegalArgumentException("Cantidad positiva requerida");
            return Math.multiplyExact(precioCentavos, cantidad);
        }
    }
}
```

### Paso 6. Comprueba y extiende

3 × 1250: 3750 centavos; cantidad 0: rechazo; alias observa el mismo objeto; otra instancia no es idéntica.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 06: Métodos y modularización](../unidad06-metodos/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 08: Constructores, encapsulamiento e invariantes](../unidad08-encapsulamiento/README.md)


# Unidad 17 — Genéricos

## Qué aprenderás
Reutilizar código conservando seguridad de tipos y comprender invariancia, wildcards y PECS.

# 1. Sin genéricos

Si una Caja guardara Object:
```java
Object valor = caja.obtener();
String texto = (String) valor;
```

El cast desplaza errores hacia ejecución.

# 2. Tipo parametrizado

```java
class Caja<T> {
    private T valor;

    public void guardar(T valor) {
        this.valor = valor;
    }

    public T obtener() {
        return valor;
    }
}
```

Uso:
```java
Caja<String> caja = new Caja<>();
caja.guardar("Hola");
String s = caja.obtener();
```

El compilador protege el tipo.

# 3. Métodos genéricos

```java
static <T> T primero(List<T> datos) {
    return datos.get(0);
}
```

`<T>` antes del retorno declara el parámetro de tipo del método.

# 4. Límites

```java
<T extends Number>
```

indica que T debe ser Number o subtipo.

`extends` aquí expresa un límite de tipo, incluso si T es una clase que implementa una interface en otros casos.

# 5. Invariancia

Aunque Integer es Number:

```text
List<Integer> NO es subtipo de List<Number>
```

Si lo fuera, podríamos insertar un Double en una List<Integer> mediante la referencia List<Number>.

# 6. Wildcard extends

```java
List<? extends Number>
```

Representa lista de algún tipo desconocido que es Number/subtipo.

Puedes leer elementos como Number, pero no añadir arbitrariamente Integer/Double porque no sabes el tipo exacto.

# 7. Wildcard super

```java
List<? super Integer>
```

Puede consumir Integer de forma segura.

Al leer, el tipo garantizado general es Object.

# 8. PECS

**Producer Extends, Consumer Super.**

Si una estructura produce T para ti → `? extends T`.

Si consume T que tú insertas → `? super T`.

Es una guía, no un sustituto de comprender el contrato.

# 9. Type erasure

Los genéricos Java se implementan principalmente mediante borrado de tipos. Esto explica restricciones como no poder hacer normalmente `new T()` o `new T[10]`.

# 10. Práctica guiada

Escribe método:
```java
static double sumar(List<? extends Number> numeros)
```

Después un método que copie Integer a un destino compatible usando super.

# 11. Errores frecuentes
- casts para evitar genéricos.
- List<Integer> = List<Number>.
- añadir a ? extends.
- PECS memorizado sin entender lectura/escritura.
- usar raw types como List sin parámetro.

# 12. Ejercicios
Caja, primero, máximo con límite apropiado, copia de colecciones y suma numérica.

# 13. Reto
Crea utilidades genéricas para copiar/filtrar colecciones manteniendo seguridad de tipos.

# 14. Autoevaluación
1. ¿Qué resuelve T?
2. ¿Qué es invariancia?
3. ¿Qué permite ? extends?
4. ¿? super?
5. ¿Qué significa PECS?
6. ¿Qué efecto tiene type erasure?

# 15. Checklist
- [ ] Creo clases/métodos genéricos.
- [ ] Comprendo invariancia.
- [ ] Uso wildcards con propósito.
- [ ] Evito raw types.

Continúa con lambdas.

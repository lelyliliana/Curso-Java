# Unidad 17: Genéricos

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Reutilizar código conservando seguridad de tipos y comprender invariancia, wildcards y PECS.

## 1. Sin genéricos

Si una Caja guardara Object:
```java
Object valor = caja.obtener();
String texto = (String) valor;
```

El cast desplaza errores hacia ejecución.

## 2. Tipo parametrizado

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

## 3. Métodos genéricos

```java
static <T> T primero(List<T> datos) {
    return datos.get(0);
}
```

`<T>` antes del retorno declara el parámetro de tipo del método.

## 4. Límites

```java
<T extends Number>
```

indica que T debe ser Number o subtipo.

`extends` aquí expresa un límite de tipo, incluso si T es una clase que implementa una interface en otros casos.

## 5. Invariancia

Aunque Integer es Number:

```text
List<Integer> NO es subtipo de List<Number>
```

Si lo fuera, podríamos insertar un Double en una List<Integer> mediante la referencia List<Number>.

## 6. Wildcard extends

```java
List<? extends Number>
```

Representa lista de algún tipo desconocido que es Number/subtipo.

Puedes leer elementos como Number, pero no añadir arbitrariamente Integer/Double porque no sabes el tipo exacto.

## 7. Wildcard super

```java
List<? super Integer>
```

Puede consumir Integer de forma segura.

Al leer, el tipo garantizado general es Object.

## 8. PECS

**Producer Extends, Consumer Super.**

Si una estructura produce T para ti → `? extends T`.

Si consume T que tú insertas → `? super T`.

Es una guía, no un sustituto de comprender el contrato.

## 9. Type erasure

Los genéricos Java se implementan principalmente mediante borrado de tipos. Esto explica restricciones como no poder hacer normalmente `new T()` o `new T[10]`.

## 10. Práctica guiada

Escribe método:
```java
static double sumar(List<? extends Number> numeros)
```

Después un método que copie Integer a un destino compatible usando super.

## 11. Errores frecuentes
- casts para evitar genéricos.
- List<Integer> = List<Number>.
- añadir a ? extends.
- PECS memorizado sin entender lectura/escritura.
- usar raw types como List sin parámetro.

## 12. Ejercicios
Caja, primero, máximo con límite apropiado, copia de colecciones y suma numérica.

## 13. Reto
Crea utilidades genéricas para copiar/filtrar colecciones manteniendo seguridad de tipos.

## 14. Autoevaluación
1. ¿Qué resuelve T?
2. ¿Qué es invariancia?
3. ¿Qué permite ? extends?
4. ¿? super?
5. ¿Qué significa PECS?
6. ¿Qué efecto tiene type erasure?

## 15. Checklist
- [ ] Creo clases/métodos genéricos.
- [ ] Comprendo invariancia.
- [ ] Uso wildcards con propósito.
- [ ] Evito raw types.

Continúa con lambdas.


## Laboratorio completo: observar, explicar y modificar

El origen produce elementos para el método y el destino los consume. El parámetro T relaciona ambos lados. Los tipos genéricos son invariantes: List<Integer> no se asigna a List<Number>, pero puede pasarse como List<? extends Number>. PECS describe este acceso, no impide toda mutación de la lista; por ejemplo puede eliminar elementos si su implementación lo admite.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad17-genericos/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

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
[1, 2, 3]
Suma: 6.0
```

### Paso 4. Recorre la lógica

Copia a List<Number> y a List<Object>. Intenta asignar directamente origen a List<Number> y observa el error de compilación en un archivo aparte. Prueba un destino List.of para distinguir seguridad de tipos de mutabilidad.

### Paso 5. Lee el código completo

```java
import java.util.*;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        List<Integer> origen = List.of(1, 2, 3);
        List<Number> destino = new ArrayList<>();
        copiar(origen, destino);
        System.out.println(destino);
        System.out.println("Suma: " + sumar(origen));
    }

    static <T> void copiar(List<? extends T> origen, List<? super T> destino) {
        for (T elemento : origen) destino.add(elemento);
    }
    static double sumar(List<? extends Number> datos) {
        double total = 0;
        for (Number dato : datos) total += dato.doubleValue();
        return total;
    }
}
```

### Paso 6. Comprueba y extiende

List<String> devuelve Optional<String>; vacía:empty; [7]:Optional[7]; destino no modificable:UnsupportedOperationException.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 16: Colecciones](../unidad16-colecciones/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 18: Lambdas e interfaces funcionales](../unidad18-lambdas/README.md)


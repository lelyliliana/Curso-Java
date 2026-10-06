# Unidad 18: Lambdas e interfaces funcionales

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Tratar comportamiento como valor mediante interfaces funcionales, lambdas y referencias a métodos.

## 1. Problema

Queremos filtrar números según distintas reglas.

Sin parametrizar comportamiento podríamos duplicar:
```text
filtrarPares
filtrarPositivos
filtrarMayoresA10
```

Podemos recibir la regla.

## 2. Interface funcional

Tiene un único método abstracto relevante para lambda.

```java
@FunctionalInterface
interface Regla<T> {
    boolean cumple(T valor);
}
```

## 3. Lambda

```java
Regla<Integer> esPar = n -> n % 2 == 0;
```

No es “una función suelta” fuera del sistema de tipos: es una implementación compatible con un tipo funcional objetivo.

## 4. Predicate

Java ya ofrece:

```java
Predicate<Integer> esPar = n -> n % 2 == 0;
```

`Predicate<T>`: T→boolean.

## 5. Interfaces estándar

`Consumer<T>`: recibe T, no retorna valor.  
`Supplier<T>`: produce T.  
`Function<T,R>`: transforma T→R.  
`UnaryOperator<T>`: T→T.  
`BiFunction<T,U,R>`: dos entradas→R.

Elegir una estándar evita interfaces propias innecesarias.

## 6. Captura

```java
int limite = 10;
Predicate<Integer> mayor = n -> n > limite;
```

Variables locales capturadas deben ser finales o efectivamente finales.

No puedes reasignar `limite` después de usarlo así.

## 7. Referencia a método

```java
System.out::println
```

Puede sustituir una lambda cuando las firmas son compatibles.

No la uses si vuelve menos clara la intención.

## 8. Composición

Predicates:
```java
Predicate<Integer> positivo = n -> n > 0;
Predicate<Integer> par = n -> n % 2 == 0;

Predicate<Integer> positivoYPar = positivo.and(par);
```

## 9. Práctica guiada

Crea método:
```java
filtrar(List<T>, Predicate<T>)
```

Pásale:
- pares;
- positivos;
- Strings no vacíos.

Observa que el algoritmo de recorrido no cambia; cambia el comportamiento recibido.

## 10. Errores frecuentes
- lambda larga con mucha lógica.
- crear interface propia cuando Function/Predicate basta.
- efectos secundarios ocultos.
- referencias a métodos crípticas.
- creer que lambda elimina tipos.

## 11. Ejercicios
Predicates, transformaciones, comparadores y estrategias recibidas como parámetro.

## 12. Reto
Refactoriza reglas hardcodeadas para recibir comportamiento y prueba varias implementaciones.

## 13. Autoevaluación
1. ¿Qué es interface funcional?
2. ¿Lambda tiene tipo objetivo?
3. ¿Predicate?
4. ¿Function?
5. ¿Qué significa efectivamente final?
6. ¿Referencia a método siempre mejora?

## 14. Checklist
- [ ] Uso interfaces estándar.
- [ ] Escribo lambdas pequeñas.
- [ ] Comprendo captura.
- [ ] Parametrizo comportamiento.

Continúa con Streams.


## Laboratorio completo: observar, explicar y modificar

Una lambda necesita un tipo objetivo que sea una interfaz funcional, con un método abstracto principal. Predicate prueba una condición y Function transforma un valor. El cuerpo no ejecuta al declararse: se invoca mediante test o apply. Las variables locales capturadas deben ser finales o efectivamente finales.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad18-lambdas/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

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
[4, 6]
N=4
```

### Paso 4. Recorre la lógica

Identifica parámetros y valor devuelto. Cambia and por or y predice resultados. Reescribe par como clase anónima para comparar el contrato. Evita modificar una lista externa dentro del predicate.

### Paso 5. Lee el código completo

```java
import java.util.*;
import java.util.function.*;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        var datos = List.of(1, 2, 3, 4, 5, 6);
        Predicate<Integer> par = n -> n % 2 == 0;
        Predicate<Integer> grande = n -> n > 3;
        System.out.println(filtrar(datos, par.and(grande)));
        Function<Integer, String> etiqueta = n -> "N=" + n;
        System.out.println(etiqueta.apply(4));
    }

    static List<Integer> filtrar(List<Integer> datos, Predicate<Integer> criterio) {
        var salida = new ArrayList<Integer>();
        for (int dato : datos) if (criterio.test(dato)) salida.add(dato);
        return List.copyOf(salida);
    }
}
```

### Paso 6. Comprueba y extiende

Cumple ambas:incluido; solo stock:no incluido con and; lista vacía:vacía; original intacto.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 17: Genéricos](../unidad17-genericos/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 19: Stream API](../unidad19-streams/README.md)


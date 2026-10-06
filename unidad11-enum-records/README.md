# Unidad 11: Enumeraciones y records

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Representar dominios cerrados con enum y portadores de datos concisos con record, comprendiendo sus límites de mutabilidad.

## 1. Problema con Strings libres

```java
String estado = "pagadoo";
```

Compila, aunque el valor sea inválido para nuestro dominio.

Si los estados son cerrados:

```java
enum EstadoPedido {
    CREADO, PAGADO, ENVIADO, ENTREGADO
}
```

## 2. enum es un tipo

```java
EstadoPedido estado = EstadoPedido.PAGADO;
```

No puede recibir arbitrariamente `"OTRO"`.

## 3. enum puede tener comportamiento

```java
enum Prioridad {
    BAJA(1), MEDIA(2), ALTA(3);

    private final int nivel;

    Prioridad(int nivel) {
        this.nivel = nivel;
    }

    public int nivel() {
        return nivel;
    }
}
```

No es solo una lista de constantes enteras.

## 4. switch con enum

```java
String mensaje = switch (estado) {
    case CREADO -> "Pendiente";
    case PAGADO -> "Confirmado";
    case ENVIADO -> "En ruta";
    case ENTREGADO -> "Finalizado";
};
```

El compilador puede ayudar con exhaustividad en expresiones switch sobre dominios apropiados.

## 5. record

```java
public record Punto(double x, double y) {}
```

Genera componentes/accesores, constructor canónico, equals/hashCode/toString según semántica de records.

Acceso:
```java
punto.x()
```
no `getX()` generado automáticamente.

## 6. Validación en record

```java
public record Medicion(double valor, String unidad) {
    public Medicion {
        if (unidad == null || unidad.isBlank()) {
            throw new IllegalArgumentException("Unidad requerida");
        }
    }
}
```

Es un constructor compacto.

## 7. Inmutabilidad superficial

```java
record Grupo(List<String> nombres) {}
```

El componente `nombres` no puede reasignarse dentro del record como campo normal mutable, pero la List referenciada puede seguir siendo mutable si no la proteges.

Record no garantiza inmutabilidad profunda.

## 8. ¿Cuándo record?

Bueno para valores/datos cuyo significado se expresa principalmente por sus componentes.

No reemplaza automáticamente cualquier clase de dominio con comportamiento e identidad mutable.

## 9. Igualdad

Records implementan igualdad basada en componentes, lo que los hace útiles como valores.

Esto contrasta con una clase normal que no sobrescribe equals.

## 10. Práctica guiada

Modela:
```java
enum EstadoSensor { OK, ADVERTENCIA, ERROR }
record ResultadoMedicion(double valor, String unidad, EstadoSensor estado) {}
```

Define estados permitidos y validación.

## 11. Errores frecuentes
- enum como int disfrazado sin necesidad.
- String para dominio cerrado.
- creer que record es profundamente inmutable.
- usar record para entidad mutable con ciclo de vida complejo sin analizar.
- esperar getters getX.

## 12. Ejercicios
Estados de pedido, prioridad, coordenada, rango de fechas simple y resultado de cálculo.

## 13. Reto
ResultadoMedicion record + EstadoSensor enum. Protege una colección mutable si la incluyes y explica cómo.

## 14. Autoevaluación
1. ¿enum es un tipo?
2. ¿Puede tener campos/métodos?
3. ¿Qué genera record?
4. ¿Cómo accedes a x?
5. ¿Record = inmutabilidad profunda?
6. ¿Cuándo preferir clase normal?

## 15. Checklist
- [ ] Uso enum para dominio cerrado.
- [ ] Uso records como valores.
- [ ] Valido construcción.
- [ ] Comprendo mutabilidad superficial.

Continúa con excepciones.


## Precisiones para aplicar el modelo

### Variantes cerradas y patrones de records

[Variantes.java](ejemplos/Variantes.java) muestra sealed, records y pattern matching en switch, disponibles sin preview para este ejemplo en Java 21. Resultado admite solamente Exito y Fallo; el switch distingue y descompone ambos. Se ejecuta como los demás ejemplos, compilando Variantes.java desde ejemplos.

La salida es `Éxito: Listo` y `Fallo: 404`. Si añades una variante permitida sin cubrirla en el switch, el compilador señala la falta de exhaustividad. El ejemplo no acepta null: describir(null) lanza NullPointerException porque no contiene case null. Un tipo cerrado tampoco convierte automáticamente los datos de cada variante en datos válidos; esos contratos requieren validación propia.

### Igualdad de valores y claves

Una clase que redefine equals debe mantener un hashCode compatible: objetos iguales tienen el mismo hash. El inverso no es cierto. No uses campos que cambian mientras el objeto es clave de HashMap o miembro de HashSet, porque puede dejar de encontrarse en la posición esperada.

Los records generan igualdad por componentes, no por identidad de negocio escogida automáticamente. Dos Producto con el mismo código y distinto stock son instantáneas diferentes; el catálogo decide unicidad por código. Un array como componente se compara como referencia bajo su equals, no por contenido profundo. Normaliza o elige un tipo de componente apropiado cuando necesites otra semántica.

## Laboratorio completo: observar, explicar y modificar

Un record genera constructor canónico, accesores, equals, hashCode y toString. Sus campos son finales, pero los componentes pueden apuntar a objetos mutables. List.copyOf toma una instantánea no modificable de la lista; sus elementos String son inmutables. Si fueran objetos mutables, la copia seguiría siendo superficial.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad11-enum-records/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

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
Grupo[nombre=A, temas=[Java], estado=ACTIVO]
Copia protegida: 1
Igualdad: true
```

### Paso 4. Recorre la lógica

Añade un elemento a la lista origen y observa el record. Intenta grupo.temas().add y localiza el rechazo. Compara dos records con los mismos componentes. Explica la diferencia con identidad mediante ==.

### Paso 5. Lee el código completo

```java
import java.util.ArrayList;
import java.util.List;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        var origen = new ArrayList<>(List.of("Java"));
        var grupo = new Grupo("A", origen, Estado.ACTIVO);
        origen.add("SQL");
        System.out.println(grupo);
        System.out.println("Copia protegida: " + grupo.temas().size());
        System.out.println("Igualdad: " + grupo.equals(new Grupo("A", List.of("Java"), Estado.ACTIVO)));
    }

    enum Estado { ACTIVO, CERRADO }
    record Grupo(String nombre, List<String> temas, Estado estado) {
        Grupo {
            if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre requerido");
            temas = List.copyOf(temas);
            java.util.Objects.requireNonNull(estado);
        }
    }
}
```

### Paso 6. Comprueba y extiende

25.0 válido; NaN/infinito rechazados; estado nulo rechazado; dos lecturas iguales tienen equals true.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 10: Polimorfismo, interfaces y clases abstractas](../unidad10-polimorfismo-interfaces/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 12: Excepciones y manejo de errores](../unidad12-excepciones/README.md)

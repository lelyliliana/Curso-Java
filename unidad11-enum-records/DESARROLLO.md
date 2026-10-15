# Proteger los componentes de un record

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad11-enum-records/laboratorio/Laboratorio.java](../unidad11-enum-records/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

El constructor compacto de Grupo valida nombre, copia temas y exige estado. List.copyOf separa la lista recibida de futuras modificaciones de origen y entrega una lista no modificable. Agregar SQL al ArrayList original no cambia los temas ya conservados en Grupo.

Un record crea componentes finales, pero eso no vuelve inmutables de manera profunda todos los objetos que puedan referenciar. Si un componente contuviera elementos mutables, copiar solo la lista no copiaría cada elemento. Aquí String permite una protección suficiente para esta demostración.

La igualdad del record considera sus componentes. Dos grupos con mismo nombre, lista y estado pueden ser iguales sin ser la misma instancia. No confundas esa política con la identidad por código elegida para buscar un producto del inventario.

La extensión Lectura valida Double.isFinite y estado no nulo en su constructor compacto. Las operaciones posteriores pueden suponer esos requisitos porque ninguna instancia válida omitió esa frontera. No basta validar solo donde se imprime: otro llamador también podría construir el record.

## 3. Construye y contrasta

Construye dos Lectura iguales, una con otro estado y casos NaN/infinito/null. Compara equals y construcción rechazada. En Grupo intenta modificar origen y luego la lista entregada por temas para distinguir copia de entrada y protección de salida.

## Implementación de la parte añadida

Dentro de Laboratorio, junto al enum Estado de la referencia:

```java
record Lectura(double valor, Estado estado) {
    Lectura {
        if (!Double.isFinite(valor)) throw new IllegalArgumentException("Valor finito requerido");
        java.util.Objects.requireNonNull(estado, "Estado requerido");
    }
}
```

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2011%20%E2%80%94%20Enumeraciones%20y%20records%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad11-enum-records%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

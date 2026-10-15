# Soluciones razonadas

## Solución del laboratorio

Un record genera constructor canónico, accesores, equals, hashCode y toString. Sus campos son finales, pero los componentes pueden apuntar a objetos mutables. List.copyOf toma una instantánea no modificable de la lista; sus elementos String son inmutables. Si fueran objetos mutables, la copia seguiría siendo superficial.

La salida prevista es:

```text
Grupo[nombre=A, temas=[Java], estado=ACTIVO]
Copia protegida: 1
Igualdad: true
```

Añade un elemento a la lista origen y observa el record. Intenta grupo.temas().add y localiza el rechazo. Compara dos records con los mismos componentes. Explica la diferencia con identidad mediante ==.

## Solución de la extensión

Escribe un constructor compacto con Double.isFinite y Objects.requireNonNull. No reasignes campos con this: el constructor compacto asigna componentes al finalizar. Usa enum para estados cerrados, sin prometer que impedirá null por sí solo.

## Casos de aceptación

25.0 válido; NaN/infinito rechazados; estado nulo rechazado; dos lecturas iguales tienen equals true.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

Declara Lectura con constructor compacto: rechaza !Double.isFinite(valor) mediante IllegalArgumentException y exige estado con Objects.requireNonNull. Con 20.5 y ACTIVO se construye; NaN e infinitos no. Dos records con componentes equivalentes son iguales. Esta validación no establece que toda temperatura finita sea físicamente correcta: ese límite no forma parte de la práctica.

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

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

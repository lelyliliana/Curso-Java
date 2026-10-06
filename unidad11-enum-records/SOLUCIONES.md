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

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

25.0 válido; NaN/infinito rechazados; estado nulo rechazado; dos lecturas iguales tienen equals true.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

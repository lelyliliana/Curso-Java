# Soluciones razonadas

## Solución del laboratorio

Una lambda necesita un tipo objetivo que sea una interfaz funcional, con un método abstracto principal. Predicate prueba una condición y Function transforma un valor. El cuerpo no ejecuta al declararse: se invoca mediante test o apply. Las variables locales capturadas deben ser finales o efectivamente finales.

La salida prevista es:

```text
[4, 6]
N=4
```

Identifica parámetros y valor devuelto. Cambia and por or y predice resultados. Reescribe par como clase anónima para comparar el contrato. Evita modificar una lista externa dentro del predicate.

## Solución de la extensión

Combina dos Predicate<Producto>. Normaliza una vez el criterio y usa startsWith dentro de la condición. Mantén los predicates sin efectos laterales y devuelve una nueva lista.

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

Cumple ambas:incluido; solo stock:no incluido con and; lista vacía:vacía; original intacto.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

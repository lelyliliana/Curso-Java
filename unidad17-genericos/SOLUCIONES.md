# Soluciones razonadas

## Solución del laboratorio

El origen produce elementos para el método y el destino los consume. El parámetro T relaciona ambos lados. Los tipos genéricos son invariantes: List<Integer> no se asigna a List<Number>, pero puede pasarse como List<? extends Number>. PECS describe este acceso, no impide toda mutación de la lista; por ejemplo puede eliminar elementos si su implementación lo admite.

La salida prevista es:

```text
[1, 2, 3]
Suma: 6.0
```

Copia a List<Number> y a List<Object>. Intenta asignar directamente origen a List<Number> y observa el error de compilación en un archivo aparte. Prueba un destino List.of para distinguir seguridad de tipos de mutabilidad.

## Solución de la extensión

Devuelve Optional.empty si isEmpty y Optional.of(datos.getFirst()) en otro caso, con contrato de elementos no nulos. Si se permite null, decide si representa ausencia o error. El tipo T evita casts del llamador.

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

List<String> devuelve Optional<String>; vacía:empty; [7]:Optional[7]; destino no modificable:UnsupportedOperationException.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

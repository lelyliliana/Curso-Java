# Soluciones razonadas

## Solución del laboratorio

Optional expresa una ausencia prevista en el retorno. No convierte un fallo de red o archivo en ausencia. orElse evalúa su argumento antes de invocar el método, aunque haya valor. orElseGet recibe un proveedor que solo se invoca si falta el valor. Evita get sin verificar y no retornes null en lugar de Optional.empty.

La salida prevista es:

```text
ANA
Invitado
Se calculó alternativa
Ana
```

Consulta código existente y ausente. Predice si se imprime Se calculó alternativa. Sustituye orElse por orElseGet y comprueba. Distingue colección vacía de un valor único ausente.

## Solución de la extensión

Encadena buscar, map al correo, filter para no vacío y map para normalizar. Si buscar devuelve otro Optional, usa flatMap para evitar Optional<Optional<String>>. Define correo inválido por separado si requiere validación real.

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

Usuario ausente:empty; correo vacío:empty; correo válido:presente; fallo de repositorio:propaga error según contrato.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

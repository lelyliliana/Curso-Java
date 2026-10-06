# Soluciones razonadas

## Solución del laboratorio

String es inmutable y sus índices cuentan unidades UTF-16, no necesariamente caracteres percibidos. Un punto de código tampoco equivale siempre a un grafema: algunos símbolos visibles combinan varios. Locale.ROOT evita depender del idioma del equipo para una normalización técnica. No elimina tildes ni hace equivalentes todas las representaciones Unicode.

La salida prevista es:

```text
Identidad: false
Contenido: true
{sol=2, luna=1}
Unidades UTF-16: 2
Puntos de código: 1
```

Predice == y equals. Cambia el locale del proceso y conserva ROOT. Prueba varias separaciones. Cuenta length de una letra, un emoji y una secuencia combinada. Define qué significa longitud para tu aplicación.

## Solución de la extensión

Aplica strip y comprueba isEmpty antes de split, porque split sobre cadena vacía puede producir un elemento vacío. Usa LinkedHashMap si necesitas orden de primera aparición y merge para contar.

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

" Sol sol ": {sol=2}; "  ": {}; "LUNA luna": {luna=2}; una tilde conserva su identidad.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

# Soluciones razonadas

## Solución del laboratorio

La propiedad java.class.version informa la versión de formato de clase soportada por la JVM que ejecuta, no inspecciona el archivo actual. Para inspeccionar el bytecode compilado usa javap -verbose Laboratorio.class y busca major version. release 21 produce major 65 aun si se compila con un JDK posterior.

La salida prevista es:

```text
Versión de clase: 65.0 (al ejecutar con Java 21)
Mensaje del bytecode: versión A
```

Compila. Cambia A por B sin compilar. Ejecuta el .class: todavía dice A. Recompila y vuelve a ejecutar: dice B. Inspecciona el archivo con javap -c y localiza println.

## Solución de la extensión

Registra la salida antes y después de recompilar. Añade javap -verbose para conocer major version. Evita usar la propiedad del sistema como si leyera metadatos del archivo: pertenece a la JVM activa.

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

Fuente B y bytecode A: A. Recompilado: B. JVM compatible: ejecuta; JVM 17 con clase release 21: UnsupportedClassVersionError.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

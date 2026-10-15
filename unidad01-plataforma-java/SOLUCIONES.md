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

## Casos de aceptación

Fuente B y bytecode A: A. Recompilado: B. JVM compatible: ejecuta; JVM 17 con clase release 21: UnsupportedClassVersionError.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

Sin recompilar, se sigue mostrando versión A. Después de javac, aparece B. javap -verbose Laboratorio.class debe indicar major 65 con --release 21. La línea java.class.version puede reflejar otra versión si la JVM activa es posterior. No alteres esa propiedad para que parezca que inspeccionaste el archivo.

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

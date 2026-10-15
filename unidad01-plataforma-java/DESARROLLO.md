# Identificar qué bytecode se ejecuta realmente

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad01-plataforma-java/laboratorio/Laboratorio.java](../unidad01-plataforma-java/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

La fuente contiene versión A como mensaje. javac produce un archivo de clase y java ejecuta ese bytecode. Editar la fuente a versión B sin volver a compilar deja disponible el mensaje anterior en el .class; el comportamiento permite observar que ambos archivos representan etapas distintas.

La propiedad java.class.version describe el formato soportado por la JVM activa. No inspecciona automáticamente el archivo Laboratorio.class. Para leer el formato de ese archivo usa javap -verbose y localiza major version. Una compilación --release 21 genera major 65 incluso si el compilador pertenece a un JDK posterior compatible.

El classpath indica dónde encontrar clases. Si existen varias carpetas con una clase del mismo nombre, puedes ejecutar una copia distinta de la que editaste. Conserva cada laboratorio separado y usa -cp con un destino explícito cuando investigues esa situación.

Una JVM compatible con una versión posterior puede ejecutar el bytecode objetivo dentro de sus garantías de compatibilidad, pero un bytecode más nuevo no se convierte en antiguo por cambiar el nombre del archivo. Revisa compilador, objetivo y JVM como tres datos diferentes.

## 3. Construye y contrasta

Compila A; cambia solo el texto fuente a B; ejecuta sin compilar y después recompila. Registra mensaje, versión de javac, versión de java y major del archivo. Esta tabla permite distinguir una modificación pendiente de una incompatibilidad de plataforma.

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2001%20%E2%80%94%20C%C3%B3mo%20funciona%20Java%3A%20JDK%2C%20JVM%20y%20bytecode%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad01-plataforma-java%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

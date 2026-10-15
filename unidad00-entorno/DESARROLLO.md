# Separar archivo, compilación y ejecución

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad00-entorno/laboratorio/Laboratorio.java](../unidad00-entorno/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

Laboratorio.java declara una clase pública cuyo nombre coincide con el archivo. main es el punto de entrada que ejecuta el lanzador. System.out.println escribe durante esa ejecución; javac transforma fuente en bytecode y no ejecuta los saludos.

Al compilar con --release 21 eliges lenguaje, API y formato compatibles con Java 21. -encoding UTF-8 indica cómo leer el archivo fuente. La codificación con la que la terminal muestra salida es otra decisión; no cambies el texto del programa para ocultar un problema de visualización de tildes.

args contiene argumentos del proceso, no las líneas que una persona escriba después. Ejecutar java Laboratorio Ana Java entrega dos elementos; una cadena entre comillas puede ser un solo argumento aunque tenga espacios. Los comandos se ejecutan desde la carpeta que contiene el bytecode o indicando un classpath adecuado.

Si la compilación falla y todavía existe un .class anterior, ejecutar ese archivo puede mostrar un resultado antiguo. Confirma primero el éxito de javac y después relaciona la salida con el cambio de fuente que acabas de realizar.

## 3. Construye y contrasta

Añade tres líneas con un perfil ficticio y conserva el conteo de argumentos. Compila y ejecuta sin argumentos, con dos y con uno que contenga espacios entre comillas. No escribas los datos después del lanzamiento esperando que args se actualice.

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2000%20%E2%80%94%20Entorno%2C%20JDK%20y%20primer%20programa%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad00-entorno%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

# Delimitar mensajes antes de reservar contenido sin límite

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad23-redes/laboratorio/Laboratorio.java](../unidad23-redes/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

El laboratorio enlaza loopback y solicita puerto 0 para obtener uno libre. Cliente y servidor usan UTF-8, terminan una línea y hacen flush. El servidor recibe un mensaje y devuelve su eco. La comunicación real permite distinguir un procesamiento local de un intercambio TCP.

readLine no impone por sí mismo un límite de longitud. Comprobar length después de recibir ya permitió construir la línea completa. La extensión lee carácter por carácter y rechaza al superar 200 unidades UTF-16 antes de añadir el siguiente carácter al acumulador.

El protocolo elegido utiliza LF como terminador, incluye ECHO| dentro del límite, permite contenido vacío y rechaza CR. EOF antes de LF es un mensaje incompleto. Estas decisiones deben coincidir en ambos extremos; no deduzcas un protocolo solo por cómo se ve una línea en la terminal.

El ejemplo resuelto separa leerLinea y procesar para probarlos sin depender de la planificación de sockets. Al integrarlo al laboratorio usa el Reader UTF-8 y cierra la conexión ante un mensaje rechazado: no intenta resincronizar una conversación completa. Los timeouts de lectura no equivalen a un límite total de todas las escrituras.

## 3. Construye y contrasta

Prueba ECHO|hola, comando desconocido, 200 unidades exactas, 201 y EOF sin terminador. Añade un ensayo de CRLF y documenta que este protocolo concreto lo rechaza. Conserva el intercambio TCP original para verificar el transporte por separado.

## Ejecutar la extensión completa

El archivo [Solucion.java](solucion/Solucion.java) contiene imports, métodos y main. Abre una terminal en la carpeta solucion de esta unidad y ejecuta cada comando por separado:

```text
javac -encoding UTF-8 --release 21 Solucion.java
```

```text
java Solucion
```

La referencia Laboratorio.java permanece en su carpeta original. Las clases sin paquete de unidades diferentes se compilan por separado; no juntes todos sus archivos en una sola compilación.

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2023%20%E2%80%94%20Redes%20con%20sockets%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad23-redes%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

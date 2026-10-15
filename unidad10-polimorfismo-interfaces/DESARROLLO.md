# Añadir comportamiento envolviendo el mismo contrato

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad10-polimorfismo-interfaces/laboratorio/Laboratorio.java](../unidad10-polimorfismo-interfaces/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

La referencia recorre una lista declarada como Notificador y ejecuta enviar sin conocer si la instancia es Consola o Simulado. El contrato del método determina qué puede pedir el llamador; la implementación concreta decide cómo resolverlo.

NotificadorPrefijo también implementa Notificador, pero contiene otro Notificador. Su enviar prepara el mensaje y delega. Así la pieza puede colocarse donde antes se utilizaba el contrato original y no necesita heredar de una consola concreta.

El prefijo se aplica al mensaje antes de entregarlo al destino. Por eso el resultado es Consola: [Curso] Listo. Anteponerlo al resultado del destino produciría otro orden y resolvería una transformación distinta.

La composición puede repetirse: envolver dos veces aplica dos prefijos. No es un fallo automático; es una consecuencia del contrato. Si el producto exigiera exactamente uno, necesitarías definir cómo detectar o evitar envolturas repetidas, sin adivinar a partir de texto arbitrario.

## 3. Construye y contrasta

Compara un notificador simple, uno envuelto y dos envolturas. Verifica que cada enviar se delega una vez por capa. Prueba una dependencia null y explica por qué debe rechazarse al construir, antes de una acción visible.

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

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2010%20%E2%80%94%20Polimorfismo%2C%20clases%20abstractas%20e%20interfaces%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad10-polimorfismo-interfaces%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

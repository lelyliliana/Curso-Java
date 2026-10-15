# Elegir entre importación parcial y aceptación íntegra

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad12-excepciones/laboratorio/Laboratorio.java](../unidad12-excepciones/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

La referencia recorre líneas y captura NumberFormatException dentro del ciclo. Eso permite conservar 10 y 25 mientras informa las líneas inválidas. La lista de errores y la de válidos se copian antes de entregar Resultado; el llamador no recibe los acumuladores mutables.

La extensión estricta tiene otro contrato. Utiliza un candidato local y, si una línea falla, lanza una excepción con número de línea y causa. El método no entrega el candidato parcial. El resultado aceptado solo aparece al completar toda la validación.

No conviertas cualquier excepción en una lista vacía. Ausencia de registros, líneas inválidas y fallo al leer un archivo son situaciones diferentes. Capturar una excepción específica permite preservar esa distinción y evita ocultar defectos ajenos al formato numérico.

La numeración humana comienza en 1, mientras el índice del arreglo comienza en 0. Explicar esa conversión hace que el mensaje pueda relacionarse con la entrada. Los enteros fuera del rango int se rechazan igual que otro formato que parseInt no pueda representar.

## 3. Construye y contrasta

Compara {10,abc,25}: la referencia entrega dos válidos con una incidencia; la estricta no devuelve una lista. Prueba todas válidas, vacío y 2147483648. Comprueba que el mensaje conserve la línea y la causa para diagnóstico.

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

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2012%20%E2%80%94%20Excepciones%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad12-excepciones%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

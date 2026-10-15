# Ordenar fronteras sin aceptar valores no finitos

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad04-decisiones/laboratorio/Laboratorio.java](../unidad04-decisiones/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

El clasificador de notas comprueba primero el dominio y después los rangos. NaN necesita una comprobación explícita porque compararlo con < o > no rechaza su presencia como podrías esperar. Double.isFinite descarta NaN e infinitos antes de decidir una categoría.

Para temperatura, el contrato no impone un mínimo físico en esta actividad: todo número finito inferior a 18 es frío. Exactamente 18 y exactamente 30 son templados; solo lo superior a 30 es caliente. Escribe esas fronteras antes de convertirlas en if.

Una vez descartado lo inferior a 18, la siguiente rama solo necesita comprobar <=30. No hace falta repetir >=18 porque ya lo garantiza el camino recorrido. Ordenar casos permite simplificar sin cambiar el significado.

El switch del laboratorio ilustra opciones discretas del menú. Las flechas impiden el fall-through ordinario de la forma clásica. No conviertas rangos continuos de temperatura en una lista de casos enteros que pierda decimales.

## 3. Construye y contrasta

Contrasta 17.99,18,30,30.01,NaN e infinito. Registra resultado o excepción, no solo si el programa terminó. Cambiar <=30 por <30 debe producir una diferencia observable precisamente en la frontera 30.

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

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2004%20%E2%80%94%20Decisiones%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad04-decisiones%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

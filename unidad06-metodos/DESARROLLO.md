# Separar copia de referencia y copia de elementos

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad06-metodos/laboratorio/Laboratorio.java](../unidad06-metodos/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

El llamador conserva numero=10 porque el método recibe su valor y asigna otro solo a la variable local. El parámetro del arreglo también se pasa por valor, pero ese valor es una referencia al mismo objeto. Modificar valores[0] afecta el arreglo compartido; reasignar valores a otro arreglo solo cambia el parámetro local.

La extensión duplicar crea otro arreglo y llena cada posición con el doble. No reutiliza datos como destino. Cambiar después una posición de la copia no debe alterar el original; esa observación demuestra más que comparar dos salidas visualmente iguales.

La multiplicación también tiene un contrato de rango. Math.multiplyExact rechaza un resultado int que no cabe en vez de aceptar un número desbordado. Si una posición falla, el arreglo original continúa intacto; la copia parcial no se publica como resultado del método.

El nombre duplicar puede significar copiar o multiplicar por dos según el enunciado. Aquí se declara explícitamente multiplicar cada elemento y devolver otro arreglo. Esa precisión evita evaluar dos programas distintos como si resolvieran exactamente el mismo problema.

## 3. Construye y contrasta

Con {3,-2,0}, espera {6,-4,0}. Modifica la copia a {100,-4,0} y comprueba que el original sigue igual. Prueba vacío y Integer.MAX_VALUE. Relaciona la excepción con la multiplicación, no con un índice incorrecto.

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

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2006%20%E2%80%94%20M%C3%A9todos%20y%20modularizaci%C3%B3n%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad06-metodos%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

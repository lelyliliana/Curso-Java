# Conservar unidades y orden de evaluación

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad02-datos-operadores/laboratorio/Laboratorio.java](../unidad02-datos-operadores/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

El valor 7385 se descompone sin modificar el total: división entre 3600 obtiene horas; el residuo de esa división contiene lo que queda para minutos y segundos. Dividir ese residuo por 60 produce minutos y %60 deja segundos. Los minutos y segundos finales están entre 0 y 59.

5/2 se calcula como división entera antes de asignarlo a cualquier variable receptora. Para obtener 2.5 debe participar un operando decimal en la operación. El mismo principio explica el desbordamiento: convertir a long después de una suma int conserva el resultado ya desbordado.

La extensión recibe segundos no negativos y devuelve un record con las tres partes. El tipo int admite una duración finita; no promete representar cualquier cantidad arbitraria de tiempo. Un total negativo se rechaza antes de usar las reglas de división, cuyo significado ya no coincidiría con este contrato.

El formato %02d agrega un cero de presentación. No cambia el número ni convierte minutos en una cadena almacenada como dato de negocio. Conserva separadas representación y cálculo.

## 3. Construye y contrasta

Prueba 0, 59, 60, 3599, 3600 y 7385. Reconstruye total con horas*3600 + minutos*60 + segundos y verifica que coincide. Contrasta -1 como rechazo y explica por qué truncar no significa redondear al entero más próximo.

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

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2002%20%E2%80%94%20Variables%2C%20tipos%20y%20operadores%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad02-datos-operadores%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

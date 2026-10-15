# Construir una condición compuesta sin ejecutarla al declararla

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad18-lambdas/laboratorio/Laboratorio.java](../unidad18-lambdas/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

par y grande son Predicate<Integer>. Declararlos construye valores funcionales; filtrar los invoca mediante test sobre cada dato. par.and(grande) acepta números pares y mayores que tres, por lo que la referencia entrega 4 y 6.

Function<Integer,String> transforma el valor 4 en N=4. Predicate decide aceptación y Function produce otro valor: distinguir sus contratos permite seleccionar una interfaz funcional adecuada antes de escribir la lambda.

La extensión compone stock positivo y prefijo de nombre. Normaliza el texto con una política de mayúsculas conocida y declara qué significa letra. No cambies el stock dentro de la condición para registrar que se visitó un producto: un filtro debería seleccionar sin alterar esos registros.

Las variables locales capturadas deben ser finales o efectivamente finales. Esto no vuelve inmutables todos los objetos alcanzables mediante una referencia capturada. Mantén los predicados libres de efectos innecesarios y prueba condiciones que pasen solo una de las dos partes.

## 3. Construye y contrasta

Usa Cuaderno con stock 2, Cable con stock 0 y Libro con stock 4. Para prefijo C solo debe quedar Cuaderno. Prueba también un nombre que pase el prefijo pero no el stock, y uno que pase el stock pero no el prefijo.

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2018%20%E2%80%94%20Lambdas%20e%20interfaces%20funcionales%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad18-lambdas%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

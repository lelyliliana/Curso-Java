# Refactorizar preservando resultados, redondeo y errores

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad28-buenas-practicas/laboratorio/Laboratorio.java](../unidad28-buenas-practicas/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

Las dos funciones del laboratorio suman long y rechazan precios negativos. La segunda extrae validar para dar nombre a una responsabilidad. Ambas usan Math.addExact y, por tanto, deben rechazar el mismo desbordamiento.

El enunciado del impuesto necesita además una política explícita: base no negativa, tasa decimal entre 0 y 1, y total con dos decimales HALF_UP al final. Sin fijar cuándo redondear, dos versiones pueden parecer equivalentes con entradas simples y diferir en valores pequeños.

La solución conserva una versión directa y otra con validación extraída. Compara valor y escala mediante BigDecimal.equals porque el contrato de presentación fija escala 2. Para una regla de magnitud sin escala, compareTo respondería otra pregunta.

Extraer métodos no convierte automáticamente un diseño en mejor. Mantén nombres relacionados con la regla y evita añadir jerarquías para una multiplicación. Las pruebas comparan casos definidos y rechazos; no constituyen una demostración formal para toda entrada posible.

## 3. Construye y contrasta

Compara base 0, base 100 con tasa 0.19 y base 0.05 con tasa 0.10. Añade base negativa y tasa fuera de rango. Registra en qué punto se aplica el redondeo y conserva esa decisión antes y después de refactorizar.

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

## Comparar las versiones ejecutables

[Solucion.java](solucion/Solucion.java) contiene ambas versiones y casos de redondeo/rechazo. Desde la carpeta solucion, ejecuta por separado:

```text
javac -encoding UTF-8 --release 21 Solucion.java
```

```text
java Solucion
```

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2028%20%E2%80%94%20Buenas%20pr%C3%A1cticas%20y%20refactorizaci%C3%B3n%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad28-buenas-practicas%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

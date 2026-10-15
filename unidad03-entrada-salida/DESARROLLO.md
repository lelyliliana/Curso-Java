# Leer líneas completas y validar antes del cálculo

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad03-entrada-salida/laboratorio/Laboratorio.java](../unidad03-entrada-salida/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

Cada campo se lee mediante nextLine y se comprueba hasNextLine antes de consumirlo. Así un fin de entrada no se confunde con una línea vacía ni deja un acceso sin datos. El nombre se recorta antes de decidir si está vacío.

Integer.parseInt convierte la cantidad y rechaza letras o un entero fuera de rango. BigDecimal construido desde texto conserva el valor decimal sin introducir primero una aproximación de double. El laboratorio solo exige positividad del precio; la política de dos decimales se introduce de forma explícita en el inventario.

Una conversión correcta no implica un dato aceptable: cantidad -2 es un entero válido y un valor fuera del dominio de esta factura. Por eso se separan formato y condiciones de negocio. El cálculo ocurre después de ambas etapas.

La extensión añade máximo 40 unidades UTF-16 al nombre y muestra su confirmación antes de calcular. Confirmar aquí significa volver a mostrar el nombre normalizado; no es una nueva respuesta sí/no a menos que decidas ampliar ese contrato. length cuenta unidades UTF-16, no siempre caracteres visuales.

## 3. Construye y contrasta

Prueba un nombre de 40 y otro de 41 unidades, cantidad no numérica, cantidad cero y EOF en cada campo. Verifica qué casos llegan al producto precio*cantidad y cuáles terminan con un aviso sin total.

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2003%20%E2%80%94%20Entrada%2C%20salida%20y%20conversiones%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad03-entrada-salida%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

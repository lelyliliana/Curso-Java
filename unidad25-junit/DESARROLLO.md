# Escoger entradas que distingan implementaciones defectuosas

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad25-junit/ejemplos/CalculadoraTest.java](../unidad25-junit/ejemplos/CalculadoraTest.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

La suite declara un contrato de división entera. 7/2 produce 3, -7/2 produce -3 y 0/2 produce 0. Esa política trunca hacia cero y no equivale a piso matemático para todos los negativos.

Una implementación que devuelve siempre 3 pasa el primer caso y falla los otros. Elegir casos diferentes por su capacidad de distinguir defectos aporta más que repetir muchas sumas positivas equivalentes. assertThrows comprueba que divisor cero se rechaza; no necesitas probar un método privado para observar esa regla.

El borde Integer.MIN_VALUE/-1 conserva el comportamiento ordinario int definido para esta práctica: produce Integer.MIN_VALUE. Si decidieras detectar desbordamiento en la API, tendrías que cambiar contrato e implementación juntos, en vez de modificar una expectativa para conseguir una prueba verde.

Maven ejecuta las pruebas desde esta unidad mediante su testSourceDirectory. La clase de ejemplo y sus tests están reunidos para el aprendizaje; no constituyen un patrón obligatorio de organización para todas las aplicaciones.

## 3. Construye y contrasta

Ejecuta mvn test. Relaciona cada caso con un error que detectaría. En una copia sustituye la división por return 3 y observa fallos pertinentes; restaura la implementación y verifica el borde negativo extremo.

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2025%20%E2%80%94%20Pruebas%20con%20JUnit%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad25-junit%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

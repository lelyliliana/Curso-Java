# Seguir las fases y producir un JAR que pueda ejecutarse

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad24-maven/ejemplos/proyecto-minimo/pom.xml](../unidad24-maven/ejemplos/proyecto-minimo/pom.xml) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

El pom declara coordenadas, objetivo de compilación, dependencias y plugins. Las clases de producción están en src/main/java y las pruebas en src/test/java. La raíz del curso tiene otro pom para el inventario; ejecutar Maven desde una carpeta distinta cambia qué proyecto construyes.

package incluye fases anteriores, entre ellas test, salvo que cambies explícitamente la ejecución. El plugin jar incluye Main-Class en el manifiesto y permite java -jar. Escribir un main no garantiza por sí solo que cualquier JAR tenga esa entrada configurada.

La extensión extrae la responsabilidad de saludar a Saludo. Main puede delegar y conservar su API para las pruebas anteriores. Así se estudia una separación concreta y no una carpeta añadida sin responsabilidad.

maven.compiler.release=21 no instala Java ni cambia la JVM que ejecuta Maven. Confirma mvn -version cuando investigues una incompatibilidad. Fijar versiones y ejecutar desde el proyecto correcto permite reproducir una construcción mejor que cambiar dependencias al azar.

## 3. Construye y contrasta

Ejecuta test y package desde proyecto-minimo. Abre los informes para comprobar que se ejecutaron pruebas. Ejecuta el JAR y espera Hola, Java. Cambia un saludo esperado en una copia para confirmar que la prueba detecta el cambio y luego restáuralo.

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2024%20%E2%80%94%20Maven%20y%20estructura%20de%20proyectos%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad24-maven%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

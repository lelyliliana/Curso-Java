# Java actual y decisiones del curso

## Una referencia compatible, con herramientas actualizadas

Los ejemplos compilan con release 21. Esta decisión permite enseñar records, pattern matching con instanceof, expresiones switch, bloques de texto, Stream API y virtual threads sin activar preview. El curso no afirma que Java 21 sea la versión más reciente.

JUnit Jupiter se utiliza en su generación 6 (6.1.3), que requiere Java 17 o posterior; Java 21 satisface esa base. Los paquetes siguen siendo org.junit.jupiter.api: cambiar de generación no convierte @Test en otra anotación ni exige migrar a JUnit 4.

Maven 3.9.16, Mockito 5.24.0 y las versiones de plugins están fijados en los pom. Mockito se añade como agente al proceso de pruebas, con la ruta del repositorio local resuelta por Maven. Esto evita depender de la carga dinámica automática del agente. No copies la ruta personal de quien escribió una prueba.

## Características que debes distinguir

| Recurso | Aporta | No garantiza |
|---|---|---|
| var local | Inferencia estática | Tipo dinámico |
| record | Portador con componentes finales e igualdad generada | Copia profunda |
| switch con flechas | Selección clara y expresión de valor | Validación automática de cualquier dominio |
| Stream | Pipeline sobre una fuente | Almacenamiento ni mejora de rendimiento automática |
| Optional | Ausencia prevista en el retorno | Conversión de fallos en resultados válidos |
| virtual threads | Concurrencia de muchas tareas, especialmente espera de I/O | Más velocidad de cálculo ni ausencia de carreras |
| --release 21 | Lenguaje, API y bytecode compatibles con 21 | Cambio de la JVM que ejecuta Maven |

## Pattern matching y sealed

Java 21 permite expresar ciertas descomposiciones y alternativas cerradas. No sustituyas todas las interfaces por sealed ni todos los if por patrones: una jerarquía cerrada sirve cuando el dominio realmente controla sus variantes. El curso presenta estos recursos en el contexto de modelado, sin obligarlos en el inventario.

## Rendimiento y rigor

Comparar una ejecución secuencial con otra concurrente sirve para formular hipótesis. Una sola corrida incluye calentamiento JIT, asignaciones, cachés y ruido del sistema. Los ejercicios no son un benchmark profesional ni una promesa de rendimiento. Del mismo modo, una corrida del contador incorrecto puede coincidir con el valor esperado y seguir teniendo una carrera.

## Fuera del alcance del proyecto de consola

El inventario no incorpora Spring, base de datos, GUI, autenticación, servicio web ni acceso simultáneo desde varios procesos. Estos temas requieren requisitos y comprobaciones propios. No se añade concurrencia artificial a una aplicación cuyos comandos se atienden secuencialmente.

[Referencias](REFERENCIAS.md) · [Volver al índice](../README.md)

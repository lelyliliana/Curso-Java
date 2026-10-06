# Soluciones razonadas

## Solución del laboratorio

System.getProperty consulta propiedades de la JVM; System.getenv consulta variables del proceso. Son mecanismos diferentes. Un valor predeterminado solo se aplica ante ausencia, no ante formato incorrecto. java.util.logging pertenece al JDK y permite niveles sin añadir un framework. La marca temporal del log no forma parte de la salida estable del ejercicio.

La salida prevista es:

```text
Límite: 3 (más un registro INFO con fecha y formato dependientes del entorno)
```

Ejecuta con -Dcurso.limite=5 antes del nombre de la clase. Repite con 0 y abc. Pon un breakpoint tras parseInt y compara hipótesis con valor observado. No imprimas el entorno completo para depurar.

## Solución de la extensión

Extrae validarPuerto(String) y prueba su contrato como función. Usa un valor por defecto solo si falta la propiedad. Devuelve error para número fuera del rango o formato inválido. No sustituyas un error por un puerto silenciosamente.

No reemplaces una regla por un resultado fijo. El objetivo es que el programa cumpla el contrato con otras entradas válidas y rechace los errores indicados.

## Casos de aceptación

Ausente:valor por defecto; 5000:válido; 80:fuera de política; abc:formato; 65536:fuera de rango.

Verifica tanto el valor como el estado posterior cuando hay cambios. Si una excepción es parte del contrato, documenta su tipo y el punto donde se origina; si es un error de entrada recuperable, explica qué muestra el programa y cómo termina o continúa.

## Cómo revisar tu explicación

Puedes justificar tu respuesta si distingues entrada, transformación y resultado sin depender del nombre de una herramienta. Una alternativa es válida cuando preserva el contrato y puedes explicar su costo y límites.

Vuelve a ejecutar el laboratorio original para confirmar que tu extensión no alteró el ejemplo de referencia.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

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

## Casos de aceptación

Ausente:valor por defecto; 5000:válido; 80:fuera de política; abc:formato; 65536:fuera de rango.

[Volver a la práctica](PRACTICA.md) · [Volver a la unidad](README.md)

## Resolución concreta de la práctica

La función de lectura usa System.getProperty("curso.puerto","8080"), convierte con Integer.parseInt y exige 1024<=puerto<=65535. Ausente devuelve 8080; 1023 y 65536 se rechazan; abc falla por formato. Ejecuta -Dcurso.puerto=9000 antes de la clase. Esta configuración no reserva el puerto ni comprueba su disponibilidad.

## Implementación de la parte añadida

Método dentro de Laboratorio; main puede mostrar el puerto o capturar IllegalArgumentException:

```java
static int leerPuerto() {
    int puerto = Integer.parseInt(System.getProperty("curso.puerto", "8080"));
    if (puerto < 1024 || puerto > 65535)
        throw new IllegalArgumentException("Puerto entre 1024 y 65535");
    return puerto;
}
```

[Seguir el desarrollo del código](DESARROLLO.md) · [Volver a la práctica](PRACTICA.md)

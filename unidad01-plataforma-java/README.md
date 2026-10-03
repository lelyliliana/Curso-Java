# Unidad 01 — JDK, JVM y bytecode

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Comprender las piezas principales de la plataforma Java y localizar en qué etapa ocurre un problema.

# 1. Tres términos que no son lo mismo

## JDK
Java Development Kit: herramientas para desarrollar. Incluye compilador y otras utilidades.

## JVM
Java Virtual Machine: ejecuta bytecode y proporciona el entorno de ejecución a nivel de máquina virtual.

## Bytecode
Instrucciones intermedias almacenadas normalmente en `.class`.

```text
.java → javac → .class → JVM → ejecución
```

# 2. ¿Dónde está el lenguaje?

Java es el lenguaje con el que escribimos `.java`.

La JVM no ejecuta directamente “el texto Java” del archivo fuente en el flujo clásico que estamos estudiando: ejecuta bytecode.

# 3. Portabilidad

Una idea conocida es “write once, run anywhere”.

El bytecode puede ejecutarse en JVM compatibles de diferentes plataformas.

Pero una aplicación real puede depender de:
- rutas de archivos;
- bibliotecas nativas;
- configuración;
- codificación;
- sistema operativo.

La portabilidad no significa que todo programa sea automáticamente independiente del entorno.

# 4. Compilación vs ejecución

Error:
```java
int x = "hola";
```

El compilador detecta incompatibilidad de tipos.

Otro:
```java
int x = 10 / 0;
```

Dependiendo de cómo esté expresado, ciertos errores pueden detectarse al compilar o manifestarse en ejecución; por ejemplo, dividir un entero por una variable cuyo valor en ejecución es cero produce una excepción.

Aprende a preguntar:
> ¿el programa llegó a ejecutarse?

# 5. JRE como concepto

Históricamente se hablaba mucho de JRE como paquete de ejecución. La distribución moderna de Java y los proveedores pueden empaquetar runtimes de distintas formas.

Para este curso instala/utiliza un JDK y evita depender de terminología de paquetes antiguos para diagnosticar tu entorno.

# 6. Versiones

```bash
java --version
javac --version
```

Si reportan versiones diferentes, revisa PATH/JAVA_HOME/configuración.

El curso usa Java 21 como referencia.

# 7. Práctica guiada

1. Compila HolaJava.
2. Observa .class.
3. Modifica fuente sin recompilar.
4. Ejecuta de nuevo el .class.
5. Explica por qué no refleja todavía el cambio.
6. Recompila y ejecuta.

Así compruebas la separación fuente/bytecode.

# 8. Errores frecuentes
- JVM = JDK.
- .class = código fuente.
- “Java es interpretado/compilado” como dicotomía simplista: existe compilación a bytecode y la JVM puede interpretar/JIT compilar internamente.
- Suponer portabilidad absoluta.

# 9. Ejercicios
Clasifica situaciones por etapa: fuente, compilación, bytecode, ejecución.

# 10. Reto
Explica el ciclo Java a alguien que viene de un lenguaje ejecutado de forma diferente, usando un diagrama propio.

# 11. Autoevaluación
1. ¿JDK/JVM?
2. ¿Qué produce javac?
3. ¿Qué ejecuta JVM?
4. ¿Por qué modificar .java no cambia el .class existente?
5. ¿Portabilidad significa cero dependencias?

# 12. Checklist
- [ ] Distingo JDK/JVM.
- [ ] Comprendo bytecode.
- [ ] Localizo etapa de error.
- [ ] Comprendo versión/entorno.

Continúa con datos y operadores.


---

## Continuar el curso

- **Unidad anterior:** [Unidad 00 — Entorno, JDK y primer programa](../unidad00-entorno/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 02 — Variables, tipos y operadores](../unidad02-datos-operadores/README.md)

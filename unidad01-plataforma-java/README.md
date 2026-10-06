# Unidad 01: JDK, JVM y bytecode

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Comprender las piezas principales de la plataforma Java y localizar en qué etapa ocurre un problema.

## 1. Tres términos que no son lo mismo

## JDK
Java Development Kit: herramientas para desarrollar. Incluye compilador y otras utilidades.

## JVM
Java Virtual Machine: ejecuta bytecode y proporciona el entorno de ejecución a nivel de máquina virtual.

## Bytecode
Instrucciones intermedias almacenadas normalmente en `.class`.

```text
.java → javac → .class → JVM → ejecución
```

## 2. ¿Dónde está el lenguaje?

Java es el lenguaje con el que escribimos `.java`.

La JVM no ejecuta directamente “el texto Java” del archivo fuente en el flujo clásico que estamos estudiando: ejecuta bytecode.

## 3. Portabilidad

Una idea conocida es “write once, run anywhere”.

El bytecode puede ejecutarse en JVM compatibles de diferentes plataformas.

Pero una aplicación real puede depender de:
- rutas de archivos;
- bibliotecas nativas;
- configuración;
- codificación;
- sistema operativo.

La portabilidad no significa que todo programa sea automáticamente independiente del entorno.

## 4. Compilación vs ejecución

Error:
```java
int x = "hola";
```

El compilador detecta incompatibilidad de tipos.

Otro:
```java
int x = 10 / 0;
```

La división entera por cero produce ArithmeticException cuando se evalúa, incluso en `int x = 10 / 0;`. No es una incompatibilidad de tipos como asignar texto a int. Algunos contextos que exigen una expresión constante, como una etiqueta case, imponen reglas adicionales de compilación. La división flotante tiene otra semántica: puede producir infinito o NaN.

Aprende a preguntar:
> ¿el programa llegó a ejecutarse?

## 5. JRE como concepto

Históricamente se hablaba mucho de JRE como paquete de ejecución. La distribución moderna de Java y los proveedores pueden empaquetar runtimes de distintas formas.

Para este curso instala/utiliza un JDK y evita depender de terminología de paquetes antiguos para diagnosticar tu entorno.

## 6. Versiones

```bash
java --version
javac --version
```

Si reportan versiones diferentes, revisa PATH/JAVA_HOME/configuración.

El curso usa Java 21 como referencia.

## 7. Práctica guiada

1. Compila HolaJava.
2. Observa .class.
3. Modifica fuente sin recompilar.
4. Ejecuta de nuevo el .class.
5. Explica por qué no refleja todavía el cambio.
6. Recompila y ejecuta.

Así compruebas la separación fuente/bytecode.

## 8. Errores frecuentes
- JVM = JDK.
- .class = código fuente.
- “Java es interpretado/compilado” como dicotomía simplista: existe compilación a bytecode y la JVM puede interpretar/JIT compilar internamente.
- Suponer portabilidad absoluta.

## 9. Ejercicios
Clasifica situaciones por etapa: fuente, compilación, bytecode, ejecución.

## 10. Reto
Explica el ciclo Java a alguien que viene de un lenguaje ejecutado de forma diferente, usando un diagrama propio.

## 11. Autoevaluación
1. ¿JDK/JVM?
2. ¿Qué produce javac?
3. ¿Qué ejecuta JVM?
4. ¿Por qué modificar .java no cambia el .class existente?
5. ¿Portabilidad significa cero dependencias?

## 12. Checklist
- [ ] Distingo JDK/JVM.
- [ ] Comprendo bytecode.
- [ ] Localizo etapa de error.
- [ ] Comprendo versión/entorno.

Continúa con datos y operadores.


## Laboratorio completo: observar, explicar y modificar

La propiedad java.class.version informa la versión de formato de clase soportada por la JVM que ejecuta, no inspecciona el archivo actual. Para inspeccionar el bytecode compilado usa javap -verbose Laboratorio.class y busca major version. release 21 produce major 65 aun si se compila con un JDK posterior.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad01-plataforma-java/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

### Paso 2. Compila

```text
javac -encoding UTF-8 --release 21 Laboratorio.java
```

`-encoding` define cómo se lee el código fuente y `--release` fija lenguaje, API y formato de clase compatibles con Java 21. Son decisiones diferentes. Si el comando falla, corrige el primer error relevante antes de ejecutar un bytecode antiguo.

### Paso 3. Ejecuta

```text
java Laboratorio
```

Compara la salida con el resultado previsto. Los valores se eligieron para hacer visible el comportamiento de esta unidad.

```text
Versión de clase: 65.0 (al ejecutar con Java 21)
Mensaje del bytecode: versión A
```

### Paso 4. Recorre la lógica

Compila. Cambia A por B sin compilar. Ejecuta el .class: todavía dice A. Recompila y vuelve a ejecutar: dice B. Inspecciona el archivo con javap -c y localiza println.

### Paso 5. Lee el código completo

```java
public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        System.out.println("Versión de clase: " + System.getProperty("java.class.version"));
        System.out.println("Mensaje del bytecode: versión A");
    }

    
}
```

### Paso 6. Comprueba y extiende

Fuente B y bytecode A: A. Recompilado: B. JVM compatible: ejecuta; JVM 17 con clase release 21: UnsupportedClassVersionError.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 00: Entorno, JDK y primer programa](../unidad00-entorno/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 02: Variables, tipos y operadores](../unidad02-datos-operadores/README.md)


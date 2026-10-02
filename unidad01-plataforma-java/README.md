# Unidad 01 — JDK, JVM y bytecode

## Objetivo
Comprender qué ocurre entre el código fuente y la ejecución.

## Conceptos
**JDK:** herramientas para desarrollar, incluido compilador.

**JVM:** máquina virtual que ejecuta bytecode.

**Bytecode:** instrucciones intermedias almacenadas normalmente en archivos .class.

```text
.java
 ↓ javac
.class (bytecode)
 ↓ JVM
programa ejecutándose
```

## Portabilidad
El mismo bytecode puede ejecutarse sobre JVM compatibles en distintos sistemas, aunque aplicaciones reales también pueden depender de archivos, bibliotecas nativas o entorno.

## Compilación vs ejecución
Un error puede ocurrir antes de ejecutar o durante la ejecución. Distinguir la etapa mejora el diagnóstico.

## Ejercicios
1. Identifica archivos antes/después de javac.
2. Explica JDK vs JVM.
3. Clasifica errores como compilación o ejecución.

## Reto
Explica el ciclo de un programa Java a alguien que solo ha utilizado lenguajes interpretados.

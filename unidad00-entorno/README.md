# Unidad 00 — Entorno, JDK y primer programa

## Objetivo
Preparar un entorno Java 21 y ejecutar un programa desde terminal antes de depender de un IDE.

## Comprobar instalación
```bash
java --version
javac --version
```

Ambos deben corresponder al JDK esperado.

## Primer programa
```java
public class HolaJava {
    public static void main(String[] args) {
        System.out.println("Hola, Java");
    }
}
```

Guardar como `HolaJava.java`.

Compilar:
```bash
javac HolaJava.java
```

Ejecutar:
```bash
java HolaJava
```

## Qué ocurrió
```text
HolaJava.java → javac → HolaJava.class → JVM → ejecución
```

## Diagnóstico
### java funciona pero javac no
Probablemente existe un runtime/configuración incompleta o PATH diferente al JDK.

### “class ... is public, should be declared...”
El nombre del archivo debe coincidir con la clase pública.

## Ejercicios
1. Cambia el mensaje.
2. Imprime tres líneas.
3. Provoca deliberadamente un error de sintaxis y lee el diagnóstico.

## Reto
Crea un programa que presente nombre, área de interés y tres tecnologías, compilándolo y ejecutándolo desde terminal.

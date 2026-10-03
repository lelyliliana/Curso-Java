# Unidad 00 — Entorno, JDK y primer programa

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Preparar Java 21, distinguir compilación/ejecución y diagnosticar los primeros errores desde terminal.

## Antes de empezar
Se recomienda haber estudiado fundamentos de algoritmos. No necesitas experiencia previa con Java.

# 1. Comprobar el JDK

En terminal:

```bash
java --version
javac --version
```

Necesitamos ambas herramientas.

- `java`: ejecuta aplicaciones/clases mediante la plataforma Java.
- `javac`: compila código fuente Java.

Si `java` existe y `javac` no, probablemente no estás usando un JDK completo o el PATH no apunta correctamente.

# 2. Primer archivo

Crea `HolaJava.java`:

```java
public class HolaJava {
    public static void main(String[] args) {
        System.out.println("Hola, Java");
    }
}
```

Java distingue mayúsculas/minúsculas.

Si la clase pública se llama `HolaJava`, el archivo debe llamarse `HolaJava.java`.

# 3. Compilar

```bash
javac HolaJava.java
```

Si no hay errores, aparecerá normalmente:

```text
HolaJava.class
```

No es el código fuente: contiene bytecode para la JVM.

# 4. Ejecutar

```bash
java HolaJava
```

No escribas `java HolaJava.class`.

Salida:

```text
Hola, Java
```

# 5. Flujo

```text
HolaJava.java
      ↓ javac
HolaJava.class
      ↓ java / JVM
programa ejecutándose
```

# 6. main

```java
public static void main(String[] args)
```

Es el punto de entrada tradicional para esta aplicación.

Por ahora reconoce su forma. `public`, `static`, métodos y arrays se comprenderán progresivamente.

No necesitas memorizar palabras que aún no entiendes.

# 7. Primer diagnóstico

## Error de compilación

Quita un `;`:

```java
System.out.println("Hola")
```

Ejecuta `javac`.

Lee:
- archivo;
- línea;
- mensaje;
- indicador aproximado.

Corrige y recompila.

## Error de nombre

Si guardas la clase pública `HolaJava` en `Prueba.java`, javac te indicará la incompatibilidad.

# 8. Terminal antes del IDE

Un IDE ayuda muchísimo, pero aprender primero:

```text
archivo → compilador → .class → ejecución
```

evita que Java parezca “magia del botón Run”.

Después podrás usar VS Code, IntelliJ u otro entorno comprendiendo qué automatiza.

# 9. Práctica guiada

1. Comprueba versiones.
2. Crea HolaJava.java.
3. Compila.
4. Lista archivos.
5. Ejecuta.
6. Cambia el mensaje.
7. Provoca un error.
8. Corrígelo.

# 10. Errores frecuentes
- Ejecutar desde carpeta equivocada.
- Nombre archivo/clase diferente.
- `javac` no disponible.
- Intentar ejecutar `.java` con un flujo que no corresponde a la práctica.
- Copiar comandos sin mirar el directorio actual.

# 11. Ejercicios
1. Tres líneas.
2. Presentación personal ficticia.
3. Texto con números.
4. Provoca dos errores de compilación y documenta qué significan.

# 12. Reto
Crea un programa que presente un perfil tecnológico ficticio. Compílalo y ejecútalo únicamente desde terminal.

# 13. Autoevaluación
1. ¿Qué hace javac?
2. ¿Qué archivo genera?
3. ¿Qué hace java?
4. ¿Por qué importa el nombre del archivo?
5. ¿Qué diferencia hay entre código fuente y bytecode?

# 14. Checklist
- [ ] Tengo JDK.
- [ ] Compilo.
- [ ] Ejecuto.
- [ ] Leo errores básicos.
- [ ] Comprendo el flujo.

Continúa con la plataforma Java.


---

## Continuar el curso

- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 01 — JDK, JVM y bytecode](../unidad01-plataforma-java/README.md)

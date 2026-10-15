# Validar configuración sin confundir su origen

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad27-diagnostico/laboratorio/Laboratorio.java](../unidad27-diagnostico/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

System.getProperty lee propiedades de la JVM y System.getenv lee variables del proceso. El laboratorio usa curso.limite con valor por defecto 3. Ese predeterminado se aplica por ausencia, no como una excusa para ignorar cualquier valor incorrecto.

La extensión usa curso.puerto con default 8080 y rango 1024..65535. parseInt comprueba representación int y una condición posterior comprueba el rango del ejercicio. Aceptar el número no demuestra que el puerto esté libre ni que puedas abrir un servidor en la interfaz deseada.

Logger.info escribe un mensaje cuyo prefijo temporal y formato pueden variar. La verificación debe observar el contenido relevante sin fijar la fecha de una ejecución. No registres credenciales para demostrar que la configuración llegó a la aplicación.

Los parámetros -D pertenecen al lanzador de Java y deben ir antes de la clase principal. Escribirlos después los convertiría en argumentos de main y System.getProperty no los recibiría como esperabas.

## 3. Construye y contrasta

Prueba propiedad ausente,8080,1023,65535,65536 y texto no numérico. Registra qué valores fallan por formato o por rango. Confirma que una propiedad inválida no se reemplaza silenciosamente por 8080.

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

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2027%20%E2%80%94%20Logging%2C%20depuraci%C3%B3n%20y%20manejo%20de%20configuraci%C3%B3n%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad27-diagnostico%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

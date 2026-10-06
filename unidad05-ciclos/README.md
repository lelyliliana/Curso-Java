# Unidad 05: Ciclos en Java

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Implementar repeticiones con for, while, do-while y for-each y reconocer errores de límites e infinitos.

## 1. for

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

Tres partes:
```text
inicialización; condición; actualización
```

Traza i antes de escribir código complejo.

## 2. Error off-by-one

Para índices de un arreglo de longitud n:
```java
for (int i = 0; i < n; i++)
```

Usar `i <= n` intentaría acceder a una posición fuera del rango si utilizas i como índice.

## 3. while

```java
int saldo = 3;
while (saldo > 0) {
    System.out.println(saldo);
    saldo--;
}
```

Úsalo cuando la cantidad de iteraciones depende de una condición.

Pregunta: ¿qué cambia la condición?

## 4. do-while

```java
int intentos = 0;
do {
    intentos++;
} while (intentos < 3);
```

El cuerpo se ejecuta al menos una vez.

Puede ser útil para ciertos menús/validaciones, aunque el diseño debe seguir siendo claro.

## 5. for-each

```java
for (int valor : valores) {
    System.out.println(valor);
}
```

Recorre valores. Si necesitas índice, otro recorrido puede ser más apropiado.

## 6. Contador/acumulador

```java
int cantidad = 0;
double suma = 0.0;
```

Dentro:
```java
cantidad++;
suma += valor;
```

## 7. Centinela

```java
int valor = scanner.nextInt();

while (valor != -1) {
    System.out.println("Aceptado: " + valor);
    valor = scanner.nextInt();
}
```

No incluyas -1 en estadísticas.

## 8. Máximo/mínimo

No inicialices `maximo=0` si pueden existir negativos.

Para datos almacenados puedes usar el primer elemento. Para streaming, trata especialmente el primer dato válido.

## 9. break y continue

Existen y son útiles, pero no deben ocultar un flujo que podría expresarse más claramente.

`break`: termina el ciclo.  
`continue`: pasa a la siguiente iteración.

## 10. Ciclo infinito

```java
int i=0;
while (i<10) {
    System.out.println(i);
}
```

i no cambia.

## 11. Práctica guiada

Lee valores hasta -1 y calcula:
- cantidad;
- suma;
- promedio;
- mayor;
- menor.

Define el caso donde el primer valor es -1.

## 12. Errores frecuentes
- < vs <=.
- actualización incorrecta.
- centinela incluido.
- división entre cero.
- máximo inicial incorrecto.
- modificar colección mientras for-each sin comprender reglas.

## 13. Ejercicios
Tabla, factorial, suma, promedio, máximo/mínimo, centinela y validación.

## 14. Reto
Estadísticas sin almacenar todos los datos. Documenta estado que necesitas mantener.

## 15. Autoevaluación
1. ¿Cuándo for/while?
2. ¿Qué garantiza do-while?
3. ¿for-each da índice?
4. ¿Qué es off-by-one?
5. ¿Cómo evitar infinito?

## 16. Checklist
- [ ] Elijo ciclo.
- [ ] Manejo límites.
- [ ] Uso contador/acumulador.
- [ ] Manejo caso vacío.
- [ ] Trazo iteraciones.

Continúa con métodos.


## Precisiones para aplicar el modelo

### Arreglos y matrices

Un arreglo tiene tamaño fijo: `int[] valores = new int[3]` crea tres ceros. El índice válido cumple 0 <= i < length. `int[][] matriz` es un arreglo de referencias a arreglos; sus filas pueden tener distintas longitudes. No asumas un rectángulo si el contrato no lo exige. Para recorrer una matriz irregular usa matriz[fila].length en cada fila.

El arreglo vacío es válido, pero no tiene primer elemento. Distingue una colección sin observaciones de un promedio0: si no hay datos, el promedio no se calcula. Una matriz cuyos elementos son objetos tampoco los crea automáticamente: debes construir cada referencia que necesites.

## Laboratorio completo: observar, explicar y modificar

Un arreglo es un objeto con tamaño fijo, posiciones desde cero y length como campo. Sus elementos de int comienzan en cero cuando se crea con new int[n]. El for-each copia cada valor a la variable local: reasignarla no cambia un elemento primitivo del arreglo. Necesitas índices para modificar posiciones.

### Paso 1. Ubica el archivo

Abre una terminal en `unidad05-ciclos/laboratorio`. El programa completo está en [Laboratorio.java](laboratorio/Laboratorio.java). Cada unidad tiene su propia carpeta: estos archivos usan el mismo nombre y se compilan **por separado**.

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
Promedio: 30.75
Intentos: 3
Dato: 28
Dato: 31
Dato: 35
Dato: 29
```

### Paso 4. Recorre la lógica

Traza i, condición y suma en cada vuelta. Distingue datos.length de un método length(). Cambia < por <= para reproducir el acceso inválido y luego corrígelo. Evalúa qué ocurre con un arreglo vacío antes de calcular un promedio.

### Paso 5. Lee el código completo

```java
public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        int[] datos = {28, 31, 35, 29};
        int suma = 0;
        for (int i = 0; i < datos.length; i++) { suma += datos[i]; }
        System.out.println("Promedio: " + (double) suma / datos.length);
        int intentos = 0;
        do { intentos++; } while (intentos < 3);
        System.out.println("Intentos: " + intentos);
        for (int dato : datos) { System.out.println("Dato: " + dato); }
    }

    
}
```

### Paso 6. Comprueba y extiende

[5]: min=max=5; [-3,-8]: min=-8,max=-3; []: sin datos; última posición válida: length-1.

Continúa con [la práctica](PRACTICA.md). Escribe primero tus predicciones y consulta [las soluciones razonadas](SOLUCIONES.md) después de intentarla.

---

## Continuar el curso

- **Unidad anterior:** [Unidad 04: Decisiones en Java](../unidad04-decisiones/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 06: Métodos y modularización](../unidad06-metodos/README.md)


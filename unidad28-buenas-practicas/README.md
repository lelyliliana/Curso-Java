# Unidad 28 — Buenas prácticas y refactorización

[Volver al índice del curso](../README.md) · [Ver el curso en Aprende con Leli](https://lelyliliana.github.io/aprende-con-leli/cursos/java/)

## Qué aprenderás
Mejorar diseño preservando comportamiento y distinguir principios útiles de reglas rígidas.

# 1. Código mantenible

No significa “código corto”.

Debe facilitar:
- comprender;
- cambiar;
- probar;
- diagnosticar;
- revisar.

# 2. Nombres

```java
double x;
```

puede ser apropiado en una fórmula local obvia.

```java
double totalConImpuesto;
```

es mejor cuando expresa una idea de negocio.

No hagas nombres largos por obligación; expresa intención.

# 3. Métodos

Un método debe tener una responsabilidad coherente.

Señales de revisión:
- demasiados niveles;
- muchos parámetros;
- mezcla I/O + reglas + persistencia;
- nombre con varios “y”.

“Pequeño” no es un número mágico de líneas.

# 4. Clases

Alta cohesión: elementos de la clase pertenecen a una responsabilidad relacionada.

Bajo acoplamiento: no depende innecesariamente de detalles ajenos.

No conviertas cada método en una clase solo por aplicar principios.

# 5. Duplicación

Duplicación de **conocimiento** es más importante que líneas visualmente parecidas.

Dos fragmentos iguales hoy pueden evolucionar por razones distintas; abstraerlos prematuramente puede acoplar conceptos que no son iguales.

# 6. Comentarios

Mal:
```java
// Incrementa i
i++;
```

Útil:
```text
// El proveedor considera el límite superior exclusivo.
```

El comentario explica una decisión/contexto no evidente.

# 7. Constantes y números mágicos

```java
if (intentos > 3)
```

Si 3 tiene significado de política:
```java
private static final int MAX_INTENTOS = 3;
```

No conviertas cada literal 0/1 en constante sin aportar significado.

# 8. Dependencias

Programa contra contratos cuando necesitas sustitución/desacoplamiento.

No crees una interface para cada clase por reflejo.

# 9. Refactorización

Cambiar estructura **sin cambiar comportamiento observable previsto**.

Flujo:
1. tests verdes;
2. cambio pequeño;
3. tests;
4. repetir.

# 10. Ejemplo

Método monolítico:
```text
leer archivo
parsear
validar
calcular
guardar
imprimir
```

Refactoriza responsabilidades donde haya fronteras reales.

# 11. YAGNI / simplicidad

No diseñes extensibilidad para veinte escenarios hipotéticos.

Resuelve requisitos actuales manteniendo espacio razonable para cambios conocidos.

# 12. SOLID — orientación, no checklist

Puedes estudiar SRP, OCP, LSP, ISP, DIP como vocabulario para razonar sobre diseño.

No conviertas “cumplir SOLID” en objetivo independiente del problema.

# 13. Práctica guiada

Toma una clase difícil:
1. caracteriza comportamiento con tests;
2. renombra;
3. extrae método;
4. separa dependencia;
5. ejecuta tests tras cada paso.

# 14. Errores frecuentes
- refactor grande sin tests.
- abstraer prematuramente.
- interface para todo.
- comentarios que repiten.
- nombres artificialmente largos.
- “clean code” como reglas absolutas.

# 15. Reto
Refactoriza código en commits/pasos pequeños y explica qué problema de mantenibilidad resuelve cada cambio.

# 16. Autoevaluación
1. ¿Refactor cambia comportamiento?
2. ¿Qué es cohesión?
3. ¿Duplicación visual siempre se abstrae?
4. ¿Interface siempre?
5. ¿Qué debe explicar comentario?
6. ¿Por qué tests antes de refactor?

# 17. Checklist
- [ ] Refactorizo con pruebas.
- [ ] Nombro con intención.
- [ ] Mantengo responsabilidades.
- [ ] Evito abstracción prematura.

Continúa con taller.


---

## Continuar el curso

- **Unidad anterior:** [Unidad 27 — Diagnóstico, logging, depuración y configuración](../unidad27-diagnostico/README.md)
- **Volver al índice:** [Todas las unidades](../README.md)
- **Siguiente unidad:** [Unidad 29 — Taller integrador de Java](../unidad29-taller/README.md)

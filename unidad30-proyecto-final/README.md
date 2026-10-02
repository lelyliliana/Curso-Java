# Unidad 30 — Proyecto final

## Propósito

Construir una aplicación Java reproducible que demuestre dominio del lenguaje, POO, biblioteca estándar, pruebas y diagnóstico.

No es obligatorio utilizar todas las características del curso.

# Etapa 1 — Problema

Elige un dominio ficticio o con datos no sensibles:
- inventario;
- biblioteca;
- agenda;
- sensores simulados;
- tareas;
- reservas.

Define usuario, necesidad, alcance y exclusiones.

# Etapa 2 — Casos de uso

Escribe al menos cinco acciones:
```text
registrar
buscar
actualizar mediante operación válida
listar
generar reporte
```

Incluye errores esperados.

# Etapa 3 — Modelo de dominio

Diseña clases/records/enums.

Para cada tipo:
- responsabilidad;
- invariantes;
- identidad/igualdad;
- mutabilidad.

No empieces con getters/setters.

# Etapa 4 — Arquitectura pequeña

Separa cuando aporte:
```text
entrada/interfaz
   ↓
servicios/casos de uso
   ↓
dominio
   ↓
repositorio/archivo
```

No necesitas crear capas vacías solo para imitar arquitecturas empresariales.

# Etapa 5 — Colecciones

Elige List/Set/Map/Queue según operaciones.

Documenta por qué.

# Etapa 6 — Persistencia o intercambio

Implementa al menos una:
- archivos con NIO;
- formato textual/CSV sencillo;
- comunicación local si el problema lo justifica.

No necesitas base de datos en este curso.

# Etapa 7 — Errores

Define:
- entradas inválidas;
- ausencia;
- errores de I/O;
- reglas de dominio.

Decide cuándo excepción, Optional o resultado vacío.

# Etapa 8 — Funcional moderno

Usa lambdas/Streams **solo donde mejoren claridad**.

Incluye al menos una comparación breve con alternativa imperativa si utilizas un pipeline importante.

# Etapa 9 — Concurrencia opcional por necesidad

Threads/Executor/virtual threads solo si el problema contiene tareas independientes o I/O concurrente que lo justifique.

No se otorgan puntos por añadir concurrencia artificial.

# Etapa 10 — Maven

Proyecto debe ejecutar:

```bash
mvn test
mvn package
```

sin rutas personales ni dependencias manuales.

# Etapa 11 — Pruebas

Incluye JUnit para:
- invariantes;
- normal;
- límites;
- errores.

Mockito solo cuando exista una dependencia que realmente convenga sustituir.

# Etapa 12 — Diagnóstico

Configura mensajes/logging apropiados al alcance.

No expongas secretos/datos sensibles.

Conserva causas de errores.

# Etapa 13 — Calidad

Antes de refactorizar, tests verdes.

Revisa:
- nombres;
- duplicación de conocimiento;
- responsabilidades;
- acoplamiento;
- métodos complejos.

# Etapa 14 — README reproducible

Debe indicar:
1. requisitos;
2. Java/Maven;
3. cómo ejecutar tests;
4. cómo ejecutar app;
5. datos de ejemplo;
6. decisiones principales;
7. limitaciones.

# Etapa 15 — Revisión

Usa:
- `PLANTILLA_PROYECTO.md`;
- `RUBRICA.md`;
- `CHECKLIST.md`.

Pregunta:
- ¿otra persona puede clonar y ejecutar?
- ¿el dominio puede entrar en estado inválido?
- ¿cada dependencia tiene razón?
- ¿tests prueban comportamiento?
- ¿hay secretos/rutas personales?
- ¿puedo explicar cada característica usada?

# Entregables

- código Maven;
- README;
- pruebas;
- datos ficticios de ejemplo;
- documentación de diseño;
- evidencia de ejecución/pruebas.

# Cierre

> Java profesional no consiste en utilizar todas las APIs del lenguaje, sino en construir software que pueda comprenderse, probarse, diagnosticarse y mantenerse.

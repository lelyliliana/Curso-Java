# Unidad 27 — Diagnóstico, logging, depuración y configuración

## Qué aprenderás
Investigar fallos con hipótesis/evidencia, usar debugger/logs y separar configuración del código.

# 1. No cambies cosas al azar

Proceso:
```text
síntoma
→ reproducir
→ hipótesis
→ evidencia
→ experimento pequeño
→ conclusión
→ corrección
→ prueba de regresión
```

Cambiar cinco cosas simultáneamente destruye información.

# 2. Stack trace

Lee:
- tipo de excepción;
- mensaje;
- causa (`Caused by`);
- primera línea relevante de tu código;
- cadena de llamadas.

No empieces necesariamente por la primera línea del stack si pertenece a framework/biblioteca.

# 3. Logging

Niveles conceptuales:
- ERROR: fallo que requiere atención;
- WARN: situación anómala/recuperable;
- INFO: eventos operativos significativos;
- DEBUG/TRACE: detalle diagnóstico.

La política concreta depende de la aplicación.

# 4. No registres secretos

Nunca logs con:
- contraseñas;
- tokens;
- claves;
- datos sensibles innecesarios.

“Necesito depurar” no justifica exponerlos.

# 5. System.out vs logging

Para ejercicios, println es útil.

En aplicaciones con observabilidad, un framework de logging aporta niveles, destinos, formato y contexto.

No añadiremos uno obligatorio solo para aprender el concepto.

# 6. Debugger

Herramientas:
- breakpoint;
- step over;
- step into;
- step out;
- watches;
- inspección de variables.

Usa breakpoint cerca del punto donde el estado empieza a divergir, no necesariamente donde finalmente explota.

# 7. Configuración

No hardcodees:
```java
String password = "real-secret";
String ruta = "/home/miusuario/...";
```

Valores variables por entorno deben venir de mecanismos de configuración apropiados.

# 8. Variables de entorno

Pueden servir para ciertos secretos/configuración:
```java
System.getenv("APP_PORT")
```

Pero también requieren validación y gestión segura.

# 9. Causa y contexto

Al relanzar:
```java
throw new ProcesamientoException(
    "Error procesando archivo " + nombreSeguro,
    e
);
```

Conserva causa sin incluir datos sensibles.

# 10. Práctica guiada

Toma programa defectuoso:
1. reproduce;
2. escribe hipótesis;
3. breakpoint;
4. inspecciona;
5. añade log solo si aporta;
6. corrige;
7. crea test que falle antes y pase después.

Consulta `GUIA.md`.

# 11. Errores frecuentes
- “arreglar” borrando configuración/caché sin hipótesis.
- logs excesivos.
- secretos en logs.
- catch que pierde stack trace.
- debugger sin entender flujo.
- configuración personal versionada.

# 12. Reto
Diagnostica un fallo y entrega bitácora hipótesis→evidencia→corrección→prueba.

# 13. Autoevaluación
1. ¿Qué lees en stack trace?
2. ¿Qué es causa?
3. ¿INFO/DEBUG son iguales?
4. ¿Qué no debe ir a logs?
5. ¿Por qué cambiar una variable por vez?
6. ¿Cómo una prueba evita regresión?

# 14. Checklist
- [ ] Reproduzco.
- [ ] Formulo hipótesis.
- [ ] Uso debugger/logs.
- [ ] Protejo secretos.
- [ ] Creo regresión.

Continúa con buenas prácticas.

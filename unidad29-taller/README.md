# Unidad 29 — Taller integrador de Java

## Propósito

Resolver problemas sin que el enunciado diga “usa Stream”, “usa interface” o “usa HashMap”.

Debes elegir la herramienta.

# Método

Para cada problema:
1. reformula;
2. define modelo/contratos;
3. identifica errores/límites;
4. elige estructuras/APIs;
5. implementa;
6. prueba;
7. diagnostica fallos;
8. compara alternativa cuando aporte;
9. documenta.

Consulta `PROBLEMAS.md`.

# Nivel 1 — Dominio

## Catálogo
Productos con código único, precio válido y stock.

Decide:
- clase/record;
- colección;
- igualdad;
- operaciones públicas.

# Nivel 2 — Importación

## Transacciones desde archivo
Lee registros con líneas inválidas.

Decide:
- NIO;
- política de errores;
- estructura de resultado;
- reporte.

# Nivel 3 — Diseño desacoplado

## Notificaciones
El sistema debe enviar mensajes por dos mecanismos intercambiables.

No se indica si debes usar herencia/interface/composición: justifica.

# Nivel 4 — Procesamiento

## Estadísticas
Procesa ventas mediante:
- versión imperativa;
- versión Stream.

Compara claridad y costo conceptual. No declares ganador por estilo.

# Nivel 5 — Ausencia

## Repositorio en memoria
Búsquedas por id y búsquedas por criterio.

Decide cuándo:
- Optional;
- colección vacía;
- excepción.

# Nivel 6 — Concurrencia

## Tareas independientes
Procesa trabajos secuencial/concurrentemente.

Mide bajo condiciones documentadas.

Incluye al menos un escenario donde añadir concurrencia no aporte.

# Nivel 7 — Red local

## Cliente/servidor
Diseña protocolo textual:
- framing;
- errores;
- desconexión;
- timeout.

Solo localhost/red controlada.

# Nivel 8 — Proyecto reproducible

Convierte una solución a Maven:
- tests;
- dependencias;
- un comando de verificación.

# Criterios

Una solución sólida:
- preserva invariantes;
- usa APIs por necesidad;
- tiene pruebas;
- conserva causas/diagnóstico;
- no expone secretos;
- puede ejecutarse desde README.

# Autoevaluación

1. ¿Puedo decidir List/Set/Map?
2. ¿Puedo decidir interface/composición?
3. ¿Puedo explicar Optional vs vacío?
4. ¿Puedo escribir tests sin mockear todo?
5. ¿Puedo diagnosticar stack trace?
6. ¿Puedo justificar concurrencia?
7. ¿Puedo hacer proyecto reproducible?

Si necesitas que el enunciado te diga la característica de Java, vuelve a la unidad correspondiente.

# Checklist

- [ ] Modelo antes de código.
- [ ] Contratos.
- [ ] Pruebas.
- [ ] Errores.
- [ ] Reproducibilidad.
- [ ] Justificación técnica.

Continúa con el proyecto final.

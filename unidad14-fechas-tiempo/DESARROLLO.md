# Separar fecha civil, instante y reloj controlable

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad14-fechas-tiempo/laboratorio/Laboratorio.java](../unidad14-fechas-tiempo/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

LocalDate representa una fecha sin hora ni zona. Instant representa un punto temporal. Clock reúne una fuente de instantes y una zona para derivar la fecha local; por eso un mismo instante puede pertenecer a días civiles distintos según la zona.

La referencia fija 2026-01-01T02:00Z y America/Bogota, donde todavía corresponde al 31 de diciembre anterior. Esta demostración no debe depender de la fecha real del equipo. Un reloj fijo permite probar exactamente ese borde.

La extensión suma siete días con plusDays y define vencido como hoy posterior al vencimiento. El mismo día de vencimiento todavía no se considera vencido. Cambiar a una comparación inclusiva sería otra regla, no una corrección automática.

La API de fechas gestiona el paso por meses y años bisiestos. No sumes siete a dayOfMonth y reconstruyas una fecha que pueda quedar fuera del mes. Un período de siete días civiles tampoco equivale a cualquier requisito de 168 horas exactas en todas las zonas.

## 3. Construye y contrasta

Con inicio 1 de enero, espera vencimiento 8. Usa un reloj fijo para el 8 y otro para el 9 en Bogotá. Prueba también inicio 25 de febrero de un año bisiesto. Registra la zona junto al instante para interpretar el resultado.

## Ejecutar la extensión completa

El archivo [Solucion.java](solucion/Solucion.java) contiene imports, métodos y main. Abre una terminal en la carpeta solucion de esta unidad y ejecuta cada comando por separado:

```text
javac -encoding UTF-8 --release 21 Solucion.java
```

```text
java Solucion
```

La referencia Laboratorio.java permanece en su carpeta original. Las clases sin paquete de unidades diferentes se compilan por separado; no juntes todos sus archivos en una sola compilación.

## 4. Explica tu resultado

Resuelve la [práctica](PRACTICA.md) antes de consultar la [solución](SOLUCIONES.md). Relaciona cada entrada o acción con el resultado y el estado posterior cuando haya cambios. Conserva la diferencia entre una operación rechazada y una ausencia válida de datos.

---

### ¿Necesitas apoyo con este tema?

Si te bloqueaste con la práctica, necesitas revisar tu entorno o adaptar lo aprendido a tu proyecto, podemos trabajarlo en una sesión personalizada.

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2014%20%E2%80%94%20Fechas%20y%20tiempo%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad14-fechas-tiempo%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

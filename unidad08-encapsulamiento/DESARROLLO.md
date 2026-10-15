# Validar una transferencia antes de modificar dos objetos

[Unidad](README.md) · [Práctica](PRACTICA.md) · [Solución](SOLUCIONES.md)

## 1. Ubica el código

Sigue [unidad08-encapsulamiento/laboratorio/Laboratorio.java](../unidad08-encapsulamiento/laboratorio/Laboratorio.java) desde la copia completa del curso. Consulta la preparación de [entorno](../docs/ENTORNO.md) si todavía no has ejecutado la referencia.

## 2. Recorre las decisiones

El saldo cambia solo después de comprobar importe y fondos. BigDecimal no se modifica internamente: add y subtract devuelven valores que la cuenta asigna a su campo. compareTo compara la magnitud monetaria, mientras equals también considera escala.

La extensión admite saldo inicial no negativo y hasta dos decimales de escala. El importe transferido debe ser positivo, tener escala permitida, caber en el saldo y dirigirse a otra cuenta existente. Estas condiciones se comprueban antes de cambiar cualquiera de las dos.

La solución calcula nuevoOrigen y nuevoDestino primero y después los asigna. Un rechazo por validación conserva ambos saldos. El ejemplo no impone un máximo de saldo que pudiera fallar al depositar; si introduces uno, debe validarse antes del débito.

Esta secuencia pertenece a un ejercicio de un hilo. Dos asignaciones no constituyen una transacción concurrente ni garantizan atomicidad frente a errores físicos o cualquier excepción extraordinaria. Añadir synchronized solo a un método sin pensar el bloqueo de ambas cuentas puede introducir otros problemas.

## 3. Construye y contrasta

Transfiere 4.25 desde 10.00 a 0.00 y espera 5.75/4.25. Intenta 8.00 y comprueba conservación de los dos valores. Rechaza destino idéntico y termina con un retiro exacto del saldo restante. Conserva total 10.00 en las transferencias válidas.

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

[**Solicitar asesoría para este tema por WhatsApp**](https://wa.me/573103618296?text=Hola%2C%20Leli.%20Estoy%20estudiando%20Unidad%2008%20%E2%80%94%20Constructores%2C%20encapsulamiento%20y%20validaci%C3%B3n%20del%20curso%20Java%20desde%20cero%20%28https%3A%2F%2Fgithub.com%2Flelyliliana%2FCurso-Java%2Ftree%2Fmain%2Funidad08-encapsulamiento%29%20y%20necesito%20una%20asesor%C3%ADa%20personalizada.%20Mi%20duda%20es%E2%80%A6)

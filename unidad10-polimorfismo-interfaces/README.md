# Unidad 10 — Polimorfismo, clases abstractas e interfaces

## Polimorfismo
```java
List<Notificador> notificadores = ...;
for (Notificador n : notificadores) {
    n.enviar("Hola");
}
```

El código usa un contrato común sin depender de la implementación concreta.

## Interface
```java
public interface Notificador {
    void enviar(String mensaje);
}
```

## Clase abstracta
Puede compartir estado y comportamiento base además de definir métodos abstractos.

## ¿Cuál elegir?
No existe una regla “interfaces siempre”. Pregunta si necesitas:
- contrato desacoplado;
- implementación múltiple de capacidades;
- estado/comportamiento base compartido.

## Reto
Diseña EmailNotificador y ConsolaNotificador detrás de una interfaz y demuestra sustitución polimórfica.

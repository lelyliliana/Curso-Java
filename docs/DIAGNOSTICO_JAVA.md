# Diagnóstico Java — Por capas

## 1. Compilación
¿javac/Maven compila?

## 2. Pruebas
¿Qué test falla?

## 3. Arranque
¿main inicia? ¿configuración disponible?

## 4. Dominio
¿la regla produce el estado esperado?

## 5. Infraestructura
¿archivo/red/recurso existe y es accesible?

## 6. Concurrencia
¿el fallo depende del orden o timing?

## 7. Evidencia
Stack trace, logs, debugger y caso mínimo.

## Regla
“Java no funciona” no es un diagnóstico. Identifica la capa y el contrato que se incumple.

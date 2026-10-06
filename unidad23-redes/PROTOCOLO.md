# Contrato del ejemplo de red

## Transporte
TCP sobre localhost:5000.

## Mensaje cliente
Una línea UTF-8 terminada por salto de línea.

## Respuesta
```text
ECO:<mensaje>
```

## Limitaciones
El ejemplo atiende un cliente y no implementa autenticación, cifrado ni protocolo robusto. Su objetivo es comprender sockets localmente, no exponer un servicio en Internet.

## Reto
Añade comandos PING y MAYUSCULAS, validando mensajes desconocidos.


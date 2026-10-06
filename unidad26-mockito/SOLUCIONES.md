# Soluciones: dependencia simulada

Añade a ServicioUsuarioTest:

```java
@Test
void ausenciaEsUnResultadoPrevisto() {
    var repo = mock(RepositorioUsuario.class);
    when(repo.buscarNombre("2")).thenReturn(Optional.empty());
    var servicio = new ServicioUsuario(repo);
    assertEquals("No encontrado", servicio.obtenerNombre("2"));
    verify(repo).buscarNombre("2");
}

@Test
void falloNoSeConfundeConAusencia() {
    var repo = mock(RepositorioUsuario.class);
    when(repo.buscarNombre("2")).thenThrow(new IllegalStateException("Fallo simulado"));
    var servicio = new ServicioUsuario(repo);
    assertThrows(IllegalStateException.class, () -> servicio.obtenerNombre("2"));
}
```

El mock controla la respuesta de un colaborador. El objeto ServicioUsuario es real, porque sus reglas son precisamente el objeto de la prueba. Optional.of("Ana") y Optional.empty también son reales; no aporta simularlos.

La primera prueba demuestra la política de ausencia. La segunda evita una regresión frecuente: capturar cualquier fallo del repositorio y devolver un valor vacío como si la consulta hubiera funcionado.

Una prueba con mock no verifica el formato del archivo ni el funcionamiento de una red real. Para eso se usan pruebas de integración sobre un entorno controlado. El proyecto final contiene ambos tipos y permite simular error de escritura sin depender de permisos distintos en Windows y Ubuntu.

Ejecuta `mvn test` y revisa que las tres pruebas de la suite se hayan ejecutado. La configuración de agente permanece en el pom, no dentro de cada test.

[Práctica](PRACTICA.md) · [Unidad](README.md)

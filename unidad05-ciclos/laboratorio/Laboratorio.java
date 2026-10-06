public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        int[] datos = {28, 31, 35, 29};
        int suma = 0;
        for (int i = 0; i < datos.length; i++) { suma += datos[i]; }
        System.out.println("Promedio: " + (double) suma / datos.length);
        int intentos = 0;
        do { intentos++; } while (intentos < 3);
        System.out.println("Intentos: " + intentos);
        for (int dato : datos) { System.out.println("Dato: " + dato); }
    }

    
}

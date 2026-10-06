public class Estadisticas {
    public static void main(String[] args) {
        double[] datos = {28, 31, 35, 29};
        double suma = 0;
        double maximo = datos[0];
        double minimo = datos[0];

        for (double dato : datos) {
            suma += dato;
            if (dato > maximo) maximo = dato;
            if (dato < minimo) minimo = dato;
        }

        double promedio = suma / datos.length;
        System.out.printf("Promedio %.2f, min %.2f, max %.2f%n",
                promedio, minimo, maximo);
    }
}


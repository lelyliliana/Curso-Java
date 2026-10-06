import java.util.logging.Logger;

public final class Laboratorio {
    public static void main(String[] args) throws Exception {
        Logger log = Logger.getLogger(Laboratorio.class.getName());
        String texto = System.getProperty("curso.limite", "3");
        try {
            int limite = Integer.parseInt(texto);
            if (limite < 1 || limite > 10) throw new IllegalArgumentException("Límite entre 1 y 10");
            log.info("Configuración validada");
            System.out.println("Límite: " + limite);
        } catch (IllegalArgumentException e) {
            System.out.println("Configuración rechazada: " + e.getMessage());
        }
    }

    
}

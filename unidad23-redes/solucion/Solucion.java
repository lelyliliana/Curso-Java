import java.io.*;
public final class Solucion {
    // Protocolo de una línea: LF termina, CR se rechaza y EOF sin LF es incompleto.
    static String leerLinea(Reader entrada,int maximo) throws IOException {
        if (maximo<1) throw new IllegalArgumentException("Límite positivo");
        var texto=new StringBuilder();
        for (int c;(c=entrada.read())!=-1;) {
            if (c=='\n') return texto.toString();
            if (c=='\r') throw new IOException("CR no admitido; usa LF");
            if (texto.length()==maximo) throw new IOException("Mensaje demasiado largo");
            texto.append((char)c);
        }
        throw new EOFException("Mensaje sin terminador LF");
    }
    static String procesar(String mensaje) {
        return mensaje.startsWith("ECHO|") ? "OK|"+mensaje.substring(5) : "ERROR|Comando desconocido";
    }
    public static void main(String[] args) throws Exception {
        System.out.println(procesar(leerLinea(new StringReader("ECHO|hola\n"),200)));
        System.out.println(procesar(leerLinea(new StringReader("OTRO|hola\n"),200)));
        System.out.println("Frontera: "+leerLinea(new StringReader("ECHO|"+"x".repeat(195)+"\n"),200).length());
        try { leerLinea(new StringReader("x".repeat(201)+"\n"),200); }
        catch (IOException e) { System.out.println(e.getMessage()); }
        try { leerLinea(new StringReader("ECHO|hola"),200); }
        catch (EOFException e) { System.out.println(e.getMessage()); }
    }
}

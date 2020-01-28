package as400;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        leer();
        convertir();
    }

    private static void convertir() {
        leerArchivo linea = new leerArchivo();
        linea.getCurrentLine();
        System.out.println("Arreglo de comandos: " + linea.getCurrentLine());
    }

    private static void leer() {
        leerProperties properties = new leerProperties();
        properties.getPropValues();
        System.out.println("Usuario: " + properties.getUsuario());
    }
}

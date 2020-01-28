package as400;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
                leerProperties properties = new leerProperties();
                properties.getPropValues();
                System.out.println("Usuario: " + properties.getUsuario());
                leerArchivo linea = new leerArchivo();
                linea.getCurrentLine();
                System.out.println("Comando: " + linea.getCurrentLine());
            }
        }

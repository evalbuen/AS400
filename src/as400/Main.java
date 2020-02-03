package as400;

import java.io.IOException;

public class Main {
    private static LeerProperties properties = new LeerProperties();
    private static LeerArchivo linea = new LeerArchivo();
    private static ConectarseAS400 ca4;

    public static void main(String[] args) throws IOException {

        properties.getPropValues();
        System.out.println("Usuario: " + properties.getUsuario());
        System.out.println("Password: " + properties.getPassword());
        System.out.println("Servidor: " + properties.getServidor());

        linea.getCurrentLine();
        System.out.println("Arreglo de comandos: " + linea.getCurrentLine());

        ca4 = new ConectarseAS400(properties.getServidor(), properties.getUsuario(), properties.getPassword(), linea.getCurrentLine());

    }
}
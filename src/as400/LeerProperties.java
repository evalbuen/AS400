package as400;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;


public class LeerProperties {


    private String usuario;
    private String password;
    private String servidor;
    private ArrayList<String> vectorComandos;


    public ArrayList<String> getVectorComandos() {
        return vectorComandos;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getServidor() {
        return servidor;
    }


    public void getPropValues() {

        try {
            InputStream input = new FileInputStream("resources/config.properties");
            Properties prop = new Properties();
            prop.load(input);

            usuario = (prop.getProperty("user"));
            password = (prop.getProperty("password"));
            servidor = (prop.getProperty("IP"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
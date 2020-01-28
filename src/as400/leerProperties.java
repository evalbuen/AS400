package as400;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class leerProperties {


    private String usuario;
    private String password;

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getServidor() {
        return servidor;
    }

    private String servidor;



    public void getPropValues() throws IOException {

        try (InputStream input = new FileInputStream("resources/config.properties")) {

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
package as400;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.CommandCall;

import java.util.ArrayList;

public class ConectarseAS400 {

    public String servidor;
    public String usuario;
    public String password;

    public ArrayList<String> vectorCommandos;

    public ConectarseAS400(String servidor, String usuario, String password, ArrayList<String> vector) {
        vectorCommandos = vector;


        AS400 as400 = null;
        try {
            // Create an AS400 object
            System.out.println(servidor);
            as400 = new AS400(servidor, usuario, password);
            
            ArrayList<String> cola = getVectorCommandos();
            for (int i = 0; i < cola.size(); i++) {

                // Create a Command object
                CommandCall command = new CommandCall(as400);

                // Run the command.
                System.out.println("Executing: " + cola.get(i).toString());
                String salidaMensaje = cola.get(i).toString();
                String [] ejecutar = salidaMensaje.split("\\|");
                String interfaz = ejecutar[0];
                String node = ejecutar[1];
                String state = ejecutar[2];
                boolean numero = Boolean.parseBoolean(state);
                System.out.println(state);

                if (numero = true) {
                    String linea = ("STRTCPIFC INTNETADR('" + interfaz + "')");
                    System.out.println(linea);
                    boolean success = command.run(linea);
                    //boolean success = true;

                    if (success) {
                        System.out.println("Command Executed Successfully.");
                    } else {
                        System.out.println("Command Failed!");
                    }
                    // Get the command results
                    AS400Message[] messageList = command.getMessageList();
                    for (AS400Message message : messageList) {
                        System.out.println(message.getText());
                    }
                } else{
                    System.out.println("La interfaz " + interfaz + " se encontraba apagada");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Make sure to disconnect
                as400.disconnectAllServices();
            } catch (Exception e) {
            }
        }
    }

    public String getServidor() {
        return servidor;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }
    public ArrayList<String> getVectorCommandos() {
        return vectorCommandos;
    }
    public void getVectorCommandos(ArrayList<String> p) {
        vectorCommandos = p;
    }
}

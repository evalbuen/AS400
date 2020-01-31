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

    public ConectarseAS400(ArrayList<String> vector) {
        vectorCommandos = vector;

        AS400 as400 = null;
        try {
            // Create an AS400 object
            //as400 = new AS400(getServidor(), getUsuario(), getPassword());

            // Create a Command object
            //CommandCall command = new CommandCall(as400);

            ArrayList<String> cola = getVectorCommandos();
            for (int i = 0; i < cola.size(); i++) {

                // Run the command.
                System.out.println("Executing: " + cola.get(i).toString());
                System.out.println();

                //boolean success = command.run(linea);
                boolean success = true;

                if (success) {
                    System.out.println("Command Executed Successfully.");
                } else {
                    System.out.println("Command Failed!");
                }
                // Get the command results
                //AS400Message[] messageList = command.getMessageList();
                //for (AS400Message message : messageList) {
                //    System.out.println(message.getText());
                //}
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

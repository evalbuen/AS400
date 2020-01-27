package as400;

import java.util.Date;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.CommandCall;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AS400CommandCallTest {

        public static Properties readPropertiesFile(String fileName) throws IOException {
            FileInputStream fis = null;
            Properties prop = null;

            try {
                fis = new FileInputStream(fileName);
                prop = new Properties();
                prop.load(fis);
            } catch (FileNotFoundException var8) {
                var8.printStackTrace();
            } catch (IOException var9) {
                var9.printStackTrace();
            } finally {
                fis.close();
            }

            return prop;
        }

        public static void main(String[] args) throws IOException {
            Properties prop = readPropertiesFile("resources/credentials.properties");
            String servidor = prop.getProperty("servidor");
            String userName = prop.getProperty("username");
            String password = prop.getProperty("password");
            String commandStr = prop.getProperty("comando");
            System.out.println("El valor de servidor es: " + servidor);
            System.out.println("El valor de username es: " + userName);
            System.out.println("El valor de password es: " + password);

        AS400 as400 = null;
        try  {
            // Create an AS400 object
            as400 = new AS400(servidor, userName, password);

            // Create a Command object
            System.out.println("Va a ejecutar el comando: " + commandStr);
            CommandCall command = new CommandCall(as400);

            // Run the command.
            System.out.println("Executing: " + commandStr);
            boolean success = command.run(commandStr);

            if (success) {
                System.out.println("Command Executed Successfully.");
            }else{
                System.out.println("Command Failed!");
            }

            // Get the command results
            AS400Message[] messageList = command.getMessageList();
            for (AS400Message message : messageList){
                System.out.println(message.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                // Make sure to disconnect
                as400.disconnectAllServices();
            }catch(Exception e){}
        }
        System.exit(0);
    }
}
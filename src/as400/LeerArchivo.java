package as400;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class LeerArchivo {

    public ArrayList<String> getCurrentLine() {
        return vectorComandos;
    }
    private ArrayList<String> vectorComandos;

    public LeerArchivo() {
        try {
            Scanner linea = new Scanner(new File("resources/test_read.txt")).useDelimiter(System.lineSeparator());
            ArrayList<String> list = new ArrayList<String>();
            while (linea.hasNext()){
                list.add(linea.next());
            }
            linea.close();
            vectorComandos = list;
/* Crear con File
            //creating File instance to reference text file in Java
            File text = new File("resources/test_read.txt");

            //Creating Scanner instnace to read File in Java
            Scanner scnr = new Scanner(text);

            //Reading each line of file using Scanner class
            int lineNumber = 1;
            while(scnr.hasNextLine()){
                String line = scnr.nextLine();
                currentLine = line;
                System.out.println("line " + lineNumber + " :" + line);
                lineNumber++;
*/
/* Crear con BufferedReader
                BufferedReader reader = new BufferedReader(new FileReader(file));
                currentLine = reader.readLine();
                reader.close();
 */
            }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

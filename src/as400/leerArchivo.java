package as400;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class leerArchivo {
    public String getCurrentLine() {
        return currentLine;
    }
    private String currentLine;
    public leerArchivo() {
        try {
            String file = "resources/test_read.txt";
            BufferedReader reader = new BufferedReader(new FileReader(file));
            currentLine = reader.readLine();
            reader.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

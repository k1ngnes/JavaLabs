package FileSave;

import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {
    public void writeCharToFile(char symbol) {
        try {
            FileWriter writer = new FileWriter("result.txt");
            writer.write(symbol);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

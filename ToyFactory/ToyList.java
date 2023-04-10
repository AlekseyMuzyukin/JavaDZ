package ToyFactory;

import java.io.FileWriter;
import java.io.IOException;

public class ToyList {
    private final FileWriter fW;

    public ToyList(String fileName) throws IOException {
        this.fW = new FileWriter(fileName, true);
    }

    public void writeToFile(String stringToWrite) throws IOException {
        try {
            fW.write(stringToWrite + "\n");
            fW.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
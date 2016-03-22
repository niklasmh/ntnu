package sudokuv2;

//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileHandler {
    private String filePath, content;

    public FileHandler(String filePath) {
        this.filePath = filePath;
        this.content = getFileContent();
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileContent(String filePath) {

        try {
            Scanner scanner = new Scanner(new FileReader(filePath));

            content = scanner.next();
            scanner.close();

            return content;
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file with filepath: " + filePath);
        }

        return "";
    }

    public String getFileContent() {
        return getFileContent(this.filePath);
    }
}

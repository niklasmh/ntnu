package eksamen2;

import java.io.*;

/**
 * Created by Niklas on 15.05.2016.
 */
public class FileManager {
    public static char[] readChars (String addr) throws IOException {
        Reader reader = new FileReader(new File(addr));
        char[] buffer = new char[1000];

        int charCount = reader.read(buffer);

        reader.close();
        return buffer;
    }

    public void writeString (String out, String addr) throws IOException {
        PrintWriter writer = new PrintWriter(addr);
        writer.println(out);
        System.out.println(out);
        writer.flush();
        writer.close();
    }
}

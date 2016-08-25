package eksamen2;

import java.io.File;
import java.io.IOException;

/**
 * Created by Niklas on 15.05.2016.
 */
public class RobberLang {
    private static final String CONST = "BCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ILLEGAL_CHARS = "#";

    public String encrypt (String str) {
        String out = "";

        for (int i = 0; i < out.length(); i++) {
            char c = str.charAt(i);

            //if (ILLEGAL_CHARS.indexOf(Character.toUpperCase(c)) >= 0) {
            //    throw new RobberLangParseException(str, c);
            //}

            if (CONST.indexOf(Character.toUpperCase(c)) >= 0) {
                out += c + "o" + c + Character.toLowerCase(c);
            } else {
                out += c;
            }
        }

        return out;
    }

    public static void main(String[] args) throws IOException {
        RobberLang r = new RobberLang();

        String rootPath = new File("").getAbsolutePath();
        String filePath = rootPath + "/src/eksamen2/in.txt";

        FileManager fm = new FileManager();
        char[] chars = fm.readChars(filePath);
        String fileContent = new String(chars);
        System.out.println("Vi har flg. input: " + fileContent);

        String encryptedContent = r.encrypt(fileContent);
        System.out.println(encryptedContent);

        String encryptedFilePath = rootPath + "/src/eksamen2/out.txt";
        fm.writeString(encryptedContent, encryptedFilePath);
    }
}

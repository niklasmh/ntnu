package eksamen2;

import java.util.Scanner;

/**
 * Created by Niklas on 15.05.2016.
 */
public class ScannerEx {

    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Skriv navn: ");

        while (s.hasNextLine()) {
            String line = s.nextLine();

            if (line.equals("lukk")) {
                break;
            } else {
                System.out.println("Hei, " + line);
            }

            System.out.println("Skriv navn: ");
        }
    }
}

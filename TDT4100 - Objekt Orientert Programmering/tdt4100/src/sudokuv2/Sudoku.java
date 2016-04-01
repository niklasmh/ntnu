package sudokuv2;

import java.util.Scanner;

public class Sudoku {
    public int attempts;

    public Sudoku() {
        attempts = 0;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Brett (ingenting blir default brett):");

        String board = scan.nextLine();

        sudoku.Board b;

        if (board.matches("[1-9.]{81,}")) {
            System.out.println("Sukksess i å importere brett:\n");
            b = new sudoku.Board(board.substring(0, 81));
        } else if (board.length() > 0) {
            System.out.println("Kunne ikke lage brett, du får nå default:\n");
            b = new sudoku.Board();
        } else {
            System.out.println("Du får nå default:\n");
            b = new sudoku.Board();
        }

        System.out.println(b);

        while (!b.isGameOver()) {
            System.out.println(b);
            System.out.println("\n\nEndre felt (f.eks. g 1 5):");
            int posX, posY, val;

            while (true) {
                String posXChar = scan.next();
                posX = (int) posXChar.charAt(0) - 97;
                posY = scan.nextInt();
                val = scan.nextInt();

                System.out.println(posXChar + ", " + posY + ", " + val);

                if (posX >= 0 && posX < 9) {

                    if (posY >= 0 && posY < 9) {

                        if (val >= 0 && val <= 9) {
                            break;
                        } else {
                            System.out.println("Not a valid value. Must be between 0-9.");
                        }
                    } else {
                        System.out.println("Not a valid y-position. Must be between 0-8.");
                    }
                } else {
                    System.out.println("Not a valid x-position. Must be a-i.");
                }
            }

            b.setField(posX, posY, val);
        }

        System.out.println("Du vant!!! Spillet avsluttes her.");
    }
}

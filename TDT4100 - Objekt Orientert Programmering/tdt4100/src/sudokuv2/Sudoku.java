package sudokuv2;

import java.util.List;
import java.util.Scanner;

public class Sudoku {

    /**
     * Runs the sudoku v2 game.
     *
     * @param args = not needed
     */
    public static void main(String[] args) {
        String filepath = "history.txt";
        FileHandler file = new FileHandler(filepath);
        int game;

        Scanner scan = new Scanner(System.in);
        System.out.println("Du kan velge mellom");
        List<String> content = file.getContent();

        for (int i = 0; i < content.size(); i++) {
            System.out.println(i + ". - " + file.getContentField(i, 0));
        }

        System.out.println("Velg brett nummer eller legg inn nytt:");

        String board = scan.nextLine();
        Board b;

        if (board.matches("[1-9.]{81,}")) {
            System.out.println("Sukksess i å importere brett:");
            b = new Board(board.substring(0, 81));
            System.out.println("Hva vil du kalle brettet?");
            String name = scan.nextLine();

            if (name.matches("[^a-z0-9A-Z]")) {
                name = name.replaceAll("[^a-z0-9A-Z]", "");
                System.out.println("Fordi navnet inneholdt spesielle tegn ble det: " + name);
            } else {
                System.out.println("Brettet heter nå: " + name);
            }

            System.out.println("Vi lagrer nå brettet til " + filepath + "...");
            file.appendContent(file.buildSave(name, b.getBoard(), "", 0));
            System.out.println("Brettet ble lagret i " + filepath + "!");
            game = file.getContent().size() - 1;
        } else {
            if (board.matches("[0-9]{1,10}")) {
                int num = Integer.parseInt(board);

                if (num < content.size()) {
                    System.out.println("Du valgte brett " + num + ". Du får nå brettet: " + file.getContentField(num, 0));
                    b = new Board(file.getContentField(num, 1).substring(0, 81),
                            file.getContentField(num, 2),
                            Integer.parseInt(file.getContentField(num, 3)));
                    game = num;
                } else {
                    System.out.println("Du valgte et nummer, men brettet fantes ikke. Du får nå default: \n");
                    b = new Board();
                    game = 0;
                }

            } else {

                if (board.length() > 0) {
                    System.out.println("Kunne ikke lage brett... ");
                }

                System.out.println("Du får nå default: \n");
                b = new Board();
                game = 0;
            }
        }

        System.out.println(b);

        while (!b.isGameOver()) {
            System.out.println("\nEndre felt (f.eks. g 1 5): ");
            int posX, posY, val;

            while (true) {
                String[] input = scan.nextLine().split(" ");

                if (input[0].matches("[Uu]|[Uu]ndo")) {

                    if (input.length >= 2 && input[1].matches("-[Aa]|--[Aa]ll")) {
                        System.out.println("Undoing all steps.");
                        int steps = 0;
                        while (b.undo()) {
                            steps++;
                            System.out.println("Undoing");
                        }
                        b.rebuild();
                        System.out.println(b);
                        System.out.println("Undid " + steps + " steps");
                        System.out.println("You can still go to last step with \"goto [--last|-l]\", " +
                                "but one move will reset the game for good");
                    } else {
                        System.out.println("Undoing last action...");
                        b.undo();
                        b.rebuild();
                        System.out.println(b);
                        System.out.println("Success!");
                    }

                    System.out.println("Step: " + b.getStep() + "/" + b.getSizeOfLog());
                    System.out.println("Log: " + b.getLogFormatted(b.getStep()));
                    file.setContentField(game, 3, String.valueOf(b.getStep()));
                    file.save();
                } else if (input[0].matches("[Rr]|[Rr]edo")) {

                    if (input.length >= 2 && input[1].matches("-[Aa]|--[Aa]ll")) {
                        int steps = 0;
                        while (b.redo()) {
                            steps++;
                            System.out.println("Redoing");
                        }
                        b.rebuild();
                        System.out.println(b);
                        System.out.println("Redid " + steps + " steps");
                    } else {
                        if (b.redo()) {
                            b.rebuild();
                            System.out.println(b);
                            System.out.println("Redoing one step");
                        } else {
                            System.out.println("Out of redo");
                        }
                    }
                    System.out.println("Step: " + b.getStep() + "/" + b.getSizeOfLog());
                    System.out.println("Log: " + b.getLogFormatted(b.getStep()));
                    file.setContentField(game, 3, String.valueOf(b.getStep()));
                    file.save();
                    break;
                } else if (input[0].matches("[Qq]|[Qq]uit|[Ee]xit")) {
                    file.setContentField(game, 2, b.getLogFormatted());
                    file.setContentField(game, 3, String.valueOf(b.getStep()));
                    file.save();
                    System.out.println("Bye. All your date is saved and you're welcome back!");
                    System.exit(1);
                } else if (input[0].matches("[Ll]|[Ll]og")) {
                    System.out.println("Log: " + b.getLogFormatted(b.getStep()));
                } else if (input[0].matches("[Ss]tat[es]|[Ss]tatus")) {
                    System.out.println(b);
                    System.out.println("Step: " + b.getStep() + "/" + b.getSizeOfLog());
                    System.out.println("Log: " + b.getLogFormatted(b.getStep()));
                    break;
                } else if (input[0].matches("[Ss]|[Ss]tep")) {
                    System.out.println("Step: " + b.getStep() + "/" + b.getSizeOfLog());
                    break;
                } else if (input[0].matches("[Gg][Tt]|[Gg]oto")) {

                    if (input.length >= 2 && input[1].matches("-[Ff]|--[Ff]irst")) {
                        b.setStep(0);
                        b.rebuild();
                        file.setContentField(game, 3, String.valueOf(b.getStep()));
                        System.out.println(b);
                        System.out.println("You are now at the start.");
                    } else if (input.length >= 2 && input[1].matches("-[Ll]|--[Ll]ast")) {
                        b.setStep(b.getSizeOfLog());
                        b.rebuild();
                        file.setContentField(game, 3, String.valueOf(b.getStep()));
                        System.out.println(b);
                        System.out.println("You are now at the end of stack.");
                    } else if (input.length >= 2 && input[1].matches("-?[0-9]+")) {
                        int step = Integer.parseInt(input[1]);
                        if (step >= 0) {
                            if (step <= b.getSizeOfLog()) {
                                b.setStep(step);
                                b.rebuild();
                                System.out.println(b);
                                file.setContentField(game, 3, String.valueOf(b.getStep()));
                                System.out.println("Moved to step " + step);
                                break;
                            } else {
                                System.out.println("You can't go further than " + (step - b.getSizeOfLog()) + " steps after the future");
                            }
                        } else {
                            System.out.println("You can't go back before time existed..");
                        }
                    } else {
                        System.out.println("You are on step " + b.getStep());
                    }
                    System.out.println("Log: " + b.getLogFormatted(b.getStep()));
                } else if (input[0].matches("clear")) {

                    if (input.length >= 2 && input[1].matches("-[Aa]|--[Aa]ll")) {
                    } else if (input.length >= 2 && input[1].matches("-[Pp]|--[Pp]ast")) {
                    } else if (input.length >= 2 && input[1].matches("-[Ff]|--[Ff]uture")) {
                    } else {
                        System.out.println("Need to apply --past, --future or --all");
                    }
                } else {

                    if (input.length >= 3) {
                        posX = (int) input[0].charAt(0) - 97;
                        posY = Integer.parseInt(input[1]);
                        val = Integer.parseInt(input[2]);

                        System.out.println(input[0] + ", " + posY + ", " + val);

                        if (posX >= 0 && posX < 9) {

                            if (posY >= 0 && posY < 9) {

                                if (val >= 0 && val <= 9) {
                                    b.setField(posX, posY, val);
                                    System.out.println(b);
                                    file.setContentField(game, 2, b.getLogFormatted());
                                    file.setContentField(game, 3, String.valueOf(b.getStep()));
                                    file.save();
                                    break;
                                } else {
                                    System.out.println("Not a valid value, must be between 0-9.");
                                }
                            } else {
                                System.out.println("Not a valid y-position, must be between 0-8.");
                            }
                        } else {
                            System.out.println("Not a valid x-position, must be a-i.");
                        }
                    } else {
                        System.out.println("For få argumenter. Må være 3 med mellomrom");
                    }
                }
            }

            file.save();
        }

        System.out.println("Du vant! Spillet avsluttes her.");
    }
}

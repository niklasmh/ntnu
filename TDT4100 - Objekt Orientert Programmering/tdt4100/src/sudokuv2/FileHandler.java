package sudokuv2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Stream;

public class FileHandler {
    private String filePath;
    private List<String> content = new ArrayList<>();

    /**
     * A contructor which sets history.txt as default path for import/export file.
     */
    public FileHandler() {
        this.filePath = "history.txt";
    }

    /**
     * A contructor which sets the filepath while getting the content from that file.
     *
     * @param filePath = relative path
     */
    public FileHandler(String filePath) {
        this.filePath = filePath;
        this.content = getFileContent();
    }

    /**
     * Sets the filepath.
     *
     * @param filePath = the file to import and export to
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Makes the private filepath of the class accessible.
     *
     * @return = the private filepath from the class
     */
    public String getFilePath() {
        return this.filePath;
    }

    /**
     * Makes the private content of the class accessible.
     *
     * @return = the private content from the class
     */
    public List<String> getContent() {
        return this.content;
    }

    /**
     * Returns the game content of the nth game in the memory of the class
     *
     * @param game = the nth game content
     * @return = the content of the nth game
     */
    public String getContent(int game) {
        if (game < this.content.size()) {
            return this.content.get(game);
        }

        return "";
    }

    /**
     * Set content of index.
     *
     * @param game = index of the game
     * @param content = the content in one string
     */
    public void setContent (int game, String content) {
        this.content.set(game, content);
    }

    /**
     * Set field in content of index.
     *
     * @param game = index of the game
     * @param field = the content of the field
     * @param content = the content to replace with field
     */
    public void setContentField (int game, int field, String content) {
        String[] pieces = this.content.get(game).split(";");
        pieces[field] = content;
        this.content.set(game, String.join(";", pieces));
    }

    /**
     * Returns the field from an indexed game in the memory.
     *
     * @param game = the nth element in the content
     * @param field = the field of the content element divided by ;
     * @return = the field of the nth-game element in content
     */
    public String getContentField(int game, int field) {
        if (game < this.content.size() && field < 4) {
            return this.content.get(game).split(";")[field];
        }

        return "";
    }

    /**
     * Returns a piece of the content string sent in.
     * The content is delimited by ;
     *
     * @param content = the content of the game in one string
     * @param field = the field of the content divided by ;
     * @return = a piece og the content string
     */
    public String getField(String content, int field) {
        return content.split(";")[field];
    }

    /**
     * This function returns a string in this format:
     *
     * @param name = the name of the game/board
     * @param board = the initial game, needed for building the game with the log
     * @param log = the recorded log, for undo and redo process
     * @param step = steps into the game
     * @return = makes a saveable string
     */
    public String buildSave (String name, String board, String log, int step) {
        return name + ";" + board + ";" + log + ";" + step;
    }

    /**
     * Returns a game in current format: name;board;log;stepsInLog
     *
     * If file is not found or an other error occurs, it will be handled.
     *
     * @param game = the current game in this format: name;board;log;stepsInLog
     */
    public void appendContent(String game) {
        this.content.add(game);

        try {
            Files.write(Paths.get("./src/sudokuv2", this.filePath), game.getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get("./src/sudokuv2", this.filePath), System.getProperty("line.separator").getBytes(), StandardOpenOption.APPEND);
            System.out.println("Kunne legge til i " + this.filePath);
        } catch (IOException e) {
            System.out.println("Kan ikke legge til " + this.filePath);
        }
    }

    /**
     * Saves the content of the game. Makes it possible to reset the whole game.
     *
     * @param content = list of strings with games
     */
    public void save (List<String> content) {
        this.content = content;
        save();
    }

    /**
     * Saves the game to the file at filepath.
     */
    public void save () {
        try {
            new PrintWriter("./src/sudokuv2/" + this.filePath).close();
        } catch (FileNotFoundException e) {
            System.out.println("Kunne ikke finne filen");
        }

        try (PrintWriter file = new PrintWriter(new BufferedWriter(new FileWriter("./src/sudokuv2/" + this.filePath, true)))) {

            for (int i = 0; i < this.content.size(); i++) {
                file.println(this.content.get(i));
            }

        } catch (IOException e) {
            System.out.println("Kunne ikke lagre til " + this.filePath);
        }
    }

    /**
     * Returns a list of games in this format: name;board;log;stepsInLog.
     * This is to later make it accessible through the game.
     *
     * @param filePath = the relative path to file
     * @return = a list of games
     */
    public List<String> getFileContent(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get("./src/sudokuv2", filePath), StandardCharsets.UTF_8)) {

            // Everyone loves lambda expressions!
            lines.forEach(line -> this.content.add(line));

            // This one is faster, but not easier written, which is a problem at the exam
            // for (String line : (Iterable<String>) lines::iterator) {
            //     this.content.add(line);
            // }

            return content;
        } catch (IOException e) {
            System.out.println("Feilet med noe I/O greier: " + e);
        }

        return new ArrayList<>();
    }

    /**
     * The function above, but with the local filepath instead.
     * Then you can set the filepath first, then get the file content.
     *
     * @return = a list of games
     */
    public List<String> getFileContent() {
        return getFileContent(this.filePath);
    }
}

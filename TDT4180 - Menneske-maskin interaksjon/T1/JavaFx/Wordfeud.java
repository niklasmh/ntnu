import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Wordfeud extends Application {
    public void start(Stage stage) throws Exception {
        int[] grid = new int[49];
        String[] letters = new String[49];
        int[] points = new int[49];
        for (int i = 0; i < 49; i++) {
            grid[i] = 0;
            letters[i] = "";
            points[i] = 0;
        }
        letters[7*5 + 1] = "R";
        points[7*5 + 1] = 2;
        letters[7*5 + 2] = "I";
        points[7*5 + 2] = 2;
        letters[7*5 + 3] = "V";
        points[7*5 + 3] = 4;
        letters[7*5 + 4] = "E";
        points[7*5 + 4] = 1;
        letters[7*5 + 5] = "R";
        points[7*5 + 5] = 2;
        grid[2] = 1;
        grid[6] = 4;
        grid[7*1 + 1] = 2;
        grid[7*1 + 3] = 2;
        grid[7*2 + 0] = 3;
        grid[7*2 + 4] = 3;
        grid[7*3 + 3] = 1;
        grid[7*3 + 5] = 2;
        grid[7*4 + 2] = 3;
        grid[7*4 + 6] = 1;
        grid[7*5 + 1] = 1;
        grid[7*5 + 5] = 2;
        grid[7*6 + 0] = 2;
        grid[7*6 + 4] = 3;

        String[] types = { "", "DW", "DL", "TL", "\u2605" };
        String[] classNames = { "empty", "DW", "DL", "TL", "star" };

        GridPane root = new GridPane();
        root.setId("root");
        final int size = 64;

        for (int i = 0; i < 7; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPrefWidth(size);
            root.getColumnConstraints().add(colConst);
        }

        for (int i = 0; i < 7; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPrefHeight(size);
            root.getRowConstraints().add(rowConst);

            for (int j = 0; j < 7; j++) {
                Label label = new Label(types[grid[j * 7 + i]]);
                label.getStyleClass().add("box");
                label.getStyleClass().add(classNames[grid[j * 7 + i]]);
                label.setAlignment(Pos.CENTER);
                root.add(label, i, j);

                Label letter = new Label(letters[j * 7 + i]);
                root.add(letter, i, j);

                if (letters[j * 7 + i] != "") {
                    letter.getStyleClass().add("letter");
                    letter.setAlignment(Pos.CENTER);

                    Label point = new Label(Integer.toString(points[j * 7 + i]));
                    point.getStyleClass().add("point");
                    point.setAlignment(Pos.TOP_RIGHT);
                    root.add(point, i, j);
                }
            }
        }

        Scene scene = new Scene(root);
        scene.getStylesheets().add("Wordfeud.css");

        stage.setTitle("Wordfeud written in JavaFx");
        stage.setScene(scene);
        stage.show();
    }

    public static void main (String[] args) {
        launch(args);
    }
}

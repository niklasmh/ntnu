package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.*;
//import javafx.scene.layout.AnchorPane;

public class App extends Application {
    public void start(Stage stage) throws Exception {
        TestController controller = new TestController();
        Parent root = FXMLLoader.load(getClass().getResource("/application/UI.fxml"));
        Scene scene = new Scene(root, 295, 394);

        stage.setScene(scene);
        stage.setTitle("Avtaleskjema");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

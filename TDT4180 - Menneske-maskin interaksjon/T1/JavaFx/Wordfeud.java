import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Stage;

public class HelloWorld extends Application {
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(root);
        scene.addStylesheet(getClass().getResource("Wordfeud.css"));

        stage.setTitle("Wordfeud written in JavaFx");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main (String[] args) {
        launch(args);
    }
}

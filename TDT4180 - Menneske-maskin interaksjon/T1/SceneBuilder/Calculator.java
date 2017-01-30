import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class Calculator extends Application {
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
        Scene scene = new Scene(root);

        stage.setTitle("Calculator made with Scene Builder");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main (String[] args) {
        launch(args);
    }
}

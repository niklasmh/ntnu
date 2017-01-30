import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class CurrencyConverter extends Application {
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CurrencyConverter.fxml"));
        Scene scene = new Scene(root);

        stage.setTitle("CurrencyConverter written in plain FXML");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main (String[] args) {
        launch(args);
    }
}

package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class TestController {

    @FXML
    private TextArea formal;

    @FXML
    private TextField rom;

    @FXML
    private DatePicker dato;

    @FXML
    private TextField fra;

    @FXML
    private TextField til;

    @FXML
    private TextField repfrek;

    @FXML
    private DatePicker sluttdato;

    public TestController(){
    }

    @FXML
    private void initialize(){
    }

    @FXML
    public void handleRomChange(){
        String[] splitted = rom.getText().split("\\s+");
        if(splitted[splitted.length-1].matches("\\d+")){
            System.out.println("Bra");
            rom.setStyle("-fx-text-fill: green;");
        }
        else {
            rom.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    public void rep(){
        sluttdato.setDisable(false);
    }

    @FXML
    public void handleSubmit(){
        System.out.println("Det er sendt.");
    }
}

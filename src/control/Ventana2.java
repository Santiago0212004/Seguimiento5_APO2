package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Ventana2 {
	
	private double income;
	
    @FXML
    private TextField incomeTF;

    @FXML
    private Button submitBTM;

    @FXML
    void submit(ActionEvent event) {
    	income = Double.parseDouble(incomeTF.getText());
    }
}

package control;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Data;
import model.Value;

public class AddValueController implements Initializable{

    @FXML
    private TextField amountTF;

    @FXML
    private Button submitBTM;

    @FXML
    private DatePicker valueDatePicker;

    @FXML
    private TextField descriptionTF;

    @FXML
    private ComboBox<String> typeBox;

    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	typeBox.getItems().addAll("Ingreso","Gasto");
		
	}
    
    @FXML
    void submit(ActionEvent event) {
    	double amount = Double.parseDouble(amountTF.getText());
    	LocalDate date = valueDatePicker.getValue();
    	String description = descriptionTF.getText();
    	String type = typeBox.getValue();
    	
    	if(amount<=0 || date==null || description.equalsIgnoreCase("") || type.equalsIgnoreCase("")) {
    	    Alert alert = new Alert(Alert.AlertType.ERROR);
    	    alert.setHeaderText(null);
    	    alert.setTitle("Error");
    	    alert.setContentText("Ingrese datos validos.");
    	    alert.showAndWait();
    	} else {
    		Value addingValue = new Value(amount,date,description,type);
        	
        	Data.data.add(addingValue);
    	}
    }

	

}

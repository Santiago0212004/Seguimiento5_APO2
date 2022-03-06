package control;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import model.Data;
import model.Value;

public class FilterController {

    @FXML
    private DatePicker beforeDatePicker;

    @FXML
    private Button filterBeforeBTN;

    @FXML
    private DatePicker afterDatePicker;

    @FXML
    private Button filterAfterBTN;

    @FXML
    private DatePicker initialDatePicker;

    @FXML
    private DatePicker finalDatePicker;

    @FXML
    private Button filterRangeBTN;

    @FXML
    void filterAfter(ActionEvent event) {
    	Data.filteredData.clear();
    	LocalDate afterDate = afterDatePicker.getValue();
    	
    	if(afterDate==null) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    	    alert.setHeaderText(null);
    	    alert.setTitle("Error");
    	    alert.setContentText("Ingrese la fecha.");
    	    alert.showAndWait();
    	}
    	else {
    		for(Value v : Data.data) {
        		if(v.getDate().isAfter(afterDate) || v.getDate().isEqual(afterDate)) {
        			Data.filteredData.add(v);
        		}
        	}
    	}
    	
    }

    @FXML
    void filterBefore(ActionEvent event) {
    	Data.filteredData.clear();
    	LocalDate beforeDate = beforeDatePicker.getValue();
    	
    	if(beforeDate==null) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    	    alert.setHeaderText(null);
    	    alert.setTitle("Error");
    	    alert.setContentText("Ingrese la fecha.");
    	    alert.showAndWait();
    	} else {
    		for(Value v : Data.data) {
        		if(v.getDate().isBefore(beforeDate) || v.getDate().isEqual(beforeDate)) {
        			Data.filteredData.add(v);
        		}
        	}
    	}
    }

    @FXML
    void filterRange(ActionEvent event) {
    	Data.filteredData.clear();
    	LocalDate initialDate = initialDatePicker.getValue();
    	LocalDate finalDate = finalDatePicker.getValue();
    	
    	if(initialDate==null || finalDate==null) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    	    alert.setHeaderText(null);
    	    alert.setTitle("Error");
    	    alert.setContentText("Ingrese todas las fechas.");
    	    alert.showAndWait();
    	} else {
    		for(Value v : Data.data) {
        		if((v.getDate().isAfter(initialDate) && v.getDate().isBefore(finalDate)) || v.getDate().isEqual(initialDate) || v.getDate().isEqual(finalDate)) {
        			Data.filteredData.add(v);
        		}
        	}
    	}
    }

}

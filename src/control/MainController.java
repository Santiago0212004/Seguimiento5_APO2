package control;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.Main;
import model.Data;
import model.Value;

public class MainController implements Initializable{
	
    @FXML
    private TableView<Value> dataTable;

    @FXML
    private TableColumn<Value, Double> amountCol;

    @FXML
    private TableColumn<Value, String> typeCol;

    @FXML
    private TableColumn<Value, LocalDate> dateCol;

    @FXML
    private TableColumn<Value, String> descriptionCol;

    @FXML
    private Button addElementBTN;

    @FXML
    private TextArea balanceTA;

    @FXML
    private Button refreshBTN;

    @FXML
    private Button deleteBTN;    
    Value valueClicked;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
		typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
		dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
		descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
		
		dataTable.setItems(Data.data);
		
		dataTable.setOnMouseClicked(event -> {
			valueClicked = dataTable.getSelectionModel().getSelectedItem();
		});
		
	}

    @FXML
    void addElement(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/AddValueWindow.fxml"));
		loader.setController(new AddValueController());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void delete(ActionEvent event) {
    	Data.data.remove(valueClicked);
    }

    @FXML
    void openFilterWindow(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/FilterWindow.fxml"));
		loader.setController(new FilterController());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
		
		Data.filteredData.clear();
    	dataTable.setItems(Data.filteredData);
    }

    @FXML
    void refresh(ActionEvent event) {
    	if(dataTable.getItems().equals(Data.data)){
    		double incomes = 0;
        	double spends = 0;
        	double balance = 0;
        	for(Value v : Data.data) {
        		if(v.getType().equalsIgnoreCase("Ingreso")) {
        			incomes += v.getAmount();
        		} else if(v.getType().equalsIgnoreCase("Gasto")) {
        			spends += v.getAmount();
        		}
        	}
        	balance = incomes - spends;
        	
        	balanceTA.setText("Ingresos: "+incomes+"\nGastos: "+spends+"\nBalance: "+balance);
    	}
    	else if(dataTable.getItems().equals(Data.filteredData)) {
    		double incomes = 0;
        	double spends = 0;
        	double balance = 0;
        	for(Value v : Data.filteredData) {
        		if(v.getType().equalsIgnoreCase("Ingreso")) {
        			incomes += v.getAmount();
        		} else if(v.getType().equalsIgnoreCase("Gasto")) {
        			spends += v.getAmount();
        		}
        	}
        	balance = incomes - spends;
        	
        	balanceTA.setText("Ingresos: "+incomes+"\nGastos: "+spends+"\nBalance: "+balance);
    	}
    }

    @FXML
    void reset(ActionEvent event) {
    	Data.data.clear();
    	Data.filteredData.clear();
    }

    @FXML
    void showAll(ActionEvent event) {
    	dataTable.setItems(Data.data);
    }


}

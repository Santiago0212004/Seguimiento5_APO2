package control;

import java.io.IOException;
import java.net.URL;
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
import model.IncomeAndSpend;
import model.Student;

public class Ventana1 implements Initializable{
	@FXML
    private TableView<IncomeAndSpend> incomeSpendsTable;

    @FXML
    private TableColumn<IncomeAndSpend, Double> incomesCol;

    @FXML
    private TableColumn<IncomeAndSpend, Double> spendsCol;

    @FXML
    private TextArea balanceTF;

    @FXML
    private Button addIncomeBTM;

    @FXML
    private Button addSpendBTM;

    @FXML
    private Button refreshBTM;
    
    private IncomeAndSpend stClicked;

    @FXML
    void addIncome(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/Ventana2.fxml"));
		loader.setController(new Ventana2());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void addSpend(ActionEvent event) {

    }

    @FXML
    void refresh(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		incomesCol.setCellValueFactory(new PropertyValueFactory<>("income"));
		spendsCol.setCellValueFactory(new PropertyValueFactory<>("spend"));
		incomeSpendsTable.setItems(Data.incomesAndSpends);
		
		incomeSpendsTable.setOnMouseClicked(event -> {
			stClicked = incomeSpendsTable.getSelectionModel().getSelectedItem();
		});
		
	}
}

package main;

import java.io.IOException;

import control.Ventana1;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main {

	public static void main(String[] args) throws IOException {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/Ventana1.fxml"));
		loader.setController(new Ventana1());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
		
	}

}

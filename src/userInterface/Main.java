package userInterface;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		
		launch();

	}
	
	public void start(Stage stage) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("battleBoard.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Battle Board");
		stage.setScene(scene);
		stage.show();
		
	}

}

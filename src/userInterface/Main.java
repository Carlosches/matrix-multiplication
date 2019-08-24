//______________________________________________________PACKAGE___________________________________________________________

/**
 *This package contains all the classes required to show the user interface and matrices in it. 
 */

package userInterface;

//______________________________________________________IMPORTS___________________________________________________________

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

//______________________________________________________THE CLASS__________________________________________________________

/**
* This class defines the necessary attributes and methods to launch the user interface. 
* @author 
*/

public class Main extends Application {

//______________________________________________________CONSTANTS___________________________________________________________	

//______________________________________________________ATTRIBUTES___________________________________________________________

//______________________________________________________METHODS___________________________________________________________
	
	public static void main(String[] args) {
		
		launch();

	}
	
//________________________________________________________________________________________________________________

	public void start(Stage stage) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("battleBoard.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Battle Board");
		stage.setScene(scene);
		stage.show();
		
		letterbox(scene, root);
		
	}
	
//________________________________________________________________________________________________________________
	
	private void letterbox(final Scene scene, final Parent contentPane) {
	    final double initWidth  = scene.getWidth();
	    final double initHeight = scene.getHeight();
	    final double ratio      = initWidth / initHeight;

	    SceneSizeChangeListener sizeListener = new SceneSizeChangeListener(scene, ratio, initHeight, initWidth, contentPane);
	    scene.widthProperty().addListener(sizeListener);
	    scene.heightProperty().addListener(sizeListener);
	  }

//________________________________________________________________________________________________________________

}

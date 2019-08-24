//______________________________________________________PACKAGE___________________________________________________________

/**
 *This package contains all the classes required to show the user interface and matrices in it. 
 */

package userInterface;

//______________________________________________________IMPORTS___________________________________________________________

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//______________________________________________________THE CLASS__________________________________________________________

/**
* This class defines the necessary attributes and methods to show and control the battle board in the user interface. 
* @author 
*/

public class BoardController {
	
//______________________________________________________CONSTANTS___________________________________________________________	

//______________________________________________________ATTRIBUTES___________________________________________________________
		
    @FXML
    private Tab tabOne;

    @FXML
    private TextField rowMatrixTwo;

    @FXML
    private TextField rowMatrixOne;

    @FXML
    private TextField columnMatrixOne;

    @FXML
    private TextField columnMatrixTwo;

    @FXML
    private ScrollPane scrollPaneOneA;
    
    @FXML
    private ScrollPane scrollPaneOneB;
    
    @FXML
    private ScrollPane scrollPaneTwo;

    @FXML
    private Label tabOneLabel;

    @FXML
    private Tab tabTwo;

    @FXML
    private TextField tabTwoTextField;

    @FXML
    private Label tabTwoLabel;
    
//______________________________________________________METHODS___________________________________________________________

    @FXML
    void tabOneGenerateButton(ActionEvent event) {

    	int rows1=0;
    	int rows2=0;
    	int columns1=0;
    	int columns2=0;
    	GridPane gridPane = new GridPane();
    	
    	gridPane.getChildren().clear();
    	
    	try {
    		
	    	 rows1 = Integer.parseInt(rowMatrixOne.getText());
	    	 columns1 = Integer.parseInt(columnMatrixOne.getText());
	    	 rows2 = Integer.parseInt(rowMatrixTwo.getText());
	    	 columns2 = Integer.parseInt(columnMatrixTwo.getText());
	    	 
    	}catch(NumberFormatException e){
    		
    		tabOneLabel.setText("PLEASE, INTRODUCE ONLY POSITIVE INTEGER VALUES");
    		
    	}
    	
    	GridPane gridPaneOne = new GridPane();
    	gridPaneOne.setPadding(new Insets(20));
    	scrollPaneOneA.setContent(gridPaneOne);
    	GridPane gridPaneTwo = new GridPane();
    	gridPaneTwo.setPadding(new Insets(20));
    	scrollPaneOneB.setContent(gridPaneTwo);
    	
	    	for (int i = 0; i < columns1; i++) {
				for (int j = 0; j < rows1; j++) {
					gridPaneOne.add(new Button(" F "), i, j);
				}
			}

	    	
	    	for (int i = 0; i < columns2; i++) {
				for (int j = 0; j < rows2; j++) {
					gridPaneTwo.add(new Button(" F "), i, j);
				}
			}
    	

		}

//________________________________________________________________________________________________________________

    @FXML
    void tabOneMultiplyButton(ActionEvent event) {
    	
    	
		try {
			
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("outcome.fxml"));
			Parent root1= (Parent)fxmlLoader.load();
			
			Stage stage= new Stage();
			
			stage.setTitle("OUTCOME MATRIX");
			
			stage.setScene(new Scene(root1));
			
			stage.show();
			
		} catch (IOException e) {
			
			System.out.println("ERROR");
			e.printStackTrace();
			
		}
    	
    }

//________________________________________________________________________________________________________________

    @FXML
    void tabTwoGenerateButton(ActionEvent event) {
    	
    	try {
    		
    		tabTwoLabel.setText("Here you can generate as many random matrices as you want");
    		
	    	int num = Integer.parseInt(tabTwoTextField.getText());
	    	GridPane gridPane = new GridPane();
	    	scrollPaneTwo.setContent(gridPane);
	    	gridPane.getChildren().clear();
	    	
	    	for (int k = 0; k < num; k++) {
	    		GridPane gridPane2 = new GridPane();
	    		gridPane2.getChildren().clear();
	    		gridPane2.setPadding(new Insets(20));
	    		for (int i = 0; i < 5; i++) {
	    			for (int j = 0; j < 5; j++) {
	    				gridPane2.add(new Button(" F "), i, j);
	    			}
	    		}
	    	
	    		gridPane.add(gridPane2, k,0);
			}
    	
    	}catch(NumberFormatException e) {
    		
    		tabTwoLabel.setText("PLEASE, INTRODUCE ONLY POSITIVE INTEGER VALUES");
    		
    	}
    }

//________________________________________________________________________________________________________________
 
    @FXML
    void tabTwoMultiplyButton(ActionEvent event) {
    	
    	try {
			
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("outcome.fxml"));
			Parent root1= (Parent)fxmlLoader.load();
			
			Stage stage= new Stage();
			
			stage.setTitle("OUTCOME MATRIX");
			
			stage.setScene(new Scene(root1));
			
			stage.show();
			
		} catch (IOException e) {
			
			System.out.println("ERROR");
			e.printStackTrace();
			
		}
    	
    }
    
//________________________________________________________________________________________________________________
 

}

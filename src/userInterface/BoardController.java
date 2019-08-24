package userInterface;

import java.awt.font.NumericShaper;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
<<<<<<< HEAD
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
=======
import javafx.geometry.Insets;
>>>>>>> 288f20681103a37a719be38707c079866ef05f26
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BoardController {

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
    
    @FXML
    void tabOneGenerateButton(ActionEvent event) {
<<<<<<< HEAD
    	
    	try {
    		
    		tabOneLabel.setText("");
    	
    		int rows = Integer.parseInt(rowMatrixOne.getText());
    		int columns = Integer.parseInt(columnMatrixOne.getText());
    		
    		GridPane gridPane = new GridPane();
        	scrollPaneOneA.setContent(gridPane);
        	
        	gridPane.getChildren().clear();
        	
        	 
        	for (int i = 0; i < columns; i++) {
    			for (int j = 0; j < rows; j++) {
    				gridPane.add(new Button(" F "), i, j);
    			}
    		}
        	
        	int rowsB = Integer.parseInt(rowMatrixTwo.getText());
        	int columnsB = Integer.parseInt(columnMatrixTwo.getText());
        	
        	GridPane gridPane2 = new GridPane();
        	scrollPaneOneB.setContent(gridPane2);
        	
        	gridPane2.getChildren().clear();
        	
        	 
        	for (int i = 0; i < columnsB; i++) {
    			for (int j = 0; j < rowsB; j++) {
    				gridPane2.add(new Button(" F "), i, j);
    			}
    		}
    	
    	}catch(NumberFormatException e) {
    		
    		tabOneLabel.setText("PLEASE, INTRODUCE ONLY INTEGERS");
    		
    	}
=======
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
    		System.out.println(88);
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
>>>>>>> 288f20681103a37a719be38707c079866ef05f26

    

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

    @FXML
    void tabTwoGenerateButton(ActionEvent event) {
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
    }

    @FXML
    void tabTwoMultiplyButton(ActionEvent event) {

    }

}

package userInterface;

import java.awt.font.NumericShaper;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    }

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

    }

    @FXML
    void tabTwoMultiplyButton(ActionEvent event) {

    }

}

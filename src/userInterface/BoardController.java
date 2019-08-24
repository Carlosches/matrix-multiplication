package userInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

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

    }

    @FXML
    void tabOneMultiplyButton(ActionEvent event) {

    }

    @FXML
    void tabTwoGenerateButton(ActionEvent event) {

    }

    @FXML
    void tabTwoMultiplyButton(ActionEvent event) {

    }

}

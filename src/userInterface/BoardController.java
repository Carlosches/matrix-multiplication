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
    private ScrollPane scrollPaneOne;
    
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
    	scrollPaneOne.setContent(gridPane);
    	
    	gridPane.getChildren().clear();
    	
    	 
    	for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				gridPane.add(new Button(" F "), i, j);
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

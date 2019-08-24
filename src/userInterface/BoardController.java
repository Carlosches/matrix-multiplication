package userInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
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
    	int rows1=0;
    	int rows2=0;
    	int columns1=0;
    	int columns2=0;
    	GridPane gridPane = new GridPane();
    	scrollPaneOne.setContent(gridPane);
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
    	GridPane gridPaneTwo = new GridPane();
    	gridPaneTwo.setPadding(new Insets(20));
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
    	 gridPane.add(gridPaneOne, 0, 0);
    	 gridPane.add(gridPaneTwo, 1, 0);

    }

    @FXML
    void tabOneMultiplyButton(ActionEvent event) {

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

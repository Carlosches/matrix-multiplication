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
import model.*;

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
    
    private Board board;
    
//______________________________________________________METHODS___________________________________________________________
    
    @FXML
    private void initialize() {
    	board = new Board();
    }
    
//________________________________________________________________________________________________________________

    /**
     * <b>Description:</b>
     * This method allows to generate and show two matrices with specific values of the rows and columns.
     * The matrices will only be generated if you can multiply each other
     * 
     * @param event, the click on the button
     * <b>post:</b>  the list of the matrices of the object board has been modified
     */
    
    @FXML
    void tabOneGenerateButton(ActionEvent event) {
    	tabOneLabel.setText("");
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
    	
    	if(validateSizes(columns1, rows2)) {
    		board.getMatrices().clear();
    		Matrix firstMatrix = new Matrix(Matrix.LAST_BATTLE_MATRIX, rows1, columns1);
    		Matrix secondMatrix = new Matrix(Matrix.COEFFICIENTS_MATRIX, rows2, columns2);
    		board.getMatrices().add(firstMatrix);
    		board.getMatrices().add(secondMatrix);
    		
	    	GridPane gridPaneOne = new GridPane();
	    	gridPaneOne.setPadding(new Insets(20));
	    	scrollPaneOneA.setContent(gridPaneOne);
	    	GridPane gridPaneTwo = new GridPane();
	    	gridPaneTwo.setPadding(new Insets(20));
	    	scrollPaneOneB.setContent(gridPaneTwo);
	    	
		    	for (int i = 0; i < rows1; i++) {
					for (int j = 0; j < columns1; j++) {
						Button button = new Button(""+firstMatrix.getMatrix()[i][j]);
						button.setPadding(new Insets(20));
						gridPaneOne.add(button, j, i);
					}
				}
	
		    	
		    	for (int i = 0; i < rows2; i++) {
					for (int j = 0; j < columns2; j++) {
						Button button = new Button(""+secondMatrix.getMatrix()[i][j]);
						button.setPadding(new Insets(20));
						gridPaneTwo.add(button, j,i );
					}
				}
	    	
    	}else {
    		tabOneLabel.setText("The amount of columns in the first matrix must be equal "+"\n"+" to the amount of rows in the second matrix");
    	}
	}

	/**
	 * <b>Description:</b>
	 * This function validates the sizes of two matrices to determine whether or not they can be mutliplied
	 * @param a the number of columns in the first matrix.
	 * @param b the number of rows in the second matrix.
	 * @return True if they can be multiplied, false otherwise.
	 */
	public boolean validateSizes(int a, int b){
    	boolean success = false;
    	if(a == b)
    		success = true;
    	return success;
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
    /**
     * <b>Description:</b>
     * This method allows to show a list of matrices with random values of the rows and columns.
     * 
     * @param event, the click on the button
     * <b>post:</b>  the list of the matrices of the object board has been modified
     */
    
    @FXML
    void tabTwoGenerateButton(ActionEvent event) {
    	
    	try {
    		
    		tabTwoLabel.setText("Here you can generate as many random matrices as you want");
    		
	    	int num = Integer.parseInt(tabTwoTextField.getText());
	    	GridPane gridPane = new GridPane();
	    	scrollPaneTwo.setContent(gridPane);
	    	gridPane.getChildren().clear();
	    	
	    	board.generateMatrices(num);
	    	
	    	for (int k = 0; k < board.getMatrices().size(); k++) {
				int[][] currentMatrix = board.getMatrices().get(k).getMatrix();
	    		GridPane gridPane2 = new GridPane();
	    		gridPane2.setPadding(new Insets(20));
	    		
	    		for (int i = 0; i < currentMatrix.length; i++) {
	    			for (int j = 0; j < currentMatrix[i].length; j++) {
	    				gridPane2.add(new Button(""+currentMatrix[i][j]), j,i);
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

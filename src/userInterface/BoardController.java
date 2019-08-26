//______________________________________________________PACKAGE___________________________________________________________

/**
 *This package contains all the classes required to show the user interface and matrices in it. 
 */

package userInterface;


//______________________________________________________IMPORTS___________________________________________________________

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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
    private ScrollPane scrollPaneThree;

    @FXML
    private Label tabOneLabel;

    @FXML
    private Tab tabTwo;
    
    @FXML
    private Tab tabThree;

    @FXML
    private TextField tabTwoTextField;

    @FXML
    private Label tabTwoLabel;
    
    private Board board;
    
    private int[][] matrix;
    
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
    		
    		List<String> shipsOne = firstMatrix.findShips(board.getPrimes());
    		List<String> shipsTwo = secondMatrix.findShips(board.getPrimes());
    		
	    	GridPane gridPaneOne = new GridPane();
	    	gridPaneOne.setPadding(new Insets(20));
	    	scrollPaneOneA.setContent(gridPaneOne);
	    	GridPane gridPaneTwo = new GridPane();
	    	gridPaneTwo.setPadding(new Insets(20));
	    	scrollPaneOneB.setContent(gridPaneTwo);
	    	
		    	for (int i = 0; i < rows1; i++) {
					for (int j = 0; j < columns1; j++) {
						Button  button = new Button(""+firstMatrix.getMatrix()[i][j]);
						if(shipsOne.contains(i+","+j)) {
							 button.setTextFill(Color.BLUE);
							 
						}
						button.setPadding(new Insets(20));
						gridPaneOne.add(button, j, i);
					}
				}
	
		    	
		    	for (int i = 0; i < rows2; i++) {
					for (int j = 0; j < columns2; j++) {
						Button button = new Button(""+secondMatrix.getMatrix()[i][j]);
						if(shipsTwo.contains(i+","+j)) {
							 button.setTextFill(Color.BLUE);
							 
						}
						button.setPadding(new Insets(20));
						gridPaneTwo.add(button, j,i );
					}
				}
		    	tabOneLabel.setText("the blue numbers represent the ships".toUpperCase());
    	}else {
    		tabOneLabel.setText("The amount of columns in the first matrix must be equal "+"\n"+" to the amount of rows in the second matrix");
    	}
	}

    
   /* public void addImageButton(Button button) {
    	
    	ImageView image = new ImageView(new Image("/image/ship.png"));
    	
    	button.setGraphic(image);
    }*/
//________________________________________________________________________________________________________________


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
    	
    	if(!board.getMatrices().isEmpty()) {
	    	matrix = board.multiplyMatricesFirstOption();
	    	
	    	GridPane gridPane = new GridPane();
	    	gridPane.getChildren().clear();
	    	gridPane.setPadding(new Insets(20));
	    	scrollPaneThree.setContent(gridPane);
	    	
	    	for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					int cur = +matrix[i][j];
					Button button = new Button(""+cur);
					if(board.getPrimes()[cur]==0)
						button.setTextFill(Color.BLUE);
					button.setPadding(new Insets(20));
					gridPane.add(button, j,i );
				}
			}
	    	tabOneLabel.setText("YOU CAN SEE THE RESULT IN RESULT TAB");
    	}else {
    		tabOneLabel.setText("ENTER THE MATRICES PLEASE");
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
				Matrix act = board.getMatrices().get(k);
				List<String> positions = act.findShips(board.getPrimes());
				 int[][] currentMatrix = act.getMatrix();
	    		GridPane gridPane2 = new GridPane();
	    		gridPane2.setPadding(new Insets(20));
	    		
	    		for (int i = 0; i < currentMatrix.length; i++) {
	    			for (int j = 0; j < currentMatrix[i].length; j++) {
	    				Button button = new Button(""+currentMatrix[i][j]);
	    				if(positions.contains(""+i+","+j)) {
	    					button.setTextFill(Color.BLUE);
	    				}
	    				gridPane2.add(button, j,i);
	    			
	    					
	    			}
	    		}
	    	
	    		gridPane.add(gridPane2, k,0);
	    	}
	    	tabTwoLabel.setText("the blue numbers represent the ships".toUpperCase());
    	}catch(NumberFormatException e) {
    		
    		tabTwoLabel.setText("PLEASE, INTRODUCE ONLY POSITIVE INTEGER VALUES");
    		
    	}
    }

//________________________________________________________________________________________________________________
 
    @FXML
    void tabTwoMultiplyButton(ActionEvent event) {
    	
    	if(board.getMatrices().isEmpty()) {
	    	matrix = board.multiplyMatricesFirstOption();
	    	
	    	GridPane gridPane = new GridPane();
	    	gridPane.getChildren().clear();
	    	gridPane.setPadding(new Insets(20));
	    	scrollPaneThree.setContent(gridPane);
	    	
	    	for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					int cur = matrix[i][j];
					Button button = new Button(""+cur);
					if(cur<10000000 && board.getPrimes()[cur]==0)
						button.setTextFill(Color.BLUE);
					button.setPadding(new Insets(20));
					gridPane.add(button, j,i );
				}
			}
	    	tabTwoLabel.setText("ENTER THE MATRICES PLEASE");
    	}else {
    		tabTwoLabel.setText("YOU CAN SEE THE RESULT IN RESULT TAB");
    	}
    	
    	
    }
    
//________________________________________________________________________________________________________________
 

}

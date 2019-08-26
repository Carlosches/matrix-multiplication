//______________________________________________________PACKAGE___________________________________________________________

/**
 *This package contains all the classes required to show the user interface and matrices in it. 
 */

package userInterface;

//______________________________________________________IMPORTS___________________________________________________________

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import model.Board;

//______________________________________________________THE CLASS__________________________________________________________

/**
* This class defines the necessary attributes and methods to show the window in which the the product of the matrices will be shown. 
* @author 
*/

public class OutcomeController {

//______________________________________________________CONSTANTS___________________________________________________________	

//______________________________________________________ATTRIBUTES___________________________________________________________
		
    @FXML
    private ScrollPane outcomeScrollPane;
    
    private Board board;
    
//______________________________________________________METHODS___________________________________________________________
    
    @FXML
    public void initialize() {
    	
    	board = new Board();
    	
    	
    }

//________________________________________________________________________________________________________________
    
    public void generateMatrix() {
    	
    	GridPane gridPane = new GridPane();
    	
    }
    
 //________________________________________________________________________________________________________________
    
}


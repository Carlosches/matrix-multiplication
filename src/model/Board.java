//______________________________________________________PACKAGE___________________________________________________________

/**
 *This package contains all the classes required to multiply matrices and finding prime numbers. 
 */

package model;

//______________________________________________________IMPORTS___________________________________________________________

import java.util.List;

//______________________________________________________THE CLASS__________________________________________________________

/**
* This class defines the necessary methods to multiply matrices and finding prime numbers. 
* @author 
*/

public class Board {

//______________________________________________________CONSTANTS___________________________________________________________	
	
	public static final String SHIP_IMAGE = "";
	
//______________________________________________________ATTRIBUTES___________________________________________________________

	private int[] primeNumbers;
	private List<Matrix> matrices;
	
//______________________________________________________METHODS___________________________________________________________
	
	/**
	 * The constructor of the battle board.<br><br>
	 */
	
	public Board() {
		
	}
	
//________________________________________________________________________________________________________________
	
	/**
	 * This method multiply matrices by using the iterative algorithm.<br><br>
	 * <b>Pre: </b>
	 * <b>Post: </b>
	 */
	
	public void multiplyMatricesFirstOption() {
		
	}
	
//________________________________________________________________________________________________________________
	
	/**
	 * This method multiply matrices by using the divide and conquer algorithm.<br><br>
	 * <b>Pre: </b>
	 * <b>Post: </b>
	 */
	
	public void multiplyMatricesSecondOption() {
		
	}
	
//________________________________________________________________________________________________________________
	
	/**
	 * This method multiply matrices by using the Strassen algorithm.<br><br>
	 * <b>Pre: </b>
	 * <b>Post: </b>
	 */
	
	public void multiplyMatricesThirdOption() {
	
	}
	
//________________________________________________________________________________________________________________
	
	/**
	 * 
	 */
	
	public void generatePrimes() {
		
		primeNumbers[0] = primeNumbers[1] = 1;
		
		for(int i = 2; i < 1000; i++){
		
			if(primeNumbers[i] == 0){
			
				int mul = 2;
				while(mul * i < 1000001)
					primeNumbers[mul++ * i] = 1;
			}
		}		
	}
	
	public int[] getPrimes() {
		return primeNumbers;
	}
	
//________________________________________________________________________________________________________________
	
}

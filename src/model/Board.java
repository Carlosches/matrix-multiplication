//______________________________________________________PACKAGE___________________________________________________________

/**
 *This package contains all the classes required to multiply matrices and finding prime numbers. 
 */

package model;

import java.util.ArrayList;

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
	 * <b>Description:</b>
	 * The constructor of the battle board.<br><br>
	 */
	
	public Board() {
		matrices = new ArrayList<>();
		
	}
	
//________________________________________________________________________________________________________________
	
	/**
	 * <b>Description:</b>
	 * This method multiply matrices by using the iterative algorithm.<br><br>
	 * <b>Pre: </b>
	 * <b>Post: </b>
	 */
	
	public void multiplyMatricesFirstOption() {
		
	}
	
//________________________________________________________________________________________________________________
	
	/**
	 * <b>Description:</b>
	 * This method multiply matrices by using the divide and conquer algorithm.<br><br>
	 * <b>Pre: </b>
	 * <b>Post: </b>
	 */
	
	public void multiplyMatricesSecondOption() {
		
	}
	
//________________________________________________________________________________________________________________
	
	/**
	 * <b>Description:</b>
	 * This method multiply matrices by using the Strassen algorithm.<br><br>
	 * <b>Pre: </b>
	 * <b>Post: </b>
	 */
	
	public void multiplyMatricesThirdOption() {
	
	}
	
//________________________________________________________________________________________________________________
	
	/**
	 * <b>Description:</b>
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
	
//________________________________________________________________________________________________________________
	
	/**
	 * <b>Description:</b>
     * This function allows to generate a specific quantity of matrices with random values.
     * Ensures that the generated matrices can be multiplied.
     * <b>pre:</b> The board must not be null
     * <b>post:</b> the matrices' list has been modified
	 * @param quantity number of matrices to be generated
	 */
	
	public void generateMatrices(int quantity) {
		matrices.clear();
		int next = (int)(Math.random()*10)+1;
		for (int i = 0; i < quantity; i++) {
			if(i==0) {
				int ro = (int)(Math.random()*10)+1;
				Matrix mat = new Matrix(Matrix.OTHER,ro,next);
				matrices.add(mat);
			}else {
				int column = (int)(Math.random()*10)+1;
				Matrix mat = new Matrix(Matrix.OTHER,next,column);
				next = column;
				matrices.add(mat);
			}
		}
		
	}
	
//________________________________________________________________________________________________________________
	
	/**
	 * <b>Description:</b>
	 * 
	 * @return
	 */
	
	public int[] getPrimes() {
		return primeNumbers;
	}

//________________________________________________________________________________________________________________

	/**
	 * <b>Description:</b>
	 * 
	 * @return the matrices
	 */
	public List<Matrix> getMatrices() {
		return matrices;
	}
	
//________________________________________________________________________________________________________________

	/**
	 * <b>Description:</b>
	 * 
	 * @param matrices the matrices to set
	 */
	public void setMatrices(List<Matrix> matrices) {
		this.matrices = matrices;
	}
	
	
//________________________________________________________________________________________________________________
	
}

//______________________________________________________PACKAGE___________________________________________________________

/**
 *This package contains all the classes required to multiply matrices and finding prime numbers. 
 */

package model;

//______________________________________________________IMPORTS___________________________________________________________

import java.util.List;

//______________________________________________________THE CLASS__________________________________________________________

/**
* This class defines the necessary attributes and methods to build the matrices. 
* @author 
*/

public class Matrix {

//______________________________________________________CONSTANTS___________________________________________________________	

	public static final String LAST_BATTLE_MATRIX = "battle";
	public static final String COEFFICIENTS_MATRIX = "coefficients";
	public static final String CURRENT_BATTLE_MATRIX = "current";
	public static final String OTHER = "other";
	
//______________________________________________________ATTRIBUTES___________________________________________________________

	private String type;
	private int[][] matrix;
	private int rows;
	private int columns;
	private boolean repeatedNumbers;
	
//______________________________________________________METHODS___________________________________________________________

	public Matrix(String type, int rows, int columns) {
		this.type = type;
		this.rows = rows;
		this.columns = columns;
		matrix = new int[rows][columns];
		fillMatrix();
	}
	
//________________________________________________________________________________________________________________
	/**
	 * <b>Description:</b>
	 * This method allows to fill the matrix with random values
	 * <b>post:</b> the parameter matrix has been modified
	 */
	private void fillMatrix() {
		
		for (int i = 0; i < rows; i++) {
			
			for (int j = 0; j < columns; j++) {
				int num = (int) (Math.random()*150)+1;
				matrix[i][j] = num;
			}
		}
		
	}

//________________________________________________________________________________________________________________

	public List<String> findShips(){
		return null;
	}

//________________________________________________________________________________________________________________

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

//________________________________________________________________________________________________________________

	/**
	 * @return the matrix
	 */
	public int[][] getMatrix() {
		return matrix;
	}

//________________________________________________________________________________________________________________

	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

//________________________________________________________________________________________________________________

	/**
	 * @return the columns
	 */
	public int getColumns() {
		return columns;
	}

//________________________________________________________________________________________________________________

	/**
	 * @return the repeatedNumbers
	 */
	public boolean isRepeatedNumbers() {
		return repeatedNumbers;
	}

//________________________________________________________________________________________________________________	
	
}


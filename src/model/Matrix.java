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
	
	/**
	 * <b>Description:</b>
	 * The constructor of the matrices.
	 * @param type The type of the matrix.
	 * @param rows The number of rows of the matrix.
	 * @param columns The number of columns of the matrix.
	 */
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
	 * This method allows to fill the matrix with random values.
	 * <b>Pre: </b> the matrix must not be null.
	 * <b>post:</b> the parameter matrix has been modified.
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
	 * <b>Description:</b>
	 * This method returns the type of the matrix.
	 * <b>Pre: </b> The matrix must not be null.
	 * @return the type
	 */
	public String getType() {
		return type;
	}

//________________________________________________________________________________________________________________

	/**
	 * <b>Description:</b>
	 * This method returns a two dimensional array that contains all the numbers.
	 * <b>Pre: </b> The matrix must not be null.
	 * @return the matrix
	 */
	public int[][] getMatrix() {
		return matrix;
	}

//________________________________________________________________________________________________________________

	/**
	 * <b>Description:</b>
	 * This methods returns the number of rows of the matrix.
	 * <b>Pre: </b> The matrix must not be null.
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

//________________________________________________________________________________________________________________

	/**
	 * <b>Description:</b>
	 * This methods returns the number of columns of the matrix.
	 * <b>Pre: </b> The matrix must not be null.
	 * @return the columns
	 */
	public int getColumns() {
		return columns;
	}

//________________________________________________________________________________________________________________

	/**
	 * <b>Description:</b>
	 * 
	 * @return the repeatedNumbers
	 */
	public boolean isRepeatedNumbers() {
		return repeatedNumbers;
	}

//________________________________________________________________________________________________________________	
	
	/**
	 * <b>Description:</b>
	 * This methods changes the array that contains the number for another that is given as parameter
	 * <b>Pre: </b> The matrix must not be null.
	 * <b>Post: </b> The array has been modified.
	 * @param newMatrix the new matrix.
	 */
	
	public void setMatrix(int[][] newMatrix) {
		
		this.matrix = newMatrix;
		
	}
	
//________________________________________________________________________________________________________________	
	
}


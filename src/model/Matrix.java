package model;

import java.util.List;

public class Matrix {
	
<<<<<<< HEAD
=======
	public static final String LAST_BATTLE_MATRIX = "battle";
	public static final String COEFFICIENTS_MATRIX = "coefficients";
	public static final String CURRENT_BATTLE_MATRIX = "current";
	
	private String type;
	private int[][] matrix;
	private int rows;
	private int columns;
	private boolean repeatedNumbers;
	
	public Matrix(String type, int rows, int columns) {
		this.type = type;
		this.rows = rows;
		this.columns = columns;
	}
	
	public void fillMatrix() {
		
	}
	
	public List<String> findShips(){
		return null;
	}

	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the matrix
	 */
	public int[][] getMatrix() {
		return matrix;
	}

	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @return the columns
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * @return the repeatedNumbers
	 */
	public boolean isRepeatedNumbers() {
		return repeatedNumbers;
	}
>>>>>>> ca1e4f1efd11ca6f5b55a1eeb8370e675fd9b3d6
	
	
}


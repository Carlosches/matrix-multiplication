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
	 * The constructor of the battle board.<br><br>
	 */
	
	public Board() {
		matrices = new ArrayList<>();
		
	}
	
//________________________________________________________________________________________________________________
	
	/**
	 * This method multiply matrices by using the iterative algorithm.<br><br>
	 * <b>Pre: </b>
	 * <b>Post: </b>
	 */
	
	public int[][] multiplyMatricesFirstOption() {
		int[][] A = matrices.get(0).getMatrix();
		for (int y = 1; y < matrices.size(); y++) {
			int[][] B = matrices.get(y).getMatrix();
			int n = A.length;
			int m = B[0].length;
			int p = A[0].length;
			int[][] C = new int[n][m];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					for(int k = 0; k < p; k++){
						C[i][j] += A[i][k] * B[k][j];
					}
				}
			}
			A = C;
		}

		return A;
	}
	
//________________________________________________________________________________________________________________

	public int[][] multiplyMatricesSecondOption(){
		int[][] A = matrices.get(0).getMatrix();
		for (int i = 1; i < matrices.size(); i++) {
			int[][] B = matrices.get(i).getMatrix();
			A = multiplyMatricesSecondOptionAux(A, B, A.length);
		}
		return A;
	}

	/**
	 * This method multiply matrices by using the divide and conquer algorithm.<br><br>
	 * <b>Pre: </b>
	 * <b>Post: </b>
	 */
	
	private int[][] multiplyMatricesSecondOptionAux(int[][] A, int[][] B, int n) {
		int[][] C = new int[n][n];
		if (n == 1) {
			C[0][0] = A[0][0] * B[0][0];
			return C;
		} else {
			int[][] A11 = new int[n / 2][n / 2];
			int[][] A12 = new int[n / 2][n / 2];
			int[][] A21 = new int[n / 2][n / 2];
			int[][] A22 = new int[n / 2][n / 2];
			int[][] B11 = new int[n / 2][n / 2];
			int[][] B12 = new int[n / 2][n / 2];
			int[][] B21 = new int[n / 2][n / 2];
			int[][] B22 = new int[n / 2][n / 2];

			deconstructMatrix(A, A11, 0, 0);
			deconstructMatrix(A, A12, 0, n / 2);
			deconstructMatrix(A, A21, n / 2, 0);
			deconstructMatrix(A, A22, n / 2, n / 2);
			deconstructMatrix(B, B11, 0, 0);
			deconstructMatrix(B, B12, 0, n / 2);
			deconstructMatrix(B, B21, n / 2, 0);
			deconstructMatrix(B, B22, n / 2, n / 2);

			int[][] C11 = addMatrix(multiplyMatricesSecondOptionAux(A11, B11, n / 2), multiplyMatricesSecondOptionAux(A12, B21, n / 2), n / 2);
			int[][] C12 = addMatrix(multiplyMatricesSecondOptionAux(A11, B12, n / 2), multiplyMatricesSecondOptionAux(A12, B22, n / 2), n / 2);
			int[][] C21 = addMatrix(multiplyMatricesSecondOptionAux(A21, B11, n / 2), multiplyMatricesSecondOptionAux(A22, B21, n / 2), n / 2);
			int[][] C22 = addMatrix(multiplyMatricesSecondOptionAux(A21, B12, n / 2), multiplyMatricesSecondOptionAux(A22, B22, n / 2), n / 2);

			constructMatrix(C11, C, 0, 0);
			constructMatrix(C12, C, 0, n / 2);
			constructMatrix(C21, C, n / 2, 0);
			constructMatrix(C22, C, n / 2, n / 2);
		}

		return C;

	}

	private void constructMatrix(int[][] initialMatrix, int[][] newMatrix, int a, int b) {
		int y = b;
		for (int i = 0; i < initialMatrix.length; i++) {
			for (int j = 0; j < initialMatrix.length; j++) {
				newMatrix[a][y++] = initialMatrix[i][j];
			}
			y = b;
			a++;
		}
	}


	private int[][] addMatrix(int[][] A, int[][] B, int n){
		int[][] C = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		return C;
	}

	private void deconstructMatrix(int[][] initialMatrix, int[][] newMatrix, int a, int b) {
		int y = b;
		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix.length; j++) {
				newMatrix[i][j] = initialMatrix[a][y++];
			}
			y = b;
			a++;
		}
	}

	private int[][] subtractMatrix(int[][] A, int[][] B, int n) {
		int[][] C = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				C[i][j] = A[i][j] - B[i][j];
			}
		}
		return C;
	}

//________________________________________________________________________________________________________________

	public int[][] multiplyMatricesThirdOption(){
		int[][] A = matrices.get(0).getMatrix();
		for (int i = 1; i < matrices.size(); i++) {
			int[][] B = matrices.get(i).getMatrix();
			int[][] C = new int[B.length][B.length];
			multiplyMatricesThirdOptionAux(A, B, C, A.length);
			A = C;
		}
		return A;
	}

	/**
	 * This method multiply matrices by using the Strassen algorithm.<br><br>
	 * <b>Pre: </b>
	 * <b>Post: </b>
	 */

	private void multiplyMatricesThirdOptionAux(int[][] A, int[][] B, int[][] C, int n) {
		if (n == 2) {
			C[0][0] = (A[0][0] * B[0][0]) + (A[0][1] * B[1][0]);
			C[0][1] = (A[0][0] * B[0][1]) + (A[0][1] * B[1][1]);
			C[1][0] = (A[1][0] * B[0][0]) + (A[1][1] * B[1][0]);
			C[1][1] = (A[1][0] * B[0][1]) + (A[1][1] * B[1][1]);
		} else {
			int[][] A11 = new int[n / 2][n / 2];
			int[][] A12 = new int[n / 2][n / 2];
			int[][] A21 = new int[n / 2][n / 2];
			int[][] A22 = new int[n / 2][n / 2];
			int[][] B11 = new int[n / 2][n / 2];
			int[][] B12 = new int[n / 2][n / 2];
			int[][] B21 = new int[n / 2][n / 2];
			int[][] B22 = new int[n / 2][n / 2];

			int[][] P = new int[n / 2][n / 2];
			int[][] Q = new int[n / 2][n / 2];
			int[][] R = new int[n / 2][n / 2];
			int[][] S = new int[n / 2][n / 2];
			int[][] T = new int[n / 2][n / 2];
			int[][] U = new int[n / 2][n / 2];
			int[][] V = new int[n / 2][n / 2];

			deconstructMatrix(A, A11, 0, 0);
			deconstructMatrix(A, A12, 0, n / 2);
			deconstructMatrix(A, A21, n / 2, 0);
			deconstructMatrix(A, A22, n / 2, n / 2);
			deconstructMatrix(B, B11, 0, 0);
			deconstructMatrix(B, B12, 0, n / 2);
			deconstructMatrix(B, B21, n / 2, 0);
			deconstructMatrix(B, B22, n / 2, n / 2);

			multiplyMatricesThirdOptionAux(addMatrix(A11, A22, n / 2), addMatrix(B11, B22, n / 2), P, n / 2);
			multiplyMatricesThirdOptionAux(addMatrix(A21, A22, n / 2), B11, Q, n / 2);
			multiplyMatricesThirdOptionAux(A11, subtractMatrix(B12, B22, n / 2), R, n / 2);
			multiplyMatricesThirdOptionAux(A22, subtractMatrix(B21, B11, n / 2), S, n / 2);
			multiplyMatricesThirdOptionAux(addMatrix(A11, A12, n / 2), B22, T, n / 2);
			multiplyMatricesThirdOptionAux(subtractMatrix(A21, A11, n / 2), addMatrix(B11, B12, n / 2), U, n / 2);
			multiplyMatricesThirdOptionAux(subtractMatrix(A12, A22, n / 2), addMatrix(B21, B22, n / 2), V, n / 2);

			int[][] C11 = addMatrix(subtractMatrix(addMatrix(P, S, P.length), T, T.length), V, V.length);
			int[][] C12 = addMatrix(R, T, R.length);
			int[][] C21 = addMatrix(Q, S, Q.length);
			int[][] C22 = addMatrix(subtractMatrix(addMatrix(P, R, P.length), Q, Q.length), U, U.length);

			constructMatrix(C11, C, 0, 0);
			constructMatrix(C12, C, 0, n / 2);
			constructMatrix(C21, C, n / 2, 0);
			constructMatrix(C22, C, n / 2, n / 2);
		}
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
	
	/**
	 * <b>Description:</b>
     * This function allows to generate a specific quantity of matrices with random values.
     * Ensures that the generated matrices can be multiplied
     * 
	 * @param quantity number of matrices to be generated
	 * <b>post:</b> the matrices' list has been modified
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
	
	public int[] getPrimes() {
		return primeNumbers;
	}

	/**
	 * @return the matrices
	 */
	public List<Matrix> getMatrices() {
		return matrices;
	}

	/**
	 * @param matrices the matrices to set
	 */
	public void setMatrices(List<Matrix> matrices) {
		this.matrices = matrices;
	}
	
	
//________________________________________________________________________________________________________________
	
}

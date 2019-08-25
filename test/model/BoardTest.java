package model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {
	
//________________________________________________ATTRIBUTES________________________________________________________________
	
	private Board board;
	
//________________________________________________STAGES________________________________________________________________

	private void stage1() {
		
		board = new Board();
		
	}
	
//________________________________________________TEST METHODS________________________________________________________________
	
	@Test
	public void testMultiplyMatricesFirstOption_StandarCase() {
		
		stage1();
		
		int[][] A = new int[6][5];
		int[][] B = new int[5][4];
		int[][] C = new int[6][4];
		
		A[0][0] = 5;
		A[0][1] = 7;
		A[0][2] = 12;
		A[0][3] = 4;
		A[0][4] = 23;
		A[1][0] = 11;
		A[1][1] = 17;
		A[1][2] = 34;
		A[1][3] = 45;
		A[1][4] = 2;
		A[2][0] = 1;
		A[2][1] = 0;
		A[2][2] = 20;
		A[2][3] = 11;
		A[2][4] = 3;
		A[3][0] = 4;
		A[3][1] = 34;
		A[3][2] = 22;
		A[3][3] = 13;
		A[3][4] = 17;
		A[4][0] = 1;
		A[4][1] = 5;
		A[4][2] = 15;
		A[4][3] = 23;
		A[4][4] = 30;
		A[5][0] = 8;
		A[5][1] = 21;
		A[5][2] = 19;
		A[5][3] = 13;
		A[5][4] = 12;
		
		B[0][0] = 15;
		B[0][1] = 73;
		B[0][2] = 21;
		B[0][3] = 2;
		B[1][0] = 1;
		B[1][1] = 7;
		B[1][2] = 17;
		B[1][3] = 50;
		B[2][0] = 5;
		B[2][1] = 2;
		B[2][2] = 0;
		B[2][3] = 110;
		B[3][0] = 40;
		B[3][1] = 15;
		B[3][2] = 9;
		B[3][3] = 27;
		B[4][0] = 41;
		B[4][1] = 6;
		B[4][2] = 17;
		B[4][3] = 25;
		
		C[0][0] = 1245;
		C[0][1] = 636;
		C[0][2] = 651;
		C[0][3] = 2363;
		C[1][0] = 2234;
		C[1][1] = 1677;
		C[1][2] = 959;
		C[1][3] = 5877;
		C[2][0] = 678;
		C[2][1] = 296;
		C[2][2] = 171;
		C[2][3] = 2574;
		C[3][0] = 1421;
		C[3][1] = 871;
		C[3][2] = 1068;
		C[3][3] = 4904;
		C[4][0] = 2245;
		C[4][1] = 663;
		C[4][2] = 823;
		C[4][3] = 3273;
		C[5][0] = 1248;
		C[5][1] = 1036;
		C[5][2] = 846;
		C[5][3] = 3807;
		
		Matrix matrixA = new Matrix(Matrix.LAST_BATTLE_MATRIX, 6, 5);
		Matrix matrixB = new Matrix(Matrix.COEFFICIENTS_MATRIX, 5, 4);
		
		matrixA.setMatrix(A);
		matrixB.setMatrix(B);
		
		board.getMatrices().add(matrixA);
		board.getMatrices().add(matrixB);
		
		int[][] D = board.multiplyMatricesFirstOption();
		
		boolean correctMultiplication = true;
		
		for (int i = 0; i < C.length && correctMultiplication; i++) {
			for (int j = 0; j < C[i].length && correctMultiplication; j++) {
				if (C[i][j] != D[i][j]) {
					correctMultiplication = false;
				}
			}
		}
		
		assertTrue("The multiplication went wrong", correctMultiplication);
		
		
	}

//________________________________________________________________________________________________________________
	
	@Test
	public void testMultiplyMatricesFirstOption_LimitCase() {
				
		stage1();
		
		Matrix matrixA = new Matrix(Matrix.COEFFICIENTS_MATRIX, 1000, 1000);
		Matrix matrixB = new Matrix(Matrix.LAST_BATTLE_MATRIX, 1000, 1000);
		
		for (int i = 0; i < matrixB.getMatrix().length; i++) {
			for (int j = 0; j < matrixB.getMatrix()[i].length; j++) {
				if (i == j) {
					matrixB.getMatrix()[i][j] = 1;
				}else {
					matrixB.getMatrix()[i][j] = 0;
				}
			}
		}
		
		
		
		board.getMatrices().add(matrixA);
		board.getMatrices().add(matrixB);
		
		int[][] C = matrixA.getMatrix();
		int[][] D = board.multiplyMatricesFirstOption();
		
		boolean correctMultiplication = true;
		
		for (int i = 0; i < C.length && correctMultiplication; i++) {
			for (int j = 0; j < C[i].length && correctMultiplication; j++) {
				if (C[i][j] != D[i][j]) {
					correctMultiplication = false;
				}
			}
		}
		
		assertTrue("The multiplication went wrong", correctMultiplication);
		
	}
		
//________________________________________________________________________________________________________________
	
	@Test
	public void testMultiplyMatricesFirstOption_InterestingCase() {
					
		stage1();
		
		Matrix matrixA = new Matrix(Matrix.COEFFICIENTS_MATRIX, 50, 50);
		Matrix matrixB = new Matrix(Matrix.LAST_BATTLE_MATRIX, 50, 50);
		
		for (int i = 0; i < matrixB.getMatrix().length; i++) {
			for (int j = 0; j < matrixB.getMatrix()[i].length; j++) {
				if (i > j) {
					matrixA.getMatrix()[i][j] = 0;
					matrixB.getMatrix()[i][j] = 0;
				}	
			}
		}
		
		
		board.getMatrices().add(matrixA);
		board.getMatrices().add(matrixB);
		
		int[][] C = board.multiplyMatricesFirstOption();
		/*
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C[i].length; j++) {
				System.out.print(C[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println();*/
		
		boolean correctMultiplication = true;
		
		for (int i = 1; i < C.length && correctMultiplication; i++) {
			for (int j = 0; j < i && correctMultiplication; j++) {
				if (C[i][j] != 0) {
					correctMultiplication = false;
				}
			}
		}
		
		assertTrue("The multiplication went wrong", correctMultiplication);			
					
	}
	
//________________________________________________________________________________________________________________
	
	
	@Test
	public void testMultiplyMatricesSecondOption_StandarCase() {
		
		stage1();
		
		int[][] A = new int[4][4];
		int[][] B = new int[4][4];
		int[][] C = new int[4][4];
		
		A[0][0] = 5;
		A[0][1] = 7;
		A[0][2] = 12;
		A[0][3] = 4;
		//A[0][4] = 23;
		A[1][0] = 11;
		A[1][1] = 17;
		A[1][2] = 34;
		A[1][3] = 45;
		//A[1][4] = 2;
		A[2][0] = 1;
		A[2][1] = 0;
		A[2][2] = 20;
		A[2][3] = 11;
		//A[2][4] = 3;
		A[3][0] = 4;
		A[3][1] = 34;
		A[3][2] = 22;
		A[3][3] = 13;
		//A[3][4] = 17;
		/*A[4][0] = 1;
		A[4][1] = 5;
		A[4][2] = 15;
		A[4][3] = 23;
		A[4][4] = 30;
		A[5][0] = 8;
		A[5][1] = 21;
		A[5][2] = 19;
		A[5][3] = 13;
		A[5][4] = 12;*/
		
		B[0][0] = 15;
		B[0][1] = 73;
		B[0][2] = 21;
		B[0][3] = 2;
		B[1][0] = 1;
		B[1][1] = 7;
		B[1][2] = 17;
		B[1][3] = 50;
		B[2][0] = 5;
		B[2][1] = 2;
		B[2][2] = 0;
		B[2][3] = 110;
		B[3][0] = 40;
		B[3][1] = 15;
		B[3][2] = 9;
		B[3][3] = 27;
		/*B[4][0] = 41;
		B[4][1] = 6;
		B[4][2] = 17;
		B[4][3] = 25;*/
		
		C[0][0] = 302;
		C[0][1] = 498;
		C[0][2] = 260;
		C[0][3] = 1788;
		C[1][0] = 2152;
		C[1][1] = 1665;
		C[1][2] = 925;
		C[1][3] = 5827;
		C[2][0] = 555;
		C[2][1] = 278;
		C[2][2] = 120;
		C[2][3] = 2499;
		C[3][0] = 724;
		C[3][1] = 769;
		C[3][2] = 779;
		C[3][3] = 4479;
		/*C[4][0] = 2245;
		C[4][1] = 663;
		C[4][2] = 823;
		C[4][3] = 3273;
		C[5][0] = 1248;
		C[5][1] = 1036;
		C[5][2] = 846;
		C[5][3] = 3807;*/
		
		Matrix matrixA = new Matrix(Matrix.LAST_BATTLE_MATRIX, 4, 4);
		Matrix matrixB = new Matrix(Matrix.COEFFICIENTS_MATRIX, 4, 4);
		
		matrixA.setMatrix(A);
		matrixB.setMatrix(B);
		
		board.getMatrices().add(matrixA);
		board.getMatrices().add(matrixB);
		
		int[][] D = board.multiplyMatricesSecondOption();
		
		
		for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < D[i].length; j++) {
				System.out.print(D[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println();
		
		
		boolean correctMultiplication = true;
		
		for (int i = 0; i < C.length && correctMultiplication; i++) {
			for (int j = 0; j < C[i].length && correctMultiplication; j++) {
				if (C[i][j] != D[i][j]) {
					correctMultiplication = false;
				}
			}
		}
		
		assertTrue("The multiplication went wrong", correctMultiplication);
		
	}

//________________________________________________________________________________________________________________
	/*
	@Test
	public void testMultiplyMatricesSecondOption_LimitCase() {
				
		stage1();
		
		Matrix matrixA = new Matrix(Matrix.COEFFICIENTS_MATRIX, 1000, 1000);
		Matrix matrixB = new Matrix(Matrix.LAST_BATTLE_MATRIX, 1000, 1000);
		
		for (int i = 0; i < matrixB.getMatrix().length; i++) {
			for (int j = 0; j < matrixB.getMatrix()[i].length; j++) {
				if (i == j) {
					matrixB.getMatrix()[i][j] = 1;
				}else {
					matrixB.getMatrix()[i][j] = 0;
				}
			}
		}
		
		
		
		board.getMatrices().add(matrixA);
		board.getMatrices().add(matrixB);
		
		int[][] C = matrixA.getMatrix();
		int[][] D = board.multiplyMatricesSecondOption();
		
		boolean correctMultiplication = true;
		
		for (int i = 0; i < C.length && correctMultiplication; i++) {
			for (int j = 0; j < C[i].length && correctMultiplication; j++) {
				if (C[i][j] != D[i][j]) {
					correctMultiplication = false;
				}
			}
		}
		
		assertTrue("The multiplication went wrong", correctMultiplication);
		
			
	}*/
		
//________________________________________________________________________________________________________________
	
	@Test
	public void testMultiplyMatricesSecondOption_InterestingCase() {
					
		stage1();
		
		Matrix matrixA = new Matrix(Matrix.COEFFICIENTS_MATRIX, 50, 50);
		Matrix matrixB = new Matrix(Matrix.LAST_BATTLE_MATRIX, 50, 50);
		
		for (int i = 0; i < matrixB.getMatrix().length; i++) {
			for (int j = 0; j < matrixB.getMatrix()[i].length; j++) {
				if (i > j) {
					matrixA.getMatrix()[i][j] = 0;
					matrixB.getMatrix()[i][j] = 0;
				}	
			}
		}
		
		
		board.getMatrices().add(matrixA);
		board.getMatrices().add(matrixB);
		
		int[][] C = board.multiplyMatricesSecondOption();
		/*
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C[i].length; j++) {
				System.out.print(C[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println();*/
		
		boolean correctMultiplication = true;
		
		for (int i = 1; i < C.length && correctMultiplication; i++) {
			for (int j = 0; j < i && correctMultiplication; j++) {
				if (C[i][j] != 0) {
					correctMultiplication = false;
				}
			}
		}
		
		assertTrue("The multiplication went wrong", correctMultiplication);						
					
	}
	
//________________________________________________________________________________________________________________
	
	@Test
	public void testMultiplyMatricesThirdOption_StandarCase() {
		
		stage1();
		
		int[][] A = new int[4][4];
		int[][] B = new int[4][4];
		int[][] C = new int[4][4];
		
		A[0][0] = 5;
		A[0][1] = 7;
		A[0][2] = 12;
		A[0][3] = 4;
		//A[0][4] = 23;
		A[1][0] = 11;
		A[1][1] = 17;
		A[1][2] = 34;
		A[1][3] = 45;
		//A[1][4] = 2;
		A[2][0] = 1;
		A[2][1] = 0;
		A[2][2] = 20;
		A[2][3] = 11;
		//A[2][4] = 3;
		A[3][0] = 4;
		A[3][1] = 34;
		A[3][2] = 22;
		A[3][3] = 13;
		//A[3][4] = 17;
		/*A[4][0] = 1;
		A[4][1] = 5;
		A[4][2] = 15;
		A[4][3] = 23;
		A[4][4] = 30;
		A[5][0] = 8;
		A[5][1] = 21;
		A[5][2] = 19;
		A[5][3] = 13;
		A[5][4] = 12;*/
		
		B[0][0] = 15;
		B[0][1] = 73;
		B[0][2] = 21;
		B[0][3] = 2;
		B[1][0] = 1;
		B[1][1] = 7;
		B[1][2] = 17;
		B[1][3] = 50;
		B[2][0] = 5;
		B[2][1] = 2;
		B[2][2] = 0;
		B[2][3] = 110;
		B[3][0] = 40;
		B[3][1] = 15;
		B[3][2] = 9;
		B[3][3] = 27;
		/*B[4][0] = 41;
		B[4][1] = 6;
		B[4][2] = 17;
		B[4][3] = 25;*/
		
		C[0][0] = 302;
		C[0][1] = 498;
		C[0][2] = 260;
		C[0][3] = 1788;
		C[1][0] = 2152;
		C[1][1] = 1665;
		C[1][2] = 925;
		C[1][3] = 5827;
		C[2][0] = 555;
		C[2][1] = 278;
		C[2][2] = 120;
		C[2][3] = 2499;
		C[3][0] = 724;
		C[3][1] = 769;
		C[3][2] = 779;
		C[3][3] = 4479;
		/*C[4][0] = 2245;
		C[4][1] = 663;
		C[4][2] = 823;
		C[4][3] = 3273;
		C[5][0] = 1248;
		C[5][1] = 1036;
		C[5][2] = 846;
		C[5][3] = 3807;*/
		
		Matrix matrixA = new Matrix(Matrix.LAST_BATTLE_MATRIX, 4, 4);
		Matrix matrixB = new Matrix(Matrix.COEFFICIENTS_MATRIX, 4, 4);
		
		matrixA.setMatrix(A);
		matrixB.setMatrix(B);
		
		board.getMatrices().add(matrixA);
		board.getMatrices().add(matrixB);
		
		int[][] D = board.multiplyMatricesThirdOption();
		
		
		for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < D[i].length; j++) {
				System.out.print(D[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println();
		
		
		boolean correctMultiplication = true;
		
		
		for (int i = 0; i < C.length && correctMultiplication; i++) {
			for (int j = 0; j < C[i].length && correctMultiplication; j++) {
				if (C[i][j] != D[i][j]) {
					correctMultiplication = false;
				}
			}
		}
		
		assertTrue("The multiplication went wrong", correctMultiplication); 
		
	}

//________________________________________________________________________________________________________________
	
	@Test
	public void testMultiplyMatricesThirdOption_LimitCase() {
				
		stage1();
		
		Matrix matrixA = new Matrix(Matrix.COEFFICIENTS_MATRIX, 10, 10);
		Matrix matrixB = new Matrix(Matrix.LAST_BATTLE_MATRIX, 10, 10);
		
		for (int i = 0; i < matrixB.getMatrix().length; i++) {
			for (int j = 0; j < matrixB.getMatrix()[i].length; j++) {
				if (i == j) {
					matrixB.getMatrix()[i][j] = 1;
				}else {
					matrixB.getMatrix()[i][j] = 0;
				}
			}
		}
		
		board.getMatrices().add(matrixA);
		board.getMatrices().add(matrixB);
		
		int[][] C = matrixA.getMatrix();
		int[][] D = board.multiplyMatricesThirdOption();
		
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C[i].length; j++) {
				System.out.print(C[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < D[i].length; j++) {
				System.out.print(D[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println();
		
		boolean correctMultiplication = true;
		
		for (int i = 0; i < C.length && correctMultiplication; i++) {
			for (int j = 0; j < C[i].length && correctMultiplication; j++) {
				if (C[i][j] != D[i][j]) {
					correctMultiplication = false;
				}
			}
		}
		
		assertTrue("The multiplication went wrong", correctMultiplication);
		
				
				
	}
		
//________________________________________________________________________________________________________________
	
	@Test
	public void testMultiplyMatricesThirdOption_InterestingCase() {
					
		stage1();
		
		Matrix matrixA = new Matrix(Matrix.COEFFICIENTS_MATRIX, 50, 50);
		Matrix matrixB = new Matrix(Matrix.LAST_BATTLE_MATRIX, 50, 50);
		
		for (int i = 0; i < matrixB.getMatrix().length; i++) {
			for (int j = 0; j < matrixB.getMatrix()[i].length; j++) {
				if (i > j) {
					matrixA.getMatrix()[i][j] = 0;
					matrixB.getMatrix()[i][j] = 0;
				}	
			}
		}
		
		
		board.getMatrices().add(matrixA);
		board.getMatrices().add(matrixB);
		
		int[][] C = board.multiplyMatricesThirdOption();
		/*
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C[i].length; j++) {
				System.out.print(C[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println();*/
		
		boolean correctMultiplication = true;
		
		for (int i = 1; i < C.length && correctMultiplication; i++) {
			for (int j = 0; j < i && correctMultiplication; j++) {
				if (C[i][j] != 0) {
					correctMultiplication = false;
				}
			}
		}
		
		assertTrue("The multiplication went wrong", correctMultiplication);						
					
					
	}
	
//________________________________________________________________________________________________________________
	
	
}























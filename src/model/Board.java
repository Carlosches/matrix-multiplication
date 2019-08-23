package model;

import java.util.List;

public class Board {

	public static final String SHIP_IMAGE = "";
	private int[] primeNumbers;
	private List<Matrix> matrices;
	
	public Board() {
		
	}
	
	
	public void multiplyMatricesFirstOption() {
		
	}
	public void multiplyMatricesSecondOption() {
		
	}
	public void multiplyMatricesThirdOption() {
	
	}
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
	
}

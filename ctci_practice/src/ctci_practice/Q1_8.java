package ctci_practice;

/* Zero Matrix: Write an algorithm such that if an element in 
 * an MxN matrix is 0, its entire row and column are set to 0.
*/
public class Q1_8 {
	
	private static void zeroMatrix(int[][] matrix) {
		
		int rows = matrix.length;
		int columns = matrix[0].length;
		
		//use two arrays to track the zero elements
		boolean[] row = new boolean[rows];
		boolean[] column = new boolean[columns];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		//zero out the appropriate row elements
		for(int i = 0; i < rows; i++) {
			if(row[i]) {
				for(int j = 0; j < columns; j++) 
					matrix[i][j] = 0;
			}
		}
		
		//zero out the appropriate column elements
		for(int i = 0; i < columns; i++) {
			if(column[i]) {
				for(int j = 0; j < rows; j++) 
					matrix[j][i] = 0;
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[][] matrix = Q1_7.randomMatrix(5, 4, 0, 9);
		Q1_7.printMatrix(matrix);
		zeroMatrix(matrix);
		Q1_7.printMatrix(matrix);
	}

}

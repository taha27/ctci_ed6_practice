package ctci_practice;

/*Rotate Matrix: Given an image represented by an NxN matrix, 
 * where each pixel in the image is 4 bytes, write a method to 
 * rotate the image by 90 degrees. Can you do this in place?
 * */

public class Q1_7 {

	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	
	public static int[][] randomMatrix(int M, int N, int min, int max) {
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = randomIntInRange(min, max);
			}
		}
		return matrix;
	}
	
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] < 10 && matrix[i][j] > -10) {
					System.out.print(" ");
				}
				if (matrix[i][j] < 100 && matrix[i][j] > -100) {
					System.out.print(" ");
				}
				if (matrix[i][j] >= 0) {
					System.out.print(" ");
				}
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void rotateMatrix(int[][] matrix) {
		int n = matrix.length;
		for(int layer = 0; layer < n/2; layer++) {
			int first = layer, last = (n - 1) - layer;
			for(int i = first; i < last; i++) {
				int offset = i - first;
				
				int top = matrix[first][i];
				
				//left 2 top
				matrix[first][i] = matrix[last - offset][first];
				//bottom 2 left
				matrix[last - offset][first] = matrix[last][last - offset];
				//right 2 bottom
				matrix[last][last - offset] = matrix[i][last];
				// top 2 right
				matrix[i][last] = top;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] image = randomMatrix(3, 3, 0, 9);
		
		printMatrix(image);
		
		//check to make sure it is NxN
		if(image.length != 0 && image.length == image[0].length) {
			rotateMatrix(image);
			printMatrix(image);
		}
	}

}

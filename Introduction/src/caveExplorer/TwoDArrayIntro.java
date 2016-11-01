package caveExplorer;

import java.util.Arrays;

public class TwoDArrayIntro {
	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,5,6,7};
		System.out.println(Arrays.toString(arr));
		
		// rows, columns
		String[][] array2D = new String[4][3];
		
		for (int row = 0; row < array2D.length; row++) {
			for (int col = 0; col < array2D[row].length; col++) {
				array2D[row][col] = "("+row+","+col+")";
			}
		}
		for (String[] row: array2D) {
			System.out.println(Arrays.toString(row));
		}
	}
}

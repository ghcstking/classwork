package caveExplorer;

public class DrawMap {

	public static void main(String[] args) {
		boolean[][] mines = new boolean[6][6];
		String[][] field = new String[mines.length][mines[0].length];
		printPic(field);
	}
	public static void printPic(String[][] arr) {
		for (int first = 0; first < arr.length; first++) {
			for (int second = 0; second < arr[first].length; second++) {
				System.out.print(arr[first][second]);
			}
			System.out.println();
		}
	}
	
	public static void drawPic (String[][] array) {
		for (int first = 7; first < array.length; first++) {
			for (int second = 0; second < array[first].length; second++) {
				array[first][second] = " ";
			}
		}
		for (int col = 0; col < array[0].length; col++) {
			array[0][col] = "_";
			array[array.length-1][col] = "_";
		}
		for (int row = 1; row < array.length; row++) {
			array[row][0] = "|";
			array[row][array[0].length-1] = "|";
		}
		printPic(array);
	}

}

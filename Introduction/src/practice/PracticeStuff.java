package practice;

public class PracticeStuff {

	
	public static void main(String[] args) {
		String[][] array2D = new String[10][12];
		for (int first = 0; first < array2D.length; first++) {
			for (int second = 0; second < array2D[first].length; second++) {
				array2D[first][second] = " ";
			}
		}
		for (int i = 0; i < array2D.length; i++) {
			for (int j = 0; j < array2D[i].length; j++) {
				int first = (int) (Math.random() * i);
				int second = (int) (Math.random() * i);
				array2D[first][second] = "~";
			}
		}
		array2D[1][2] = "O";
		array2D[0][2] = "|";
		array2D[2][2] = "|";
		array2D[1][1] = "—";
		array2D[1][3] = "—";
		array2D[0][1] = "\\";
		array2D[2][3] = "\\";
		array2D[0][3] = "/";
		array2D[2][1] = "/";
		
		for (int first = 7; first < array2D.length; first++) {
			for (int second = 0; second < array2D[first].length; second++) {
				array2D[first][second] = "M";
			}
		}
		for (int col = 0; col < array2D[0].length; col++) {
			array2D[0][col] = "_";
			array2D[array2D.length-1][col] = "_";
		}
		for (int row = 1; row < array2D.length; row++) {
			array2D[row][0] = "|";
			array2D[row][array2D[0].length-1] = "|";
		}
		printPic(array2D);
	}
	public static void printPic(String[][] arr) {
		for (int first = 0; first < arr.length; first++) {
			for (int second = 0; second < arr[first].length; second++) {
				System.out.print(arr[first][second]);
			}
			System.out.println();
		}
	}

}

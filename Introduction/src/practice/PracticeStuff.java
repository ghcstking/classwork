package practice;

public class PracticeStuff {

	
	public static void main(String[] args) {
		mines();
	}
	
	public static void mines() {
		boolean[][] mines = new boolean[6][6];
		createMines(mines, 10);
		String[][] field = new String[mines.length][mines[0].length];
		matchValues(field, mines);
		printPic(field);
	}
	
	private static void matchValues(String[][] field, boolean[][] mines) {
		for (int row = 0; row < field.length; row++) {
			for (int col = 0; col < field[0].length; col++) {
				if(mines[row][col]) {
					field[row][col] = "X";
				}
				else {
					field[row][col] = countAdjacent(mines, row, col);
				}
			}
		}
		
	}

	private static String countAdjacent(boolean[][] mines, int r, int c) {
		int count = 0;
//		for (int row = r-1; row <= r+1; row++) {
//			for (int col = c-1; col <= c+1; col++) {
//				if(row != r && col != c) {
//					if (row >= 0 && row < mines.length && col >= 0 && col < mines[row].length) {
//					}
//				}
//			}
//		}
		// method only checks elements in the 2d array
//		for (int row = 0; row < mines.length; row++) {
//			for (int col = 0; col < mines[row].length; col++) {
//				if (Math.abs(row - r) + Math.abs(col - c) == 1 && mines[row][col]) {
//					count++;
//				}
//			}
//		}
		// method checks ALL the elements
		count+= validAndTrue(mines,r-1,c);
		// above
		count+= validAndTrue(mines,r+1, c);
		// below
		count+= validAndTrue(mines,r,c+1);
		// right
		count+= validAndTrue(mines,r,c-1);
		// left
		return count + "";
	}

	private static int validAndTrue(boolean[][] mines, int i, int j) {
		if (i >= 0 && i < mines.length && j >= 0 && j < mines[i].length && mines[i][j]) {
			return 1;
			// checks if valid FIRST then if TRUE
		}
		return 0;
	}

	private static void createMines(boolean[][] mines, int num) {
		while(num > 0) {
			int row = (int)(Math.random() * mines.length);
			int col = (int)(Math.random() * mines[0].length);
			if (!mines[row][col]) {
				mines[row][col] = true;
				num--;
			}
		}
		
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
				array[first][second] = "M";
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

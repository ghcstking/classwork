package gui.components;

public class Random {
	private static boolean[][] grid;
	public Random() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		grid = new boolean[5][5];
		printArr(grid);
		buttonClick(3,3);
		printArr(grid);
		buttonClick(3,3);
		printArr(grid);
	}
	
	public static void switchRow(boolean[] row, int x) {
		if (x >= 0 && x < row.length) {
			for (int i = -1; i < 2; i++) {
				if(x + i >= 0 && x + i < row.length) {
					row[x+i] = !row[x+1];
				}
			}
		}
	}
	
	public static void switchColumn(boolean[][] grid, int r, int c) {
		switchIfValid(grid, r-1, c);
		switchIfValid(grid, r+1, c);
	}
	
	public static void switchIfValid(boolean[][] grid, int r, int c) {
		if (r >= 0 && r < grid.length && c >= 0 && c < grid[r].length) {
			grid[r][c] = !grid[r][c];
		}
	}
	
	public static void buttonClick(int r, int c) {
		if(r >= 0 && r < grid.length) {
			switchRow(grid[r], c);
		}
		switchColumn(grid, r, c);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j]) {
					return;
				}
			}
		}
		System.out.println("You have solved the puzzle");
	}
	public static void printArr(boolean[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				if(arr[row][col]) {
					System.out.print("O");
				}
				else {
					System.out.print("X");
				}
			}
			System.out.println();
		}
		System.out.println("- - -");
	}
}

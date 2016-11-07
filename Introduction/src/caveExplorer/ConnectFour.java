package caveExplorer;

import java.util.Scanner;

public class ConnectFour {
	private static String[][] grid;
	public static Scanner in;
	private static boolean[][] secGrid;
	
	public static void main(String[] args) {
		grid = new String[6][7];
		secGrid = new boolean[6][7];
		in = new Scanner(System.in);
		runGame();
	}
	public static void runGame() {
		while(true) {
			printPic(grid);
			System.out.println("Which column would you like to put your piece in? Enter a number 0 through 6");
			String input = in.nextLine();
			while(!checkInput(input)) {
				System.out.println("Please enter a number 0 through 6");
				input = in.nextLine();
			}
			checkLocation(input);
		}
	}
	private static void checkLocation(String input) {
		int colNum = Integer.parseInt(input);
		for (int row = grid.length - 1; row >= 0; row--) {
			if (!secGrid[row][colNum]){
				secGrid[row][colNum]=true;
				grid[row][colNum]="o";
			}
		}
	}
	public static boolean checkInput(String value) {
		String[] keys = {"0", "1", "2", "3", "4", "5", "6"};
		for (int i = 0; i < keys.length; i++) {
			if (keys[i].equals(value)) {
				return true;
			}
		}
		return false;
		
	}
	public static void printPic(String[][] arr) {
		String[][] newArr = new String[(arr.length * 2) + 1][(arr[0].length * 2) + 1];
		for (int row = 0; row < newArr.length; row++) {
			for (int col = 0; col < newArr[0].length; col++) {
				if (row%2 == 0) {
					newArr[row][col] = "-";
				}
				else {
					if (col%2 == 0) {
						newArr[row][col] = "|";
					}
					else if(secGrid[row/2][col/2]){
						newArr[row][col] = "o";
					}
					else{
						newArr[row][col] = " ";
					}
				}
			}
		}
		for (int i = 0; i < newArr.length; i++) {
			for (int j = 0; j < newArr[0].length; j++) {
				System.out.print(newArr[i][j]);
			}
			System.out.println();
		}
		System.out.println("0  1  2  3  4  5  6");
	}
	
}

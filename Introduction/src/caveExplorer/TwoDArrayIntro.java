package caveExplorer;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDArrayIntro {
	public static String[][] arr2D;
	public static String[][] pic;
	public static int i;
	public static int j;
	public static Scanner in;
	
	public static void main(String[] args) {
		arr2D = new String[5][4];
		pic = new String[5][4];
		for (int row = 0; row < arr2D.length; row++) {
			for (int col = 0; col < arr2D[row].length; col++) {
				arr2D[row][col] = "("+row+","+col+")";
			}
		}
		i = 2;
		j = 3;
		// start positions;
		in = new Scanner(System.in);
		startExploring();
	}
	public static void startExploring() {
		while(true) {
			printPic(pic);
			System.out.println("You are in room " + arr2D[i][j]);
			System.out.println("What do you want to do?");
			String input = in.nextLine();
			while(!isValid(input)) {
				System.out.println("Please enter w, a, s, or d");
				input = in.nextLine();
			}
			interpretInput(input);
		}
	}
	private static void interpretInput(String input) {
		int iOrig = i;
		int jOrig = j;
		if (input.equals("w") && i > 0) {
			i--;
		}
		if (input.equals("a") && j > 0) {
			j--;
		}
		if (input.equals("s") && i+1 < arr2D.length) {
			i++;
		}
		if (input.equals("d") && j+1 < arr2D[0].length) {
			j++;
		}
		if (iOrig == i && jOrig == j) {
			System.out.println("You are at the edge of the universe");
		}
	}
	private static boolean isValid(String input) {
		String lc = input.toLowerCase();
		String[] keys = {"w", "a", "s", "d"};
		for (int i = 0; i < keys.length; i++) {
			if (keys[i].equals(lc)) {
				return true;
			}
		}
		return false;
	}
	public static void printPic(String[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				arr[row][col] = "  |  ";
			}
		}
		for (int col = 0; col < arr[0].length; col++) {
			arr[0][col] = " _ ";
			arr[arr.length-1][col] = " _ ";
		}
		for (int row = 1; row < arr.length; row++) {
			arr[row][0] = "|";
			arr[row][arr[0].length-1] = "|";
		}
		
		for (int first = 0; first < arr.length; first++) {
			for (int second = 0; second < arr[first].length; second++) {
				System.out.print(arr[first][second]);
			}
			System.out.println();
		}
	}
}

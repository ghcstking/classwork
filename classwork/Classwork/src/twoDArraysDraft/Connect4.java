package twoDArraysDraft;

import java.util.Scanner;

public class Connect4 {
	
	public static final boolean PRINT_SPLIT = false;
	public static Scanner in = new Scanner(System.in);
	static boolean[][] arr2D;//change this from String
	static String[][] pic;

	public static void main(String[] args) {
		arr2D = new boolean[6][8];
		pic = new String[6][8];
		updatePic();


		startPlaying();

	}

	private static void startPlaying() {
		while(true){
			printPic(pic);


			System.out.println("Which column do you want to drop your piece?");
			String input = in.nextLine();

			dropPiece(interpretInput(input));
		}
	
	}



	private static void dropPiece(int col) {
		boolean full = true;
		int r = 0;
		//start at bottom-most row and go up until a false value is found
		for(int row = arr2D.length-1; row>=0; row--){
			if(!arr2D[row][col]){
				full = false;
				r = row;
				break;
			}
		}
		if(full){
			System.out.println("This column is already full.");
		}else{
			System.out.println("You drop a piece into colum "+col);
			arr2D[r][col]=true;
			updatePic();
		}
	}

	private static int interpretInput(String input) {
		//verify input is valid
		while(!isValid(input)){
			System.out.println("Sorry, in this game, "
					+ "you can only use the "
					+ "values of column numbers");
			System.out.println("Tell me again where you would like to drop a piece.");
			input = in.nextLine();
		}

		int col = Integer.parseInt(input);
		return col;
	}

	private static boolean isValid(String input) {
		for(int i = 0; i < arr2D[0].length; i++){
			if(input.toLowerCase().equals(""+i)){
				return true;
			}
		}
		return false;
	}



	private static int isValidAndTrue(boolean[][] mines, int i, int j) {
		if(i >= 0 &&
				i < mines.length &&
				j >=0 &&
				j < mines[0].length && 
				mines[i][j])
			return 1;
		else return 0;
	}





	public static void printPic(String[][] pic){
		//print indices above top
		if(PRINT_SPLIT)System.out.print(" ");
		for(int i = 0; i < pic[0].length; i++){
			String s =(PRINT_SPLIT)?i+" ":i+"";
			System.out.print(s);
		}
		System.out.println("");
		for(String[] row : pic){
			if(PRINT_SPLIT)System.out.print("|");
			for(String col: row){
				String s = (PRINT_SPLIT)?col+"|":col+"";
				System.out.print(s);
			}
			System.out.println();
		}

	}














	private static void updatePic() {
		for(int row = 0; row < pic.length; row++){

			//populate with coordinates
			for(int col = 0; col < pic[row].length; col++){
				if(arr2D[row][col])pic[row][col] = "O";
				else pic[row][col]=" ";
			}
		}
	}
}

package shohebHansMineSweeper;

import java.util.Scanner;

import hansExplorerMain.Event;
import hansExplorerMain.HansCaveExplorer;

public class HansFrontEnd implements Event{
	
	public static Scanner in = new Scanner(System.in);
	public static int[] coords = new int[2];
	
	
	public void play(){
		System.out.println("You now stand face to face with your gf's dad. He has some questions for you...");
		ShohebBackEnd.createBoards();
		displayBoard();
		ShohebBackEnd.cycleThroughQuestions(5);
	}
	
	public static void loseGame() {
		System.out.println("lmao ur dooonnnnneeeeee xD\n"
				+ "You get kicked out of the house for being such a clown");
		//System.out.close();
		HansCaveExplorer.setGameOver(true);
		
	}
	
	public static void winGame(){
		System.out.println("lmao u woonnnnnnnnnnn xD\n"
				+ "With your entire gf's family respecting you, the door to her room unlocks :^)");
		HansCaveExplorer.caves[2][9].getDoor(2).setLocked(false);
	}
	
	public static void displayBoard() {
		System.out.print("  ");
		for(int c = 0; c < ShohebBackEnd.isNotHidden[0].length; c++){
			System.out.print("|" + c + "|");
		}
		System.out.print("\n");
		for(int row = 0; row < ShohebBackEnd.isNotHidden.length; row++){
			for(int col = -1; col < ShohebBackEnd.isNotHidden[row].length; col++){
				if(col == -1){
					System.out.print(row + " ");
				}
				else{
					if(col < 10){
						if(!ShohebBackEnd.isNotHidden[row][col]){
							System.out.print("[ ]");
						}
						else{
							if(ShohebBackEnd.board[row][col] == 1){
								System.out.print("[" + ShohebBackEnd.count[row][col]+"]");
							}
							else{
								System.out.print("[X]");
							}
						}
					}
					else{
						if(!ShohebBackEnd.isNotHidden[row][col]){
							System.out.print(" [ ]");
						}
						else{
							if(ShohebBackEnd.board[row][col] == 1){
								System.out.print(" [" + ShohebBackEnd.count[row][col]+"]");
							}
							else{
								System.out.print(" [X]");
							}
						}
					}
				}
			}
			System.out.print("\n");
		}
	}
	

	public static void getUserResponse(){
		System.out.println("Please select a row");
		String row = in.nextLine();
		if(row.equals("win")){
			coords[0] = 99;
			coords[1] = 99;
		} //cheat code 
		else{
			while(!isValid(row, ShohebBackEnd.board.length-1)){
				System.out.println("Please input a number between 0 and " + (ShohebBackEnd.board.length-1) + " thx");
				row = in.nextLine();
			}
			int r = Integer.parseInt(row);
			System.out.println("Please select a column");
			String column = in.nextLine();
			while(!isValid(column, ShohebBackEnd.board[0].length-1)){
				System.out.println("Please input a number between 0 and " + (ShohebBackEnd.board[0].length-1) + " thx");
				column = in.nextLine();
			}
			int col = Integer.parseInt(column);
			if(ShohebBackEnd.isNotHidden[r][col]){
				System.out.println("You must pick a space that isn't already visible!");
				getUserResponse();
			}
			else{
				coords[0] = r;
				coords[1] = col;
			}
		}
	}
	
	public static boolean isValid(String input, int max){
		try{
			int num = Integer.parseInt(input);
		}catch(NumberFormatException nfe){
			return false;
		}
		int num = Integer.parseInt(input);
		if(num < 0 || num > max){
			return false;
		}
		return true;
	}
	
	public static void revealBoard(){
		for(int i=0; i<ShohebBackEnd.isNotHidden.length; i++){
			for(int j=0; j<ShohebBackEnd.isNotHidden[i].length; j++){
				ShohebBackEnd.isNotHidden[i][j] = true;
			} 
		}
	}
}

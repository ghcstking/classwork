package hansConnectFour;

import java.util.Scanner;

import hansConnectFour.HansConnectFourBack;
import hansExplorerMain.Event;
import hansExplorerMain.HansCaveExplorer;

public class HansConnectFourFront implements Event {
	public static Scanner in;
	private static String[][] board;
	private static boolean userWon = false;
	private static boolean compWon = false;
	public void play(){
		System.out.println("You encounter your gf's lil bro waiting for you near the entrance of the house.\n"
				+ "He challenges you to a game of Connect Four, even though he's not good at it.\n"
				+ "You must defeat him or else you are banished from the house!!! He let's you go first, though.");
		board = (makeConnectFourBoard(6,7));
		playConnectFour();
	}
	public static void playConnectFour() {
		in = new Scanner(System.in);
		print2DArr(board);
		boolean inGame = true;
		while(inGame){
			HansConnectFourBack.userMove();	
			while(!HansConnectFourBack.getMadeChange()&& !userWon){
				System.out.println("Uhhh... that column is full wyd xD");
				HansConnectFourBack.userMove();	
			}
			if(userWon){
				print2DArr(board);
				System.out.println("You won! Now that you beat your worthy oponent, you may explore the rest of the house.");
				inGame = false;
				HansCaveExplorer.caves[3][1].getDoor(0).setLocked(false);
			}
			else{
				HansConnectFourBack.compMove();
				System.out.println("Hmm...\n");
				print2DArr(board);
				if(compWon){
					System.out.println("I won!! Get out of here you loser!!");
					HansCaveExplorer.setGameOver(true);
					inGame =false;
				}
			}
		}
		
	}
	public static String[][] makeConnectFourBoard(int r, int c) {
		int numCol = (c*2)+1;
		int numRow = r+1;
		String[][] grid = new String[numRow][numCol];
		int lastColHeader = 0;
		for(int i = 0;i< numCol;i++){
			if(i%2==1){
				grid[0][i] = Integer.toString(i-lastColHeader);
				lastColHeader = i-lastColHeader;
			}
		}
		
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				if(j%2==0){
					grid[i][j] = "|";
				}
				else{
					if(i!=0)
						grid[i][j] = " ";
				}
			}
		}
		return grid;
	}
	public static void print2DArr(String[][] a){
		for(int r=0;r<a.length;r++){
			for(int c=0;c<a[r].length;c++){
				System.out.print(a[r][c]);
			}
			System.out.println();
		}
	}
	public static String[][] getBoard() {
		return board;
	}
	public static void setUserWon(boolean u){
		userWon = u;
	}
	public static void setCompWon(boolean u){
		compWon = u;
	}
	public HansConnectFourFront(){
		
	}
}

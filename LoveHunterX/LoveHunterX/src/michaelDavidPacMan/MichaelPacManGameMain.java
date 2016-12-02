package michaelDavidPacMan;

import java.util.Scanner;
import michaelDavidPacMan.MichaelCellRoom;
import hansExplorerMain.Event;
import hansExplorerMain.HansCaveExplorer;

public class MichaelPacManGameMain implements Event {

	//things we need:
	//	a default grid - I got this, any questions feel free to email me.
	//	a pacman - This too.
	//	dogs - 
	//	pieces of bones - can be done /w a counter...

	public static MichaelCellRoom cells[][];
	public static Scanner in;
	public static boolean inPacGame=true;	

	public void play() {
		System.out.println("You encounter an angry looking doge. There are bone fragments scattered on the ground.\n"
				+ "Maybe if you give doge enough bone fragments, he'll come thru with the key");
		in = new Scanner(System.in);
		cells = new MichaelCellRoom[12][12];
		for(int r=0; r<cells.length;r++){
			for(int c=0;c<cells[r].length;c++){
				cells[r][c]= new MichaelCellRoom();
			}
		}
		while(inPacGame){
			printMaze();
			String input = in.nextLine();
			MichaelPacMan.interpretInput(input);
			MichaelPacMan.getBoneFrags();
			DavidEnemy.updateEnemyMovement();
			checkCondition();
		}
	}

	public static void checkCondition(){
		if(DavidEnemy.checkLoseCondition()){
			System.out.println("You lose, the vicious doge got to you before you could get all the bone fragments");
			printMaze();
			inPacGame=false;
			HansCaveExplorer.setGameOver(true);
		}
		if(MichaelPacMan.getNumCollected()>=15){
			System.out.println("You fed the doge and now doge respects you. With that, doge gives you the key to the house.");
			printMaze();
			inPacGame=false;
			HansCaveExplorer.caves[4][1].getDoor(1).setLocked(false);
			System.out.println("The door to the house has been unlocked.");
		}
	}

	public static void setUpStarters(){
		//starting cell and dog cell must be accessible and not have bone frags.
		cells[0][0].accessible = true;
		cells[0][0].boneFrag = false;
		cells[cells.length/3][cells[0].length/3].accessible = true;
		cells[cells.length/3][cells[0].length/3].boneFrag = false;
	}

	public static void printMaze(){
		String[][] grid = new String[cells.length][cells[0].length];
		//X = not accessible
		//O = bone frag here
		//% = dog
		for (int row =0; row<grid.length; row++){
			for(int col = 0; col < grid[row].length; col ++){
				grid[row][col]=" ";
				if(!(cells[row][col].getAccessible())){
					grid[row][col]="X";		
				}else{
					if(cells[row][col].getBFrag()){
						grid[row][col]="O";
					}
					if(row == DavidEnemy.currentEnemyOneRoomRow && col == DavidEnemy.currentEnemyOneRoomCol){
						//System.out.println("The dog1 row is " + DavidEnemy.getDog1Row());
						//System.out.println("The dog1 col is " + DavidEnemy.getDog1Col());
						grid[row][col] = "%";
					}
				}
				//locate pacman
				if(row == MichaelCellRoom.currentRoomRow && col == MichaelCellRoom.currentRoomCol){
					grid[row][col] = "!";
				}
			}
		}
		//starting cell and dog cell must be accessible.
		setUpStarters();

		//upper border
		for (int col = 0; col < grid[0].length; col++){
			System.out.print(" _");
		}
		System.out.println();

		//inside borders
		for (int row = 0; row < grid.length; row++){
			for(int col = 0; col < grid[row].length; col++){
				System.out.print("|");
				System.out.print(grid[row][col]);
				if (col == grid[row].length -1){
					System.out.print("|");
				}
			}
			System.out.println();
		}

		//bottom border
		for (int col = 0; col < grid[0].length; col++){
			System.out.print(" ¯");
		}
		System.out.println("\nYou have collected " + MichaelPacMan.getNumCollected() + " bone fragments. \n");
	}

}

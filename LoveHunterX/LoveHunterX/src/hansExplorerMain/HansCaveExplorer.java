package hansExplorerMain;

import java.util.Scanner;

import annaDanielBejeweled.*;
import hansConnectFour.*;
import michaelDavidPacMan.*;
import shohebHansMineSweeper.*;

public class HansCaveExplorer {
	
	public static HansCaveRoom caves[][];
	public static Scanner in;
	public static HansCaveRoom currentRoom;
	public static HansInventory inventory;
	private static boolean gameOver;
	
	public static void main(String[] args){
		in = new Scanner(System.in);
		caves = new HansCaveRoom[5][10];
		for(int r=0; r<caves.length;r++){
			for(int c=0;c<caves[r].length;c++){
				caves[r][c] = new HansCaveRoom("You're at coords ("+r+","+c+")!");
			}
		}
		caves[3][3] = new EventRoom("It's a doge!!!", new MichaelPacManGameMain());
		caves[0][5] = new EventRoom("It's your girlfriend's mother!!!", new AnnaFrontend());
		caves[0][9] = new EventRoom("It's your girlfriend's father!!!", new HansFrontEnd());
		caves[4][9] = new EventRoom("It's your gf!", new HansEndGameEvent()); 
		caves[4][0] = new EventRoom("It's your gf's lil bro!", new HansConnectFourFront());
		currentRoom = caves[4][7];
		currentRoom.enter();
		caves[4][7].setConnection(HansCaveRoom.WEST, caves[4][6], new HansDoor("gravel path",true));
		caves[4][6].setConnection(HansCaveRoom.NORTH, caves[3][6], new HansDoor("gravel path",true));
		caves[4][6].setConnection(HansCaveRoom.WEST, caves[4][5], new HansDoor("gravel path",true));
		caves[4][7].setConnection(HansCaveRoom.NORTH, caves[3][7], new HansDoor("gravel path",true));
		caves[3][7].setConnection(HansCaveRoom.WEST, caves[3][6], new HansDoor("gravel path",true));
		caves[3][6].setConnection(HansCaveRoom.WEST, caves[3][5], new HansDoor("gravel path",true));
		caves[3][5].setConnection(HansCaveRoom.WEST, caves[3][4], new HansDoor("gravel path",true));
		caves[3][4].setConnection(HansCaveRoom.WEST, caves[3][3], new HansDoor("gravel path",true));
		caves[3][3].setConnection(HansCaveRoom.WEST, caves[3][2], new HansDoor("gravel path",true));
		caves[4][5].setConnection(HansCaveRoom.WEST, caves[4][4], new HansDoor("gravel path",true));
		caves[4][5].setConnection(HansCaveRoom.NORTH, caves[3][5], new HansDoor("gravel path",true));
		caves[4][4].setConnection(HansCaveRoom.WEST, caves[4][3], new HansDoor("gravel path",true));
		caves[4][4].setConnection(HansCaveRoom.NORTH, caves[3][4], new HansDoor("gravel path",true));
		caves[4][3].setConnection(HansCaveRoom.WEST, caves[4][2], new HansDoor("gravel path",true));
		caves[4][3].setConnection(HansCaveRoom.NORTH, caves[3][3], new HansDoor("gravel path",true));
		caves[4][2].setConnection(HansCaveRoom.NORTH, caves[3][2], new HansDoor("gravel path",true));
		caves[4][2].setConnection(HansCaveRoom.WEST, caves[4][1], new HansDoor("grand door",false));
		caves[4][1].setConnection(HansCaveRoom.NORTH, caves[3][1], new HansDoor("rug",true));
		caves[3][1].setConnection(HansCaveRoom.NORTH, caves[2][1], new HansDoor("door",false));
		caves[4][1].setConnection(HansCaveRoom.WEST, caves[4][0], new HansDoor("rug",true));
		caves[4][0].setConnection(HansCaveRoom.NORTH, caves[3][0], new HansDoor("rug",true));
		caves[3][0].setConnection(HansCaveRoom.EAST, caves[3][1], new HansDoor("rug",true));
		caves[2][0].setConnection(HansCaveRoom.EAST, caves[2][1], new HansDoor("rug",true));
		caves[2][1].setConnection(HansCaveRoom.EAST, caves[2][2], new HansDoor("rug",true));
		caves[2][2].setConnection(HansCaveRoom.EAST, caves[2][3], new HansDoor("rug",true));
		caves[2][3].setConnection(HansCaveRoom.EAST, caves[2][4], new HansDoor("rug",true));
		caves[2][4].setConnection(HansCaveRoom.EAST, caves[2][5], new HansDoor("rug",true));
		caves[2][5].setConnection(HansCaveRoom.EAST, caves[2][6], new HansDoor("rug",true));
		caves[2][6].setConnection(HansCaveRoom.EAST, caves[2][7], new HansDoor("rug",true));
		caves[2][7].setConnection(HansCaveRoom.EAST, caves[2][8], new HansDoor("rug",true));
		caves[2][8].setConnection(HansCaveRoom.EAST, caves[2][9], new HansDoor("rug",true));
		caves[1][0].setConnection(HansCaveRoom.SOUTH, caves[2][0], new HansDoor("door",false));
		caves[1][0].setConnection(HansCaveRoom.NORTH, caves[0][0], new HansDoor("rug",true));
		caves[1][0].setConnection(HansCaveRoom.EAST, caves[1][1], new HansDoor("rug",true));
		caves[2][5].setConnection(HansCaveRoom.NORTH, caves[1][5], new HansDoor("rug",true));
		caves[1][5].setConnection(HansCaveRoom.NORTH, caves[0][5], new HansDoor("door",false));
		caves[0][1].setConnection(HansCaveRoom.EAST, caves[0][2], new HansDoor("rug",true));
		caves[0][1].setConnection(HansCaveRoom.WEST, caves[0][0], new HansDoor("rug",true));
		caves[0][1].setConnection(HansCaveRoom.SOUTH, caves[1][1], new HansDoor("rug",true));
		caves[1][1].setConnection(HansCaveRoom.EAST, caves[1][2], new HansDoor("rug",true));
		caves[1][2].setConnection(HansCaveRoom.NORTH, caves[0][2], new HansDoor("rug",true));
		caves[1][2].setConnection(HansCaveRoom.EAST, caves[1][3], new HansDoor("door",false));
		caves[0][2].setConnection(HansCaveRoom.EAST, caves[0][3], new HansDoor("door",false));
		caves[0][3].setConnection(HansCaveRoom.SOUTH, caves[1][3], new HansDoor("tiled floor",true));
		caves[0][4].setConnection(HansCaveRoom.SOUTH, caves[1][4], new HansDoor("tiled floor",true));
		caves[1][4].setConnection(HansCaveRoom.SOUTH, caves[2][4], new HansDoor("bathroom door",false));
		caves[0][5].updateContents("M");
		caves[4][0].updateContents("B");
		caves[0][9].updateContents("F");
		caves[4][9].updateContents("G");
		caves[0][1].updateContents("o");
		caves[3][3].updateContents("D");
		caves[1][1].updateContents("o");
		caves[0][4].updateContents("O");
		caves[0][3].updateContents("|");
		caves[1][3].updateContents("|");
		caves[0][6].setConnection(HansCaveRoom.SOUTH, caves[1][6], new HansDoor("bedroom tile",true));
		caves[0][6].setConnection(HansCaveRoom.EAST, caves[0][7], new HansDoor("bedroom tile",true));
		caves[1][6].setConnection(HansCaveRoom.SOUTH, caves[2][6], new HansDoor("bedroom door",false));
		caves[1][6].setConnection(HansCaveRoom.EAST, caves[1][7], new HansDoor("bedroom tile",true));
		caves[1][7].setConnection(HansCaveRoom.NORTH, caves[0][7], new HansDoor("bedroom tile",true));
		caves[1][7].setConnection(HansCaveRoom.EAST, caves[1][8], new HansDoor("bedroom tile",true));
		caves[0][9].setConnection(HansCaveRoom.WEST, caves[0][8], new HansDoor("bedroom tile",true));
		caves[0][9].setConnection(HansCaveRoom.SOUTH, caves[1][9], new HansDoor("bedroom tile",true));
		caves[0][9].setConnection(HansCaveRoom.SOUTH, caves[1][9], new HansDoor("bedroom tile",true));
		caves[1][8].setConnection(HansCaveRoom.NORTH, caves[0][8], new HansDoor("bedroom tile",true));
		caves[1][8].setConnection(HansCaveRoom.EAST, caves[1][9], new HansDoor("bedroom tile",true));
		caves[0][7].setConnection(HansCaveRoom.EAST, caves[0][8], new HansDoor("bedroom tile",true));
		caves[4][9].setConnection(HansCaveRoom.NORTH, caves[3][9], new HansDoor("bedroom tile",true));
		caves[4][9].setConnection(HansCaveRoom.WEST, caves[4][8], new HansDoor("bedroom tile",true));
		caves[3][8].setConnection(HansCaveRoom.EAST, caves[3][9], new HansDoor("bedroom tile",true));
		caves[3][8].setConnection(HansCaveRoom.SOUTH, caves[4][8], new HansDoor("bedroom tile",true));
		caves[3][9].setConnection(HansCaveRoom.NORTH, caves[2][9], new HansDoor("bedroom door",false));
		caves[4][1].getDoor(1).setLocked(true);
		caves[3][1].getDoor(0).setLocked(true);
		caves[2][9].getDoor(2).setLocked(true);
		caves[2][6].getDoor(0).setLocked(true);
		
//		caves[4][0] = new EventRoom("It's your girlfriend's little brother!", new HansFrontEnd());
//		caves[4][9] = new EventRoom("It's your girlfriend!!!", new HansFrontEnd());
		
		
		inventory = new HansInventory();
		startExploring();
	}

	public static void startExploring() {
		System.out.println("You find yourself at the front gate of your girlfriend's house.\n"
				+ "She told you to come over at 8PM, but gave you no further directions...\n"
				+ "You look to your East and see her room through the foggy window.\n"
				+ "You knock on the glass to catch her attention. She smiles at you points you\n"
				+ "in the opposite direction, towards the entrance of the house.");
		boolean inGame = true;
		while(inGame){
			System.out.println(inventory.getDescription());
			System.out.println(currentRoom.getDescription());
			System.out.println("wyd fam xD");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
			if(gameOver){
				inGame = false;
				print("GAME OVER!");
				System.out.close();
			}
		}
		
	}

	public static void print(String string) {
		System.out.println(string);
	}
	public static void setGameOver(boolean g){
		gameOver= g;
	}
	public static boolean getGameOver(){
		return gameOver;
	}


}

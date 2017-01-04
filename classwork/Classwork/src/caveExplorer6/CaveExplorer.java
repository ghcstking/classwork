package caveExplorer6;


import java.util.Scanner;

public class CaveExplorer {

	public static CaveRoom[][] caves;
	public static Scanner in;
	public static CaveRoom currentRoom;
	public static Inventory inventory;

	
	public static void main(String[] args){
		in = new Scanner(System.in);
		CaveRoom.setUpCaves();

		inventory = new Inventory();
		startExploring();
	}


	private static void startExploring() {
		
		while(true){
			System.out.println(inventory.getDescription());
			System.out.println(currentRoom.getDescription());
			System.out.println("What would you like to do?");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
		}
	}


	public static void print(String string) {
		System.out.println(string);
	}
	
	
}


















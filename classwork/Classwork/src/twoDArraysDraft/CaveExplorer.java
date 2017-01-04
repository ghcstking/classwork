package twoDArraysDraft;

import java.util.Scanner;

public class CaveExplorer {

	public static CaveRoom[][] caves;
	public static Scanner in;
	public static CaveRoom currentRoom;
	public static Inventory inventory;
	//Note: because all of the methods in this class are static, 
	//we are breaking standard convention and making all fields public. In your own classes, 
	//your methods should not be static and your firelds should be private
	public static boolean lose;
	
	public static void main(String[] args){
		in = new Scanner(System.in);
		caves = new CaveRoom[5][5];
		for(int i = 0; i < caves.length; i++){
			for(int j = 0; j < caves[i].length; j++){
				caves[i][j] = new CaveRoom("This cave has coordinates "+i+", "+j);
			}
		}
		caves[3][4]= new EventRoom("This is the room where you got the map", new GameStartEvent());
		caves[2][3]= new EventRoom("This is the room where you saved the world from nuclear holocaust.", new DefconEvent() );
		currentRoom = caves[3][3];
		currentRoom.enter();
		caves[3][3].setConnection(CaveRoom.EAST, caves[3][4], new Door());
		caves[3][3].setDescription("This is the room you started in.");
		
		caves[3][4].setConnection(CaveRoom.NORTH, caves[2][4], new Door());
		caves[2][4].setConnection(CaveRoom.WEST, caves[2][3], new Door());
		caves[2][3].setConnection(CaveRoom.SOUTH, caves[3][3], new Door());
		inventory = new Inventory(caves);
		startExploring();
	}
	
	private static void startExploring() {
		while(!lose){
			System.out.println(inventory.getDescription());//do not use print method. Inventory width should not be controlled
			System.out.println(currentRoom.getDescription());
			System.out.println("What would you like to do?");
			String input = waitForInput();
			act(input);
		}
	}
	
	/**
	 * This method is from StringsPractice. It prints longs Strings in
	 * multiple lines
	 * @param s String to be printed
	 */
	public static void print(String s){
		//create a multi-line String
		String printString = "";
		int cutoff = 85;
		//check to see if there are words to add
		//(IOW, is the length of s > 0
		while(s.length() > 0){
			String currentLine = "";
			String nextWord = "";
			//while the currentLine and nextWord are less
			//than the cuttoff, AND there are still 
			//words to add do the following loop
			while(currentLine.length() + 
					nextWord.length() <= cutoff &&
					s.length() > 0){
				//add the next word to the line
				currentLine += nextWord;
				//remove that word
				s = s.substring(nextWord.length());
				//get the following word
				int endOfWord = s.indexOf(" ");
				//check to see if this is the last word
				if(endOfWord == -1){
					endOfWord = s.length() -1;
				}
				//get the next word and space
				nextWord = s.substring(0, endOfWord+1);
			}
			printString += currentLine +"\n";
			
		}
		
		System.out.println(printString);
	}


	private static void act(String input) {
		
		currentRoom = currentRoom.interpretAction(input);
	}


	public static String waitForInput(){
		return in.nextLine();
	}
	
}

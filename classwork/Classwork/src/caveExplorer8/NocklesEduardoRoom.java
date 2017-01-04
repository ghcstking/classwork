package caveExplorer8;

public class NocklesEduardoRoom extends CaveRoomPd8 {

	public NocklesEduardoRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}
	
	public void enter(){
		super.enter();
		System.out.println("You are locked in this room!");
		//for loop to close all doors
	}
	
	
	public void interpretAction(String input) {
		while(!isValid(input.toLowerCase())){
			CaveExplorer.print("Please enter 'w','a','s', or 'd'.");
			input = CaveExplorer.in.nextLine().toLowerCase();
		}
		String[] keys = {"w","d","s","a"};
		int indexFound = -1;
		for(int i = 0; i < keys.length; i++){
			if(keys[i].equals(input)){
				indexFound = i;
				break;
			}
		}
		goToRoom(indexFound);
		
	}
	
	
	public static boolean isValid(String input){
		String[] keys = {"w","d","s","a"};
		for(String key : keys){
			if (input.equals(key))return true;
		}
		return false;
	}

}

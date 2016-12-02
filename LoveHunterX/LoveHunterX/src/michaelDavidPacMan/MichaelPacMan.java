package michaelDavidPacMan;

public class MichaelPacMan {
	private static String[] pResults = {"w","a","s","d","cheat"};
	private static int numCollected = 0;

	public static int getNumCollected(){
		return numCollected;
	}
	
	public static void interpretInput(String input) {
		if(!(isValid(input))){
			System.out.println("Yo. w a s d only please");
		}else{
			switch(input){
			case "w": //moveup
				if(MichaelCellRoom.currentRoomRow>0 && checkIfAccessible(-1,0)){
					MichaelCellRoom.currentRoomRow--;
				}else{
					System.out.println("Can't move out of the maze :)");
				}
				break;
			case "a": //moveleft
				if(MichaelCellRoom.currentRoomCol>0 && checkIfAccessible(0,-1)){
					MichaelCellRoom.currentRoomCol--;
				}else{
					System.out.println("Can't move out of the maze :)");
				}
				break;
			case "s": //movedown
				if(MichaelCellRoom.currentRoomRow<MichaelPacManGameMain.cells.length-1 && checkIfAccessible(1,0)){
					MichaelCellRoom.currentRoomRow++;
				}else{
					System.out.println("Can't move out of the maze :)");
				}
				break;
			case "d": //moveright.
				if(MichaelCellRoom.currentRoomCol<MichaelPacManGameMain.cells[0].length-1 && checkIfAccessible(0,1)){
					MichaelCellRoom.currentRoomCol++;
				}else{
					System.out.println("Can't move out of the maze :)");
				}
				break;
			case "cheat":
				System.out.println("Oh look. You happen to have 15 bones in your pocket. How... intriguing.");
				numCollected=16;
				break;
			}
		}
	}

	public static boolean isValid(String key){

		for (int i = 0; i <pResults.length; i++){
			if(pResults[i].equals(key)){
				return true;
			}
		}
		return false;
	}

	public static boolean checkIfAccessible(int cRow, int cCol){
		return MichaelPacManGameMain.cells[MichaelCellRoom.currentRoomRow+cRow][MichaelCellRoom.currentRoomCol+cCol].getAccessible();
	}

	public static void getBoneFrags(){
		if(MichaelPacManGameMain.cells[MichaelCellRoom.currentRoomRow][MichaelCellRoom.currentRoomCol].getBFrag()){
			MichaelPacManGameMain.cells[MichaelCellRoom.currentRoomRow][MichaelCellRoom.currentRoomCol].changeBoneStatus();
			numCollected++;
		}
	}
}

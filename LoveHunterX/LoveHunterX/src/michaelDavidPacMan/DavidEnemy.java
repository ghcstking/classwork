package michaelDavidPacMan;

public class DavidEnemy {
	public static int currentEnemyOneRoomRow = (int) ((MichaelPacManGameMain.cells.length/3));
	public static int currentEnemyOneRoomCol = (int) ((MichaelPacManGameMain.cells[0].length/3));

	public final static int UP = 0;
	public final static int DOWN = 1;
	public final static int RIGHT = 2;
	public final static int LEFT = 3;

	public static int getDog1Row(){
		return currentEnemyOneRoomRow;
	}

	public static int getDog1Col(){
		return currentEnemyOneRoomCol;
	}

	public static void updateEnemyMovement(){
		if(genIntegerOfMovement(checkIfOneAccessible(-1,0),
				checkIfOneAccessible(1,0), checkIfOneAccessible(0,1), checkIfOneAccessible(0,-1)) == UP){
			currentEnemyOneRoomRow--;
		}
		else if(genIntegerOfMovement(checkIfOneAccessible(-1,0),
				checkIfOneAccessible(1,0), checkIfOneAccessible(0,1), checkIfOneAccessible(0,-1)) == DOWN){
			currentEnemyOneRoomRow++;
		}
		else if(genIntegerOfMovement(checkIfOneAccessible(-1,0),
				checkIfOneAccessible(1,0), checkIfOneAccessible(0,1), checkIfOneAccessible(0,-1)) == RIGHT){
			currentEnemyOneRoomCol++;
		}
		else if(genIntegerOfMovement(checkIfOneAccessible(-1,0),
				checkIfOneAccessible(1,0), checkIfOneAccessible(0,1), checkIfOneAccessible(0,-1)) == LEFT){
			currentEnemyOneRoomCol--;
		}
	}
	
	private static int genIntegerOfMovement(boolean up, boolean down, boolean right, boolean left){
		int[] possibleMoves = {-1, -1, -1, -1};
		boolean[] checks = {up, down, right,left};
		for(int i = 0; i < possibleMoves.length; i++){
			if(checks[i]){
				possibleMoves[i] = i;
				//System.out.println(Arrays.toString(possibleMoves));
			}
		}
		int randNum = (int) (Math.random() * possibleMoves.length);
		while(possibleMoves[randNum] == -1){
			randNum = (int) (Math.random() * possibleMoves.length);
		}
		return possibleMoves[randNum];
	}

	public static boolean checkIfOneAccessible(int eRow, int eCol){
		if(currentEnemyOneRoomRow + eRow < 10 && currentEnemyOneRoomRow+eRow>=0
				&& currentEnemyOneRoomCol + eCol < 10 && currentEnemyOneRoomCol+eCol>=0
				&& MichaelPacManGameMain.cells[currentEnemyOneRoomRow+eRow][currentEnemyOneRoomCol+eCol].getAccessible()){
			return true;
		}
		else return false;
	}

	public static boolean checkLoseCondition(){
		//mike - help here. ok.
		if (Math.abs(MichaelCellRoom.currentRoomRow-currentEnemyOneRoomRow)<2 && Math.abs(MichaelCellRoom.currentRoomCol-currentEnemyOneRoomCol)<2 ){
			//print last time before losing.
			MichaelPacManGameMain.printMaze();
			return true;
		}
		return false;
	}
}
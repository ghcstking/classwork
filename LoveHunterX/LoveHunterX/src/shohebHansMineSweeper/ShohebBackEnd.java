package shohebHansMineSweeper;

public class ShohebBackEnd {
	public static int[][] board;
	public static int[][] count;
	public static boolean[][] isNotHidden;
	public static final String[][] questionAnswers = {{"What do you like most about my daughter?", "Her personality :)", "Her money xP", "Nice answer my dude", "hey man thats not nice"}, {"If you could take my daughter to one restaurant, where would you go?", "A nice italiano ristorante", "Mickey Dee's", "hell yeah", "y so cheap yo"}, {"Why do you think my daughter likes you?", "idk man im just blessed to have her", "im pretty funny xD", "wow youre so humble :)", "youre not tho lol"}, {"what's your ideal date", "a nice walk along the coastline at sunset", "i prefer to stay home man", "wow so romantic!", "ur boring :/"}, {"What's the most common error when dealing with arrays?", "array out of bounds exception of course", "idk how to code", "good looks buddy, thats important to know", "sorry, my daughter only dates REAL coders"}, {"What's your favorite programming language", "Java!", "Scratch", "nice, java is a good language. very professional", "grow up kid thats not a real language haha"}};
	public static void cycleThroughQuestions(int totalQuestions){
		boolean[] availableQuestions = new boolean[questionAnswers.length];
		int i = 0;
		for(i = 0; i < totalQuestions; i++){
			int qIndex = (int)(Math.random()*questionAnswers.length);
			while(availableQuestions[qIndex]){
				qIndex = (int)(Math.random()*questionAnswers.length);
			}
			availableQuestions[qIndex] = true;
			System.out.println("Dad: "+questionAnswers[qIndex][0]);
			HansFrontEnd.getUserResponse();
			if(HansFrontEnd.coords[0] == 99){
				HansFrontEnd.winGame();
				break;
			}
			int boardSpace = board[HansFrontEnd.coords[0]][HansFrontEnd.coords[1]];
			updateBooleanArray(HansFrontEnd.coords[0], HansFrontEnd.coords[1]);
			System.out.println("You: " +questionAnswers[qIndex][boardSpace]);
			if(boardSpace == 2){
				System.out.println("Dad: "+questionAnswers[qIndex][4]);
				HansFrontEnd.revealBoard();
				HansFrontEnd.displayBoard();
				HansFrontEnd.loseGame();
				break;
			}
			HansFrontEnd.displayBoard();
			System.out.println("Dad: "+questionAnswers[qIndex][3]);
		}
		if(i == totalQuestions){
			HansFrontEnd.winGame();
		}
	}

	public static void createBoards(){
		int rows = (int)(Math.random()*5 + 5);
		int columns = (int)(Math.random()*5 + 20);
		board = new int[rows][columns];
		fillBoard();
		count = new int[rows][columns];
		fillCount();
		isNotHidden = new boolean[rows][columns];
	}
	
	private static void fillBoard(){
		for(int r = 0; r < board.length; r++){
			for(int c = 0; c < board[r].length; c++){
				if(Math.random() < .15){
					board[r][c] = 2;
				}
				else{
					board[r][c] = 1;
				}
			}
		}
	}
	
	private static void fillCount(){
		for(int r = 0; r < board.length; r++){
			for(int c = 0; c < board[r].length; c++){
				count[r][c] = countAdjacent(board, r, c);
			}
		}
	}
	
	private static int countAdjacent(int[][] mines, int r, int c) {
		int count = 0;
		count+=(isAdjacentMine(mines, r, c-1));
		count+=(isAdjacentMine(mines, r, c+1));
		count+=(isAdjacentMine(mines, r-1, c));
		count+=(isAdjacentMine(mines, r+1, c));
		count+=(isAdjacentMine(mines, r-1, c-1));
		count+=(isAdjacentMine(mines, r-1, c+1));
		count+=(isAdjacentMine(mines, r+1, c-1));
		count+=(isAdjacentMine(mines, r-1, c+1));
		return count;
	}
	
	private static int isAdjacentMine(int[][] mines, int r, int c){
		if(r >= 0 && r < mines.length && c >=0 && c < mines[r].length && mines[r][c] == 2){
			return 1;
		}
		return 0;
	}

	private static void updateBooleanArray(int row, int col) {
		int[][] adjacentPosArray = {{row, col-1}, {row, col+1}, {row-1, col}, {row+1, col}, {row-1, col-1}, {row-1, col+1}, {row+1, col-1}, {row-1, col+1}};
		isNotHidden[row][col] = true;
		for(int p = 0; p < adjacentPosArray.length; p++){
			int r = adjacentPosArray[p][0];
			int c = adjacentPosArray[p][1];
			if(r >= 0 && r < board.length && c >=0 && c < board[r].length && isAdjacentMine(board, r, c) == 0){ 
				isNotHidden[r][c] = true;
				/*if(count[r][c] == 0) //if there is no mine and no adjacent mine
					updateBooleanArray(r, c);*/
			}
		
		}
	}
}

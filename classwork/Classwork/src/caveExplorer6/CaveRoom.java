package caveExplorer6;

public class CaveRoom {

	private String description;
	private String directions;
	private String contents;
	private String defaultContents;

	private CaveRoom[] borderingRooms;
	private Door[] doors; 

	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;


	public CaveRoom(String description){
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		for(int i = 0 ; i < borderingRooms.length; i++){
			borderingRooms[i] = null;
			doors[i] = null;
		}
		setDirections();
	}

	protected void setDirections() {
		directions	= "";
		if(doors[NORTH] == null && 
				doors[EAST] == null &&
				doors[SOUTH] == null &&
				doors[WEST] == null){
			directions = "\n\nThis is a room with no exit. You will die here.";		
		}else{
			for(int dir = 0; dir < doors.length; dir++){
				if(doors[dir] != null){
					directions += "\n   There is a "+doors[dir].getDescription()+" to "+toDirection(dir)+". "+doors[dir].getDetails();
				}
			}
		}
	
	}

	public static String toDirection(int dir) {
		String[] directions = {"the North","the East",
				"the South", "the West"};
		
		return directions[dir];
	}

	public String getContents(){
		return contents;
	}
	
	public void enter(){
		contents = "X";
	}
	
	public void leave(){
		contents = defaultContents;
	}
	
	public void setDefaultContents(String symbol){
		defaultContents = symbol;
	}
	

	public void addRoom(int direction, CaveRoom anotherRoom, Door door){
		borderingRooms[direction] = anotherRoom;
		doors[direction] = door;
		setDirections();
	}
	
	/**
	 * Gives this room access to anotherRoom (and vice-versa) and
	 * sets a door between them, and updates the directions
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door){
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}

	/**
	 * 
	 * @param dir
	 * @return opposite direction of dir (NORTH returns SOUTH...)
	 */
	public static int oppositeDirection(int dir){
		return (dir+2)%4;
	}

	
	public String getDescription(){
		return description+directions;
	}

	

	
	public Door getDoor(int dir){
		return doors[dir];
	}


	public void setDescription(String string) {
		description = string;
	}

	public void interpretInput(String input) {
		while(!isValid(input)){
			System.out.println("You can only enter "
					+ "'w','a','s', or 'd'.");
			input = CaveExplorer.in.nextLine();
		}
		String[] keys = {"w","d","s","a"};
		int indexFound = -1;
		for(int i = 0; i < keys.length; i++){
			if(input.equals(keys[i])){
				indexFound = i;
				break;
			}
		}
		goToRoom(indexFound);
	}
	
	public void goToRoom(int direction){
		if(borderingRooms[direction] != null &&
				doors[direction].isOpen()){
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		}
	}

	public boolean isValid(String s){
		String[] keys = {"w","a","s","d"};
		for(String key:keys){
			if (s.equals(key))return true;
		}
		return false;
	}

	public static void setUpCaves() {
		CaveExplorer.caves = new CaveRoom[5][5];
		for(int i = 0; i < CaveExplorer.caves.length; i++){
			for(int j = 0; j < CaveExplorer.caves[i].length; j++){
				CaveExplorer.caves[i][j] = new CaveRoom("This cave has coordinates "+i+", "+j);
			}
		}
		CaveExplorer.caves[0][2] = new EventRoom("This is the room"
				+ " where that guy with a tail met you.",
				new GameStartEvent());
		CaveExplorer.currentRoom = CaveExplorer.caves[0][1];
		CaveExplorer.currentRoom.enter();
		CaveExplorer.caves[0][1].setConnection(CaveRoom.EAST,CaveExplorer.caves[0][2],new Door());
		CaveExplorer.caves[0][2].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[1][2],new Door());
		CaveExplorer.caves[1][2].setConnection(CaveRoom.SOUTH,CaveExplorer.caves[2][2],new Door());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
 
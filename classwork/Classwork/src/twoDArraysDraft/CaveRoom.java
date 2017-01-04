package twoDArraysDraft;

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
		setDefaultContents("   ");
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

	public String getContents(){
		return contents;
	}
	
	public void enter(){
		contents = " X ";
	}
	
	public void leave(){
		contents = defaultContents;
	}
	
	public void setDefaultContents(String symbol){
		defaultContents = symbol;
	}
	
	private static String toDirection(int dir) {
		switch(dir){
		case NORTH: return "the North";
		case EAST: return "the East";
		case SOUTH: return "the South";
		case WEST: return "the West";
		}
		return "somewhere";
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

	public CaveRoom interpretAction(String command) {
		boolean valid = isValidCommand(command);
		while(!valid){
			System.out.println("In this room, you can only enter 'w','a','s', or 'd'.");
			command = CaveExplorer.waitForInput();
		}
		if(command.equals("a")) return moveToRoom(WEST);
		else if(command.equals("d")) return moveToRoom(EAST);
		else if(command.equals("w")) return moveToRoom(NORTH);
		else if(command.equals("s")) return moveToRoom(SOUTH);
		return this;
	}
	
	private CaveRoom moveToRoom(int dir){
		if(borderingRooms[dir] != null && !doors[dir].isLocked()){
			leave();
			borderingRooms[dir].enter();
			return borderingRooms[dir];
		}else{
			return this;
		}
	}
	
	public Door getDoor(int dir){
		return doors[dir];
	}

	private boolean isValidCommand(String command) {
		return command.equals("w") ||
				command.equals("d") ||
				command.equals("s") ||
				command.equals("a"); 
	}

	public void setDescription(String string) {
		description = string;
	}

}

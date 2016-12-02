package hansExplorerMain;

public class HansCaveRoom {

	private String description;
	private String directions;
	private String contents;
	private String defaultContents;

	private HansCaveRoom[] borderingRooms;
	private HansDoor[] doors; 

	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;


	public HansCaveRoom(String description){
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		
		borderingRooms = new HansCaveRoom[4];
		doors = new HansDoor[4];
//		for(int i = 0 ; i < borderingRooms.length; i++){
//			borderingRooms[i] = null;
//			doors[i] = null;
//		}
		setDirections();
	}
	
	public void updateContents(String c){
		defaultContents = c;
		contents = c;
	}
	
	public HansDoor getDoor(int dir){
		return doors[dir];
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
		String[] directions = {"the North","the East","the South","the West"};
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
	

	public void addRoom(int direction, HansCaveRoom anotherRoom, HansDoor door){
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
	public void setConnection(int direction, HansCaveRoom anotherRoom, HansDoor door){
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



	public void setDescription(String string) {
		description = string;
	}

	public void interpretInput(String input) {
		input = input.toLowerCase();
		while(!isValid(input)){
			System.out.println("You can only enter 'w', 'a', 's', 'd'");
			input = HansCaveExplorer.in.nextLine().toLowerCase();
		}
		String[] keys = {"w","d","s","a"};
		int indexFound = -1;
		for(int i=0;i<keys.length;i++){
			if(input.equals(keys[i])){
				indexFound = i;
				break;
			}
		}
		goToRoom(indexFound);
	}
	public void goToRoom(int direction){
		if(borderingRooms[direction]!=null && !doors[direction].isLocked()){
			HansCaveExplorer.currentRoom.leave();
			HansCaveExplorer.currentRoom = borderingRooms[direction];
			HansCaveExplorer.currentRoom.enter();
			HansCaveExplorer.inventory.updateMap();
		}
		else{
			if(borderingRooms[direction]!=null && doors[direction].isLocked())
				System.out.println("This door is locked! You need the key man!!");
			else
				System.out.println("You can't go there.");
		}
	}
	public static boolean isValid(String input){
		String lc = input.toLowerCase();
		String[] keys = {"w","a","s","d"};
		for(String key:keys){
			if(key.equals(lc))
				return true;
		}
		return false;
		
	}

}

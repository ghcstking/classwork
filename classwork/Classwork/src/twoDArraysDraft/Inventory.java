package twoDArraysDraft;

public class Inventory {

	private boolean hasMap;
	private String map;
	

	public Inventory(CaveRoom[][] caves) {
		hasMap = false;
		updateMap();
	}

	private void updateMap() {
		CaveRoom[][] caves = CaveExplorer.caves;
		//create top
		map = " ";
		for(int i = 0; i < caves[0].length-1; i++){
			
			map+="____";
		}
		map+="___ \n";
		for(CaveRoom[] row: caves){
			for(int i = 0; i < 3; i++){
				for(CaveRoom cr: row){
					//each cave takes up 3 rows and columns of txt

					if(cr.getDoor(CaveRoom.WEST) == null){
						map+="|";
					}else{
						map+=" ";
					}
					if(i == 1){
						map+=cr.getContents();
					}else if(i== 0){
						map+="   ";
					}
					if(i ==2){
						if(cr.getDoor(CaveRoom.SOUTH) == null){
							map+="___";
						}else{
							map+="   ";
						}
					}
				}
				map+="|\n";//end of row
			}
		}
	}



	public String getDescription(){
		if(hasMap){
			updateMap();
			return "You have a map:\n" +map;
		}else{
			return "You have no inventory.";
		}
	}

	public void setMap(boolean b) {
		hasMap = b;
	}

}

package hansExplorerMain;

public class HansDoor {
	private boolean locked;
	private boolean open;
	private boolean isRoom;
	private String description;
	private String details;
	
	public HansDoor(String p,boolean r){
		locked = false;
		open = true;
		description = p;
		details = "";
		isRoom = r;
	}
	
	public boolean getIsRoom(){
		return isRoom;
	}
	
	public void setLocked(boolean b){
		locked = b;
	}
	
	public boolean isLocked(){
		return locked;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}

package twoDArraysDraft;

public class Door {

	private boolean open;
	private boolean locked;
	
	public Door(){
		open = true;
		locked = false;
	}

	public String getDescription() {
		if(open){
			return "passage";
		}else{
			return "door";
		}
	}

	public String getDetails() {
		if(locked){
			return "It appears locked.";
		}else{
			return "";
		}
	}

	public boolean isLocked() {
		return locked;
	}
}

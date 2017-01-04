package guiTeacher.simon;

public class Move implements MoveInterface {

	private ButtonInterface b; 
	
	public Move(ButtonInterface b) {
		this.b = b;
	}

	public ButtonInterface getButton() {
		return b;
	}

}

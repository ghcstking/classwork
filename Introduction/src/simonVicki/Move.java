package simonVicki;

public class Move implements MoveInterfaceVicki {
	
	private ButtonInterfaceVicki button;
	
	public Move(ButtonInterfaceVicki b) {
		this.button = b;
	}
	
	@Override
	public ButtonInterfaceVicki getButton() {
		return button;
	}

}

package whackamole;

import gui.GUIApplication;

public class WhackAMoleGame extends GUIApplication {

	public WhackAMoleGame(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void initScreen() {
		WhackAMoleScreen wams = 
				new WhackAMoleScreen(getWidth(), getHeight());
		setScreen(wams);
	}

	public static void main(String[] args) {
		WhackAMoleGame game = new WhackAMoleGame(800,500);
		Thread app = new Thread(game);
		app.start();
	}
}

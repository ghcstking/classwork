package guiTeacher.simon;

import guiTeacher.GUIApplication;

public class SimonGame extends GUIApplication {

	public SimonGame(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		SimonScreen s = new SimonScreen(getWidth(), getHeight());
		setScreen(s);
	}

	public static void main(String[] args) {
		SimonGame game = new SimonGame(800, 500);
		Thread app = new Thread(game);
		app.start();
	}

}

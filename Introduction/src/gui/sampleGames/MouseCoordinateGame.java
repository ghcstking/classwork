package gui.sampleGames;

import gui.GUIApplication;
import gui.screens.CoordinateScreen;

public class MouseCoordinateGame extends GUIApplication {

	public static MyScreen myScreen;
	public static MouseCoordinateGame game;
	public static CoordinateScreen originalScreen;
	
	public MouseCoordinateGame(int width, int height) {
		super(width, height);
	}

	@Override
	public void initScreen() {
		originalScreen = new CoordinateScreen(getWidth(), getHeight());
		setScreen(originalScreen);
		myScreen = new MyScreen(getWidth(), getHeight());
	}

	public static void main(String[] args) {
		game = new MouseCoordinateGame(500,500);
		Thread app = new Thread(game);
		app.start();
	}


}

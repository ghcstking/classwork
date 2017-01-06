package gui.sampleGames;

import gui.GUIApplication;
import gui.screens.CoordinateScreen;

public class MouseFollower extends GUIApplication {

	public MouseFollower(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public static CoordinateScreen coordScreen;
	public static MyScreen moveScreen;
	public static MouseFollower game;
	
	public static void main(String[] args){
		game = new MouseFollower(800, 600);
		Thread app = new Thread(game);
		app.start();
	}
	
	@Override
	public void initScreen() {
		moveScreen = new MyScreen(getWidth(), getHeight());
		coordScreen = new CoordinateScreen(getWidth(), getHeight());
		setScreen(coordScreen);
	}
}

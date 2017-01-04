package guiPractice8.sampleGames;

import guiPractice8.GUIApplication;
import guiPractice8.Screen;

public class TheBlankScreenGame extends GUIApplication {


	@Override
	protected void initScreen() {
		Screen s = new BlankScreen(getWidth(), getHeight());
		setScreen(s);
	}

	public static void main(String[] args) {
		new TheBlankScreenGame();
	}

}

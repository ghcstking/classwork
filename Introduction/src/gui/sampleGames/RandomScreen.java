package gui.sampleGames;

import java.util.ArrayList;

import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;

public class RandomScreen extends Screen {
	private TextLabel text;
	public RandomScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		text = new TextLabel(200, 200, 200, 200, "hello");
		viewObjects.add(text);
	}

}

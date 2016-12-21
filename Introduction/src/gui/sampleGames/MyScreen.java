package gui.sampleGames;

import java.util.ArrayList;

import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;

public class MyScreen extends Screen {
	private TextLabel idk;

	public MyScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		idk = new TextLabel(300, 300, 200, 200, "isdfhsdkjfhskjfh");
		viewObjects.add(idk);
	}

}

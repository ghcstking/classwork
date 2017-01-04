package guiTeacher.sampleGames;

import guiTeacher.GUIApplication;

public class AnimationViewer extends GUIApplication {

	public static AnimationViewer game;
	
	public static void main(String[] args){
		game = new AnimationViewer(500, 500);
		Thread app = new Thread(game);
		app.start();
	}
	
	public AnimationViewer(int width, int height) {
		super(width, height);
	}

	@Override
	public void initScreen() {
		AnimationScreen as = new AnimationScreen(getWidth(), getHeight());
		setScreen(as);

	}

}

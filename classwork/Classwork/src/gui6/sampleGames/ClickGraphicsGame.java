package gui6.sampleGames;

import guiTeacher.GUIApplication;

public class ClickGraphicsGame extends GUIApplication{

	public ClickGraphicsGame() {
		super(500,500);
	}

	public static void main(String[] args) {
		ClickGraphicsGame cgg = new ClickGraphicsGame();
		Thread app = new Thread(cgg);
		app.start();
	}

	@Override
	public void initScreen() {
		GraphicsClickScreen gcs = new GraphicsClickScreen(getWidth(), getHeight());
//		MyPracticeClickableScreen pcs = new MyPracticeClickableScreen(getWidth(), getHeight());
		setScreen(gcs);
	}
	
	
	
	
	
	
	
	
	

}

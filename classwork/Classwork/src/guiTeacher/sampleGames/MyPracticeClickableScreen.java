package guiTeacher.sampleGames;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class MyPracticeClickableScreen extends ClickableScreen {

	ClickableGraphic mario;
	
	public MyPracticeClickableScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		mario = new ClickableGraphic(20, 20, .2, "resources/sampleImages/mario.png");
		mario.setAction(new Action() {
			
			public void act() {
				mario.setX(mario.getX() + 10);
			}
		});
		viewObjects.add(mario);
	}

}

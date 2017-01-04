package guiTeacher.wackAMole;

import guiTeacher.components.ClickableGraphic;

public class Mole extends ClickableGraphic implements MoleInterface {

	private double appearanceTime;
	

	public Mole(int x, int y) {
		super(x, y, .50, "resources/sampleImages/mole.jpg");
	}

	public void setAppearanceTime(double d) {
		this.appearanceTime = d;

	}

	public double getAppearanceTime() {
		return appearanceTime;
	}

}

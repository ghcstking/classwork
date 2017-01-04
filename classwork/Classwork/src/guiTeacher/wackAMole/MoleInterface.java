package guiTeacher.wackAMole;

import guiTeacher.components.Action;
import guiTeacher.components.Clickable;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Visible;

public interface MoleInterface extends Clickable {

	


	public void setAppearanceTime(double d);

	public double getAppearanceTime();
	
	public void setAction(Action a);

}

package guiPractice8.whackAMole;

import guiPractice8.components.Action;
import guiPractice8.components.Clickable;

public interface MoleInterface extends Clickable {

	int getAppearanceTime();

	void setAppearanceTime(int i);

	void setAction(Action action);

}

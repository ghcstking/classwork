package guiTeacher.simon;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.Clickable;

public interface ButtonInterface extends Clickable{

	void setColor(Color color);

	/**
	 * changes button's displayed color to something brighter
	 */
	void highlight();

	/**
	 * changes button's displayed color to something dimmer
	 */
	void dim();

	void setAction(Action action);

	
	void setName(String name);
}

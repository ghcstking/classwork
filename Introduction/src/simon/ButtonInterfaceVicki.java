package simon;

import java.awt.Color;

import gui.components.Action;
import gui.components.Clickable;

public interface ButtonInterfaceVicki extends Clickable {
	public void setAction(Action a);
	void setColor(int i);
	void setX(int x);
	void setY(int y);
}

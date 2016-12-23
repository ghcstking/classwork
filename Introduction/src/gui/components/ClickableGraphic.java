package gui.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class ClickableGraphic extends Graphic implements Clickable, Visible {
	
	private Action act;
	
	public ClickableGraphic(int x, int y, String imageLocation, Action act) {
		super(x, y, imageLocation);
		setAction(act);
	}
	
	// custom size
	public ClickableGraphic(int x, int y, int w, int h, String imageLocation, Action act) {
		super(x, y, w, h, imageLocation);
		setAction(act);
	}
	
	// scaled size
	public ClickableGraphic(int x, int y, double scale, String imageLocation, Action act) {
		super(x, y, scale, imageLocation);
		setAction(act);
	}

	@Override
	public boolean isHovered(int x, int y) {
		return x>getX() && x<getX() + getWidth() && y > getY() && y < getY() + getHeight();
	}

	@Override
	public void act() {
		if(this.act != null) {
			this.action.act();
		}
	}
	
	public void setAction(Action a) {
		this.act = a;
	}
	
}

package gui.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class ClickableGraphic extends Graphic implements Clickable, Visible {
	
	private Action act;
	private BufferedImage image;
	private boolean loadedImages;
	private int x;
	private int y;
	
	public ClickableGraphic(int x, int y, String imageLocation, Action act) {
		super(x, y, imageLocation);
		this.act = act;
	}
	
	// custom size
	public ClickableGraphic(int x, int y, int w, int h, String imageLocation, Action act) {
		super(x, y, w, h, imageLocation);
		this.act = act;
	}
	
	// scaled size
	public ClickableGraphic(int x, int y, double scale, String imageLocation, Action act) {
		super(x, y, scale, imageLocation);
		this.act = act;
	}

	@Override
	public boolean isHovered(int x, int y) {
		return x>getX() && x<getX() + getWidth() && y > getY() && y < getY() + getHeight();
	}

	@Override
	public void act() {
		if(act != null) {
			act();
		}
	}
	
	public void setAction(Action a) {
		
	}
	
	public BufferedImage getImage() {
		return image;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return image.getWidth();
	}

	@Override
	public int getHeight() {
		return image.getHeight();
	}

	@Override
	public boolean isAnimated() {
		return false;
	}

	@Override
	public void update() {

	}
}

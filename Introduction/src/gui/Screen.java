package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gui.components.Visible;

public abstract class Screen {
	private BufferedImage image;
	private ArrayList<Visible> viewObjects;
	
	public Screen(int width, int height) {
		viewObjects = new ArrayList<Visible>();
		initObjects(viewObjects);
		initImage(width, height);
	}
	
	public abstract void initObjects(ArrayList<Visible> viewObjects);

	public void initImage(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		update();
	}
	public BufferedImage getImage() {
		return image;
	}
	
	public int getWidth() {
		return image.getWidth();
	}
	
	public int getHeight() {
		return image.getHeight();
	}
	
	public void update() {
		Graphics2D g = image.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		g.setColor(Color.black);
//		for(int i = 0; i < viewObjects.size(); i++) {
//			
//		}
		for(Visible v: viewObjects) {
			g.drawImage(v.getImage(), v.getX(), v.getY(), null);
		}
	}
	
	public MouseMotionListener getMouseMotionListener() {
		return null;
	}
	
	public MouseListener getMouseListener() {
		return null;
	}
	
	// ABSTRACTION 
		// can implement as many interfaces as you want
	// interface: description of methods
	// abstract class: can only extend one class
		// description of methods + methods 
			// methods only useful to subclasses that inherit this class
	// CANNOT INSTANTIATE AN ABSTRACT CLASS !!!!
}

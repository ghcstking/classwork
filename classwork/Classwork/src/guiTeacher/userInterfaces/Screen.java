package guiTeacher.userInterfaces;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.GUIApplication;
import guiTeacher.components.Visible;

public abstract class Screen {

	private BufferedImage image;
	private List<Visible> viewObjects;
	
	public Screen(int width, int height) {
		viewObjects = new ArrayList<Visible>();
		initImage(width, height);
		initObjects(viewObjects);
	}

	/**
	 * adds objects to viewObjects 
	 */
	public abstract void initObjects(List<Visible> viewObjects);

	
	public void initImage(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		update();
		
	}
	
	public int getWidth(){
		return image.getWidth();
	}
	
	public int getHeight(){
		return image.getHeight();
	}
	
	public void addObject(Visible v){
		viewObjects.add(v);
	}
	
	public void update() {
		Graphics2D g = image.createGraphics();
		g.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
	             RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		g.setColor(Color.black);
		//iterate through all view objects
		for(Visible v: viewObjects){
			if(v.isAnimated())v.update();
			g.drawImage(v.getImage(), v.getX(), v.getY(), null);
		}
//		g.drawString("Look! Text is printed!", 30, 60);
	}
	
	public void remove(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);//all other objects slide up in order
		}
	}
	
	public void moveToFront(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);//all other objects slide up in order
			viewObjects.add(v);
		}
	}
	
	public void moveToBack(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);//all other objects slide up in order
			viewObjects.add(0, v);
		}
	}
	
	public Image getImage(){
		return image;
	}

	public MouseListener getMouseListener() {
		return null;
	}
	
	public MouseMotionListener getMouseMotionListener() {
		return null;
	}

}

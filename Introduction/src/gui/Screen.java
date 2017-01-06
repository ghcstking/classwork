package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import gui.components.Visible;

public abstract class Screen {
	
	private BufferedImage image;
	private ArrayList<Visible> viewObjects;


	public Screen(int width, int height) {
		viewObjects = new ArrayList<Visible>();
		initObjects(viewObjects);
		initImage(width, height);
	}

	public abstract void 
	initObjects(ArrayList<Visible> viewObjects);

	public void initImage(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		update();
		
	}

	public BufferedImage getImage(){
		return image;
	}

	public int getWidth(){
		return image.getWidth();
	}

	public int getHeight(){
		return image.getHeight();
	}

	public void update() {
		Graphics2D g = image.createGraphics();
		//smooth the graphics
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(Color.white);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		g.setColor(Color.black);
//		for(int i = 0; i < viewObjects.size(); i++){
//			
//		}
		for(Visible v: viewObjects){
			g.drawImage(v.getImage(), v.getX(), v.getY(), null);
		}
	}

	
	//represents ABILITY to listen to mouse
	//but isn't actually doing something
	public MouseMotionListener getMouseMotionListener(){
		return null;
	}
	
	public MouseListener getMouseListener(){
		return null;
	}
	
	
	public void addObject(Visible v){
		viewObjects.add(v);
	}
	
	public void remove(Visible v){
		viewObjects.remove(v);
		
		/**
		 * Note: in this implementation, we have
		 * a very simple command: remove(v)
		 * however remove is a sorta big ddeal on ap exam
		 * 
		 * When an object is removed from a List, every other obejct after that object
		 * is move up in order. Thus all indices change.
		 * Must beware of this.
		 * 
		 * here is a CLAAAASIC exmaple
		 * 
		 * The following is WRONG
		 * Suppose you have a List<Integer> with
		 * {4,8,7,1}
		 * and you want to remove all integers greater than 5
		 * You do this:
		 * for(int i = 0; i < list.size(); i++){
		 * 		if(list.get(i) >5) list.remove(i);
		 * }
		 * You fail.
		 * i = 0; nothing changes.
		 * i=1, 8 is removed, {4,7,1};
		 * i=2, nothing changes
		 * i=3, exit loop
		 * 
		 * THESE TWO WAYS ARE CORRECT:
		 * 
		 * for(int i = 0; i < list.size(); i++){
		 * 		while(list.get(i) >5) list.remove(i);
		 * }
		 * 
		 * for(int i = 0; i < list.size(); i++){
		 * 		if(list.get(i) >5){
		 * 			list.remove(i);
		 * 			i--;
		 * 		}
		 * }
		 * 
		 * FOR THE SAME REASON,THE FOLLOWING WON'T WORK
		 * (because the size can be changed)
		 * for(integer i:list){
		 * 		if(i>5)list.remove(i); 
		 */
	 }
	
	public void moveToBack(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);
			//the "back is index 0
			viewObjects.add(0,v);
		}
	}
	
	public void moveToFront(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);
			viewObjects.add(v);
		}
	}

	public void initObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}
	
//	//			ABSTRACTION
//	// interface - implement as many interfaces as you want
//		description of methods
//		
//		Abstract class- extends only one class. 
//		Description of methods
//		methods- only useful to subclasses that inherit the class.
//	

}
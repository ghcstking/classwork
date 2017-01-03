package gui.components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;

public abstract class ClickableScreen extends Screen implements MouseListener, MouseMotionListener {
	
	private ArrayList<Clickable> clickables;
	
	public ClickableScreen(int width, int height) {
		super(width, height);
		clickables = new ArrayList<Clickable>();
	}
	
	public MouseListener getMouseListener() {
		return this;
	}
	
	public abstract void initAllObjects(ArrayList<Visible> clickables);

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		initAllObjects(viewObjects);
		clickables = new ArrayList<Clickable>();
		for (int i = 0; i < clickables.size(); i++) {
			if(viewObjects.get(i) instanceof Clickable) {
				clickables.add((Clickable) (viewObjects.get(i)));
			}
		}
	}
	public void addObject(Visible v){
	 super.addObject(v);
		 if(v instanceof Clickable){
	 		clickables.add((Clickable)v);
	 	}
	 }
 

 
	 public void remove(Visible v){
	 super.remove(v);
	 clickables.remove((Clickable)v);
	 } 

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for(Clickable c: clickables){
			if(c.isHovered(e.getX(), e.getY())){
				c.act();
				break;
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

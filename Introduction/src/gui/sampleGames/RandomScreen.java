package gui.sampleGames;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.ClickableGraphic;
import gui.components.TextLabel;
import gui.components.Visible;

public class RandomScreen extends Screen implements MouseListener {
	private ClickableGraphic peach;
	public RandomScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		peach = new ClickableGraphic(20, 20, .2, "resources/sampleImages/peach.png");
		peach.setAction(new Action() {
			
			public void act() {
				peach.setX(peach.getX() + 10);
			}
		});
		viewObjects.add(peach);
	}

	public void mouseClicked(MouseEvent m) {
		if(peach.isHovered(m.getX(), m.getY())){
			peach.act();
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public MouseListener getMouseListener(){
		return this;
	}

}

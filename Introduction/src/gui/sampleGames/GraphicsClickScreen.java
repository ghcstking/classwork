package gui.sampleGames;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import gui.components.Action;
import gui.components.ClickableGraphic;
import gui.components.Visible;
import gui.Screen;

public class GraphicsClickScreen extends Screen implements MouseListener{

	private ClickableGraphic mario;
	
	public GraphicsClickScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public void initObjects(List<Visible> viewObjects) {
		mario = new ClickableGraphic(20, 20, .2, "resources/sampleImages/mario.png");
		mario.setAction(new Action() {
			
			public void act() {
				mario.setX(mario.getX() + 10);
			}
		});
		viewObjects.add(mario);
	}

	public void mouseClicked(MouseEvent m) {
		if(mario.isHovered(m.getX(), m.getY())){
			mario.act();
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

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}

}

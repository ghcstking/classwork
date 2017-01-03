package gui.sampleGames;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.Graphic;
import gui.components.Visible;

public class MyPractice extends Screen implements MouseMotionListener, MouseListener{

	public MyPractice(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	private Graphic secondPic;
	private Button back;
	
	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		secondPic = new Graphic(200,200,1,"resources/sampleImages/images.jpg");
		back = new Button(40,300,80,30,"hdf",new Color(0,76,153), new Action(){
			public void act(){
				MouseFollower.game.setScreen(MouseFollower.moveScreen);
			}
			});
		viewObjects.add(secondPic);
		viewObjects.add(back);
	}

	public void mouseDragged(MouseEvent arg0) {

	}

	public void mouseMoved(MouseEvent e) {
		
	}

	public void mouseClicked(MouseEvent e) {
		if(back.isHovered(e.getX(), e.getY())){
			back.act();
		}
	}

	public void mouseEntered(MouseEvent e) {
	
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
	
	}

	public MouseListener getMouseListener(){
		return this;
	}
	
}

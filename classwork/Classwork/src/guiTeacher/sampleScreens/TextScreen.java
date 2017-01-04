package guiTeacher.sampleScreens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextLabel;
import guiTeacher.components.Visible;
import guiTeacher.sampleGames.MouseCoordinateGame;
import guiTeacher.userInterfaces.MessageDisplayer;
import guiTeacher.userInterfaces.Screen;

public class TextScreen extends Screen implements MessageDisplayer, MouseMotionListener, MouseListener{

	private TextLabel label;
	private Button goToFollower;
	
	public TextScreen(String text, int width, int height) {
		super(width, height);
		label.setText(text);
		update();
	}

	@Override
	public void initObjects(List<Visible> viewObjects) {
		label = new TextLabel(40, getHeight()-45, getWidth()-80, 40, "");
		goToFollower = new Button(40,50,100,30,"Button that is really descriptive",new Color(0,76,255), new Action() {
			
			public void act() {
				MouseCoordinateGame.game.setScreen(MouseCoordinateGame.ballScreen);
			}
		});
		goToFollower.setSize(12);
		label.setSize(40);
		viewObjects.add(label);
		viewObjects.add(goToFollower);
	}

	public void displayMessage(String message) {
		label.setText(message);
		update();
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public MouseMotionListener getMouseMotionListener(){
		return this;
	}
	
	public MouseListener getMouseListener(){
		return this;
	}
	
	public void mouseMoved(MouseEvent m) {
		displayMessage("Mouse at "+m.getX()+","+m.getY());
	}

	public void mouseClicked(MouseEvent e) {
		if(goToFollower.isHovered(e.getX(), e.getY())){
			goToFollower.act();
		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

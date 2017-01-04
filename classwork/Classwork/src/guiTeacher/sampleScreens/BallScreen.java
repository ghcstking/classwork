package guiTeacher.sampleScreens;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;

import guiTeacher.GUIApplication;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.Visible;
import guiTeacher.sampleObjects.Ball;
import guiTeacher.userInterfaces.Screen;

public class BallScreen extends Screen implements MouseMotionListener{

	private Graphic ball;
	
	public BallScreen(int width, int height) {
		super( width, height);
		
	}

	@Override
	public void initObjects(List<Visible> viewObjects) {
		TextArea ta = new TextArea(2,25,500,400,"This is a sample of a text area. It should run multiple lines if I did everything right. I'm not sure if I did though.");
		ta.update();
//		ball = new Ball(40,40,50,50); 
		ball = new Graphic(40,40,.2,"resources/sampleImages/mario.png");
		viewObjects.add(ta);
		viewObjects.add(ball);
		
	}

	public void setBallPosition(int x, int y) {
		ball.setX(x);
		ball.setY(y);
		update();
	}

	@Override
	public MouseMotionListener getMouseMotionListener(){
		return this;
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent m) {
		setBallPosition(m.getX(), m.getY());
	}

}

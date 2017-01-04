package gui6.screens;



import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


import gui6.Screen;
import gui6.components.Button;
import gui6.components.Graphic;
import gui6.components.TextArea;
import gui6.components.Action;
import gui6.components.TextLabel;
import gui6.components.Visible;

public class CoordinateScreen extends Screen 
               implements MouseMotionListener{

	
	//FIELD
	private Button button;
	private TextLabel text;
	private TextArea area; 
	private Graphic bowser;
	
	public CoordinateScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		button = new Button(20,100,80,40,
				"The Button with a long name",new Color(100,100,250),
				new Action() {
			
			public void act() {
				// TODO Auto-generated method stub
				
			}
		});
		viewObjects.add(button);
		text = 
				new TextLabel(20, 100, 500, 40, "Some text");
		viewObjects.add(text);
		
		area = 
				new TextArea(20, 200, 500, 100, "This is "
						+ "really long text. It prints over"
						+ " multiple lines, as you can see. "
						+ "We worked on this in class. It"
						+ " is called TextArea.");
		viewObjects.add(area);
		
		bowser = new Graphic(30,30,.5, "resources/"
				+ "sampleImages/bowser.png"); 
		viewObjects.add(bowser);
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent e) {
		int mx = e.getX();//get mouse X coordinate
		int my = e. getY();//get Y coord
		text.setText("Mouse at: "+mx +", "+my);
	}

	public MouseMotionListener getMouseMotionListener(){ 
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
}

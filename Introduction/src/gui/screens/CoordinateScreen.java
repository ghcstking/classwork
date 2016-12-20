package gui.screens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.Graphic;
import gui.components.TextArea;
import gui.components.TextLabel;
import gui.components.Visible;

public class CoordinateScreen extends Screen implements MouseMotionListener{
	private Button button;
	private TextLabel text;
	private TextArea textArea;
	private TextLabel location;
	private Graphic toad;
	public CoordinateScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		text = new TextLabel(20, 50, 200, 20, "hello its me");
		location = new TextLabel(20, 50, 500, 200, " ");
		textArea = new TextArea(20,100,200,200,"zoozozoo zoop zoot zoom noooop noooy noot");
		toad = new Graphic(200,50,100,100,"resources/sampleImages/toad.png");
		viewObjects.add(location);
		viewObjects.add(textArea);
		viewObjects.add(text);
		viewObjects.add(toad);
//		button = new Button(40,40,80,30,"The Button",new Color(0,76,153), new Action(){
//			public void act(){
//				
//			}
//			});
//		viewObjects.add(button);
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent e) {
		int mx = e.getX();//get mouse X coordinate
		int my = e. getY();//get Y coord
		location.setText("Mouse at: "+mx +", "+my);
	}

	public MouseMotionListener getMouseMotionListener(){ 
		return this;
	}
}

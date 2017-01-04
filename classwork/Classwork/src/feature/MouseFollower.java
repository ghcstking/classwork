package feature;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseFollower extends BasicFeature 
implements MouseMotionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -483454187127333552L;


	public MouseFollower(int x, int y) {
		super(x, y);
	}

	public MouseFollower(int x, int y, CustomGraphics custom) {
		super(x, y, custom);
		// TODO Auto-generated constructor stub
	}

	public void mouseDragged(MouseEvent e) {
		setX(e.getX());
		setY(e.getY());
	}

	/**
	 *  @return centered x coordinate
	 */
	public int getX(){
		return x - image.getWidth()/2;
	}
	
	/**
	 *  @return centered y coordinate
	 */
	public int getY(){
		return y - image.getHeight()/2;
	}
	
	
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
	
}

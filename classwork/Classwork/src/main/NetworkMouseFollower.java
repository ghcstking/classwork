package main;

import java.awt.Color;
import java.awt.event.MouseEvent;

import feature.MouseFollower;

public class NetworkMouseFollower extends MouseFollower {

//	private MyServer server;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3729579688045244540L;

	public NetworkMouseFollower(int x, int y, Color color) {
		super(x, y);
		foregroundColor = color;
		draw();
//		this.server = server;
	}

	public void mouseDragged(MouseEvent e) {
		setX(e.getX());
		setY(e.getY());
	}
	
}

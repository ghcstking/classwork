package gui;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public abstract class GUIApplication extends JFrame implements Runnable{
	
	private Screen currentScreen;
	
	public GUIApplication(int width, int height) {
		super();
		setBounds(20,20, width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// terminates program when window is closed
		initScreen();
		setVisible(true);
	}

	public abstract void initScreen();
	
	public void paint(Graphics g) {
		g.drawImage(currentScreen.getImage(), 0, 0, null);
	}
	
	public void setScreen(Screen s) {
		if(currentScreen != null) {
			MouseListener ml = currentScreen.getMouseListener();
			if(ml != null) {
				removeMouseListener(ml);
			}
			MouseMotionListener mml = currentScreen.getMouseMotionListener();
			if (mml != null) {
				removeMouseMotionListener(mml);
			}
		}
		currentScreen = s;
		if(currentScreen != null) {
			addMouseListener(currentScreen.getMouseListener());
			addMouseMotionListener(currentScreen.getMouseMotionListener());
		}
	}
	
	public void run() {
		while(true) {
			currentScreen.update();
			repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

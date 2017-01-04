package simulator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class UI extends JFrame {

	private int width;
	private int height;
	
	private Environment city;
	
	public static void main(String[] args){
		new UI();
	}
	
	public UI() {
		width = Manhattan.WIDTH;
		height = Manhattan.HEIGHT;
		city = Manhattan.getInstance();
		applySettings();
		setVisible(true);
		start();
	}

	private void start() {
		Timer timer = new Timer(1000, new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				city.lapse();
			}
		});
		timer.start();
	}

	public void paint(Graphics g){
		g.drawImage(city.getImage(),0,0,getWidth(), getHeight(),0, 0, width,height, null);
	}
	
	
	protected void applySettings(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int monitorWidth = (int)screenSize.getWidth();
		int monitorHeight = (int)screenSize.getHeight();
		setSize(width,height);
		setLocation((monitorWidth-width)/2,(monitorHeight-height)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(false);
	}
}

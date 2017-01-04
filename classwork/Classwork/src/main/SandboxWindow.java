package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

import feature.BasicFeature;
import feature.CustomGraphics;
import feature.MouseFollower;

public class SandboxWindow extends JFrame{

	private int windowWidth;
	private int windowHeight;
	private ArrayList<Feature> features;
	
	public SandboxWindow() {
		applySettings();
		setVisible(true);
		features = new ArrayList<Feature>();
		features.add(new BasicFeature(50,50));
		features.add(new BasicFeature(200,300));
		features.add(new BasicFeature(200, 100, 
				new CustomGraphics() {
			
			@Override
			public void drawCustomImage(Graphics2D g, int width, int height) {
				g.fillRect(0, 0, width, height);
			}
		}));
		addMouseMotionListenerObjects();
		Timer t = new Timer(10, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SandboxWindow.this.repaint();
			}
		});
		t.start();
	}
	
	
	private void addMouseMotionListenerObjects() {
		MouseFollower follower = new MouseFollower(300, 300);
		features.add(follower);//to make visible
		addMouseMotionListener(follower);//to make active
	}


	public void paint(Graphics screen){
		BufferedImage imageOnTheSide = new BufferedImage(
				getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2 = imageOnTheSide.createGraphics();
		
		
		for(Feature f : features){
			g2.drawImage(f.getImage(),
					f.getX(), 
					f.getY(),null);
		}
		
		screen.drawImage(imageOnTheSide,0,0,null);
	}
	
	protected void applySettings() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int monitorWidth = (int) screenSize.getWidth();
		int monitorHeight = (int) screenSize.getHeight();
		windowWidth = 1000;
		windowHeight = 800;
		setSize(windowWidth,windowHeight);
		setLocation((monitorWidth-windowWidth)/2, (monitorHeight-windowHeight)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//so that the game terminates after the windo is closed
		setUndecorated(false);//windowBar
		setResizable(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SandboxWindow();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package sampleoverworld;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import directors.UtilityMethods;

public class SampleWanderer implements OverworldWanderer{

	BufferedImage[] frames;
	ArrayList<Integer> pressedKeys;//allow for multiple input
	boolean walking;
	int count;
	final int SPRITE_HEIGHT = 170;
	
	
	public SampleWanderer() {
		BufferedImage image0=null;
		BufferedImage image1=null;
		BufferedImage image2=null;
		try {
			BufferedImage origimage0 = UtilityMethods.getImageFromFile(this, "/sprites/sample/sprite0.png");
			BufferedImage origimage1 = UtilityMethods.getImageFromFile(this, "/sprites/sample/sprite1.png");
			BufferedImage origimage2 = UtilityMethods.getImageFromFile(this, "/sprites/sample/sprite2.png");
			image0=UtilityMethods.getScaledImage(origimage0,100,SPRITE_HEIGHT);
			image1=UtilityMethods.getScaledImage(origimage1,90,SPRITE_HEIGHT);
			image2=UtilityMethods.getScaledImage(origimage2,90,SPRITE_HEIGHT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frames = new BufferedImage[3];
		frames[0] = image0;
		frames[1] = image1;
		frames[2] = image2;
		count = 0;
		walking = false;
	}
	
	public BufferedImage getImage(){
		BufferedImage sprite = frames[0];

		if(walking && count < 5){
			sprite = frames[1];
		}
		else if (walking){
			sprite = frames[2];
		}
		return sprite;
		
	}


	
	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			if(!pressedKeys.contains(keyCode))pressedKeys.add(keyCode);
		}
		if(!pressedKeys.isEmpty()){
			walking=true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
		}
		if(pressedKeys.isEmpty())walking=false;
	}


	public void increaseCount() {
		count++;
		if(count>10)count=0;
	}

	public void setWalking(boolean b) {
		walking=b;
	}

	public int getHeight() {
		return SPRITE_HEIGHT;
	}

}

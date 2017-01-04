package guiTeacher.sampleGames;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.TextLabel;
import guiTeacher.components.Visible;
import guiTeacher.userInterfaces.Screen;

public class AnimationScreen extends Screen {

	private AnimatedComponent a;

	public AnimationScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initObjects(List<Visible> viewObjects) {
		int w = 165;
		int h = 293;
		int numberInRow =12;
		int rows = 5;
		a = new AnimatedComponent(40, 40, w, h);
		try{
			ImageIcon icon = new ImageIcon("resources/sampleImages/sprite2.png");
			for(int i = 0; i < numberInRow * rows; i++){
				
				BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = image.createGraphics();
				int leftMargin = 0;
				int topMargin = 0;
				int x1 = leftMargin+w*(i%numberInRow);
				int y1 = topMargin+h*(i/numberInRow);
				g.drawImage(icon.getImage(), 0,0,w, h, x1, y1,x1+w, y1+h, null);
				a.addFrame(image, 30);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		TextLabel text = new TextLabel(40,300,250,50,"Animation should appear above");
		a.setVx(2);
		viewObjects.add(a);
		viewObjects.add(text);
	}

}

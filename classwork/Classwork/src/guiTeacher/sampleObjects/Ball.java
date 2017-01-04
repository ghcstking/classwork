package guiTeacher.sampleObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import guiTeacher.components.Component;

public class Ball extends Component {

	private Image mario;
	private boolean imagesLoaded;
	
	public Ball(int x, int y, int w, int h) {
		super(x, y, w, h);
		loadImages();
	}

	private void loadImages() {
		try{
			mario = new ImageIcon("resources/sampleImages/mario.png").getImage();
			imagesLoaded = true;
			update();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.black);
		if(imagesLoaded) {
			g.drawImage(mario, 0, 0, getWidth(), getHeight(), 0,0,mario.getWidth(null), mario.getHeight(null), null);
		}
//		g.fillOval(0, 0, getWidth(), getHeight());
	}


}

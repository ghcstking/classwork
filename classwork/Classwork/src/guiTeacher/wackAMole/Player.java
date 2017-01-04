package guiTeacher.wackAMole;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Player extends Component implements PlayerInterface {

	private int score;
	
	public Player(int x, int y) {
		super(x,y,100,100);
		score =0;
	}

	public void increaseScore(int i) {
		score += i;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.drawOval(0, 0, 100, 100);
		g.drawString(""+score, 45, 55);
	}
	

}

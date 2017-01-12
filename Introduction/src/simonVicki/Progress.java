package simonVicki;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.components.Component;

public class Progress extends Component implements ProgressInterfaceVicki {
	
	private boolean gameOver;
	private int sequence;
	private int roundNum;
	
	public Progress() {
		super(60, 60, 120, 50);
		gameOver = false;
	}

	@Override
	public void gameOver() {
		gameOver = true;
	}

	@Override
	public void updateInfo(int roundNumber, int x) {
		this.roundNum = roundNumber;
		this.sequence = x;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(gameOver){
			g.setColor(Color.red);
			g.fillRoundRect(0, 0, 198, 98, 20, 20);
			g.setColor(Color.black);
			g.drawRoundRect(0,0,198,98,20,20);	
			g.drawString("Yikes. Game over!",5,35);
			g.drawString("Round: "+roundNum,5,55);
			g.drawString("Sequence Length: "+sequence,5,75);
		}
		else{
			g.setColor(Color.gray);
			g.fillRoundRect(0, 0, 198, 98, 20, 20);
			g.setColor(Color.black);
			g.drawRoundRect(0,0,198,98,20,20);
			
			g.drawString("Round:"+roundNum,5,35);
			g.drawString("Sequence Length:"+sequence,5,65);
		}
	}
	
}

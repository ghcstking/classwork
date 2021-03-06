package simonVicki;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.components.Action;
import gui.components.Component;

public class Button extends Component implements ButtonInterfaceVicki {

	private Action action;
	private Color c;
	private boolean highlight;
	
	public Button() {
		super(0, 0, 700, 700);
		highlight = false;
	}

	@Override
	public boolean isHovered(int x, int y) {
		return x>getX() && x<getX()+getWidth() && y > getY() && y<getY()+getHeight();
	}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public void setAction(Action a) {
		this.action = a;
	}

	@Override
	public void setColor(Color i) {
		this.c = i;
	}

	@Override
	public void update(Graphics2D g) {
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(highlight) {
			g.setColor(this.c);
			g.fillOval(this.getX(), this.getY(), 65, 65);
			g.setColor(Color.black);
			g.drawOval(this.getX(), this.getY(), 65, 65);
		}
		else {
			g.setColor(Color.gray);
			g.fillOval(this.getX(), this.getY(), 65, 65);
			g.setColor(Color.black);
			g.drawOval(this.getX(), this.getY(), 65, 65);
		}
	}

	@Override
	public void turnOn() {
		highlight = true;
		update();
	}

	@Override
	public void turnOff() {
		highlight = false;
		update();
	}

	@Override
	public Color getColor() {
		return c;
	}
}

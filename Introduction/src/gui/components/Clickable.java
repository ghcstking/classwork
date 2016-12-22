package gui.components;

public interface Clickable {
	public boolean isHovered(int x, int y);
	public void act();
	int getX();
	int getY();
	int getWidth();
	int getHeight();
	boolean isAnimated();
	void update();
}

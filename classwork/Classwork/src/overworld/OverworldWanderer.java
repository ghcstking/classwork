package sampleoverworld;

import java.awt.image.BufferedImage;

public interface OverworldWanderer{

	public BufferedImage getImage();
	public void increaseCount();
	public void setWalking(boolean b);
	public int getHeight();
}

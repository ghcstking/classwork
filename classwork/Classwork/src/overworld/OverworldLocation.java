package sampleoverworld;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * 
 * @author bnockles
 *
 */
public interface OverworldLocation {
	
	public BufferedImage getImage();
	public Rectangle getBoundary();
	public int[] getTileRowAndColumn();
	public int[] getLocationOnTile();
	public void enter();
	
}
Status API Training Shop Blog About Pricing
© 2016 GitHub, Inc. Terms Privacy Sec

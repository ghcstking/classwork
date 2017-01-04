package main;

//period 8
import java.awt.image.BufferedImage;
import java.io.Serializable;

public interface Feature extends Serializable{

	BufferedImage getImage();
	int getX();
	int getY();
	void setX(int x);
	void setY(int y);
	
}

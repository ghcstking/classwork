package simulator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public final class Location {

	public static final int WIDTH=50;
	
	private BufferedImage image;
	private Environment city;
	private int x;
	private int y;
	private double seStatus;
	private boolean taken;
	private String symbolString;
	
	
	public Location(Environment city, int x, int y, String string){
		this.city = city;
		this.x = x;
		this.y = y;
		this.symbolString = string;
		taken = false;
		seStatus = Math.random();
		image = new BufferedImage(WIDTH,WIDTH,BufferedImage.TYPE_INT_ARGB);
		draw();
	}
	
	private void draw(){
		Graphics2D g = image.createGraphics();
		g.setColor(new Color(100,(int)(255*seStatus), 100));
		g.fillRect(0, 0, WIDTH, WIDTH);
		g.setColor(Color.white);
		g.drawString(symbolString, 1, 25);
	}
	
	public Image getImage(){
		return image;
	}
	
	public void move(Inventory i, int x, int y){
		if(i.canAfford(city.getRelocateCost(x, y))){
			i.charge(city.getRelocateCost(x, y));
		
		}
	}
	
	public double getDistanceTo(Location other){
		return Math.sqrt(Math.pow(x-other.getX(), 2)+Math.pow(y-other.getY(), 2));
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Environment getCity(){
		return city;
	}

	//return price per unit of travel
	public double getTravelRate() {
		return 1.0;
	}

	public boolean taken() {
		return taken;
	}

	public double getSE(){
		return seStatus;
	}
	
	public void take(String title) {
		symbolString = title;
		draw();
		taken = true;
	}

	public String toString(){
		return "("+this.x + ", "+this.y+")";
	}
}

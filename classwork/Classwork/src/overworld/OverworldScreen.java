package sampleoverworld;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import directors.Animated;
import directors.Game;
import directors.Screen;
import directors.UtilityMethods;

public class OverworldScreen extends Screen implements KeyListener, Animated{

	BufferedImage[][] backgroundGrid;
	BufferedImage[][] obstacleGrid;
	BufferedImage[][] foregroundGrid;//for layers that appear over sprites feet
	BufferedImage[][] topGrid;//for trees and major obstacles
	
	int gridColumns;
	int gridRows;


	int currentRow;//index of the cell currently showing
	int currentColumn;//index of the cell currently showing

	int entranceRow;//the index of the cell where a character always enters from
	int entraceColumn;
	int entranceX;//exact location on the cell where the entrance is
	int entranceY;

	public static final int MOVE_UNIT = 6;
	ArrayList<Integer> pressedKeys;
	OverworldWanderer sprite;
	int spriteX;
	int spriteY;

	int mapTileWidth = 368;
	int mapTileHeight = 240;
	double scaleFactorX;
	double scaleFactorY;

	/**
	 * 
	 * @param game
	 * @param sprite 
	 * @param folder name of folder where image files are found within "overwolrd" directory
	 * @param area name of area (file name) all files followconvention areabackr-c.png, areaforer-c.png, areaobsr-c.bmp,
	 * @param gridWidth
	 * @param gridHeight
	 */
	public OverworldScreen(Game game, OverworldWanderer sprite, String folder, String area, int gridWidth, int gridHeight, int enterR, int enterC, int enterX, int enterY) {
		super(game);
		this.gridColumns=gridWidth;
		this.gridRows=gridHeight;
		backgroundGrid = new BufferedImage[gridHeight][gridWidth];
		obstacleGrid = new BufferedImage[gridHeight][gridWidth];
		foregroundGrid = new BufferedImage[gridHeight][gridWidth];
		topGrid = new BufferedImage[gridHeight][gridWidth];
		for(int r=0; r<gridHeight; r++){
			for(int c=0; c< gridWidth; c++){
				try {
					obstacleGrid[r][c]=UtilityMethods.getImageFromFile(this, "/overworld/"+folder+"/"+area+"obs"+r+"-"+c+".bmp");
					backgroundGrid[r][c]=UtilityMethods.getImageFromFile(this, "/overworld/"+folder+"/"+area+"back"+r+"-"+c+".png");
					foregroundGrid[r][c]=UtilityMethods.getImageFromFile(this, "/overworld/"+folder+"/"+area+"fore"+r+"-"+c+".png");
				} catch (IOException e) {
					System.out.println("Could not find file.");
					obstacleGrid[r][c]=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
					backgroundGrid[r][c]=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
					foregroundGrid[r][c]=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
					e.printStackTrace();
				}
				try{
					topGrid[r][c]=UtilityMethods.getImageFromFile(this, "/overworld/"+folder+"/"+area+"top"+r+"-"+c+".png");
				}catch(Exception e){
					topGrid[r][c]=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
				}
			}
		}
		scaleFactorX=(double)width/mapTileWidth;
		scaleFactorY=(double)height/mapTileHeight;
		currentRow=enterR;
		currentColumn=enterC;
		spriteX=(int)(enterX*scaleFactorX);
		spriteY=(int)(enterY*scaleFactorY);
		this.sprite=sprite;
		pressedKeys= new ArrayList<Integer>();
	}



	@Override
	public void paintScreen(Graphics2D g2) {
		int x = determineOffset(width, currentColumn, spriteX, gridColumns);
		int y = determineOffset(height, currentRow, spriteY, gridRows);
		

		//draw background
		drawLayer(g2, backgroundGrid, x, y);

		/**
		 * when you need to see the obstacle background
		 */
//		drawImage(g2, obstacleGrid[currentRow][currentColumn], x, y);

		//draws sprite
		int spriteDrawX=spriteX;
		if(x!=0)spriteDrawX=width/2;
		int spriteDrawY=spriteY;
		if(y!=0)spriteDrawY=height/2;
		g2.drawImage(sprite.getImage(),spriteDrawX,spriteDrawY,null);

		//draw foreground
		drawLayer(g2, foregroundGrid, x, y);
		
		//draw top of sprite
		int w = sprite.getImage().getWidth();
		int h = (int)(5*sprite.getImage().getHeight()/6);
		g2.drawImage(sprite.getImage(),spriteDrawX,spriteDrawY,spriteDrawX+w,spriteDrawY+h,0,0,w,h,null);
		
		//draw top
		drawLayer(g2, topGrid, x, y);
	}


	private void drawLayer(Graphics2D g2, BufferedImage[][] layer, int x, int y){
		int scaledMapTileWidth = (int)(mapTileWidth*scaleFactorX);
		int scaledMapTileHeight = (int)(mapTileHeight*scaleFactorY);
		drawImage(g2, layer[currentRow][currentColumn], x, y);
		if(x<0){
			drawImage(g2, layer[currentRow][currentColumn+1], x+scaledMapTileWidth, y);
		}
		if(x>0){
			drawImage(g2, layer[currentRow][currentColumn-1], x-scaledMapTileWidth, y);
		}
		if(y<0){
			drawImage(g2, layer[currentRow+1][currentColumn], x, y+scaledMapTileHeight);
		}
		if(y>0){
			drawImage(g2, layer[currentRow-1][currentColumn], x, y - scaledMapTileHeight);
		}
		//diagonal corners
		if(x<0 && y<0 && currentRow < gridRows-1 && currentColumn < gridColumns - 1){
			drawImage(g2, layer[currentRow+1][currentColumn+1], x+scaledMapTileWidth, y+scaledMapTileHeight);
		}
		if(x>0 && y<0 && currentRow < gridRows-1 && currentColumn > 0){
			drawImage(g2, layer[currentRow+1][currentColumn-1], x-scaledMapTileWidth, y+scaledMapTileHeight);
		}
		if(x<0 && y>0 && currentRow > 0 && currentColumn < gridColumns - 1){
			drawImage(g2, layer[currentRow-1][currentColumn+1], x+scaledMapTileWidth, y+-scaledMapTileHeight);
		}
		if(x>0 && y>0 && currentRow > 0 && currentColumn > 0){
			drawImage(g2, layer[currentRow-1][currentColumn-1], x-scaledMapTileWidth, y+-scaledMapTileHeight);
		}
	}
	
	private void drawImage(Graphics2D g2, BufferedImage img, int x, int y){
		g2.drawImage(img, x, y, x+width, y+height, 0, 0, mapTileWidth, mapTileHeight,null);
	}

	private int determineOffset(int widthOrHeight, int currentColumnOrRow, int xOrY, int gridColumnsorRows) {
		int offset = 0;
		//if sprite is left of center, offset compensates right, assuming adjacent cell
		if(xOrY < widthOrHeight/2 && currentColumnOrRow > 0){
			offset = widthOrHeight/2 - xOrY;
		}
		//if sprite is right of center, offset compensates left, assuming adjacent cell
		if(xOrY > widthOrHeight/2 && currentColumnOrRow < gridColumnsorRows-1){
			offset = -xOrY + widthOrHeight/2;
		}
		return offset;
	}



	public void update(){
		Graphics2D g2 = (Graphics2D) screenImage.getGraphics();
		g2.setColor(Color.black);
		g2.fillRect(0, 0, width, height);
		checkMotion();
		sprite.increaseCount();
		paintScreen(g2);
	}

	public KeyListener getKeyListener() {
		return this;
	}

	private void checkMotion() {
		int proposedNewY=spriteY;
		int proposedNewX=spriteX;

		if(pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)) proposedNewY-=MOVE_UNIT;
		if(!pressedKeys.contains(KeyEvent.VK_UP) && pressedKeys.contains(KeyEvent.VK_DOWN)) proposedNewY+=MOVE_UNIT+2;
		if(pressedKeys.contains(KeyEvent.VK_RIGHT) && !pressedKeys.contains(KeyEvent.VK_LEFT)) proposedNewX+=MOVE_UNIT+2;

		if(!pressedKeys.contains(KeyEvent.VK_RIGHT) && pressedKeys.contains(KeyEvent.VK_LEFT)) proposedNewX-=MOVE_UNIT;

		checkCollisionOrOutOfBounds(proposedNewX, proposedNewY+sprite.getHeight());

	}



	private void  checkCollisionOrOutOfBounds(int proposedNewX, int proposedNewY) {
		boolean moves = true;

		int comparingX = (int)(proposedNewX/scaleFactorX);
		int comparingY = (int)(proposedNewY/scaleFactorY);

		//scale down to compare to image

		if(comparingX > mapTileWidth){
			if(currentColumn == gridColumns-1) moves = false;
			else{
				currentColumn++;
				comparingX-=mapTileWidth;
				proposedNewX-=width;
			}
		}
		else if(comparingX < 0){
			if(currentColumn == 0) moves = false;
			else{
				currentColumn--;
				comparingX+=mapTileWidth;
				proposedNewX+=width;
			}
		}



		if(comparingY > mapTileHeight){
			if(currentRow == gridRows-1) moves = false;
			else{
				currentRow++;
				comparingY-=mapTileHeight;
				proposedNewY-=height;
			}
		}
		else if(comparingY < 0){
			if(currentRow == 0) moves = false;
			else{
				currentRow--;
				comparingY+=mapTileWidth;
				proposedNewY+=height;
			}
		}


		int clrLeft=  obstacleGrid[currentRow][currentColumn].getRGB(comparingX%mapTileWidth,comparingY%mapTileHeight); 
		int clrRight = clrLeft;
		if(comparingX + sprite.getImage().getWidth()/scaleFactorX > mapTileWidth && currentColumn < gridColumns - 1){
			clrRight=  obstacleGrid[currentRow][currentColumn+1].getRGB((int) ((comparingX + sprite.getImage().getWidth()/scaleFactorX)%mapTileWidth) ,comparingY%mapTileHeight);	
		}else{
			clrRight=  obstacleGrid[currentRow][currentColumn].getRGB((int) ((comparingX + sprite.getImage().getWidth()/scaleFactorX)%mapTileWidth) ,comparingY%mapTileHeight);
		}
		 

		int  lred   = (clrLeft & 0x00ff0000) >> 16;
		int  lgreen = (clrLeft & 0x0000ff00) >> 8;
		int  lblue  =  clrLeft & 0x000000ff;
		
		int  rred   = (clrRight & 0x00ff0000) >> 16;
		int  rgreen = (clrRight & 0x0000ff00) >> 8;
		int  rblue  =  clrRight & 0x000000ff;
		
		if(lred<200 && lgreen < 200 && lblue<200)moves = false;
		if(rred<200 && rgreen < 200 && rblue<200)moves = false;
		
		if(moves){

			spriteY=(proposedNewY-sprite.getHeight());
			spriteX=(proposedNewX);
		}
	}





	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			if(!pressedKeys.contains(keyCode))pressedKeys.add(keyCode);
		}
		if(!pressedKeys.isEmpty()){
			sprite.setWalking(true);
		}
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
		}
		if(pressedKeys.isEmpty())sprite.setWalking(false);
	}

}

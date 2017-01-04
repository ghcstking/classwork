package guiTeacher.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimatedComponent extends Component {

	private ArrayList<BufferedImage> frame; //the images that can be displayed
	private ArrayList<Integer> times; //the time each image is displayed
	private long displayTime; //the time when the last image switched
	private int currentFrame; //the frame that is currently being displayed
	private long moveTime; //time when the image last moved
	private double vx; //the horizontal velocity
	private double vy; //the vertical velocity
	private double posx; //the actual x-coordinate of the object
	private double posy; //the actual y-coordinate of the object
	
	public static final int REFRESH_RATE = 30;
	
	public AnimatedComponent(int x, int y, int w, int h) {
		super(x, y, w, h);
		moveTime = System.currentTimeMillis();
		displayTime = System.currentTimeMillis();
		frame = new ArrayList<BufferedImage>();
		times = new ArrayList<Integer>();
		currentFrame = 0;
		vx = 0;
		vy = 0;
		posx= x;
		posy=y;
	}

	public boolean isAnimated(){
		return true;
	}

	
	public void addFrame(BufferedImage image, Integer time){
		frame.add(image);
		this.times.add(time);
	}
	
	@Override
	public void update(Graphics2D g) {
		long currentTime = System.currentTimeMillis();//gets time now
		int difference = (int) (currentTime - moveTime);//checks how long it has been since last update
		//updates only if amount of time is greater than frame rate
		if(difference > REFRESH_RATE){
			//update displayTime, since an update is ocurring
			moveTime = currentTime;
			//calculate what the new position should be.
			posx += vx*(double)difference/REFRESH_RATE;
			posy += vy*(double)difference/REFRESH_RATE;
			//note: for very low velocities, position might not move by much. Therefore,
			//rounding to an int may not change
			setX((int)(posx));
			setY((int)(posy));
		
		}
		drawFrame(g, currentTime);
		
	}

	
	
	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	public void drawFrame(Graphics2D g, long currentTime) {
		//check if it's time to change the frame
		//and make sure that there are images in the frame list
		if(frame != null && frame.size() > 0 && frame.size() == times.size() && currentTime - displayTime > times.get(currentFrame)){
			displayTime = currentTime;
			//clear the previous image
			g = clear();
			//increase the currentFrameIndex but don't exceed size()
			currentFrame = (currentFrame+1)%frame.size();
			BufferedImage newFrame = frame.get(currentFrame);
			g.drawImage(newFrame, 0,0,getWidth(),getHeight(),0,0,newFrame.getWidth(),newFrame.getHeight(),null);
		}
	}

}

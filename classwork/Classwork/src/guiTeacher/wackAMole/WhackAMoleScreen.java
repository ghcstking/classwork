package guiTeacher.wackAMole;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.components.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class WhackAMoleScreen extends ClickableScreen implements Runnable{

	private ArrayList<MoleInterface> moles;
	private PlayerInterface player;
	private TextLabel label;
	private TextLabel timeLabel;
	private double timeLeft;

	public WhackAMoleScreen(int width, int height) {
		super(width, height);
		timeLeft = 60.0;
		Thread play = new Thread(this);
		play.start();
	}

	private void changeText(String string) {
		try{
			Thread.sleep(1000);
			label.setText(string);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		moles = new ArrayList<MoleInterface>();
		player = getAPlayer();
		label = new TextLabel(getWidth()/2-60, getHeight()/2-30, 120, 60, "Ready...");
		timeLabel = new TextLabel(getWidth()/2-60,50, 120, 60, "");
		viewObjects.add(label);
		viewObjects.add(player);
		viewObjects.add(timeLabel);
	}

	public void update(){
		super.update();

	}

	public void run() {
		changeText("Set...");
		changeText("Go!");
		changeText("");
		timeLabel.setText(""+timeLeft);
		while(timeLeft >0){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			timeLeft =timeLeft- .1;
			timeLabel.setText(""+(int)(timeLeft*10)/10.0);
			//countdown all mole time and remove those which are <=0
			for(int i = 0; i < moles.size(); i++){
				MoleInterface md = moles.get(i);
				md.setAppearanceTime(md.getAppearanceTime()-100);
				if(md.getAppearanceTime() <=0){
					remove(md);//from visible screen
					moles.remove(md);//from list
					i--;
				}
			}
			
			//calculate probability of a mole appearing
			//more appear as time counts down
			//no more than two can appear at the same time
			for(int i = 0; i < 2; i++){
				if(Math.random() < .2*(60.0 - timeLeft )/60){
					//create a mole
					final MoleInterface mole = getAMole();
					mole.setAppearanceTime(500+Math.random()*2000);
					mole.setAction(new Action() {
						
						public void act() {
							player.increaseScore(1);
							remove(mole);
						}
					});
					addObject(mole);//to visible screen
					moles.add(mole);//to list
				}
			}
			
			

		}

	}
	
	private PlayerInterface getAPlayer() {
		return new Player(20,20);
	}


	private MoleInterface getAMole() {
		return new Mole((int)(getWidth()*Math.random())-100,
				(int)(getHeight()*Math.random()));
	}

	
	
	
	
	
	
	
	
	
	
}

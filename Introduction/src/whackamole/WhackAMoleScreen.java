package whackamole;

import java.util.ArrayList;
import java.util.List;

import gui.ClickableScreen;
import gui.components.Action;
import gui.components.TextLabel;
import gui.components.Visible;

public class WhackAMoleScreen extends ClickableScreen implements Runnable{

	private ArrayList<MoleInterface> moles;
	private PlayerInterface player;
	private TextLabel label;
	private TextLabel timeLabel;
	private double timeLeft;

	public WhackAMoleScreen(int width, int height) {
		super(width, height);
		timeLeft = 30.0;
		Thread play = new Thread(this);
		play.start();
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		moles = new ArrayList<MoleInterface>();
		player = getAPlayer();
		label = new TextLabel(350,220,100,40,"yeas ");
		timeLabel = new TextLabel(360,40,80,40,"30.0");
		viewObjects.add(player);
		viewObjects.add(timeLabel);
		viewObjects.add(label);
	}

	public void update(){
		super.update();
	}

	public void changeText(String s){
		try{
			label.setText(s);
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public PlayerInterface getAPlayer() {
		return new Player();
	}

	public void run() {
		changeText("Ready...");
		changeText("Set...");
		changeText("Go!");
		changeText("");
		timeLabel.setText(""+timeLeft);
		while(timeLeft > 0){
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			timeLeft -= .1;
			timeLabel.setText(""+(int)(timeLeft*10)/10.0);
			updateAllMoles();
			appearNewMole();
		}
	}
	public void appearNewMole() {
		double chance = 0.1 * (60-timeLeft)/60;
		if (Math.random() < chance) {
			final MoleInterface mole = getAMole();
			mole.setAppearanceTime((int)(500+Math.random()*2000));
			mole.setAction(new Action() {
				public void act() {
					player.increaseScore(1);
					remove(mole);
					moles.remove(mole);
				}
			});
			addObject(mole);
			moles.add(mole);
		}
	}

	/**
	 * this is a placeholder because early in the game design 
	 * process, the players aren't designed yet, so
	 * we use this method later, once we learn how 
	 * to create a Player
	 * @return
	 */

	public void updateAllMoles() {
		for (int i = 0; i < moles.size(); i++) {
			MoleInterface m = moles.get(i);
			int screenTime = m.getAppearanceTime() - 100;
			m.setAppearanceTime(screenTime);
			if (m.getAppearanceTime() <= 0) {
				remove(m); //remove from screen
				moles.remove(m);
				i--;
			}
		}
	}
	public MoleInterface getAMole() {
		return new Mole((int)(Math.random() * getWidth()), (int)(Math.random() * getHeight()));
	}
}
package simon;

import java.util.ArrayList;

import gui.ClickableScreen;
import gui.components.TextLabel;
import gui.components.Visible;

public class SimonScreenVicki extends ClickableScreen implements Runnable {
	
	private ProgressInterfaceVicki progress;
	private ArrayList<MoveInterfaceVicki> moves;
	private int roundNumber;
	private boolean acceptedInput;
	private TextLabel label;
	private int selectCount;
	
	public SimonScreenVicki(int width, int height) {
		super(width, height);
		Thread one = new Thread(this);
		one.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		addButtons();
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		moves = new ArrayList<MoveInterfaceVicki>();
		selectCount = -1;
		moves.add(randomMove());
		moves.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceVicki randomMove() {
		// TODO Auto-generated method stub
		return null;
	}

	private ProgressInterfaceVicki getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		// TODO Auto-generated method stub
		
	}

}
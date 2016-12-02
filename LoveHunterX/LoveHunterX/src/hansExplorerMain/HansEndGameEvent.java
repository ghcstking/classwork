package hansExplorerMain;

public class HansEndGameEvent implements Event {

	public void play() {
		System.out.println("You finally arrive to your gf to find her sleeping...\n"
				+ "You gently awaken her. The moment her eyes open, they interlock with yours.\n"
				+ "What took you so long? \n"
				+ "To be continued.......");
		HansCaveExplorer.setGameOver(true);
		System.out.close();

	}

}

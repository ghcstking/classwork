package hansExplorerMain;

public class GameStartEvent implements Event {

	public static final String[] SEQ_1={"A spiky-haired guy with orange pants flies up"
			+ "to you.","Have you arrived to save us from the treacherous Buu?",
			"We need your help."};
	public static final String[] SEQ_2 = {"Great, I will be busy meditating on my super"
			+ "yellow version while you figure out where Buu is.","Kaaa, maaaaay...","btw take this map"};
	
	public GameStartEvent() {
		// TODO Auto-generated constructor stub
	}

	public void play() {
		readSequence(SEQ_1);
		HansCaveExplorer.print("Will you help us?");
		while(HansCaveExplorer.in.nextLine().indexOf("yes") < 0){
			HansCaveExplorer.print("Pls say yes. I beg you!");
		}
		readSequence(SEQ_2);
		HansCaveExplorer.inventory.setMap(true);
	}

	public static void readSequence(String[] seq) {
		for(String s:seq){
			HansCaveExplorer.print(s);
			HansCaveExplorer.print(" - - - Press enter - - -");
			HansCaveExplorer.in.nextLine();
		}
		
	}

}

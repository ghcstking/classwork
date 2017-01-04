package twoDArraysDraft;

public class GameStartEvent implements Event {

	private final String[] sequence = {"<A little mushroom man runs up to you in a frenzied panic.>","It's horrible! Simply horrible!!!",
			"\"What?\" You ask? Haven't you heard?",
			"The anthropomorphic dragon, Wobser has kidnapped the princess Stoadtool. She has been "
					+ "hidden somewhere in this cattle, but Wobser's Goombas have locked the doors!",
					"\"How do you find the princess?\" you'll need to solve all the "
							+ "puzzles to unlock the doors. But no one in all of Twodim can solve "
							+ "them. The princess is lost forever!",
							"You aren't from around here? You must be the one the prophesy foretold. "
									+ "The one who will solve the puzzles and save the princess."};
	private final String[] sequence2= {"I'm so happy! That gives me so much hope! Here. Take this map to guide you.",
			"I need to go now. I'll spread the word that you have arrived to save the "
					+ "princess and to save us all. Good luck!",
	"<The little mushroom man runs off.>"};

	public void occur() {
		readSequence(sequence);
		CaveExplorer.print("Will you help us?\n\n---Type a response.---");
		while(CaveExplorer.waitForInput().toLowerCase().indexOf("yes") < 0){
			CaveExplorer.print("Oh, please say yes. I beg of you! Will you help us?");
		}
			readSequence(sequence2);
			CaveExplorer.inventory.setMap(true);

	}

	public static void readSequence(String[] sequence){
		for(int i = 0; i < sequence.length; i++){
			CaveExplorer.print(sequence[i]);
			CaveExplorer.print("---Press enter---");
			CaveExplorer.waitForInput();
		}

	}
}
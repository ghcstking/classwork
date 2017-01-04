package twoDArraysDraft;

public class DefconEvent implements Event {

	private final String[] dontPressTheButtonSequence = {"<You walk into a dark room. There is "
			+ "a spotlight shining down on what appears to be a podium in "
			+ "the middle of the room. Is it a podium, or something else? "
			+ "You approach for a closer look.>","It isn't a podium, it's "
					+ "a pillar. In the center of the pillar is a single "
					+ "button. The button says, \"launch nukes\". Because"
					+ " the button is literally the only thing in the room,"
					+ " to press the button, you only need to enter anything "
					+ "at all. Just type anything and press enter. "
					+ "If you type anything, then press enter. You will launch the nukes."
					+ "If this makes sense, type 'y'. If you need further "
					+ "instructions, type 'n.'","Congratulations! you have successfully"
							+ " not pressed the button and saved the world. "
							+ "Great job. Now that you are a hero, what are "
							+ "you going to do next?","I can see that you "
									+ "aren't going to press that button.  You are pretty smart. "
									+ "And you know what else?","...You can answer me, you know. "
											+ "I have something cool to tell you. Guess what?",
											"...(It is polite to type 'what')",
											"Enough is enough. The game is over. You won. All done. "
													+ "Now you can leave. Use the 'w','a','s','d' keys to control "
													+ "movement."};
	private final String[] sequence2 = {"<Trumpets sound. The pillar sinks into the ground. "
			+ "The face of Putin is projected on the wall as the button "
			+ "disappear below the ground. The film plays>",
			"PUTIN: Clever American. It looks like there will be no atomic "
					+ "warfare today, but we shall see... about tomorrow...",
					"<The ground begins to move. You never realized you were "
							+ "standing on a moving sidewalk. It carries you out of "
							+ "the room to the South. You are finally safe from the "
							+ "temptation of the button.>"};
	
	//automatically called when a player enters an EventRoom
	public void occur() {
		readSequence(dontPressTheButtonSequence, true);
		//if the player did not lose, the victory sequence is delivered
		if(!CaveExplorer.lose)readSequence(sequence2, false);
	}

	
	/**
	 * 
	 * @param sequence sequence to be read
	 * @param buttonEnabled 'true' if typing anything loses the game
	 */
	public static void readSequence(String[] sequence, boolean buttonEnabled){
		for(int i = 0; i < sequence.length; i++){
			CaveExplorer.print(sequence[i]);
			String entry =CaveExplorer.waitForInput();
			if(buttonEnabled && entry.length() > 0){
				CaveExplorer.lose = true;
				CaveExplorer.print("You typed \""+entry+"\". This activates the 'launch nukes' button."
						+ " You have brought the world to an end in a nuclear armageddon. You lose.");
				break;
			}
		}

	}

}

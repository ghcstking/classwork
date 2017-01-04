package magpieTeacher;

import chatbot6.NocklesMain;

public class Hello implements chatbot6.Topic {

	private String[] calmResponses = {"Yes. Hello indeed. Let's get past the introduction, shall we?",
			"We've already said our hellos, shall we move on from here?","I said HELLO already, didn't you catch that?"};
	private String[] upsetResponses = {"You are really making me angry now. If you want to talk, then TALK, don't just keep saying hello.",
	"This is getting ridiculous.", "I'm starting to think that you are a chatbot, and a BAD one at that.", "Do you have a problem with me?"};
	private String helloInput;
	private boolean inHelloLoop;
	
	
	private int helloCount;
	
	/**
	 * Since hello count is a variable field that is NOT initialized in the talk method,
	 * (like helloInput and inHelloLoop are) we must initialize it in the constructor
	 */
	public Hello(){
		helloCount = 0;
	}
	
	/**
	 * This method gets called if a greeting is used.
	 * 
	 */
	public void talk() {
		inHelloLoop = true;
		while(inHelloLoop){	
			helloCount++;
			printAResponse();
			helloInput = NocklesMain.getInput();
			//check if the next line of text is 
			if(!isGreeting(helloInput)){
				inHelloLoop = false;
				NocklesMain.talkForever();
			}
		}

	}

	/**
	 * Helper method
	 */
	private void printAResponse() {
		int responseChoice = 0;
		if(helloCount >4){
			responseChoice = (int) (Math.random()*upsetResponses.length);
			NocklesMain.print(upsetResponses[responseChoice]);
		}else{
			responseChoice = (int) (Math.random()*calmResponses.length);
			NocklesMain.print(calmResponses[responseChoice]);
		}
	}

	/**
	 * 
	 * @param userInput
	 * @return true if userInput contains "Greeting" words, 'false' otherwise
	 */
	public static boolean isGreeting(String userInput){
		if(NocklesMain.findKeyword(userInput, "hi", 0) >= 0) return true;
		if(NocklesMain.findKeyword(userInput, "hello", 0) >= 0) return true;
		if(NocklesMain.findKeyword(userInput, "hey", 0) >= 0) return true;
		return false;
		
	}
	
}

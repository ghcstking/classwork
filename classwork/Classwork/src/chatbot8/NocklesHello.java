package chatbot8;

public class NocklesHello implements Chatbot{

	private String helloResponse;
	private boolean inHelloLoop;
	
	private String[] calmResponses = 
		{"We already said hello. "
				+ "Let's move the conversation along.",
				"You said hello already. Did you forget?"};
	private String[] angryResponses =
		{"Okay seriously. Stop saying hi.",
				"What is wrong with you and saying hello?"};
	
	private int helloCount;
	
	public NocklesHello(){
		helloCount = 0;
	}
	
	
	public void talk() {
		inHelloLoop = true;
		while(inHelloLoop){
			helloCount++;
			printResponse();//helper method
			helloResponse = NocklesMain.promptInput();
			//negate use !
			if(!isTriggered(helloResponse)){
				inHelloLoop = false;
				NocklesMain.promptForever();
			}
		}
	}

	private void printResponse() {
		if(helloCount > 4){
			int responseSelection = 
					(int)(Math.random()*
							angryResponses.length);
			NocklesMain.print(
					angryResponses[responseSelection]);
		}else{
			int responseSelection = 
					(int)(Math.random()*
							calmResponses.length);
			NocklesMain.print(
					calmResponses[responseSelection]);
		}
	}


	public boolean isTriggered(String userInput) {
		if(NocklesMain.findKeyword(userInput, "hello", 0)
				>= 0){
			return true;
		}
		if(NocklesMain.findKeyword(userInput, "hi", 0)
				>= 0){
			return true;
		}
		if(NocklesMain.findKeyword(userInput, "hey", 0)
				>= 0){
			return true;
		}
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

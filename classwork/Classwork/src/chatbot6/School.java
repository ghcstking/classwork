package chatbot6;

public class School implements Topic {

	private boolean inSchoolLoop;
	private String schoolResponse;
	
	public School(){
		
	}
	
	public void talk() {
		inSchoolLoop = true;
		while(inSchoolLoop){
			NocklesMain.print("Tell me about school.");
			schoolResponse = NocklesMain.getInput();
			if(schoolResponse.indexOf("stop")>= 0){
				inSchoolLoop =false;
				NocklesMain.talkForever();
			}else{
				NocklesMain.print("That's my favorite "
						+ "part about school too.");
			}
			
		}
	}

	public boolean isTriggered(String userInput) {
//		String[] triggers = {"schhol","class","teacher"};
		//you could use a for loop
		//to iterate through an array
		if(NocklesMain.findKeyword(userInput, "school", 0) 
				>= 0 ){
			return true;
		}
		if(NocklesMain.findKeyword(userInput, "class", 0) 
				>= 0 ){
			return true;
		}
		return false;
	}
}
























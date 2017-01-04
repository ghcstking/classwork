package magpieTeacher;

import java.util.Scanner;

public class Food implements Topic {

	
private String response;
private boolean inFoodLoop; 

	public void talk() {
		inFoodLoop = true;
		while(inFoodLoop){
			TeacherPrep.print("What would you like to say about food? (Type stop to talk about something else.)");
			response = TeacherPrep.getInput();
			if(response.indexOf("taste") >= 0){
				TeacherPrep.print("TASTE IS THE BEST!");
			}else if(response.indexOf("stop") >= 0){
				inFoodLoop = false;
				TeacherPrep.resume(this);
			}
		}
	}

}

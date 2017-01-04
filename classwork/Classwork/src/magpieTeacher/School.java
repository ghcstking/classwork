package magpieTeacher;

import java.util.Scanner;

public class School implements Topic{

	private boolean inSchoolLoop;
	private String response;

	public void talk(){
		inSchoolLoop = true;
		while(inSchoolLoop){
			TeacherPrep.print("Isn't school fantastic? What do you like about school?(If you want to stop talking about school, type stop)");
			response = TeacherPrep.getInput();
			if(response.indexOf("stop") >= 0){
				inSchoolLoop = false;
				TeacherPrep.resume(this);
			}else if(response.indexOf("food")>= 0){
				inSchoolLoop = false;
				TeacherPrep.food.talk();
			}
			else{
				TeacherPrep.print("Yes! That is cool!");
			}
		}
	}
	
}

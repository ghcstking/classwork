package introduction8;

public class Junior extends Student {

	private String examScore;
	
	public Junior(String name, String score) {
		super(name);
		examScore = score;
	}
	
	public void boastScore(){
		System.out.println("My score is "+examScore);
	}

}

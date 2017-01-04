package introduction8;

public class OOPExample {

	public static void main(String[] args) {
		Student jillian = new Senior("Jillian", "Red");
		Student jordan = new Junior("Jordan","98");
		Student josh = new Student("Josh");

		
		jillian.talk();
		
		
		josh.talk();
		jordan.talk();
		//casting a Student into a Junior
		((Junior)jordan).boastScore();
	}

	
	
}












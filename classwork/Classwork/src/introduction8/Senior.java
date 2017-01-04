package introduction8;

public class Senior extends Student {

	String favoriteColor;
	
	public Senior(String name, String color) {
		super(name);//constructs a Student first
		this.favoriteColor = color;
	}
	

	public void talk(){
		super.talk();
		System.out.println("...and I am a senior!");
	}

}









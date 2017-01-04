package introduction6;

public class Student {

	//fields
	private String name;
	
	//constructor (no return type. It creates students)
	public Student(String name){
		//initialize fields
		this.name = name;
	}
	
	public void talk(){
		System.out.println("Hi, my names is "+this.name);
	}
	
}











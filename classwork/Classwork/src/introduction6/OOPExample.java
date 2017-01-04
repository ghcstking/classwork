/**
 * 
 */
package introduction6;

/**
 * @author Teacher Station
 * This class is designed to contrast with the 
 * ProceduralExample. It embodies an Object-Oriented 
 * approach
 */
public class OOPExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//construct a student
		Student jillian = new Senior("Jillian","programmer");	
		Student jordan = new Student("Jordan");
		Student jason = new Student("Jason");
		
		
		
		

		Student[] students = {jordan, jillian};
		
		jordan.talk();
		jason.talk();

	}

}
















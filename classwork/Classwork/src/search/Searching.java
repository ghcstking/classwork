package search;
import java.util.Scanner;
import java.util.Timer;

<<<<<<< HEAD

=======
>>>>>>> branch 'search-practice' of https://github.com/bnockles/classwork.git
public class Searching {

	Scanner in;
	int[] numbers;
	public static final int HANDICAP= 10;
	
	public static void main(String[] args){
		System.out.println("Loading text ints...");
		Searching s = new Searching(); 
		
	}
	
	public Searching() {
		in = new Scanner(System.in);
		String s= new StringFromFileLoader("Data/ints.txt").getFileContent();
		String[] text =s.split(", "); 
		numbers = new int[text.length];
		for(int i=0; i<numbers.length; i++){
			numbers[i]=Integer.parseInt(text[i]);
		}
		proceedWithSearch();
	}

	private void proceedWithSearch() {
		System.out.println("Loaded " + numbers.length+" ints. Enter a value between 0 and "+numbers[numbers.length-1]);
		int target = -1;
		while(target==-1){
			try{
				target = Integer.parseInt(in.nextLine());
				if(target <=0 || target >= numbers[numbers.length-1])System.out.println("Follow instructions, please. Enter a value between 0 and "+numbers[numbers.length-1]);
			}catch(NumberFormatException e){
				System.out.println("Follow instructions, please. Enter a value between 0 and "+numbers[numbers.length-1]);
			}		
		}
		System.out.println("Get ready to race the computer. \n"
				+ "It's okay, the computer has been set to take "+HANDICAP+" ms for every iteration in its search algorithm.\n"
						+ "Try to find the number "+target+"."
				+ "\n    Press 'enter' to begin.");
		in.nextLine();

		int index = search(numbers, 0, numbers.length-1, target);

		if(index!=-1){
			System.out.println("The number "+target+" was found at index "+index+". Did the computer win?");
		}else{
			System.out.println("The number "+target+" was not found in the file.");
		}
		
	}

//TODO fill in the method body:
	private int search(int[] searchThis, int target) {

			delay(HANDICAP);
			
	
		return -1;
	}
	


		delay(HANDICAP);
		
		if(start > finish) return -1;
		else{
			int mid = (start+finish)/2;
			if (searchThis[mid]==target) return mid;
			else if (searchThis[mid] > target) return search(searchThis, start, mid-1, target);
			else return search(searchThis, mid+1,finish, target);
		
		}
	}

	private void delay(int handicap2) {
		try {
			Thread.sleep(HANDICAP);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	
	
}

package arrays8;

public class ArraysPractice8 {

	static boolean[] boos3;

	public static void main(String[] args) {
		
		listPrimes(200000);
		
//		long currentTime = System.currentTimeMillis();
//		
//		//int totalNumbers = 50;
//		int[] fiftyNumbers = new int[50000];
//		//populate(fiftyNumbers);
//		//print(fiftyNumbers);
//		//randomize(fiftyNumbers);
//		//print(fiftyNumbers);
//		rollDice(fiftyNumbers, 4);
////		print(fiftyNumbers);
//		//count each die roll and provide a percentage
//		countResult(fiftyNumbers, 4);
//		
//		
//		
//		
//		long endTime = System.currentTimeMillis();
//		System.out.println("The process took "+(endTime-currentTime) + " ms.");
		
	}
	
	
	
	private static void listPrimes(int limit) {
		int lastToCheck = (int)(Math.sqrt(limit));
		boolean[] numbers = new boolean[limit+1];
		for(int i=0; i < limit+1; i++){
			numbers[i] = false;
		}
		//0 and 1 are, by definition, not prime
		numbers[0]=false;
		numbers[1]=false;
		//check all non-"crossed of" numbers (start with 2)
		for(int prime = 2; prime <= lastToCheck; prime++){
			if(numbers[prime]){
				System.out.println("\n"+prime+" is prime."
						+ " Crossing off:");
				for(int i = (int)(Math.pow(prime, 2));
						i < limit+1; i += prime){
					System.out.print(i+", ");
					numbers[i] = false;
				}
			}
		}
		//print the primes
		System.out.println("The primes are:");
		for(int index = 0; index < numbers.length; index++){
			if(numbers[index])System.out.print(index+", ");
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void countResult(int[] m, int numberOfDice) {
		System.out.println("CountResultMethod");
		int[] counter = new int[numberOfDice*6];
		for(int n: m){
			counter[n-1] = counter[n-1] +1;
		}
		for(int i = numberOfDice - 1; i < counter.length; i ++){
			System.out.println((i+1)+" appeared " + 100*counter[i]/m.length +" %.");
		}
		
	}

	private static void rollDice(int[] n, int numberOfDice) {
		System.out.println("RollDiceMethod");
		
		for(int i = 0; i < n.length; i++){
			int dice = 0;
			for(int j = 0; j < numberOfDice; j++){
				dice = dice + (int) (1 + (Math.random()*6));
			}
			n[i] = dice;
		}	
		
	}

	private static void randomize(int[] n) {
		for(int i = 0; i < n.length; i++){
			int rand =(int) (1 + (Math.random()*6));
			n[i] = rand;
		}
		
	}
	
	private static void print(int[] n) {
		for(int i = 0; i < n.length; i++){
			System.out.println(n[i]);
		}
		
	}

	private static void populate(int[] n) {
		for(int i = 0; i < n.length; i++){
			n[i] = i + 1;
		}
		
	}
	
	

	

	private void demonstratePassByValue(){
		String[] someStrings = new String[1000];
		standardPopulate(someStrings);
		String s = someStrings[999];
		makeSpecial(s);
		someStrings[999] = getASpecialString();
		print(someStrings);
		
		
		
	}
	
	private static String getASpecialString() {
		String s = "SPECIAL STRING";
		return s;
	}

	private static void makeSpecial(String s) {
		s = "ThIS STRING IS SPECIAL"; 
		
	}

	private static void print(String[] s) {
		for(int i = 0; i < s.length; i++){
			System.out.println(s[i]);
		}
		
	}

	private static void standardPopulate(String[] s) {
		for(int i = 0; i < s.length; i++){
			s[i] = "String #"+(i+1);
		}
		
	}
	
	public static void initializeArraysExample(){
		boolean[] boos1 = new boolean[3];
		//this can ONLY be done at the declaration
		//because it sets size and content
		boolean[] boos2 = {false, false, false};
		//boos3 = {false, true, true};
		// this is all that will work
		boos3 = new boolean[3];
		
		
		/**2 ways of iterating through an array
		STANDARD FOR LOOP
				-the index is important to keep track of
				-you need to customize the order
		*/
		for(int i = 0; i < boos1.length; i++){
			System.out.println(boos1[i]);
		}
		/**
		"FOR - EACH" LOOP
				-the index is not important
				-you do not need to customize
				-automatically assigns a "handle"
				-faster to write
		*/
		for(boolean b: boos1){
			System.out.println(b);
		}
		
		
		
		// OBJECT ARRAYS
		String[] someStrings1 = new String[3];
//		someStrings1[0] = "a";
//		someStrings1[1] = "b";
//		someStrings1[2] = "c";
		
		for(int i = 0; i < someStrings1.length; i++){
			someStrings1[i] = "a new String"; 
		}
		
		for(String s: someStrings1){
			System.out.println(s);
		}
		
	}

}















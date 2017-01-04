package arrays6;

import java.util.Random;

/**
Use Afsana for populate with random numbers, point out that the method takes an array as a parameter
have her ammend the method to do numbers 1-50
https://github.com/afsanac/class-projects.git


Use Matthew Chu for populate dice method
https://github.com/Mothballs017/classwork.git

Use Daniel Goon for listing cards
https://github.com/koolkid311/classwork.git

*/
public class ArraysMain {

	static int[] numArray = new int[50];
	static int[] randomArray = new int[10];
	static int[] dieArray = new int[10000];
	static int[] results = new int[11];
	static String[] cardArray = new String[52];
	
	public static void main(String[] args) {
		//This is how you time how 
		//quickly a computer processes
		long startTime = System.currentTimeMillis();
		
		SampleElement sample = new SampleElement(10);
		sample.increase();
		System.out.println("The sample element has"
				+ " a number equal to "+sample.getNumber());
		
		long endTime = System.currentTimeMillis();
		System.out.println("Completed method in "
				+ (endTime-startTime)+ " milliseconds");
		testPrimes(50);
		
	}

	private static void testPrimes(int numberToTest) {
		int lastToCheck = (int)(Math.sqrt(numberToTest));
		boolean[] theNumbers = new boolean[numberToTest];
		for(int i=0; i < numberToTest; i++){
			theNumbers[i] = true;
		}
		theNumbers[0] = false;
		theNumbers[1] = false;
		
		for(int prime = 2; prime <= lastToCheck; prime++){
			//when checking 50 numbers,
			//tests 2,3,4,5,6,7 as if prime
			if(theNumbers[prime]){
				//only checks numbers that are prime
				//(numbers that haven't been "crossed off")
				//won't check 4 and 6 (crossed off by 2)
				System.out.println("\n"+prime+ " is prime. "
						+ "Crossing off:");

				for(int test = prime + prime; test < numberToTest; 
						test = test + prime){
					System.out.print(test+", ");
					theNumbers[test] = false;
				}
			}
		}
		System.out.println();
		for(int i = 0; i < theNumbers.length; i++){
			if(theNumbers[i]){
				System.out.println(i + " is prime.");
			}
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void passByValueDemonstration(){
		String[] someStrings = new String[100];
		populateArray(someStrings);

		int ten = 10;
		increase(ten);
		System.out.println("Ten, increased is "+ten);

		//in this method, we pass the ELEMENT
		//(a variable) not the array, so
		//no change will be made
		System.out.println("Before "+someStrings[99]);
		changeString(someStrings[99]);
		System.out.println("After \"changeString\" method "+
				someStrings[99]);
		changeArray(someStrings);
		System.out.println("After \"changeArray\" method "+
				someStrings[99]);
		changeArrayElement(someStrings,99);
		System.out.println("After \"changeArrayElement\" method "+
				someStrings[99]);
	}
	
	private static void populateRandomArray(int[] randomArray2) {
		for(int i = 0; i < randomArray2.length; i++){
			randomArray2[i] = randInt(0,100);
			System.out.println(randomArray2[i]);
		}
	}

	public static int randInt(int min, int max) {
		Random gen = new Random();
		int randomNum = gen.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	
	private static void populateArray(int[] someArray) {
		for(int i = 0; i < someArray.length; i++){
			someArray[i] = i + 1;
			System.out.println(someArray[i]);
		}
	}
	
	private static void populateDieArray(int[] array){
		
		for(int i = 0; i < array.length; i++){
			int firstRoll = randInt(1,6);
			int secondRoll = randInt(1,6);
			array[i] = firstRoll + secondRoll;
			System.out.println(array[i]);
		}
		
	}
	
	private static void populateResultsArray(int[] numsRolled){
		for(int d = 0; d<numsRolled.length;d++){
			results[numsRolled[d]-2]++;
		}
	}
	private static void printResults(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.println((i+2)+"is rolled "+
			((double)arr[i]/dieArray.length*100)+
			"% of the time.");
		}
	}

	private static void changeArrayElement
	(String[] someStrings, int i) {
		someStrings[i] = "new item "+(i+1);
	}


	private static void changeArray(String[] someStrings) {
		someStrings = new String[100];
		for(int i= 0; i < someStrings.length; i++){
			someStrings[i] = "new item "+(i+1);
		}
	}

	//this method does nothing, since local variables 
	//are destroyed after the method is complete
	private static void increase(int x) {
		x = x +1;
	}


	private static void changeString(String s){
		s = "This string has been changed!";
	}

	private static void printArray(String[] a) {
		//this loop prints the strings
		for(String s: a){
			System.out.println(s);
		}
	}


	private static void populateArray(String[] a) {
		//this loop instantiating the strings
		for(int index =0; index < a.length; 
				index ++){
			a[index] = "value "+(index+1);
		}
	}


	public static void arrayIntroMethod(){
		//construct 2 integer arrays
		//these two metods do the same thing
		//primitive type arrays fill with ZEROES 0, 0.0, false
		int[] zeros1 = {0,0,0};
		int[] zeros2 = new int[3];
		//example
		boolean[] booleans = new boolean[3];
		//iterate (2 ways)
		//FIRST METHOD: "FOR LOOP"
		//   - the index of the data is important to reference
		//   - you need to customize how you iterate 
		//(increase by 2, backwards, etc...)
		for(int index = 0; index< booleans.length; index ++){
			System.out.println(index+") "+booleans[index]); 
		}
		//SECOND METHOD: "FOR-EACH"
		//always goes in order, does nto keep track of index
		//easier to type
		for(boolean b: booleans){
			System.out.println(b+"");
		}


		//these two constructors are different
		String[] strings1 = {"","",""};
		String[] strings2 = new String[33];

		//this loop instantiating the strings
		for(int index =0; index < strings2.length; 
				index ++){
			strings2[index] = "value "+(index+1);
		}

		//this loop prints the strings
		for(String s: strings2){
			System.out.println(s);
		}
	}














}

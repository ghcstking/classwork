package arrays;

public class ArrayMethods {
	public static void main(String[] args) {
		int[] arr = {2,3,4,9,11,12,15};
		// swap(arr, 0, arr.length-1);
		//shuffle(arr);
		//checkHalfway(arr, 12, 0, arr.length-1);
//		if (checkHalfway(arr, 12, 0, arr.length-1)) {
//			System.out.println("The number you are searching for is less than the value in the middle of the array");
//		}
//		else {
//			System.out.println("The number you are searching for is greater than or equal to the value in the middle "
//					+ "of the array");
//		}
		reverseOrder(arr);
	}
	public static void reverseOrder(int[] array){
		int[] reversed = new int[array.length];
		int place = 0;
	    for(int i = array.length; i > 0; i--) {
	    	int number = array[i-1];
	    	reversed[place] = number;
	    	place++;
	    }
	    for (int i = 0; i < reversed.length; i++) {
	    	System.out.println(reversed[i]);
	    }
	}
	        
	public static void swap(int[] array, int first, int last) {
		int placeholder = array[last];
		array[last] = array[first];
		array[first] = placeholder;
	}

	public static boolean checkHalfway(int[] array, int searchValue, int begin, int end) {
		return searchValue < array[(begin+end+1)/2];
	}
	public static void shuffle (int[] array) {
		for (int i = 0; i < array.length; i++) {
			int random = (int)(Math.random()*array.length);
			swap(array, i, random);
		}
	}
}

package arrays6;
import java.util.Arrays;

public class ArrayMethods {

	public static void main(String[] args) {
		//		int[] arr = {2,3,4,6,9, 11, 12, 15};
		////		swap(arr, 0, arr.length-1);
		//		shuffle(arr);
		//		print(arr);
		//		if(checkHalfway(arr,12,0, arr.length-1)){
		//			System.out.println("The number you are "
		//					+ "searching for is "
		//					+ "less than the value in the "
		//					+ "middle of the array");	
		//		}else{
		//			System.out.println("The number you "
		//					+ "are searching for is "
		//					+ "greater than or equal to "
		//					+ "the value in the middle "
		//					+ "of the array");	
		//		}

		int[] arr = {3,9,6,11,3,9,6,13,14,16,11,3,11,3,9,6,11};
		int[] subArr = getSubArray(arr, 12, 16);
		System.out.println(Arrays.toString(subArr));
		contains(arr, subArr);
		

	}

	///**
	// * returns number of elements in arr less than d
	// * @param arr
	// * @param d
	// */
	//	public static int countUnderBound(double[] arr, 
	//			double d){
	//		
	//	}


	/**
	 * return an array containing elements from
	 * startIndex to endIndex (inclusive)
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public static int[] getSubArray(int[] arr, 
			int startIndex,
			int endIndex){
		int[] subArray = new int[endIndex - startIndex +1];
		for(int i = 0; i < subArray.length; i++){
			subArray[i] = arr[startIndex+ i];
		}
		return subArray;
	}


	/**
	 * returns true if arr contains subArray sequence
	 * @param arr
	 * @param subArray
	 * @return
	 */
	public static boolean contains(int[] arr, 
			int[] subArray){
		for(int i = 0; i < arr.length; i++){
			int j =0;
			while(j < subArray.length){
				if(subArray[j] == arr[i + j] && 
						j == subArray.length-1){
					System.out.println
					("Found a match at index "+i);
					return true;
				}else if(subArray[j] != arr[i + j]){
					System.out.println("No match at "+i);
					break;
				}
				j++;
			}

		}
		return false;
	}


	//	public static void cycleThrough(int[] arr, int n)



	private static void shuffle(int[] arr) {
		for(int i = 0 ; i < arr.length; i++){
			int random = (int)(Math.random()*arr.length);
			swap(arr,i,random);
		}
	}

	private static void print(int[] arr) {
		for(int i = 0 ; i < arr.length-1; i++){
			System.out.print(arr[i]+", ");
		}
		System.out.println(arr[arr.length-1]);
	}



	private static void swap(int[] arr, int i, int j) {
		int placeholder = arr[j];
		arr[j] = arr[i];
		arr[i] = placeholder;
	}





	/**
	 * returns true if searchValue is less than the element 
	 * halfway between beginning and end
	 * @param arr the int[] to be searched
	 * @param i
	 * @param j
	 * @param length
	 */
	private static boolean checkHalfway(int[] arr, 
			int searchValue,
			int begin, int end) {
		return searchValue < arr[(begin+end)/2];

	}
















}

package search;

import java.util.Arrays;

public class Sorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayToSort={133,0,-5,31,12,91,2};
		arrayToSort = mergeSort(arrayToSort);
		System.out.println("Sorted Array: "+Arrays.toString(arrayToSort));
	}
	public static void selectionSort(int[] arrayToSort){
		int minIndex=0;
		int minimum=arrayToSort[0];
		for(int i=0;i<arrayToSort.length;i++){
			minIndex=i;
			minimum=arrayToSort[i];
			for(int j=i;j<arrayToSort.length;j++){
				if(arrayToSort[j]<minimum){
					minimum=arrayToSort[j];
					minIndex=j;
				}
			}
			int placeHolder=arrayToSort[i];
			arrayToSort[i]=minimum;
			arrayToSort[minIndex]=placeHolder;
		}
	}
	public static int[] mergeSort(int[] toSort){
		if(toSort.length==1) return toSort ;
		int[] firstHalf = Arrays.copyOf(toSort, toSort.length/2);
		int[] secondHalf = new int[toSort.length-firstHalf.length];
		for(int i = 0;i<secondHalf.length;i++){
			secondHalf[i] = toSort[firstHalf.length+i];
		}

		firstHalf =  mergeSort(firstHalf);
		secondHalf =  mergeSort(secondHalf);
		 System.out.println("Sorting the array gave us first Half: " + Arrays.toString(firstHalf));
		 System.out.println("Sorting the array gave us Second Half: " + Arrays.toString(secondHalf));
		 System.out.println("Sorting the array gave us Result: " + Arrays.toString(merge(firstHalf,secondHalf)));
		 return merge(firstHalf,secondHalf);
    }

    //helper method for mergeSort
    public static int[] merge(int[] arrA, int[] arrB){
    	int[] result = new int[arrA.length+arrB.length];
    	int aIndex = 0;
    	int bIndex = 0;
    	int resultIndex = 0;
    	while(resultIndex<result.length){
    		if(arrA[aIndex]>arrB[bIndex]){
    			result[resultIndex] = arrB[bIndex];
    			resultIndex++;
    			bIndex++;
    		}else if(arrA[aIndex]<arrB[bIndex]){
    			result[resultIndex] = arrA[aIndex];
    			resultIndex++;
    			aIndex++;
    		}else{
    			result[resultIndex] = arrA[aIndex];
    			result[resultIndex+1] = arrA[aIndex];
    			resultIndex+=2;
    			aIndex++;
    			bIndex++;
    		}
    		while(aIndex<arrA.length&&!(bIndex<arrB.length)){
    			result[resultIndex] = arrA[aIndex];
    			aIndex++;
    			resultIndex++;
    		}
    		while(!(aIndex<arrA.length)&&(bIndex<arrB.length)){
    			result[resultIndex] = arrB[bIndex];
    			bIndex++;
    			resultIndex++;
    		}
    	}
//    	 System.out.println("Sorting the array gave us: " + Arrays.toString(arrA));
//		 System.out.println("Sorting the array gave us: " + Arrays.toString(arrB));
//		 System.out.println("Sorting the array gave us: " + Arrays.toString(result));
    	return result;
    }

}

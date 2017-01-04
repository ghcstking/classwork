package sortTeacher;

import java.util.Arrays;

public class SortingAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayToSort={2,1,0,16,8,15};
		System.out.println("- - - SELECTION SORT - - -");
		System.out.println(Arrays.toString(arrayToSort));
		mysterySort1(copy(arrayToSort));
		System.out.println("- - - BUBBLE SORT - - -");
		mysterySort2(copy(arrayToSort));
	}
	
	public static int[] copy(int[] arr){
		int[] copy = new int[arr.length];
		for(int i = 0; i < copy.length; i++){
			copy[i]=arr[i];
		}
		return copy;
	}
	
	public static void swap(int[] arr, int i, int j){
		System.out.println("Swapping "+arr[i]+" and "+arr[j]);
		int placeHolder=arr[j];
		arr[j]=arr[i];
		arr[i]=placeHolder;
		System.out.println(Arrays.toString(arr));
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
			swap(arrayToSort, i, minIndex);
		}
	}
	
	public static void mysterySort1(int[] arrayToSort){
		int j=0;
		int jValue=arrayToSort[0];
		for(int i=0;i<arrayToSort.length;i++){
			j=i;
			jValue=arrayToSort[i];
			for(int h=i;h<arrayToSort.length;h++){
				if(arrayToSort[h]<jValue){
					jValue=arrayToSort[h];
					j=h;
				}
			}
			int placeHolder=arrayToSort[j];
			arrayToSort[j]=arrayToSort[i];
			arrayToSort[i]=placeHolder;
			System.out.println(Arrays.toString(arrayToSort));
		}
	}
	
	//bubble sort
	public static void mysterySort2(int[] array){
	    for(int i=0; i < array.length-1; i++){
	        for(int j=1; j < array.length-i; j++){
	            if(array[j-1] > array[j]){
	            	int placeHolder=array[j-1];
	    			array[j-1]=array[j];
	    			array[j]=placeHolder;
	    			System.out.println(Arrays.toString(array));
	            }
	        }
	    }
	}

}

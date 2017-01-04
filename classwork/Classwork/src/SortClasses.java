import java.util.Arrays;

public class SortClasses {

	/**
	 * @param args
	 */
	
	public static final int[] originalToSort = {4,16,-9,12,8,6,3,2,22, 14,7,3};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] toSort = originalToSort;
		System.out.println(Arrays.toString(toSort)+"\n");
        System.out.println("Sorting the array with mergeSort gave us: " + Arrays.toString(mergeSort(toSort))+"\n");
        
        
        toSort = originalToSort;
        System.out.println(Arrays.toString(toSort)+"\n");
        selectionSort(toSort);
        System.out.println("Sorting the array with selectionSort gave us: "+ Arrays.toString(toSort) +"\n");
        
        toSort = originalToSort;
        System.out.println(Arrays.toString(toSort)+"\n");
        insertionSort(toSort);
        System.out.println("Sorting the array with insertionSort gave us: "+ Arrays.toString(toSort)+"\n");
        
        
	}
	
	public static void selectionSort(int[] arr){
		
		
		for(int i=0; i<arr.length-1; i++){
			int index=i;
			for(int j=i+1; j<arr.length; j++){
				if(arr[j]<arr[index])
					index=j;
			}
			if(index!=i){
				int tmp=arr[i];
				arr[i]=arr[index];
				arr[index]=tmp;
			}
		}
	}
	
	public static void insertionSort(int[] arr){
		for(int i=1; i<arr.length; i++){
			int tmp=arr[i];
			int j=i-1;
				while(j>=0 && tmp<arr[j]){	
					arr[j+1]=arr[j];
					j--;
				}	
			arr[j+1]=tmp;	
		}
		
	}
	
	public static int[] mergeSort(int[] arr){
		if(arr.length==1){
			return arr;
		}
		int[] fHalf = new int[arr.length/2];
		int[] sHalf = new int[arr.length-fHalf.length];
		for(int i=0; i<fHalf.length;i++)fHalf[i]=arr[i];
		for(int j=0; j<sHalf.length;j++)sHalf[j]=arr[fHalf.length+j];
		
		return merge(mergeSort(fHalf), mergeSort(sHalf));
	}
	
	public static int[] merge(int[] a, int[] b){
		int[] result = new int[a.length+b.length];
		int resultIndex = 0;
		int aIndex=0;
		int bIndex=0;
		
		while(aIndex<a.length && bIndex<b.length){
			if(a[aIndex]> b[bIndex]){
				result[resultIndex]=b[bIndex];
				bIndex++;
			
			}else{ 
				result[resultIndex]=a[aIndex];
				aIndex++;
			}
			resultIndex++;	
		}
		while(aIndex<a.length){
			result[resultIndex]=a[aIndex];
			aIndex++;
			resultIndex++;	
		}
		while(bIndex<b.length){
			result[resultIndex]=b[bIndex];
			bIndex++;
			resultIndex++;	
		}
		
		return result;
	}

}

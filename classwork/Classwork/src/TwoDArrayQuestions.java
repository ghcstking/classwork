import java.util.Arrays;
import java.util.Scanner;

public class TwoDArrayQuestions {

	static boolean[][] booray;

	public static void main(String[] args){
	    booray = new boolean[3][3];
	    booray[2][1] = true;
	    booray[1][1] = true;
	    methodA(1,1);
	}

	private static void methodA(int r, int c){
		Scanner in = new Scanner(System.in);
		for(int rIndex=0; rIndex<booray.length; rIndex++){
			System.out.println("Row Contents before execution = \n"+Arrays.toString(booray[rIndex]));
			for(int cIndex=0; cIndex<booray[r].length; cIndex++){
	            if(rIndex==r && Math.abs(cIndex-c)<=1){
	                switchValue(rIndex, cIndex);
	            }
	            if(cIndex==c && Math.abs(rIndex-r)<=1){
	                switchValue(rIndex, cIndex);
	            }
	        }
	        System.out.println("Finished iterating row "+rIndex);
	        System.out.println("Row Contents after execution = \n"+Arrays.toString(booray[rIndex]));
	        in.nextLine();
	    }
	} 

	private static void switchValue(int r, int c){
	    System.out.println("Switching element at "+r+","+c+" from "+booray[r][c]+ " to " +!booray[r][c]+".");
		booray[r][c]=!booray[r][c];
	}

}

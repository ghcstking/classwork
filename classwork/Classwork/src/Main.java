import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	//	public static void main(String[] args){
	//		//		System.out.println("Hello git!");
	//		//		//added a comment
	//		//		
	//		//
	//		//		 //Here's a comment that was added online, via the browser
	//		//		if(isSquare(-16))System.out.println("Square!");
	//		//		else System.out.println(Math.sqrt(-16)+" not square");
	//
	//		System.out.println(recur("eyebrows"));
	//	}


	//	public static void main(String[] args) {
	//		ArrayList<String> phrases = new ArrayList<String>();
	//		phrases.add("Hello");
	//		phrases.add("From");
	//		phrases.add("The");
	//		phrases.add("Other");
	//		phrases.add("Side");
	//		int x = 1;
	//		System.out.println(reverse(phrases, x));
	//		
	//	}

	//	public static void main(String[] args) {
	//		System.out.println(mystery(1));
	//	}

	static int sum =0, count = 0;
	
	public static void main(String[] args)
	{

		       System.out.println(mystery(20));

	}

	public static int mystery(int x){

		if (x % 5 == 0){
             sum = sum + x/5;
             count++;
             x = x + 2;
        }
        else if (x % 3 == 0){
             sum = sum + x/3;
             count++;
                 x = x - 5;
        }
        else if (x % 2 == 0){
             sum = sum + x/2;
             count++;
             x = x - 4;
        }
        else{
             sum = sum + x;
             count++;
             x--;
        }
        if (x <= 0) return sum/count;
        else return mystery(x);
}

	
	public static int dob(int i) {
		System.out.println("called" + i);
		if(i == 1){
			return i;
		}
		if(i%3 == 0){
			return  dob(i/3) + 3;        
		}
		else{
			return  dob(i-1) + 1;
		}

	}

	public static int findx(){
		int y=5;
		int x=2;
		while(x>=0 || y<10){
			int h=y;
			y=x;
			x=h;
			System.out.println("h = "+h+" x = "+x+" y = "+y);
			x--;
			y++;
		}
		return y;
	}


	public static int search(int[] nums, int start, int finish, int target) {


		if(start > finish) return -1;

		else{

			int mid = (start+finish)/2;

			if (nums[mid]==target) return mid;

			else if (nums[mid] > target)
			{
				return search(nums, start, mid-1, target);
			}

			else return search(nums, mid+1,finish, target);

		}


	}

	public static int search(int[] nums, int searchValue) {
		int low =0;
		int high = nums.length -1;
		int mid = (low + high)/2;
		while (low <= high && nums[mid] != searchValue){
			if(nums[mid] < searchValue){
				low = mid + 1;
			}else{
				high = mid - 1;
			}
			mid = (low + high)/2;
		}
		if(low > high) return -1;
		return mid;
	}








	public static boolean isSquare(double d){
		if(Math.sqrt(d)-(int)Math.sqrt(d)==0)return true;
		else return false;
		/**
		 * * I am trying to see if I can push this to my designated branch
		 * wrote
		 */
		//Here's a comment that was added online, via the browser\
		//I need to make "Pull" work
	}
}


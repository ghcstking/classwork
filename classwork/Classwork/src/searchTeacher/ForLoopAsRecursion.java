package searchTeacher;

import java.util.Arrays;

public class ForLoopAsRecursion {

	public static void main(String[] args) {
		forLoop(5, new Action() {
			
			private int value = 5;
			
			public void act() {
				System.out.println("Printing "+value);
				value --;
			}
		});
		final int[] array = new int[10];
		forLoop(10, new Action(){
			
			int index = 0;
			
			public void act() {
				array[index]= 2*(index+1);
				index++;
			}
			
		});
		System.out.println(Arrays.toString(array));
	}

	public static void forLoop(int iterationCount, Action action){
		if(iterationCount <= 0){
			return;
		}else{
			action.act();
			forLoop(iterationCount-1, action);
		}
	}
	
}

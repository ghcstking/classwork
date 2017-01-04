package datatypes6;

import java.util.Random;

public class MathRandom {

	public static void main(String[] args) {
		
		int[] results = new int[6];
		//same ass
		//int[] results = {0,0,0,0,0,0};
		int totalRolls = 10000;
		for(int index = 0; index < totalRolls; index++){
			int roll = rollFairDie();
			System.out.println("Roll #"+(index+1)+
					" Die is "+roll);
			results[roll-1]++;
		}
		for(int i = 0; i < 6; i ++){
			double percentage = (int) (1000*((double)results[i]/totalRolls))/10.0;
			System.out.println((i+1)+
					" was rolled "+
					percentage+"%.");			
		}
	}
	
	public static int rollFairDie(){
		double rand = Math.random();//random double (0,1)
		int roll = (int) (6 * rand);//[0,5] 
		return roll + 1;//0 becomes 1, 5 becomes 6
	}
	
//	public static int rollUnfairDie(){
//		//returns numbers 1-6, but with uneven distribution
//	}

	
	
	
	
	
	
	
	
	
	
	
}












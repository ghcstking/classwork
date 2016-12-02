package annaDanielBejeweled;

import java.util.Scanner;

import hansExplorerMain.Event;
import hansExplorerMain.HansCaveExplorer;

public class AnnaFrontend implements Event {
	public static String[][]arr2d;
	public static Scanner in;
	public static String[] symbol;
	public void play(){
		System.out.println("You enter the closet to find your gf's mom holding her jewelry box full of jewels.\n"
				+ "Your astonishingly good looks spook her and she drops the box oh noooooooooooo!\n"
				+ "Help her out by creating chains of jewels to reconstruct her jewelry!!!!!11 xD");
		symbol = new String[]{" A "," B "," C "," D "," E "};

		setGame();
		in = new Scanner(System.in);
		ask();
	}
	
	public AnnaFrontend(){
		
	}
	public static void setGame(){
		//int number = (int)(Math.random() * 12 + 5 );
		arr2d = new String[10][10];
		for(int row= 0; row < arr2d.length;row++){
			for(int col = 0; col < arr2d[row].length;col++){
				double rand = Math.random();
				int roll = (int) (symbol.length * rand);
				arr2d[row][col] = symbol[roll];
			}
		}
		for(int i =0; i < arr2d.length;i++){
			while(DanielBackend.checkRow(arr2d[i])[0] == 1){
				DanielBackend.clearRow(arr2d[i],DanielBackend.checkRow(arr2d[i])[1],DanielBackend.checkRow(arr2d[i])[2]);
				DanielBackend.replaceBlank(arr2d);
			}
			while(DanielBackend.checkCol(arr2d,i)[0]==1){
				DanielBackend.clearCol(arr2d,DanielBackend.checkCol(arr2d,i)[1],DanielBackend.checkCol(arr2d,i)[2],i);
				DanielBackend.replaceBlank(arr2d);
			}
		}
		
		printPic(arr2d);
	}
	public static void printPic(String[][] pic){
		System.out.print("    ");
		for(int i=0; i<arr2d.length; i++){
			if(i<10){
				System.out.print(i+"  ");
			} 
			else{
				System.out.print(i+" ");
			}
			
		}
		System.out.println();
		for(int row = 0; row< pic.length; row++){
			if(row>9){
				System.out.print(row +" ");
			}
			else{
				System.out.print(row +"  ");
			}
			for(int col = 0; col < pic[row].length; col++){
				
				System.out.print(pic[row][col]);
			}
			System.out.println();
		}
	}

	public static boolean isValid(String input){
		try{
			int num = Integer.parseInt(input);
		}catch(NumberFormatException nfe){
			return false;
		}
		int num = Integer.parseInt(input);
		if(num > 9 || num < 0){
			return false;
		}
		return true;
}
	public static void ask(){
		int a  = 0;
		while(a <5){
			System.out.println("which row?");
			String x = in.nextLine();
			if(x.equals("hax")){
				a=10000000;
				endGame();
			}
			else{
				while(!isValid(x)){
					System.out.println("Invalid. Select a row.");
					x = in.nextLine();
				}
				int row =  Integer.parseInt(x);
				
				System.out.println
				("which column?");
				String y = in.nextLine();
				while(!isValid(y)){
					System.out.println("Invalid. Select a column");
					y=in.nextLine();
				}
				int col =  Integer.parseInt(y);
				
				System.out.println("which direction?");
				String dir = in.nextLine();	
				while(row==0 && dir.equals("w")){
					System.out.println("Pick a direction that works.");
					dir = in.nextLine();
				}
				while(row==arr2d.length-1 && dir.equals("s")){
					System.out.println("Pick a direction that works.");
					dir = in.nextLine();
				}
				while(col==0 && dir.equals("a")){
					System.out.println("Pick a direction that works.");
					dir = in.nextLine();
				}
				while(col==arr2d[0].length-1 && dir.equals("d")){
					System.out.println("Pick a direction that works.");
					dir = in.nextLine();
				}
				while(!(dir.equals("w") || dir.equals("a")||dir.equals("s")||dir.equals("d"))){
					System.out.println("Direction invalid. Enter a valid direction PLS.");
					dir= in.nextLine();
				}
				DanielBackend.swap(arr2d, row,col,dir);
				for(int i = 0;i<arr2d.length;i++){
					while(DanielBackend.checkRow(arr2d[i])[0]==1||DanielBackend.checkCol(arr2d,i)[0]==1){
						if(DanielBackend.checkRow(arr2d[i])[0] == 1 ){
							DanielBackend.clearRow(arr2d[i],DanielBackend.checkRow(arr2d[i])[1],DanielBackend.checkRow(arr2d[i])[2]);
							DanielBackend.swapBlank(arr2d);
							DanielBackend.replaceBlank(arr2d);
							a++;
	
						}
						if(DanielBackend.checkCol(arr2d,i)[0] == 1){
							DanielBackend.clearCol(arr2d,DanielBackend.checkCol(arr2d,i)[1],DanielBackend.checkCol(arr2d,i)[2],i);
							DanielBackend.swapBlank(arr2d);
							DanielBackend.replaceBlank(arr2d);
							a++;
						}
					}
				}
				printPic(arr2d);
				System.out.println("Score: "+a);
				if(a>=5){
					endGame();
				}
			}
		}
	}
	public static void endGame(){
		System.out.println("Good looks, you've reconstructed enough jewelry. Your gf's mom now respects you :)\n"
				+ "With this newly gained respect, the door to the father's room opens");
		HansCaveExplorer.caves[2][6].getDoor(0).setLocked(false);
	}


}
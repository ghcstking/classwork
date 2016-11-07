package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {

	public static CaveRoom caves[][];
	public static Scanner in;
	public static CaveRoom currentRoom;
	private static Inventory inventory;
	
	public static void main(String[] args) {
		caves = new CaveRoom[5][5];
		for (int row = 0; row < caves.length; row++) {
			for (int col = 0; col < caves[row].length; col++) {
				caves[row][col] = new CaveRoom("This cave has coordinates " + "("+row+","+col+")");
			}
		}
		currentRoom = caves[0][1];
		currentRoom.enter();
		caves[0][1].setConnection(CaveRoom.EAST, caves[0][2], new Door());
		caves[0][2].setConnection(CaveRoom.SOUTH, caves[1][2], new Door());
		caves[1][2].setConnection(CaveRoom.SOUTH, caves[2][2], new Door());
		
		inventory = new Inventory();
printPic(caves);
		startExploring();
	}

	private static void startExploring() {
		while(true) {
			System.out.println(inventory.getDescription());
			System.out.println(currentRoom.getDescription());
			System.out.println("What would you like to do?");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
		}
	}
public static void printPic(String[][] arr) {
String[][] newArr = new String[(arr.length * 4) + 1][(arr[0].length * 4) + 1];
for (int row = 0; row < newArr.length; row++) {
for (int col = 0; col < newArr[0].length; col++) {
if (row%4 == 0) {
newArr[row][col] = "-";
}
else {
if (col%4 == 0) {
newArr[row][col] = "|";
}
else {
newArr[row][col] = " ";
}
}
}
}
for (int i = 0; i < newArr.length; i++) {
for (int j = 0; j < newArr[0].length; j++) {
System.out.print(newArr[i][j]);
}
System.out.println();
}

}

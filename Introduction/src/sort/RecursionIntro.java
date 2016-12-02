package sort;

public class RecursionIntro {
	private static int moveCount = 1;
	public static void main(String[] args) {
//		System.out.println("Using a for loop...");
//		for (int i = 0; i < 5; i++) {
//			System.out.println("Hello everyone!");
//		}
//		System.out.println("Using recursion...");
//		int num = 5;
//		forLoop(num, new Action() {	
//			public void act() {
//				System.out.println("Hello everyone!");
//			}
//		});
		hanoi(4, "A", "B", "C");
	}
	public static void hanoi(int numberOfDisks, String from, String mid, String to) {
		if (numberOfDisks < 2) {
			print("Move from " + from + " to " + to);
		}
		else {
			// move all but last one to peg b
			hanoi(numberOfDisks-1, from, to, mid);
			// move the last one to peg c
			hanoi(1, from, mid, to);
			// move all but last one to c
			hanoi(numberOfDisks-1,mid,from, to);
		}
	}

	public static void forLoop(int x, Action act) {
		if(x < 2) {
			act.act();
		}
		else {
			act.act();
			forLoop(x-1,act);
		}
	}
	public static void print(String input) {
		System.out.println("Move number: " + moveCount + " " +input);
		moveCount++;
	}
}
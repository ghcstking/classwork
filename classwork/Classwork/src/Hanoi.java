
public class Hanoi {

	public static void main(String[] args){

		move(4,"A","B","C");

	}



	public static void move(int n, String from, String mid, String to){

		if (n==1) System.out.println ("Move a disc from " + from + " to " + to);

		else {

			move (n-1, from, to, mid);

			move(1, from,mid,to);

			move(n-1, mid, from, to);

		}

	}


}

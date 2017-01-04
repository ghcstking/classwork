package simulator;

public final  class Account {

	private double balance;
	
	public Account(double cash){
		balance = cash;
	}
	
	public void increase(double amount) {
		balance += amount;
	}

	public void decrease(double amount) {
		balance -= amount;
	}

	public double getAmmount() {
		return balance;
	}

	
}

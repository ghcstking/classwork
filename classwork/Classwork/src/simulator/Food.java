package simulator;

public abstract class Food{

	public static final double LUXURY = 5.00;
	public static final double ESSENTIAL = 1.30;
	
	double freshness;
	double unitCost;
	double deteriorationRate;
	
	public final double getUnitCost(){
		return unitCost;
	}
	
	public final double getDeteriorationRate(){
		return deteriorationRate;
	}
	
	
	final void deteriorate(){
		freshness -= deteriorationRate;
	}

	public double getFreshness() {
		return freshness;
	}
	
}

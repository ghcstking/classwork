package simulator;

public final class GroceryList {

	
	private int luxuryNeed;
	private int essentialNeed;
	
	public GroceryList(int lux, int ess) {
		luxuryNeed=lux;
		essentialNeed = ess;
	}

	public int getLuxury(){
		return luxuryNeed;
	}

	public int getEssential(){
		return essentialNeed;
	}
	
	public String toString(){
		return luxuryNeed+" luxury, "+essentialNeed+" essential";
	}

}

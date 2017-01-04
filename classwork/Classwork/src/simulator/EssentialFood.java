package simulator;

public final class EssentialFood extends Food{

	public EssentialFood(double initialFreshness){
		this.freshness = initialFreshness;
		this.unitCost = Food.ESSENTIAL;
		this.deteriorationRate = .05;
	}
	
}

package simulator;

public final class LuxuryFood extends Food{

	public LuxuryFood(double initialFreshness){
		this.freshness = initialFreshness;
		this.unitCost = Food.LUXURY;
		this.deteriorationRate = .15;
	}

}

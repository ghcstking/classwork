package simulator;

public class LowerClass extends Population {

	
	public LowerClass(Location loc){
		this.location = loc;
		inventory= new Inventory(this, 0);
		storesByDistance= loc.getCity().getStoresByProximity(loc);
		luxuryNeed = 0;
		essentialNeed = 0;
		luxuryCapacity = 10;
		essentialCapacity = 25;
		inventory.init(luxuryCapacity, essentialCapacity);
		preferedShoppingDay1 = 6;
		luxuryConsumptionPerDay=1;
		essentialConsumptionPerDay=3;
		freshnessStandard = .3;
		name = "Lower class at "+loc;
	}
}

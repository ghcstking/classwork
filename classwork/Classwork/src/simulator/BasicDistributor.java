package simulator;

import java.util.ArrayList;
import java.util.List;

public final class BasicDistributor implements Distributor {

	final Location location;


	public BasicDistributor(Location loc) {
		this.location=loc;
	}

	public double getQuote(final Location deliveryDestination, final int numberOfLuxury, final int numberOfEssential, final double minFreshness) {
		return numberOfLuxury*Food.LUXURY + numberOfEssential*Food.ESSENTIAL + 2*location.getDistanceTo(deliveryDestination)*location.getTravelRate();
	}

	public final List<Food> getOrder(final Location deliveryDestination, final Inventory purchasingAccount, final int numberOfLuxury, final int numberOfEssential, final double minFreshness){
		if(purchasingAccount.canAfford(getQuote(deliveryDestination, numberOfLuxury, numberOfEssential, minFreshness))){
			purchasingAccount.charge(getQuote(deliveryDestination, numberOfLuxury, numberOfEssential, minFreshness));
			List<Food> order = new ArrayList<Food>();
			for(int i = 0; i < numberOfLuxury; i++){
				order.add(new LuxuryFood(Math.random()*(1.0-minFreshness) + minFreshness));
			}
			for(int i = 0; i < numberOfEssential; i++){
				order.add(new EssentialFood(Math.random()*(1.0-minFreshness) + minFreshness));
			}
			return order;
		}else return null;
	}

	public final Location getLocation(){
		return location;
		
	}

	public List<Food> getOrder(final Location deliveryDestination, Inventory inventory, GroceryList list,
			double quality) {
		return getOrder(deliveryDestination, inventory, list.getLuxury(), list.getEssential(), quality);
	}

	public boolean hasInStock(GroceryList list, double quality) {
		return true;
	}
	
	public String toString(){
		return "Distributor at "+location;
	}

}

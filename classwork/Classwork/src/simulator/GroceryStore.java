package simulator;

import java.util.ArrayList;
import java.util.List;

public abstract class GroceryStore implements Place, Distributor{

	public static final double STORE_STARTING_AMOUNT=100000 + Environment.getRelocateCost(0,0); 
	
	protected final Inventory inventory = new Inventory(this, STORE_STARTING_AMOUNT);
	protected final Inventory discardedInventory = new Inventory(this, 0);
	//location is final. Location can be set only by calling the "relocate" method
	protected Location location;
	protected List<Distributor> distributors;
	protected double quality;
	
	
	public final Location getLocation(){return location;}
	
	//returns this store's quality demand of distributors
	public final double getQuality(){return quality;}
	
	/**
	 * 
	 * @param list
	 * @return total cost of all items on list. Note: lists are always purchased in full. 
	 * Price does not have to be linear and may even be a combination: i.e. "buy two items, get one free" 
	 */
//	abstract double estimateCost(GroceryList list);

	/**
	 * Note: a population will not buy groceries at a store whose freshness standard is below that population's requirement.
	 * Further
	 * @return the freshness standard, a double describing the lowest-quality food that can be sold by this store
	 */
	abstract double getFreshness();
	


	public final boolean hasInStock(GroceryList list, double quality) {
		// TODO Auto-generated method stub
		return inventory.hasInStock(list, quality);
	}


	/**
	 * this method gets called every single "day"
	 * In it you can reorder supplies from the distributors
	 */
	public final void lapse(){
		print(this+" has a balance of "+inventory.getBalance());
		inventory.lapse();//food ages each day after it is purchased from distributors
		inventory.sortByFreshness();
		inventory.discardNonfreshFood(getFreshness(), discardedInventory);//food that is below this store's freshness standard gets moved to the discardedInventory
		orderSupplies();
	}
	
	protected void print(String s){
		if(location.toString().contains("9"))System.out.println(s);
	}
	
	/**
	 * Is called after every call of lapse() method (called every day). Should determine whether or not supplies need to be ordered,
	 * where to order them, and how much to order. See the Distributor interface for additional details on how food can be ordered
	 */
	abstract void orderSupplies();

	public String toString(){
		return "the store at "+location;
	}
	
	public abstract double getQuote(final Location deliveryDestination, int numberOfLuxury, int numberOfEssential,
			double minFreshness);

	//this method is not called by populations, it is only called by other grocery stores who purchase surplus
	public final List<Food> getOrder(final Location deliveryDestination, final Inventory inventory, final int numberOfLuxury, final int numberOfEssential, final double minFreshness){
		if((inventory.getParent() instanceof Population) || inventory.canAfford(getQuote(deliveryDestination, numberOfLuxury, numberOfEssential, minFreshness))){
			if(inventory.getParent() instanceof Population) inventory.charge(getQuote(deliveryDestination, numberOfLuxury, numberOfEssential, minFreshness));
			GroceryList list = new GroceryList(numberOfLuxury, numberOfEssential);
			return inventory.sell(list, getQuote(deliveryDestination, list.getLuxury(),list.getEssential(), quality));
		}else return null;
	}
	
}

package simulator;

import java.util.List;

public interface Distributor extends Place{

	public static final int TYPE_ESSENTIAL = 0;
	public static final int TYPE_LUXURY = 1;
	
	double getQuote(final Location deliveryDestination, int numberOfLuxury, int numberOfEssential,  double minFreshness);
	

	List<Food> getOrder(final Location deliveryDestination, final Inventory inventory, GroceryList list, double quality);

	public boolean hasInStock(GroceryList list, double quality);
	
}

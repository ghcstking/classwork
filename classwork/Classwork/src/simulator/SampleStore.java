/**
 * 
 */
package simulator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Teacher
 *
 */
public final class SampleStore extends GroceryStore{

	
	
	/**
	 * 
	 */
	public SampleStore(Location l) {
		this.location = l;
	}

	public void initDistributors(List<Distributor> listByProximity){
		distributors = listByProximity;
		orderSupplies();
	}
	

	@Override
	double getFreshness() {
		return 1;
	}

	@Override
	void orderSupplies() {
		List<ShoppingItenerary> possibleTrips = assessNeeds();
		if (!possibleTrips.isEmpty()){
			goShoppingFor(possibleTrips);
			
		}
	}
	


	
	private void goShoppingFor(List<ShoppingItenerary> possibleTrips) {
		ShoppingItenerary selected = selectBestItenerary(possibleTrips);
		Distributor selectedBusiness = selected.getStore();
		List<Food> products = selectedBusiness.getOrder(this.location, this.inventory, selected.getList(), quality);
		inventory.obtain(products);		
		print(this+" bought "+selected.getList()+". It cost "+selected.getCost());
	}
	
	private ShoppingItenerary selectBestItenerary(List<ShoppingItenerary> lists) {
		lists.sort(new Comparator<ShoppingItenerary>() {

			public int compare(ShoppingItenerary o1, ShoppingItenerary o2) {
				return o1.compareTo(o2);
			}
		});
		
		return lists.get(0);
	}

	protected List<ShoppingItenerary> assessNeeds() {

		ArrayList<ShoppingItenerary> possibleOptions = new ArrayList<ShoppingItenerary>();
		if(inventory.getLuxury()<1000 || inventory.getEssential()<1000){


			double travelCoef = 1.0;
			int amountOfLuxuryNeeded = 1000-inventory.getLuxury();
			int amountOfEssentialNeeded = 1000-inventory.getEssential();
			GroceryList list = new GroceryList(amountOfLuxuryNeeded,amountOfEssentialNeeded);
			for(Distributor d: distributors){
				possibleOptions.add(new ShoppingItenerary(location, travelCoef, d, list, quality));			
			}
		}
		return possibleOptions;
	}





	public List<Food> getOrder(final Location deliveryDestination, Inventory inventory, GroceryList list,
			double quality) {
		print(this+" sold "+list+". It earned "+getQuote(deliveryDestination, list.getLuxury(), list.getEssential(), quality));
		return getOrder(deliveryDestination, inventory, list.getLuxury(), list.getEssential(), quality);
	}

	@Override
	public double getQuote(Location deliveryDestination, int numberOfLuxury,
			int numberOfEssential, double minFreshness) {
		return numberOfLuxury*Food.LUXURY+1 + numberOfEssential*Food.ESSENTIAL+1 + 2*location.getDistanceTo(deliveryDestination)*location.getTravelRate();
	}



}

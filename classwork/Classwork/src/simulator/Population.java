package simulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Population {


	protected double luxuryNeed;
	protected double essentialNeed;
	protected int luxuryCapacity;
	protected int essentialCapacity;
	protected int preferedShoppingDay1;
	protected double freshnessStandard;

	protected String name;
	
	protected int luxuryConsumptionPerDay;
	protected int essentialConsumptionPerDay;

	protected Location location;
	protected Inventory inventory;
	protected List<GroceryStore> storesByDistance;



	/**
	 * depletes food supply and decides whether or not to shop for groceries
	 * called after ever iteration 
	 */
	public void lapse() {
		print(this+" has "+inventory+".");
		reduceFood();
		throwAwayExpiredFood();
		List<ShoppingItenerary> possibleTrips = assessNeeds();
		if (!possibleTrips.isEmpty()){
			goShoppingFor(possibleTrips);
		}
	}

	private void print(String s){
//		if(name.contains("15, 9"))System.out.println(s);
	}
	
	private void throwAwayExpiredFood() {
		inventory.lapse();
		inventory.discardNonfreshFood(.05, null);
	}

	protected void reduceFood() {
		inventory.sortByOldest();
		for(int i = 0; i < luxuryConsumptionPerDay; i++){
			inventory.consumeLux();
		}
		for(int i = 0; i < essentialConsumptionPerDay; i++){
			inventory.consumeEss();
		}
	}

	protected void goShoppingFor(List<ShoppingItenerary> lists) {
		ShoppingItenerary selected = selectBestItenerary(lists);
		GroceryStore selectedBusiness = (GroceryStore) selected.getStore();
		List<Food> products = selectedBusiness.getOrder(this.location, inventory, selected.getList(), freshnessStandard);
		inventory.obtain(products);			
		print(name +" went grocery shopping at "+selectedBusiness);

	}

	private ShoppingItenerary selectBestItenerary(List<ShoppingItenerary> lists) {
		lists.sort(new Comparator<ShoppingItenerary>() {

			public int compare(ShoppingItenerary o1, ShoppingItenerary o2) {
				return o1.compareTo(o2);
			}
		});
		double cost1 = lists.get(0).getCost();
		double cost2 = lists.get(lists.size()-1).getCost();
		
		return lists.get(0);
	}



	/**
	 * 
	 * The highest priority of a population is to have enough to to survive for another day.
	 * In a situation where not shopping would cause reduceFood() to dip into negative values, the population will ALWAYS go shopping
	 * Preference is given to shopping for enough food to last until the preferred shopping day
	 * On the preferred shopping day, the cost of travel is cut in half
	 * 
	 * @return several possible Iteneraries that would satisfy needs
	 */
	protected List<ShoppingItenerary> assessNeeds() {

		ArrayList<ShoppingItenerary> possibleOptions = new ArrayList<ShoppingItenerary>();
		if(inventory.getLuxury()-luxuryConsumptionPerDay<=0 || inventory.getEssential()-essentialConsumptionPerDay<=0){


			double travelCoef = 1.0;
			if(location.getCity().getDay()==preferedShoppingDay1)travelCoef=.1;
			int amountOfLuxuryNeeded = getNeed(Distributor.TYPE_LUXURY);
			int amountOfEssentialNeeded = getNeed(Distributor.TYPE_ESSENTIAL);
			GroceryList list = new GroceryList(amountOfLuxuryNeeded,amountOfEssentialNeeded);
			for(GroceryStore g: storesByDistance){
				if(g.hasInStock(list, freshnessStandard))
				possibleOptions.add(new ShoppingItenerary(location, travelCoef, g, list, freshnessStandard));			
			}
		}
		return possibleOptions;
	}


	private int getDaysUntilShopping(){
		return   (preferedShoppingDay1 - location.getCity().getDay())%7;
	}

	private int getNeed(int type) {
		int days = getDaysUntilShopping();
		int amountUntilShoppingDay =(type==Distributor.TYPE_LUXURY)?days*luxuryConsumptionPerDay:days*essentialConsumptionPerDay;
		int capacity = (type== Distributor.TYPE_LUXURY)?luxuryCapacity:essentialCapacity;
		if(amountUntilShoppingDay < capacity)return amountUntilShoppingDay;
		else return capacity;
	}

	public String toString(){
		return name;
	}
	//returns 





}

package simulator;

public final class ShoppingItenerary implements Comparable<ShoppingItenerary> {

	private  Distributor selectedStore;
	private GroceryList shoppingList;
	private double cost;
	private double desiredFreshness;
	
	public ShoppingItenerary(Location origin, double travelCoef, Distributor d, GroceryList shoppingList, double desiredFreshness){
		this.selectedStore = d;
		this.shoppingList = shoppingList;
		cost = calculateCost(origin, travelCoef);
		this.desiredFreshness=desiredFreshness;
	}

	private double calculateCost(Location origin, double travelCoef) {
		double travelRate = origin.getTravelRate();
//		System.out.println("The cost of buying "+shoppingList+" at "+selectedStore+", leaving from "+origin+", is the travel cost:");
//		System.out.println("distance: "+origin.getDistanceTo(selectedStore.getLocation())+" multiplied by travel cost = "+travelRate*2*travelCoef*origin.getDistanceTo(selectedStore.getLocation()));
		return travelRate*2*travelCoef*origin.getDistanceTo(selectedStore.getLocation())+selectedStore.getQuote(origin, shoppingList.getLuxury(), shoppingList.getEssential(), desiredFreshness);
	}

	public Distributor getStore() {
		// TODO Auto-generated method stub
		return selectedStore;
	}
	
	public GroceryList getList(){
		return shoppingList;
	}

	public int compareTo(ShoppingItenerary arg0) {
		return (int) (this.cost - arg0.getCost());
	}

	public double getCost() {
		return cost;
	}
	
	
}

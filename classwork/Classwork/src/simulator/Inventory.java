package simulator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final  class Inventory implements Comparator<Food>{

	private Account account;
	private List<LuxuryFood> luxuryInventory;
	private List<EssentialFood> essentialInventory;
	private final Object parent; 
	
	public Inventory(Object parent, double startingCash) {
		this.parent = parent;
		account = new Account(startingCash);
		luxuryInventory = new ArrayList<LuxuryFood>();
		essentialInventory = new ArrayList<EssentialFood>();
	}

	public Object getParent(){
		return parent;
	}

	public boolean hasInStock(GroceryList list, double quality){
		int luxuryCount = 0;
		int essCount = 0;
		for(LuxuryFood lf : luxuryInventory){
			if(lf.getFreshness()>=quality)luxuryCount++;
		}
		if(luxuryCount < list.getLuxury())return false;
		else{
			for(EssentialFood ef : essentialInventory){
				if(ef.getFreshness()>=quality)essCount++;
			}
		}
		if(essCount < list.getEssential()){
			return false;
		}else return true;
	}

	public boolean canAfford(double amount){
		return amount <= account.getAmmount();
	}
	
	public List<Food> sell(GroceryList list, double cost) {
		ArrayList<Food> product = new ArrayList<Food>();
		for(int i =0; i < list.getLuxury(); i ++){
			product.add(luxuryInventory.remove(0));
		}
		for(int i =0; i < list.getEssential(); i ++){
			product.add(essentialInventory.remove(0));
		}
		account.increase(cost);
		return product;
		
	}
	
	
	public void obtain(List<Food> purchasedProducts) {
		for(Food f: purchasedProducts){
			if(f instanceof EssentialFood)essentialInventory.add((EssentialFood) f);
			else if(f instanceof LuxuryFood)luxuryInventory.add((LuxuryFood) f);
		}

	}

	
	/**
	 * deteriorates all food
	 */
	public void lapse(){
		for(Food f: luxuryInventory){
			f.deteriorate();
		}
		for(Food f: essentialInventory){
			f.deteriorate();
		}
	}
	
	public void discardNonfreshFood(double freshness, Inventory discardedInventory) {
		int i=0;
		while(i< luxuryInventory.size()){
			Food lf = luxuryInventory.get(i);
			if(lf.getFreshness() < freshness){
				luxuryInventory.remove(lf);
				if(discardedInventory!= null) discardedInventory.add(lf);
			}else{
				i++;
			}
			
		}
		int j=0;
		while(j < essentialInventory.size()){
			Food ef = essentialInventory.get(j);
			if(ef.getFreshness() < freshness){
				essentialInventory.remove(ef);
				if(discardedInventory!= null) discardedInventory.add(ef);
			}else{
				j++;
			}
			
		}
		
		
		
	}
	
	public final void charge(double amount){
		account.decrease(amount);
	}
	
	private void add(Food f) {
		if(f instanceof LuxuryFood){
			luxuryInventory.add((LuxuryFood)f);
		}
		if(f instanceof EssentialFood){
			essentialInventory.add((EssentialFood)f);
		}
	}


	public void sortByFreshness() {
		luxuryInventory.sort(this);
		essentialInventory.sort(this);
	}


	public int compare(Food f1, Food f2) {
		if(f1.getFreshness()-f2.getFreshness()>0)return 1;
		else if(f1.getFreshness()-f2.getFreshness()<0)return -1;
		else return 0;
	}


	public void consumeLux() {
		luxuryInventory.remove(0);
	}
	
	public void consumeEss() {
		essentialInventory.remove(0);
	}


	public void sortByOldest() {
		class OldSort implements Comparator<Food>{
			public int compare(Food f2, Food f1) {
				if(f1.getFreshness()-f2.getFreshness()>0)return -1;
				else if(f1.getFreshness()-f2.getFreshness()<0)return 1;
				else return 0;
			}
			
		}
		
		luxuryInventory.sort(new OldSort());
		essentialInventory.sort(new OldSort());
	}


	public int getLuxury() {
		return luxuryInventory.size();
	}

	public int getEssential(){
		return essentialInventory.size();
	}


	public void init(int luxuryCapacity, int essentialCapacity) {
		for(int i = 0; i < luxuryCapacity; i++){
			luxuryInventory.add(new LuxuryFood(1.0));
		}
		for(int i = 0; i <essentialCapacity; i++){
			essentialInventory.add(new EssentialFood(1.0));
		}
	}


	public String toString(){
		return luxuryInventory.size()+" lux and "+essentialInventory.size()+"  ess";
	}


	public double getBalance() {
		return account.getAmmount();
	}

	
	
}

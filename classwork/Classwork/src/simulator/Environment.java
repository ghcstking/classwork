package simulator;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public abstract class Environment {

	List<GroceryStore> stores;
	List<Distributor> distributors;
	protected Population[][] populations;
	int day;
	protected BufferedImage image;

	public final List<GroceryStore> getStores() {
		return stores;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return cost of setting up a grocery store at coordinates x, y
	 */
	public static int getRelocateCost(int x, int y){
		return 1000000;
	}

	public void lapse(){
		day = ((day+1)%7);
		for(Population[] pList: populations){
			for(Population p:pList){
				p.lapse();
			}
		}
		for(GroceryStore g: stores){
			g.lapse();
		}
	}
	
	public Image getImage(){
		return image;
	}
	
	public int getDay() {
		return day;
	}
	
	List<GroceryStore> getStoresByProximity(final Location l) {
		List<GroceryStore> closeStores = new ArrayList<GroceryStore>();
		closeStores.addAll(stores);
		closeStores.sort(new PlaceSorter(l));
		return closeStores;
	}
	
	
	
	private class PlaceSorter implements Comparator<Place>{

		Location l;
		
		PlaceSorter(Location l){
			this.l = l;
		}
		
		public int compare(Place o1, Place o2) {
			double distance1 = l.getDistanceTo(o1.getLocation());
			double distance2 = l.getDistanceTo(o2.getLocation());
			if(distance1 < distance2)return -1;
			if(distance1 > distance2)return 1;
			return 0;
		}
	}

	List<Distributor> getDistributorsByProximity(final Location l) {
		List<Distributor> closeDist = new ArrayList<Distributor>();
		closeDist.addAll(distributors);
		closeDist.sort(new PlaceSorter(l));
		return closeDist;
	}
	
}

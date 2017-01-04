package simulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Manhattan extends Environment {

	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	private static final int NUMBER_OF_SAMPLE_DISTRIBUTORS = 4;
	private static final int NUMBER_OF_SAMPLE_STORES = 10;
	
	
	private static Manhattan nyc = new Manhattan();
	private Image cityMap;
	private Location[][] locations;
	

	
	public Manhattan() {
		stores = new ArrayList<GroceryStore>();
		distributors = new ArrayList<Distributor>();
		locations = new Location[HEIGHT/Location.WIDTH][WIDTH/Location.WIDTH];
		System.out.println("dims "+locations.length+" rows and "+locations[0].length+" cols");
		for(int i = 0; i< locations.length; i++){
			for(int j = 0; j< locations[0].length; j++){
				locations[i][j] = new Location(this,i,j,"");
			
			}
		}
		initDistributors();
		initSampleStores();
		initPopulations();
		initMap();
	}


	private void initDistributors() {
		for(int i=0; i < NUMBER_OF_SAMPLE_DISTRIBUTORS; i++){
			distributors.add(new BasicDistributor(claimARandomLot("Dis.")));
		}
	}

	private void initSampleStores() {
		for(int i=0; i < NUMBER_OF_SAMPLE_STORES; i++){
			SampleStore s = new SampleStore(claimARandomLot("S "+i));
			stores.add(s);
			s.initDistributors(getDistributorsByProximity(s.getLocation()));
		}
	}

	private void initPopulations() {
		populations = new Population[HEIGHT/Location.WIDTH][WIDTH/Location.WIDTH];
		for(int i = 0; i< populations.length; i++){
			for(int j = 0; j< populations[0].length; j++){
				if(locations[i][j].getSE() <.3)populations[i][j] = new LowerClass(locations[i][j]);
				else populations[i][j] = new LowerClass(locations[i][j]);
			}
		}
	}

	private void initMap() {
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = image.createGraphics();
		for(int i = 0; i< locations.length; i++){
			for(int j = 0; j< locations[0].length; j++){
				g.drawImage(locations[i][j].getImage(), j*Location.WIDTH, i*Location.WIDTH, null);
			}
		}
	}
	

	public Location getARandomLot(){
		int x = (int)(Math.random()*locations.length);
		int y = (int)(Math.random()*locations[0].length);

		return locations[x][y];
	}
	
	public Location claimARandomLot(String title){
		int x = (int)(Math.random()*locations.length);
		int y = (int)(Math.random()*locations[0].length);
		while(locations[x][y].taken()){
			x = (int)(Math.random()*locations.length);
			y = (int)(Math.random()*locations[0].length);
		}
		locations[x][y].take(title);
		return locations[x][y];
	}
	
	
	
	public static Manhattan getInstance() {
		return nyc;
	}
	
}

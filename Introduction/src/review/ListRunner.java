package review;

import java.util.ArrayList;

public class ListRunner {
	static ArrayList<Item> shoppingList;
	
	public static void main(String[] args) {
		String[] justDescriptions = getDescriptions();
		initList(justDescriptions);
		doSomeShopping();
		printPurchasedItems();
	}

	private static void printPurchasedItems() {
		for (int i = 0; i < shoppingList.size(); i++) {
			if (shoppingList.get(i).isPurchased()) {
				System.out.println("Bought " + shoppingList.get(i).getDescription());
				shoppingList.remove(i);
				i--;
			}
		}
	}

	private static void doSomeShopping() {
		shoppingList.get(0).setPurchased(true);
		shoppingList.get(3).setPurchased(true);
	}

	private static void initList(String[] justDescriptions) {
		shoppingList = new ArrayList<Item>();
		for (String s: justDescriptions) {
			shoppingList.add(new Item(s));
		}
		
	}

	private static String[] getDescriptions() {
		String[] test = {"Clothes", "Dryer", "Shampoo", "Pokeballs"};
		return test;
	}
}

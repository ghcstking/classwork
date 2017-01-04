package sort8;

public class MainBattle {

	public static void main(String[] args) {
		Pokemon squirtle = new Pokemon("Squirtle",26);
		Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		squirtle.iChooseYou();
		bulbasaur.iChooseYou();
		System.out.println("Squirtle is preparing to "
				+ "attack with water blast");
		squirtle.attack(bulbasaur, new Attack() {
			
			//cuts health(hp) in half
			public void attack(Pokemon target) {
				int newHP = target.getHP()/2;
				target.setHP(newHP);
			}
		});
		bulbasaur.attack(squirtle, new Attack() {
			//poisons the target
			public void attack(Pokemon target) {
				target.setPoisoned(true);
			}
		});
		
		
		//create a way for squirtle and bulbasaur to attack
		squirtle.lapse();
		bulbasaur.lapse();
		printScore(squirtle, bulbasaur);
	}

	private static void printScore(Pokemon p1, Pokemon p2) {
		System.out.println(p1.getName()+", HP = "+p1.getHP());
		System.out.println(p2.getName()+", HP = "+p2.getHP());
	}
	
	
	
	
	
	
	

}

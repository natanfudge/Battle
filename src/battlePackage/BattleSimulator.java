package battlePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BattleSimulator {

	public static void main(String[] args) {

		List<Player> players = new ArrayList<>();
		Map<String, Enemy> enemies = new HashMap<>();
		enemies.put("skeleton0", new Skeleton("skeleton0"));
		CharacterFactory.setCharacters(enemies);
		if (args!=null && args.length>0) {
			if (args[0].equalsIgnoreCase("printonly"))
				CharacterFactory.setPrintOnly(true);
			if (args.length>1 && args[1].equalsIgnoreCase("dev"))
				Utilities.setDev(true);
		}
		
		/*for (int i=0;i<10;i++) {
			skeletons.add(new Skeleton("skeleton"+i));
		}
		
		
		players.add(new Warrior(1000, 50, 100,3.5f, "Garrosh"));
		players.add(new Warrior(1000, 50, 100,3.5f, "Garrosh"));
		*/
		Scanner sc = new Scanner(System.in);


		

		createCharacter(players, sc);
			Player main = players.get(0);
			Utilities.p();
			Utilities.p("A skeleton appears! What do you do?");
			Utilities.p("attack      run");
			boolean ok = true;
			do{
				String nextAction = sc.next();
				ok = true;
				switch (nextAction) {

					case "attack":
Utilities.p("How to attack? 	") ;
						for (Ability ab:main.getAbilities()) {
							Utilities.p("    "+ab);
						}




						

						Character character = null;
					    character = selectTarget(sc, character);
						main.attack(character);
						Utilities.p(character.getName() + " now has " + character.getHealth() + " health");
						;
						break;
					case "run":
						Utilities.p("Coward");
						sc.close();
						break;
					default:
						Utilities.p("What?");
						ok = false;
						break;
				}

			}while(!ok);

			//test


			sc.close();
		
	/*	Thread f1 = new Thread(new Action("attack", players.get(0), skeletons.get(0)));
		Thread f2 = new Thread(new Ticker(6, f1));
		f1.start();
		f2.start();

		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
*/


	}

	private static Character selectTarget(Scanner sc, Character character) {
		Utilities.p("Who to attack?     skeleton0");
		while (character == null) {


			String target = sc.next();
			character = CharacterFactory.getEnemy(target);
			if (character==null) {
				Utilities.p("invalid target");
			}


		}
		return character;
	}

	private static void createCharacter(List<Player> players, Scanner sc) {
		Utilities.p("Enter your name");
		String name = sc.next();
		Utilities.p("Choose your player type"	+System.lineSeparator()+
				"Warrior-high health low spell power medium attack damage medium attack speed" +System.lineSeparator()+
				"Mage-low health high spell power low attack damage low attack speed");
		Player player = null;

		while (player == null) {
			String type = sc.next();

			player = CharacterFactory.createCharacter( name, type);
			if (player != null) {
				Utilities.p(player.getName()+" is a "+player.getClass().getSimpleName());

				players.add(player);
			}
		}
	}
}
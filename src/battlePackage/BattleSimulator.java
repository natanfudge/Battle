package battlePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BattleSimulator {

	private static final String PLAYER_TYPE = "playerType";
	private static final String TARGET = "target";
	public static void main(String[] args) {

		List<Player> players = new ArrayList<>();
		List<Enemy> enemies = new ArrayList<>();
		 
		enemies.add(new Skeleton("skeleton0"));
		enemies.add(new Skeleton("bob"));
		enemies.add(new Skeleton("kuku"));
		CharacterFactory.setCharacters(enemies);
		if (args!=null && args.length>0) {
			if (args[0].equalsIgnoreCase("printonly"))
				CharacterFactory.setPrintOnly(true);
			if (args.length>1 && args[1].equalsIgnoreCase("dev"))
				Utilities.setDev(true);
		}
		
	Option.fillDialogues();
	Option.fillOptions();
		Scanner sc = new Scanner(System.in);


		

		createCharacter(players, sc);
			Player main = players.get(0);
			Utilities.p();
			Utilities.p("A skeleton appears! What do you do?");
			Utilities.p("[1] attack \n"+
					"[2] run");
			boolean ok;
			do{
				String nextAction = sc.next();
				ok = true;
				switch (nextAction) {

					case "1":
Utilities.p("How to attack? 	") ;
						for (Ability ab:main.getAbilities()) {
							Utilities.p("    "+ab);
						}




						

						Character character = null;
					    character = selectTarget(sc, character);
						main.attack(character);
						Utilities.p(character.getName() + " now has " + character.getHealth() + " health");

						break;
					case "2":
						Utilities.p("Coward");
						sc.close();
						break;
					default:
						Utilities.p("What?");
						ok = false;
						break;
				}

			}while(!ok);




			sc.close();
		
	/*	Thread f1 = new Thread(new Action("attack", players.get(0), skeletons.get(0)));
		Thread f2 = new Thread(new Ticker(6, f1));
		f1.start();
		f2.start();

		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}
*/


	}


	private static void createCharacter(List<Player> players, Scanner sc) {
		Utilities.p("Enter your name");
		String name = sc.next();
		Utilities.p(Option.getDialogue(PLAYER_TYPE));
		List<String> options = Option.getOptions(PLAYER_TYPE);
		for(int i=0;i<options.size();i++){
			Utilities.p("["+(i+1)+"]"+options.get(i));
		}
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
	private static Character selectTarget(Scanner sc, Character character) {
		Utilities.p(Option.getDialogue(TARGET));
		List<String> options = Option.getOptions(TARGET);
		for(int i=0;i<options.size();i++){
			Utilities.p("["+(i+1)+"]"+options.get(i));
		}
		while (character == null) {


			int target = sc.nextInt();
			character = CharacterFactory.getEnemy(target-1);
			if (character==null) {
				Utilities.p("invalid target");
			}


		}
		return character;
	}

}
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
		}
		
		/*for (int i=0;i<10;i++) {
			skeletons.add(new Skeleton("skeleton"+i));
		}
		
		
		players.add(new Warrior(1000, 50, 100,3.5f, "Garrosh"));
		players.add(new Warrior(1000, 50, 100,3.5f, "Garrosh"));
		*/
		Scanner sc = new Scanner(System.in);


		System.out.println("Enter your name");
		String name = sc.next();

		System.out.print("What type would you like?	"+System.lineSeparator()+
				"Warrior-high health low spell power medium attack damage medium attack speed" +System.lineSeparator()+
				"Mage-low health high spell power low attack damage low attack speed"+System.lineSeparator());
		Player player = null;

		while (player == null) {
			String type = sc.next();

			player = CharacterFactory.createCharacter( name, type);
			if (player != null) {
				System.out.println(player.getName()+" is a "+player.getClass().getSimpleName());

				players.add(player);
			}
		}
			Character main = players.get(0);
			System.out.println();
			System.out.println("A skeleton appears! What would you like to do?");
			System.out.println("attack      run");
			boolean ok = true;
			do{
				String nextAction = sc.next();
				ok = true;
				switch (nextAction) {

					case "attack":

						System.out.println("What would you like to attack?     " + CharacterFactory.getEnemy("skeleton0").getName());

						Character character = null;
						while (character == null) {


							String target = sc.next();
							character = CharacterFactory.getEnemy(target);
							if (character != null) {
								main.attack(character);
								System.out.println(CharacterFactory.getEnemy(target).getName() + " now has " + CharacterFactory.getEnemy(target).getHealth() + " health");
							} else {
								System.out.println("invalid target");
							}


						}
						;
						break;
					case "run":
						System.out.println("it works");
						break;
					default:
						System.out.println("what?");
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
}
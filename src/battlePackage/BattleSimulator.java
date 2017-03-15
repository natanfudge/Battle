package battlePackage;

import java.util.*;

public class BattleSimulator {

	private static final String PLAYER_TYPE = "playerType";
	private static final String TARGET = "target";
	public static void main(String[] args) {

		List<Player> players = new ArrayList<>();
		List<Enemy> enemies1 = new ArrayList<>();
		enemies1.add(new Skeleton("skeleton0"));
		List<Enemy> enemies2 = new ArrayList<>();
		enemies2.add(new Skeleton("zombie0"));
	//	enemies.add(new Skeleton("bob"));
	//	enemies.add(new Skeleton("kuku"));
		CharacterFactory.setCharacters(enemies1);




		Map<String,Map<String,List<Equipment>>>equipment = new HashMap();




		Map<String,List<Equipment>> weapons=new HashMap<>();
		equipment.put("weapons", weapons);


		List<Equipment>swords=new ArrayList<>();
		weapons.put("swords",swords);

		swords.add(new Sword(100, "Sharpy", Enchantment.POWER, 150, 1.2f));
		swords.add(new Sword(100, "Sword1", Enchantment.NONE, 70, 1.8f));

		List<Equipment>wands=new ArrayList<>();
		weapons.put("wands",wands);
		wands.add(new Wand(80, "Wand1", Enchantment.KNOWLEDGE, 30,200, 2.2f));
		wands.add(new Wand(80, "Wand2", Enchantment.NONE, 40,150, 1.8f));



		Map<String,List<Equipment>> armor=new HashMap<>();
		equipment.put("armor", armor);


		List<Equipment>shields=new ArrayList<>();
		armor.put("shields",shields);


		List<Equipment>helmets=new ArrayList<>();
		armor.put("helmets",helmets);



















		if (args!=null && args.length>0) {
			if (args[0].equalsIgnoreCase("printonly"))
				CharacterFactory.setPrintOnly(true);
			if (args.length>1 && args[1].equalsIgnoreCase("dev"))
				Utilities.setDev(true);
		}

	Option.fillDialogues();
	Option.fillOptions();

		Scanner sc = new Scanner(System.in);

		Utilities.p(""+((Weapon)swords.get(0)).getAttackDamage());




        Utilities.p("Enter your name");   String name=sc.next();

        createCharacter(players, sc,name);    Player main = players.get(0);

		int choice=choose(sc,"opening");







				switch (choice) {

                    case 1:

                        while (enemies1.size()>0) {

							int ability = chooseAbility(sc, main);


                            Character character = null;
                            character = choiceCharacter(sc, character, TARGET);
                            main.useAbility(character, ability);
                            Utilities.p(character.getName() + " now has " + character.getHealth() + " health");
							updateEnemyList(enemies1);
                        }
                        int choiceWeapon=choose(sc,"chooseWeapon");
                        switch(choiceWeapon){
							case 1:
								int choiceSword=choose(sc,"chooseSword");
								break;

							case 2:
								int choiceWand=choose(sc,"chooseWand");


						}
                            break;
                            case 2:
                                Utilities.p("Coward");
                                sc.close();
                                break;
                            default:
                                Utilities.p("What?");

                                break;
                        }






			sc.close();




	}

	private static void updateEnemyList(List<Enemy> enemies1) {
		for (int i=0;i<enemies1.size();i++){
            if (enemies1.get(i).getHealth()<=0){
enemies1.remove(i);

            }

        }
	}




    private static int choose(Scanner sc, String topic) {

		boolean ok = false;

		int choice = 0;
		Utilities.p(Option.getDialogue(topic));
		List<String> options = Option.getOptions(topic);
		for (int i = 0; i < options.size(); i++) {
			Utilities.p("[" + (i + 1) + "]" + options.get(i));
		}
		while (!ok) {

			choice = sc.nextInt();
			ok = choice <= options.size();


		}
		return choice;
	}


	private static Character choiceCharacter(Scanner sc, Character character,String topic) {
		chooseCharacter(topic);
		while (character == null) {


			int target = sc.nextInt();
			character = CharacterFactory.getEnemy(target-1);
			if (character==null) {
				Utilities.p("invalid target");
			}


		}
		return character;
	}

	private static void chooseCharacter(String topic) {

		Utilities.p(Option.getDialogue(topic));
		List<String> options = Option.getOptions(topic);
		for(int i=0;i<options.size();i++){
			Utilities.p("["+(i+1)+"]"+options.get(i));

		}
	}




	private static int chooseAbility(Scanner sc,Player player) {
		Utilities.p(Option.getDialogue("ability"));
		List<Ability> options = player.getAbilities();
		for(int i=0;i<options.size();i++){
			Utilities.p("["+(i+1)+"]"+options.get(i));
		}
		int choice=sc.nextInt();
		return choice;
	}


	private static void createCharacter(List<Player> players, Scanner sc,String name) {

		Player player = null;

		while (player == null) {
			int type = choose(sc,PLAYER_TYPE);;

			player = CharacterFactory.createCharacter( name, type);
			if (player != null) {
				Utilities.p(player.getName()+" is a "+player.getClass().getSimpleName());

				players.add(player);
			}
		}
	}











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
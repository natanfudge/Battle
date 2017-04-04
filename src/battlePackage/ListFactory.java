package battlePackage;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ListFactory {
   boolean back;


private static final int levelModifier=Configurable.getConfigurable("levelModifier");
    public static int choose(Scanner sc, String topic) {


        int choice;
        Utils.p(Option.getDialogue(topic));
        List<String> options = Option.getOptions(topic);
        for (int i = 0; i < options.size(); i++) {
            Utils.p("[" + (i + 1) + "]" + options.get(i));
        }


        while ((choice = sc.nextInt()) > options.size()) ;


        return choice;
    }





    public static Equipment choiceWeapon(Scanner sc, int type, String name, Map<String, Map<Integer, List<Equipment>>> equipment) {
        Utils.p("Choose " + name);


        List<Equipment> weapons = equipment.get("weapons").get(type);
        for (int i = 0; i < weapons.size(); i++) {

            Utils.p("[" + (i + 1) + "]" + weapons.get(i).getName());
        }
        int choice;
        while ((choice = sc.nextInt()) > weapons.size()) ;



        return weapons.get(choice-1);

    }




    public static void createPlayer(List<Player> players, Scanner sc, String name) {

        Player player = null;

        while (player == null) {
            int type = choose(sc, "playerType");
            ;

            player = CharacterFactory.createPlayer(name, type);
            if (player != null) {
                Utils.p(player.getName() + " is a " + player.getClass().getSimpleName());

                players.add(player);
            }
        }
    }

    public static boolean battle(List<Enemy> enemies, List<Player> players, Scanner sc, Random rand, String battleType) {
        boolean back = false;
        switch (battleType) {
            case "1":

                enemies.add(new Skeleton("skeleton0"));
                enemies.get(0).setHealth(100);
                enemies.add(new Skeleton("bob"));
                enemies.get(1).setHealth(100);
                break;
            case "2":
                enemies.add(new Skeleton("Skeleton1"));

                break;
        }

        for (Enemy enemy : enemies) {
            Utils.p("A " + enemy.getClass().getSimpleName() + ", " + enemy.getName() + " Appears");

        }

        int choice = choose(sc, "opening");
        switch (choice) {
            case 1:

                while (enemies.size() > 0 && players.size() > 0) {
for(Player player:players) {
    playerAttack(enemies, sc, player);
    back = enemyAttack(enemies, players, sc, rand);
    if (back) {
        break;
    }
}
                }

                break;




            case 2:
               enemies.clear();
                Utils.p("Coward");
                back=true;

                return back;


        }
                return back;

        }
	public static Character chooseTarget(Scanner sc, List<Enemy> enemies) {
		Utils.p("Choose target");


		for (int i = 0; i < enemies.size(); i++) {

			Utils.p("[" + (i + 1) + "]" + enemies.get(i).getName());
		}
		int target;
		while ((target = sc.nextInt()) > enemies.size()) ;


		Character character = enemies.get(target - 1);
		return character;

	}


	public static int chooseAbility(Scanner sc, Player player) {
		int choice;
		Utils.p(Option.getDialogue("ability"));
		List<String> options = player.getAbilities();
		for (int i = 0; i < options.size(); i++) {
			Utils.p("[" + (i + 1) + "]" + options.get(i));
		}


		while ((choice = sc.nextInt()) > options.size()) ;


		return choice;
	}
    private static void playerAttack(List<Enemy> enemies, Scanner sc,Player player) {
        int ability = chooseAbility(sc, player);
        Character character = chooseTarget(sc, enemies);
        player.useAbility(character, ability);
        enemyDeath(enemies,player);
    }

    public static boolean enemyAttack(List<Enemy> enemies, List<Player> players, Scanner sc, Random rand) {
        boolean back=false;
        int targetPos = rand.nextInt(players.size());
        Player target = players.get(targetPos);

        for (Enemy enemy : enemies) {

            enemy.normalAttack(target);

            Utils.p(enemy.getName() + " has attacked " + target.getName() + "!  " + target.getName() + " now has " + target.getHealth() + " health.");
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getHealth() <= 0) {
                    players.remove(i);
                    Utils.p(enemies.get(i).getName() + " has died!");
                    if (players.size() == 0) {

                        Utils.p("Game over!");
back=true;
break;


                    }

                }
            }
            if(back){
                break;
            }
        }
       return back;
    }
	public static void enemyDeath(List<Enemy> enemies, Player attacker) {


		for (int i = 0; i < enemies.size(); i++) {
			Enemy attacked= enemies.get(i);
			if (attacked.getHealth() <= 0) {
				Utils.p(attacked.getName()+" has died!");

				float attackerEXP=  attacker.getExperience();
				attacker.setExperience(attackerEXP+=attacked.getEXPBounty());
				Utils.p(attacker.getName()+" got "+attacked.getEXPBounty()+" Exp!");
				if(attackerEXP>=(attacker.getLevel()*levelModifier)) {
					attacker.setExperience(attacker.getExperience()-attacker.getLevel()*levelModifier);
					attacker.setLevel(attacker.getLevel() + 1);
					Utils.p(attacker.getName()+" has leveled up! \n"+attacker.getName()+" is now level "+attacker.getLevel());
				}
				enemies.remove(i);


			}

		}
	}
    }

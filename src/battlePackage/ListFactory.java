package battlePackage;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ListFactory {
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

    public static void updateEnemyList(List<Enemy> enemies) {
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).getHealth() <= 0) {
                Utils.p(enemies.get(i).getName()+" has died!");
                enemies.remove(i);


            }

        }
    }


    public static Equipment choiceWeapon(Scanner sc, int type, String name, Map<String, Map<Integer, List<Equipment>>> equipment) {
        Utils.p("Choose " + name);


        List<Equipment> weapons = equipment.get("weapons").get(type);
        for (int i = 0; i < weapons.size(); i++) {

            Utils.p("[" + (i + 1) + "]" + weapons.get(i).getName());
        }
        int choice;
        while ((choice = sc.nextInt()) > weapons.size()) ;


        Equipment weapon = weapons.get(choice - 1);
        return weapon;

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
        List<Ability> options = player.getAbilities();
        for (int i = 0; i < options.size(); i++) {
            Utils.p("[" + (i + 1) + "]" + options.get(i));
        }


        while ((choice = sc.nextInt()) > options.size()) ;


        return choice;
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
}

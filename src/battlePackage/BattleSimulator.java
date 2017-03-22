package battlePackage;

import java.util.*;
import java.util.Random;

import static battlePackage.ListFactory.*;

public class BattleSimulator {


    public static void main(String[] args) {

        List<Player> players = new ArrayList<>();
        List<Enemy> enemies = new ArrayList<>();


        //enemies2.add(new Skeleton("zombie0"));

        //	enemies.add(new Skeleton("kuku"));
        //CharacterFactory.setCharacters(enemies);


        Map<String, Map<Integer, List<Equipment>>> equipment = new HashMap();


        Map<Integer, List<Equipment>> weapons = new HashMap<>();
        equipment.put("weapons", weapons);


        List<Equipment> swords = new ArrayList<>();
        weapons.put(1, swords);

        swords.add(new Sword(100, "Sharpy", Enchantment.POWER, 150, 1.2f));
        swords.add(new Sword(100, "Sword1", Enchantment.NONE, 70, 1.8f));

        List<Equipment> wands = new ArrayList<>();
        weapons.put(2, wands);
        wands.add(new Wand(80, "Wand1", Enchantment.KNOWLEDGE, 30, 200, 2.2f));
        wands.add(new Wand(80, "Wand2", Enchantment.NONE, 40, 150, 1.8f));


        Map<Integer, List<Equipment>> armor = new HashMap<>();
        equipment.put("armor", armor);


        List<Equipment> shields = new ArrayList<>();
        armor.put(1, shields);


        List<Equipment> helmets = new ArrayList<>();
        armor.put(2, helmets);


        if (args != null && args.length > 0) {
            if (args[0].equalsIgnoreCase("printonly"))
                CharacterFactory.setPrintOnly(true);
            if (args.length > 1 && args[1].equalsIgnoreCase("dev"))
                Utils.setDev(true);
        }

        Option.fillDialogues();
        Option.fillOptions();

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        Utils.p("" + ((Weapon) swords.get(0)).getAttackDamage());


        Utils.p("Enter your name");
        String name = sc.next();

        createPlayer(players, sc, name);
        Player main = players.get(0);

        int choice = choose(sc, "opening");


        switch (choice) {

            case 1:
                int weaponType = battle(enemies, players, sc, rand, main, 1);

                Equipment weapon = choiceWeapon(sc, weaponType, Option.getOptions("chooseWeapon").get(weaponType - 1), equipment);
                main.addEquipment(weapon);
                Utils.p(weapon.toString());
                battle(enemies, players, sc, rand, main, 2);

                break;
            case 2:
                Utils.p("Coward");
                sc.close();
                break;
            default:
                Utils.p("What?");

                break;
        }


        sc.close();

    }

    private static int battle(List<Enemy> enemies, List<Player> players, Scanner sc, Random rand, Player main, int battleNum) {
        switch (battleNum) {
            case 1:

                enemies.add(new Skeleton("skeleton0"));
                enemies.get(0).setHealth(100);
                enemies.add(new Skeleton("bob"));
                enemies.get(1).setHealth(100);
                break;
            case 2:
                enemies.add(new Skeleton("Skeleton1"));
                enemies.get(0).setAttackDamage(600);
                enemies.get(0).setHealth(2000);
                break;
        }

        while (enemies.size() > 0) {

            int ability = chooseAbility(sc, main);


            Character character = chooseTarget(sc, enemies);
            main.useAbility(character, ability);
            updateEnemyList(enemies);
            enemyAttack(enemies, players, sc, rand);
        }
        return choose(sc, "chooseWeapon");
    }
//testgg
    private static void enemyAttack(List<Enemy> enemies, List<Player> players, Scanner sc, Random rand) {
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
                            sc.close();
                        }
                    }
                }
            }

    }
}
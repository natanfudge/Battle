package battlePackage;

import java.util.*;
import java.util.Random;

import static battlePackage.ListFactory.*;

public class BattleSimulator{

    public static void main(String[] args){

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
boolean back=false;
    do{



         Utils.p("Enter your name");
         String name = sc.next();

         createPlayer(players, sc, name);
         Player main = players.get(0);







               back=battle(enemies, players, sc, rand, 1);if (back){   continue;}
               int weaponType=choose(sc,"chooseWeapon");
               Equipment weapon = choiceWeapon(sc, weaponType, Option.getOptions("chooseWeapon").get(weaponType - 1), equipment);

               main.addEquipment(weapon);
               Utils.p(weapon.toString());
               back= battle(enemies, players, sc, rand, 2); if (back){   continue;}
               Utils.p("You have beat the 2nd battle. \n "+main.getName()+"leveled up! \n"+main.getName());











             sc.close();

         Utils.p("Done");
     } while(back);
        }

}



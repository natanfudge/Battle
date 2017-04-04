package battlePackage;


import java.io.*;
import java.util.*;
import java.util.Random;

import static battlePackage.ListFactory.*;

public class BattleSimulator{

    public static void main(String[] args){
Configurable.loadConfig();
int levelModifier=Configurable.getConfigurable("levelModifier");
Utils.p("" +levelModifier);
        Properties prop = new Properties();
        InputStream input = null;




        List<Player> players = new ArrayList<>();
        List<Enemy> enemies = new ArrayList<>();


        //enemies2.add(new Skeleton("zombie0"));

        //	enemies.add(new Skeleton("kuku"));
        //CharacterFactory.setCharacters(enemies);


        Map<String, Map<Integer, List<Equipment>>> equipment = new HashMap<>();


        Map<Integer, List<Equipment>> weapons = new HashMap<>();
        equipment.put("weapons", weapons);

        List<Equipment> swords = new ArrayList<>();
        weapons.put(1, swords);

        List<Equipment> wands = new ArrayList<>();
        weapons.put(2, wands);
        
        try {
			DataInputStream dataIn = new DataInputStream(new FileInputStream("resources/equipment.txt"));
			BufferedReader in = new BufferedReader(new InputStreamReader(dataIn));
			while (true) {
				try {
					String equipmentLine = in.readLine();
					if (equipmentLine!=null) {
						String[] splits = equipmentLine.split(",");
						String type=splits[0];
						int durability = Integer.valueOf(splits[1]);
						String name = splits[2];
						Enchantment enchantment = Enchantment.valueOf(splits[3]);
						int attackDamage= Integer.valueOf(splits[4]);
						int spellDamage= Integer.valueOf(splits[5]);

						float attackSpeed= Float.valueOf(splits[6]);
					
						switch(type){
						case ("sword"):
							swords.add(new Sword(durability,name,enchantment,attackDamage,attackSpeed));
						break;
						case("Wand"):
							
							wands.add(new Wand(durability,name,enchantment,attackDamage,spellDamage,attackSpeed));
							break;
						}

					} else {
						break;
					}
				} catch (IOException e) {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}








        
        

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
boolean back;
    do{



         Utils.p("Enter your name");
         String name = sc.next();

         createPlayer(players, sc, name);
         Player main = players.get(0);







               back=battle(enemies, players, sc, rand, "1");if (back){   continue;}

               int weaponType=choose(sc,"chooseWeapon");
               Equipment weapon = choiceWeapon(sc, weaponType, Option.getOptions("chooseWeapon").get(weaponType - 1), equipment);
               main.addEquipment(weapon);

               back= battle(enemies, players, sc, rand, "2"); if (back){   continue;}
               Utils.p("You have beat the 2nd battle. \n ");











             sc.close();

         Utils.p("Done");
     } while(back);
        }

}



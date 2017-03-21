package battlePackage;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterFactory {
	
	private static boolean printOnly=false;




           private Map<String,List<Enemy>>enemies=new HashMap<>();
    public Map<String,List<Enemy>>getEnemies(){
        return enemies;
    }
CharacterFactory enemy=new CharacterFactory();
    private void someMethod(){
        Map<String,List<Enemy>> enemies = enemy.getEnemies();
        List<Enemy>enemies1=new ArrayList<>();   enemies.put("enemies1",enemies1);
             enemies1.add(new Skeleton("Skeleton0"));

    }

        //     List<Enemy>enemies1=new ArrayList<>();   enemies.put("enemies1",enemies1);
    //        enemies1.add(new Skeleton("Skeleton0"));

         //  List<Enemy>enemies2=new ArrayList<>();   enemies.put("enemies2",enemies2);
          //  enemies2.add(new Skeleton("bob"));
       //     enemies2.add(new Zombie("zombie0",200,1000));


//public static HashMap<String,List<Enemy>>getEnemies(int pos){return ;}




    public static Player createPlayer(String name, int type) {

        Player character = null;
         switch (type) {
            case 1:
                character = new Warrior(1000, 50, 100, 3.5f, 20, name);
                break;
            case 2:
                character = new Mage(400, 600, 20, 2.5f, 200, name);
                break;

        }
        if (character!=null)
        	character.setPrintOnly(printOnly);
        return character;
    }

    
    public static void setPrintOnly(boolean printOnly) {
    	CharacterFactory.printOnly=printOnly;
    }





}

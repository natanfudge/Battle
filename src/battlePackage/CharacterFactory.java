package battlePackage;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterFactory {
	
	private static boolean printOnly=false;

    private static List< Enemy> characters = new ArrayList<>();
public static List<Enemy> getCharacters(){
	return characters;
}
    public static void setCharacters(List<Enemy> enemy) {
        CharacterFactory.characters = enemy;
    }

    public static Enemy getEnemy(int name) {
        Enemy enemy = characters.get(name);
        return enemy;

    }

    public static Player createCharacter(String name, String type) {

        Player character = null;
        type = type.toLowerCase();
        switch (type) {
            case "1":
                character = new Warrior(1000, 50, 100, 3.5f, 20, name);
                break;
            case "2":
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

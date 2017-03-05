package battlePackage;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {

    private static Map<String, Enemy> characters = new HashMap<>();

    public static void setCharacters(Map<String, Enemy> enemy) {
        CharacterFactory.characters = enemy;
    }

    public static Enemy getEnemy(String name) {
        Enemy enemy = characters.get(name);
        return enemy;

    }

    public static Player createCharacter(String name, String type) {

        Player character = null;
        type = type.toLowerCase();
        switch (type) {
            case "warrior":
                character = new Warrior(1000, 50, 100, 3.5f, 20, name);
                break;
            case "mage":
                character = new Mage(400, 600, 20, 2.5f, 200, name);
                break;

        }
        return character;
    }


}

package battlePackage;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
	
	private static Map<String,Enemy> characters = new HashMap<>();
	
	public static void setCharacters(Map<String,Enemy> enemy) {
		CharacterFactory.characters=enemy;
	}
	
	public static Enemy getEnemy(String name) {
		Enemy enemy = characters.get(name);
		return enemy;
		
	}
	public static Player createCharacter(int health, int mana, int attackDamage,float attackSpeed,int spellDamage, String name,String type){
		
		Player character=null;
		type=type.toLowerCase();
		switch(type){
		case "warrior" :
			character=new Warrior(health,  mana,  attackDamage, attackSpeed,spellDamage, name); 
			break;
	
		}
		return character;
	}
		
	
	

}

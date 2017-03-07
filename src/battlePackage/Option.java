package battlePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Option {
private static Map<String, String> dialogues=new HashMap<>();
private static Map<String, List<String>> options=new HashMap<>();

public static void fillDialogues(){
	dialogues.put("target", "Who to attack?");
	dialogues.put("playerType", "Choose your player type");
	dialogues.put("nextAction", "What do you do?");
	
}

public static void fillOptions(){
 List<String> optionsList=new ArrayList<>();
 optionsList.add("Warrior-high health low spell power medium attack damage medium attack speed");
 optionsList.add("Mage-low health high spell power low attack damage low attack speed");
	options.put("playerType", optionsList) ;
	optionsList=new ArrayList<>();
	 optionsList.add("");
	 optionsList.add("");
	options.put("nextAction", optionsList) ;
	optionsList=new ArrayList<>();
	for(Enemy enemy:CharacterFactory.getCharacters()){
		optionsList.add(enemy.getName());
		
		
	}
	options.put("target",optionsList);
}
	public static String getDialogue(String topic){
 return dialogues.get(topic);
	
}
public static List <String> getOptions(String topic){
return options.get(topic);	
}
}

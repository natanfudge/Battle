package battlePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Option {

private static Map<String, String> dialogues=new HashMap<>();
private static Map<String, List<String>> options=new HashMap<>();

public static void fillDialogues(){
	dialogues.put("opening", "What do you do?");
	dialogues.put("target", "Who to attack?");
	dialogues.put("playerType", "Choose your player type");
	dialogues.put("nextAction", "What do you do?");
	dialogues.put("ability", "Choose ability");
	dialogues.put("chooseWeapon", "Now that you have defeated your first foe, choose a weapon to continue.");




}

public static void fillOptions(){


 List<String> optionsList=new ArrayList<>();
 optionsList.add("Warrior-high health low spell power medium attack damage medium attack speed");
 optionsList.add("Mage-low health high spell power low attack damage low attack speed");
 optionsList.add("Archer- attacks fast and strongly low health.");
	options.put("playerType", optionsList) ;


	optionsList=new ArrayList<>();
	options.put("nextAction", optionsList) ;
	optionsList=new ArrayList<>();

	options.put("target",optionsList);


	optionsList=new ArrayList<>();
	optionsList.add("attack");
	optionsList.add("run");
	options.put("opening",optionsList);

    optionsList=new ArrayList<>();
	optionsList.add("Sword");
	optionsList.add("Wand");
    options.put("chooseWeapon",optionsList);





}
	public static String getDialogue(String topic){
 return dialogues.get(topic);

}
public static List <String> getOptions(String topic){
return options.get(topic);
}
	public static List<String> chooseWeapon(Map<String,Equipment> equipment){
List<String>weapons=new ArrayList<>();
for(Map.Entry<String,Equipment> eqp:equipment.entrySet()) {
	weapons.add(eqp.getKey()+eqp.toString());
}
	return weapons;

	}
}

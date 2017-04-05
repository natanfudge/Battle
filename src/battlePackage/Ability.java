package battlePackage;


import org.apache.commons.beanutils.BeanUtils;


import java.util.Properties;
import java.util.StringTokenizer;

public class Ability {

    private static Properties prop=Configurable.loadConfig("abilities");


   public static Float getDamage(String abilityName, Character character){
       String abilityProp = prop.getProperty(abilityName);
       float output = damageCalculator(character,  abilityProp);
           Utils.p(""+output);
      return output;
   }


private static float damageCalculator(Character character,String abilityProp) {
    String action=null;
    float output=0;
    Float thisOutput = 0f;
	StringTokenizer tokenizer=new StringTokenizer(abilityProp,"+-*/~",true);

       while(tokenizer.hasMoreTokens()){
        String currentInput=tokenizer.nextToken();

    if(action=="/"||action=="*"||action=="+"||action=="-") {

        float number=Float.valueOf(currentInput);
        switch(action){
            case "/":
                thisOutput/=number;
                action=null;
                break;
            case "*":
                thisOutput*=number;
                action=null;
                break;
            case "+":
                thisOutput+=number;
                action=null;
                break;
            case"-":
                thisOutput-=number;
                action=null;
                break;
        }
        if (action==null) {
            output+=thisOutput;
            thisOutput=0f;
        }
   }else {
        switch(currentInput){

            case "/":
            case "*":
            case "+":
            case "-":
            case "~":
            	action = currentInput;
                break;
            default:
                currentInput = currentInput.substring(0, 1).toUpperCase() + currentInput.substring(1);
                currentInput = "T" + currentInput;
                try {
                    thisOutput = Float.valueOf(BeanUtils.getProperty(character, currentInput));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;


        }
    }


}
	return output;
}

}

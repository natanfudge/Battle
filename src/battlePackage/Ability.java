package battlePackage;


import org.apache.commons.beanutils.BeanUtils;


import java.util.Properties;
import java.util.StringTokenizer;

public class Ability {

    private static Properties prop=Configurable.loadConfig("abilities");


   public static Float getDamage(String abilityName, Character character){
       Float output = null;
       String action=null;
       String abilityProp = prop.getProperty(abilityName);
       StringTokenizer tokenizer=new StringTokenizer(abilityProp,"+-*/~",true);

       while(tokenizer.hasMoreTokens()){
        String currentInput=tokenizer.nextToken();

    if(action=="/"||action=="*"||action=="+"||action=="-") {

        float number=Float.valueOf(currentInput);
        switch(action){
            case "/":
                output/=number;
                action=null;

                break;
            case "*":
                output*=number;
                action=null;
                break;
            case "+":
                output+=number;
                action=null;
                break;
            case"-":
                output-=number;
                action=null;
                break;

        }
   }else {
        switch(currentInput){

            case "/":
                action = "/";
                break;
            case "*":
                action = "*";
                break;
            case "+":
                action = "+";
                break;
            case "-":
                action = "-";
                break;
            case "~":
                action = "~";
                break;


            default:
                currentInput = currentInput.substring(0, 1).toUpperCase() + currentInput.substring(1);
                currentInput = "T" + currentInput;
                try {
                    output = Float.valueOf(BeanUtils.getProperty(character, currentInput));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;


        }
    }

}
           Utils.p(""+output);





       return output;
   }

}

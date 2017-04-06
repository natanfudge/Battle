package battlePackage;


import org.apache.commons.beanutils.BeanUtils;

import java.util.Enumeration;
import java.util.Properties;
import java.util.StringTokenizer;

public class Ability {

    private static Properties propAbility =Configurable.load("abilities");

//adding abilities-
    public static Float getDamage(String abilityName, Character character){
        Float thisOutput = 0f;
        float output=0;
        String action=null;
        String currentInput=null;
        String abilityProp = propAbility.getProperty(abilityName);
        StringTokenizer tokenizer=new StringTokenizer(abilityProp,"+-*/~",true);

        while(tokenizer.hasMoreTokens()){
             currentInput=tokenizer.nextToken();

            if(action=="/"||action=="*"||action=="+"||action=="-") {

                float number=Float.valueOf(currentInput);
                switch(action){
                    case "/":
                        thisOutput/=number;
                        break;
                    case "*":
                        thisOutput*=number;
                        break;
                    case "+":
                        thisOutput+=number;
                        break;
                    case"-":
                        thisOutput-=number;


                }
                action=null;
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
                        output+=thisOutput;
                        thisOutput=0f;
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

        output+=thisOutput;
        //distributing to types-



        return output;

    }

    public static void giveAbilities(Class thisclass){
         Properties prop=Configurable.load("typeAbilities");

        Enumeration e=prop.propertyNames();
     while(e.hasMoreElements()){
         String key=(String)e.nextElement();

         String abilityProp = prop.getProperty(key);



             if (thisclass.getSimpleName().equals(key)) {
                 String[] splits = abilityProp.split(",");
                for(String string:splits) {
                    Player.addAbility(string);
                }
                 }
             }
         }


    }


package battlePackage;


import org.apache.commons.beanutils.BeanUtils;


import java.util.Properties;
import java.util.StringTokenizer;

public class Ability {
    private static Properties prop=Configurable.loadConfig("abilities");


   public static Float getDamage(String abilityName, Character character){
       String abilityProp = prop.getProperty(abilityName);

       abilityProp=abilityProp.substring(0,1).toUpperCase()+abilityProp.substring(1);
       abilityProp="T"+abilityProp;
Float o = null;
       try {
         o=  Float.valueOf(BeanUtils.getProperty(character,abilityProp));
       } catch (Exception e) {
           e.printStackTrace();
       }
       StringTokenizer tokenizer=new StringTokenizer(abilityProp,"+-*/",true);
while(tokenizer.hasMoreElements()){
  Utils.p(""+tokenizer.nextElement()+" ");
}
       return o;
   }

}

package battlePackage;


import org.apache.commons.beanutils.BeanUtils;


import java.util.Properties;

public class Ability {
    private static Properties prop=Configurable.loadConfig("abilities");
   public static Float getDamage(String abilityName, Character character){
       String abilityProp = prop.getProperty(abilityName);
Float o = null;
       try {
         o=  Float.valueOf(BeanUtils.getProperty(character,abilityProp));
       } catch (Exception e) {
           e.printStackTrace();
       }
       return o;
   }

}

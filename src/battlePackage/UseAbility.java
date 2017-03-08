package battlePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UseAbility {
    List<UseAbility> UseAbilityList=new ArrayList<>();


    public static void useNormal(Character character,Player player){
        character.attacked(player.getAttackDamage());
    }
    public static void useMagicMissle(Character character,Player player){
        character.attacked(player.getSpellDamage());
    }
    UseAbilityList.add(useNormal(Character character,Player player));
        UseAbilityList.add(useMagicMissle(Character character,Player player));

}

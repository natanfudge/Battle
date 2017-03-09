package battlePackage;

public class Sword extends Weapon {

    public Sword(int durability, String name, Enchantment enchantment, int attackDamage, float bAT, int spellDamage) {
		super(durability, name, enchantment, attackDamage, bAT, spellDamage);
		setSpellDamage(0);
		
	}

	
}

package battlePackage;

public class Mage extends Player {

	

	public Mage(int health, int mana, int attackDamage, float attackSpeed, int spellDamage, String name) {
		super(health, mana, attackDamage, attackSpeed, spellDamage, name);
	}



	@Override
	public void addAbilities() {
		getAbilities().add("normal");
		getAbilities().add("magicMissle");

		
	}


}

package battlePackage;

public class Mage extends Player {

	

	public Mage(int health, int mana, int attackDamage, float attackSpeed, int spellDamage, String name) {
		super(health, mana, attackDamage, attackSpeed, spellDamage, name);
	}

	@Override
	public PlayerType getPlayerType() {
		return PlayerType.mage;
	}
	public void magicMissle(Character character) {
		character.attacked(getSpellDamage());
	}

	@Override
	public void addAbilities() {
		getAbilities().add(Ability.normal);
		getAbilities().add(Ability.magicMissle);

		
	}


}

package battlePackage;

public class Mage extends Player {

	

	public Mage(int health, int mana, int attackDamage, float attackSpeed, int spellDamage, String name) {
		super(health, mana, attackDamage, attackSpeed, spellDamage, name);
		this.setAbility1(Ability.normal);
	}

	@Override
	public PlayerType getPlayerType() {
		return PlayerType.mage;
	}
	public void magicMissle(Character character) {
		character.attacked(getSpellDamage());
	}

	@Override
	public Ability getAbility1() {
		return Ability.normal;
	}
	@Override
	public Ability getAbility2() {
		return Ability.magicMissle;
	}
}

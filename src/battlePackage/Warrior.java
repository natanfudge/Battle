package battlePackage;

public class Warrior extends Player {


	@Override
	public  PlayerType getPlayerType() {
		return PlayerType.warrior;
	}

	public Warrior(int health, int mana, int attackDamage, float attackSpeed,int spellDamage, String name) {
		super(health, mana, attackDamage, attackSpeed,spellDamage, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addAbilities() {
		getAbilities().add(Ability.normal);
	}
	
	}
	

	
		
	
	



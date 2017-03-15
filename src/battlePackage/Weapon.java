package battlePackage;

abstract class Weapon extends Equipment {
	

	private int attackDamage;
	private float BAT;


    public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public float getBAT() {
		return BAT;
	}

	public void setBAT(float bAT) {
		BAT = bAT;
	}


	
	
	

	public Weapon(int durability, String name, Enchantment enchantment, int attackDamage, float bAT) {
		super(durability, name, enchantment);
		this.attackDamage = attackDamage;
		BAT = bAT;
		
	}
}

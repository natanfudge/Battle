package battlePackage;

public class Skeleton extends Normal {
	

	

	

	public Skeleton(String name) {
		super(name);
		setManaRegeneration(0);
		setHealthRegeneration(3.5f);
		setSpellDamage(0);
		setAttackDamage(60);
		setMana(0);
		setHealth(300);
		setEXPBounty(5);
	}
	
	public Skeleton(String name,float health) {
		super(name);
		setManaRegeneration(0);
		setHealthRegeneration(3.5f);
		setSpellDamage(0);
		setAttackDamage(60);
		setMana(0);
		setHealth(health);
		setEXPBounty(5);
	}

}

package battlePackage;

public interface Character {
	int getHealth();

	int getMana();

	int getAttackDamage();

	int getSpellDamage();

	float getHealthRegeneration();

	float getManaRegeneration();

	String getName();
	
	void attack(Character character);
	
	void attacked(int attackDamage);

	float getAttackSpeed();
	
	float getAttackDelay();

}

package battlePackage;

import java.util.List;

public interface Character {


	float getHealth();

	float getMana();

	int getAttackDamage();

	int getSpellDamage();

	float getHealthRegeneration();

	float getManaRegeneration();

	String getName();
	
	void normalAttack(Character character);
	
	void attacked(int attackDamage);

	float getAttackSpeed();
	
	float getAttackDelay();

	List<Equipment> getEquipment();

	void addEquipment(Equipment equipment);
	void removeEquipment(Equipment equipment);


}

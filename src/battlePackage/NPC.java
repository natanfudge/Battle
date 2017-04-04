package battlePackage;

import java.util.ArrayList;
import java.util.List;

public abstract class NPC implements Character {

	private float health;

	private int mana;

	private int attackDamage;

	private int spellDamage;

	private float healthRegeneration;

	private float manaRegeneration;

	private String name;
	
	private float attackSpeed;
	
	private float attackDelay = 1/getAttackSpeed();
	private List<Equipment> equipment=new ArrayList<>();

	public NPC(String name) {
		this.name=name;
	}

	public float getHealth() {
		return health;
	}

	public void setHealth(float health) {
		this.health = health;
	}

	public float getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int getSpellDamage() {
		return spellDamage;
	}

	public void setSpellDamage(int spellDamage) {
		this.spellDamage = spellDamage;
	}

	public float getHealthRegeneration() {
		return healthRegeneration;
	}

	public void setHealthRegeneration(float healthRegeneration) {
		this.healthRegeneration = healthRegeneration;
	}

	public float getManaRegeneration() {
		return manaRegeneration;
	}

	public void setManaRegeneration(float manaRegeneration) {
		this.manaRegeneration = manaRegeneration;
	}

	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void normalAttack(Character character){
		character.attacked(getAttackDamage());
	}
	public void attacked(float attackDamage){
		setHealth(getHealth()-attackDamage);
	}


	public float getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(float attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	public float getAttackDelay() {
		return attackDelay;
	}

	public void setAttackDelay(float attackDelay) {
		this.attackDelay = attackDelay;
	}

	public List<Equipment> getEquipment(){
		return equipment;
	}

	public void addEquipment(Equipment equipment){
		if (getEquipment().size()<5) {
			getEquipment().add(equipment);
		}
		else{
			Utils.p("Too many items");
		}
	}
	public void removeEquipment(Equipment equipment){
		getEquipment().remove(equipment);

	}
	
	
}

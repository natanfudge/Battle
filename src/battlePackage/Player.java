package battlePackage;

import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Character {

	private float health;
	private float mana;
	private int attackDamage;
	private int spellDamage;
	private float experience;
	private int level=1;
	private float healthRegeneration;
	private float manaRegeneration;
	private String name;

	private float attackSpeed;
	private float attackDelay;
	private boolean printOnly;

	private List<Ability> abilities=new ArrayList<>();
    private List<Equipment>equipment=new ArrayList<>();

	public float getHealth() {
		return health;
	}   public void setHealth(float health) {
		this.health = health;
	}

	public float getMana() {
		return mana;
	}   public void setMana(float mana) {
		this.mana = mana;
	}

	public int getAttackDamage() {
		return attackDamage;
	}   public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int getSpellDamage() {
		return spellDamage;
	}   public void setSpellDamage(int spellDamage) {
		this.spellDamage = spellDamage;
	}

	public float getExperience() {return experience;}		public void setExperience(float experience) {this.experience = experience;}

	public int getLevel() {return level;}

	public void setLevel(int level) {this.level = level;}

	public float getHealthRegeneration() {return healthRegeneration;}public void setHealthRegeneration(float healthRegeneration) {this.healthRegeneration = healthRegeneration;}

	public float getManaRegeneration() {return manaRegeneration;}  public void setManaRegeneration(float manaRegeneration) {this.manaRegeneration = manaRegeneration;}

	public String getName() {
		return name;
	}   public void setName(String name) {
		this.name = name;
	}



	public float getAttackDelay() {
		return attackDelay;
	}   public void setAttackDelay(float attackDelay) {
		this.attackDelay = attackDelay;
	}

    public float getAttackSpeed() {
        return attackSpeed;
    }   public void setAttackSpeed(float attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

   


	public List<Ability> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}


    public Player(int health, int mana, int attackDamage,float attackSpeed,int spellDamage, String name) {
        super();
        this.health = health;
        this.mana = mana;
        this.attackDamage = attackDamage;
        this.name = name;
        this.attackSpeed = attackSpeed;
        attackDelay= 1 / attackSpeed;
        this.spellDamage=spellDamage;
        addAbilities();

    }

public int getTAttackDamage(){
		int attackDamage=getAttackDamage();
		for(Equipment eqp:getEquipment()){
			if(eqp instanceof Weapon||eqp instanceof Wand) {
				attackDamage += ((Weapon) eqp).getAttackDamage();
			}



		}
		return attackDamage;
}
public int getTSpellDamage(){
	int spellDamage=getSpellDamage();
	for(Equipment eqp:getEquipment()){
		if(eqp instanceof Wand){
			spellDamage+=((Wand)eqp).getSpellDamage();
		}
	}
	return spellDamage;
}
public float getTHealth(){
	float health=getHealth();
	for(Equipment eqp:getEquipment()){
		if(eqp instanceof Armor){
			health+=((Armor)eqp).getHealth();
		}
	}
	return health;
}

	public void normalAttack(Character character) {
		if (isPrintOnly()) {
			System.out.println(getName()+" attack "+character.getName()+ " with attack damage: "+getTAttackDamage());
		} else
			character.attacked(getTAttackDamage());
	}
	public void magicMissle(Character character) {
			character.attacked(getTSpellDamage());
	}

	public void headButt(Character character){
		character.attacked((getTAttackDamage()/2)+(getTHealth()/10));
	}
	@Override
    public void attacked(float afterMathEffect) {
        setHealth(getHealth() - afterMathEffect);

    }
    public void rangedAttack(Character character){
		character.attacked(getTAttackDamage()/2);
	}

	public boolean isPrintOnly() {
		return printOnly;
	}

	public void setPrintOnly(boolean printOnly) {
		this.printOnly = printOnly;
	}


    public abstract void addAbilities();

	public void useAbility(Character character, int abilityPosition) {
		List<Ability> abilities=getAbilities();
		Ability ability=abilities.get(abilityPosition-1);
		switch(ability){
			case normal:
				normalAttack(character);
				break;
			case magicMissle:
				magicMissle(character);
				break;
			case rangedAttack:
				rangedAttack(character);
			case headButt:
				headButt(character);
		}
		Utils.p(character.getName() + " now has " + character.getHealth() + " health");

	}


	public void useAbilityDuration(Character character, int abilityPosition) {
		List<Ability> abilities=getAbilities();
		Ability ability=abilities.get(abilityPosition-1);
		switch(ability){
			case normal:
				normalAttack(character);
				break;
			case magicMissle:
				magicMissle(character);
		}
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


	

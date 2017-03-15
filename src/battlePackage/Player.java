package battlePackage;

import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Character {

	private int health;
	private int mana;
	private int attackDamage;
	private int spellDamage;
	private float healthRegeneration;
	private float manaRegeneration;
	private String name;
	private PlayerType playerType;
	private float attackSpeed;
	private float attackDelay;
	private boolean printOnly;

	private List<Ability> abilities=new ArrayList<>();
    private List<Equipment>equipment=new ArrayList<>();

	public int getHealth() {
		return health;
	}   public void setHealth(int health) {
		this.health = health;
	}

	public int getMana() {
		return mana;
	}   public void setMana(int mana) {
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

	public float getHealthRegeneration() {return healthRegeneration;}public void setHealthRegeneration(float healthRegeneration) {this.healthRegeneration = healthRegeneration;}

	public float getManaRegeneration() {return manaRegeneration;}  public void setManaRegeneration(float manaRegeneration) {this.manaRegeneration = manaRegeneration;}

	public String getName() {
		return name;
	}   public void setName(String name) {
		this.name = name;
	}

	public PlayerType getPlayerType() {return playerType;}   public void setPlayerType(PlayerType playerType) {this.playerType = playerType;}

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

public int getTAD(){
		int attackDamage=getAttackDamage();
		for(Equipment eqp:getEquipment()){
			if(eqp instanceof Weapon||eqp instanceof Wand) {
				attackDamage += ((Weapon) eqp).getAttackDamage();
			}


		}
		return attackDamage;
}
public int getTSD(){
	int spellDamage=getSpellDamage();
	for(Equipment eqp:getEquipment()){
		if(eqp instanceof Wand){
			spellDamage+=((Wand)eqp).getSpellDamage();
		}
	}
	return spellDamage;
}

	public void normalAttack(Character character) {
		if (isPrintOnly()) {
			System.out.println(getName()+" attack "+character.getName()+ " with attack damage: "+getTAD());
		} else
			character.attacked(getTAD());
	}
	public void magicMissle(Character character) {
			character.attacked(getTSD());
	}

    @Override
    public void attacked(int afterMathEffect) {
        setHealth(getHealth() - afterMathEffect);
        ;
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
		}
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
			Utilities.p("Too many items");
		}
	}
	public void removeEquipment(Equipment equipment){
		getEquipment().remove(equipment);

	}
}


	

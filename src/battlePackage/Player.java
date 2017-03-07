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
	@Override
	public void attack(Character character) {
		if (isPrintOnly()) {
			System.out.println(getName()+" attack "+character.getName()+ " with attack damage: "+getAttackDamage());
		} else 
			character.attacked(getAttackDamage());
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
	
}


	

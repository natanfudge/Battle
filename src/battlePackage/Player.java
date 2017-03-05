package battlePackage;

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
	private Ability ability1;
    private Ability ability2;
    private Ability ability3;
    private Ability ability4;
    private Ability ability5;
    private Ability ability6;

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

	public PlayerType getPlayerType() {
		return playerType;
	}   public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
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

    public Ability getAbility1() {return ability1;} public void setAbility1(Ability ability1) {this.ability1 = ability1;}

    public Ability getAbility2() {return ability2;} public void setAbility2(Ability ability2) {this.ability2 = ability2;}

    public Ability getAbility3() {return ability3;} public void setAbility3(Ability ability3) {this.ability3 = ability3;}

    public Ability getAbility4() {return ability4;} public void setAbility4(Ability ability4) {this.ability4 = ability4;}

    public Ability getAbility5() {return ability5;} public void setAbility5(Ability ability5) {this.ability5 = ability5;}

    public Ability getAbility6() {return ability6;} public void setAbility6(Ability ability6) {this.ability6 = ability6;}



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
		this.ability1 = ability1;
		this.ability2 = ability2;
		this.ability3 = ability3;
		this.ability4 = ability4;
		this.ability5 = ability5;
		this.ability6 = ability6;

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

	}
	


	

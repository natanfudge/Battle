package battlePackage;

public abstract class Enemy extends NPC {
private int EXPBounty;

	public int getEXPBounty() {return EXPBounty;}

	public void setEXPBounty(int bounty) {this.EXPBounty = bounty;}

	public Enemy(String name) {
		super(name);
	}
	public void attacked(float attackDamage){
		setHealth(getHealth()-attackDamage);
	}
	
}
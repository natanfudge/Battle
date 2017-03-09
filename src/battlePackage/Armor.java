package battlePackage;

 abstract class Armor extends Equipment{
    

	private float protection;

	

	public float getProtection() {
		return protection;
	}

	public void setProtection(float protection) {
		this.protection = protection;
	}
	

	public Armor(int durability, String name, Enchantment enchantment, float protection) {
		super(durability, name, enchantment);
		this.protection = protection;
	}
	
}

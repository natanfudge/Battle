package battlePackage;

import java.util.List;

abstract class Equipment {
	private int durability;
	private String name;
	private Enchantment enchantment;
	private SpecialEffect specialEffect;
	private Active active;

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Enchantment getEnchantment() {
		return enchantment;
	}

	public void setEnchantment(Enchantment enchantment) {
		this.enchantment = enchantment;
	}

	public SpecialEffect getSpecialEffect() {
		return specialEffect;
	}

	public void setSpecialEffect(SpecialEffect specialEffect) {
		this.specialEffect = specialEffect;
	}

	public Active getActive() {
		return active;
	}

	public void setActive(Active active) {
		this.active = active;
	}

	public Equipment(int durability, String name, Enchantment enchantment) {
		this.durability = durability;
		this.name = name;
		this.enchantment = enchantment;
	}

	@Override
	public String toString() {
		return "Equipment{" +
				"durability=" + durability +
				", name='" + name + '\'' +
				", enchantment=" + enchantment +
				", specialEffect=" + specialEffect +
				", active=" + active +
				'}';
	}
}

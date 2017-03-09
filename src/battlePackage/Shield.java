package battlePackage;

public class Shield extends Armor {
private int block;
private int blockChance;

	public int getBlock() {
	return block;
}

public void setBlock(int block) {
	this.block = block;
}

public int getBlockChance() {
	return blockChance;
}

public void setBlockChance(int blockChance) {
	this.blockChance = blockChance;
}

	
	public Shield(int durability, String name, Enchantment enchantment, float protection, int block, int blockChance) {
		super(durability, name, enchantment, protection);
		this.block = block;
		this.blockChance = blockChance;
	}

}

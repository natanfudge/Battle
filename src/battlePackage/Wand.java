package battlePackage;


public class Wand extends Weapon{
    private int spellDamage;
    public Wand(int durability, String name, Enchantment enchantment, int attackDamage,int spellDamage, float bAT) {
        super(durability, name, enchantment, attackDamage, bAT);
        this.spellDamage=spellDamage;


    }
    public int getSpellDamage() {
        return spellDamage;
    }

    public void setSpellDamage(int spellDamage) {
        this.spellDamage = spellDamage;
    }
}

package battlePackage;

public class Archer extends Player{

public void rangedAttack(Character character){
    character.attacked(getAttackDamage()/2);
    }

    public Archer(int health, int mana, int attackDamage, float attackSpeed, int spellDamage, String name) {
        super(health, mana, attackDamage, attackSpeed, spellDamage, name);
    }



}

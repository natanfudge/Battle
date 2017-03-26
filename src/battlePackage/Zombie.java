package battlePackage;

public class Zombie extends Enemy{

    @Override
    public float getHealth() {
        return 0;
    }

    @Override
    public void setHealth(float health) {

    }

    @Override
    public int getAttackDamage() {
        return 0;
    }

    @Override
    public void setAttackDamage(int attackDamage) {

    }

   public Zombie(String name, int attackDamage, int health) {
        super(name);

    }

}

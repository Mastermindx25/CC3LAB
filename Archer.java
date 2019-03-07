package myrpg;

public class Archer extends Character implements Weapon, Armor {

    public Archer(String n, int s, int d, int i) {
        super(n, s, d, i);
    }

    public int castWindStrike() {
        int damage = dice.roll() * dexterity;
        heal(damage);
        return damage;
    }

    @Override
    public int attack() {
        return dice.roll() * strength;
    }

    @Override
    public int useWeapon() {
        return dice.roll() * strength;
    }

    @Override
    public int useArmor() {
        int value = dice.roll() * strength;
        heal(value);
        return value;
    }
}

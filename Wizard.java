package myrpg;

public class Wizard extends Character implements Weapon, Armor {

    private int maxMagic, currentMagic;

    public Wizard(String n, int s, int d, int i) {
        super(n, s, d, i);
        maxMagic = dice.roll() * 10;
        currentMagic = maxMagic;
    }

    public int castLightningBolt() {
        int damage = 0;
        if (currentMagic >= 5) {
            currentMagic -= 5;
            damage = dice.roll() * intelligence;
        }
        return damage;
    }

    public int castHeal() {
        int healAmt = 0;
        if (currentMagic >= 8) {
            currentMagic -= 8;
            healAmt = dice.roll() * intelligence;
            heal(healAmt);
        }
        return healAmt;
    }

    public int getMaxMagic() {
        return maxMagic;
    }

    public int getCurrentMagic() {
        return currentMagic;
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

package myrpg;

public abstract class Character {

    protected static Dice dice = new Dice();

    protected String name;
    protected int strength, dexterity, intelligence;
    protected int maxLife, currentLife;

    public Character(String n, int s, int d, int i) {
        name = n;
        strength = s;
        dexterity = d;
        intelligence = i;
        maxLife = dice.roll() * 10;
        currentLife = maxLife;
    }

    public abstract int attack();

    public void wound(int damage) {
        if ((currentLife - damage) > 0) {
            currentLife -= damage;
        } else {
            currentLife = 0;
        }
    }

    public void heal(int heal) {
        if ((currentLife + heal) < maxLife) {
            currentLife += heal;
        } else {
            currentLife = maxLife;
        }
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getCurrentLife() {
        return currentLife;
    }

    public int getMaxLife() {
        return maxLife;
    }
}

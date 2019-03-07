package myrpg;

public class TestCharacter {

    public static void main(String args[]) {
        Character char1 = new Character("Siomai", 100, 1, 1) {

            @Override
            public int attack() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        Character char2 = new Character("Shawarma", 100, 1, 1) {

            @Override
            public int attack() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        int damage, round = 1;
        while (char1.getCurrentLife() > 0 && char2.getCurrentLife() > 0 && round <= 3) {

            System.out.println("Round " + round);

            System.out.println(char1.getName() + ": " + char1.getCurrentLife());
            System.out.println(char2.getName() + ": " + char2.getCurrentLife());

            damage = char1.attack();
            char2.wound(damage);
            System.out.println(char1.getName() + " attacks " + char2.getName() + " for " + damage);
            if (char2.getCurrentLife() <= 0) {
                System.out.println("");
                break;
            }

            damage = char2.attack();
            char1.wound(damage);
            System.out.println(char2.getName() + " attacks " + char1.getName() + " for " + damage);

            System.out.println("");
            round++;

        }

        System.out.println(char1.getName() + ": " + char1.getCurrentLife());
        System.out.println(char2.getName() + ": " + char2.getCurrentLife());
        System.out.println("");

        if (char1.getCurrentLife() == char2.getCurrentLife()) {
            System.out.println("Draw.");
        } else if (char1.getCurrentLife() > char2.getCurrentLife()) {
            System.out.println(char1.getName() + " wins.");
        } else if (char2.getCurrentLife() > char1.getCurrentLife()) {
            System.out.println(char2.getName() + " wins.");
        }
    }
}
